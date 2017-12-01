/**
 * TetrisBoard is the model of the game Tetris. 
 * It is the class where the game is played.
 * It makes the board and the maintains the current Tetromino. 
 * Should remove the line if it is full but doesn't
 * @author Carla Gonzalez-Vazquez
 * @param tetromino current tetromino
 * @param rot current rotation
 * @param gridRow current row on grid
 * @param gridCol current column on grid
 * @param row current row
 * @param col current column
 */
public class TetrisBoard {
	
	//declares boolean for board 
	public boolean [][] tetrisMatrix;
	
	//number of columns and rows
	public static int NUM_COLS = 10;
	public static int NUM_ROWS = 18;
	
	//Tetrominoes class instance variable
	public Tetrominoes tetromino; 
	
	//will be temp variable for row and columns
	private int numRow;
	private int numCol;
	
	private int lines;

	//position of current falling piece
	private int [] currentTetPosition;
	// boolean instance variable
	private boolean hasTetromino;
	
	/**
	 * Constructor of TetrisBoard
	 */
	public TetrisBoard()
	{	
		//set variables to static ints
		this.numCol = NUM_COLS;
		this.numRow = NUM_ROWS;
		//creates boolean for matrix(board)
		tetrisMatrix = new boolean [NUM_ROWS][NUM_COLS];
		
		//initalizes methods
		initCurrentGP();
		initialBoard();
		addNewTetromino();
	}
	/**
	 * initalizes an int array of length two to keep track of
	 * the grid position of the current piece (row, col)
	 */
	public void initCurrentGP()
	{
		//int array for current position of piece
		currentTetPosition = new int [2];
		//stores the current row
		currentTetPosition[0] = 1;
		//stores the current column
		currentTetPosition[1] = 2;		
	}
	/**
	 * Initializes the 2D array for the board
	 * and sets it to false values
	 */
	public void initialBoard()
	{	
		for( int i= 0; i<tetrisMatrix.length; i++){		
			for(int k = 0; k< tetrisMatrix[i].length; k++){
				tetrisMatrix[i][k] = false;
			}
		}
	}
	
	/**
	 * lands the piece when it hits the bottom of canvas
	 * or when it lands above a piece
	 */
	public void landTetromino()
	{
		//loops through piece array
		for(int i= 0; i<4; i ++){
			for( int k = 0; k< 4; k++){
				if(tetromino.isFilled(tetromino.getPieceRotation(), i, k)){
					tetrisMatrix[currentTetPosition[0]+i] [currentTetPosition[1] + k] = true;
				}
			}
		}
		addNewTetromino();
							
	}
	
	/**
	 * gets the current falling tetromino
	 * @return the current tetromino
	 */
	public Tetrominoes getCurrentTetromino()
	{
		return tetromino;
	}
	
	/**
	 * returns the current grid position where the
	 * tetromino is
	 * @return the currentTetPosition
	 */
	public int [] getCurrentTetPosition()
	{
		return currentTetPosition;
	}
	
	/**
	 * Checks if moving left is valid. 
	 * If it is, moves the current tetromino to the left
	 * @return true is valid move was performed
	 */
	public boolean moveLeft()
	{              
		if(tetromino == null){
			return false;
		}
		//if the move is valid moves to the left
		if(validMove(tetromino, tetromino.getPieceRotation(), currentTetPosition[0], currentTetPosition[1]-1)){
			currentTetPosition[1]--;
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if moving right is valid.
	 * Is it is, moves the current tetromino to the right
	 * @return true is valid move was performed
	 */
	public boolean moveRight()
	{
		if(tetromino == null){
			return false;			
		}
		//if move is valid moves to the right
		if(validMove(tetromino, tetromino.getPieceRotation(), currentTetPosition[0], currentTetPosition[1]+1)){
			currentTetPosition[1]++;
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if moving down is valid. 
	 * If it is, moves the current tetromino piece down.
	 * @return true if valid move was performed
	 */
	public boolean moveDown()
	{
		//if move is valid moves down
		if (validMove(tetromino, tetromino.getPieceRotation(), currentTetPosition[0]+1, currentTetPosition[1])){
			currentTetPosition[0]++;
			return true;
		}
		//if it can't move down anymore lands the piece
		else {
			landTetromino();						
		}						
		return false;	
	}
	
	/**
	 * rotates tetromino clockwise
	 * @return true 
	 */
	public boolean rotateCW(){
		//if move is valid rotates tetromino clockwise
		if(validMove(tetromino, tetromino.getPieceRotation(), currentTetPosition[0]+1, currentTetPosition[1])){
			tetromino.rotateClock();
		}		
		return false;
	}
		
	/**
	 * rotates piece counter-clockwise
	 * @return true 
	 */
	public boolean rotateCCW()
	{
		//if move is valid rotates tetromino counter-clockwise
		if(validMove(tetromino, tetromino.getPieceRotation(), currentTetPosition[0]-1, currentTetPosition[1])){
			tetromino.rotateNotClock();
		}
		return true;
	}
	
	/**
	 * Adds a random tetromino to the board 
	 */
	public void addNewTetromino()
	{
	//makes and sets random int gen to seven
	//because we have seven pieces
		int tet = (int) (Math.random()*7);
		
		switch(tet)
		{
		 case 1:
			 tetromino = new TetrominoI();
			 break;
		 case 2:
			 tetromino = new TetrominoJ();
			 break;
		 case 3:
			 tetromino = new TetrominoL();
			 break;
		 case 4:
			 tetromino = new TetrominoSquare();
			 break;
		 case 5:
			 tetromino = new TetrominoZ();
			 break;
		 case 6:
			 tetromino = new TetrominoS();
			 break;
		 case 0:
			 tetromino = new TetrominoT();
			 break;
	    }
	 initCurrentGP();	 
	}

	/**
	 * Checks if placing the tetromino at grid position 
	 * would cause a collision with other pieces's
	 * position with the rotation
	 * @param tetromino
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 * @return true if there would be a collision
	 */
	public boolean detectCollision(Tetrominoes tetromino, int rot, int gridRow, int gridCol)
	{
		for(int i=0; i <4; i++){
			for(int k = 0; k <4; k++){
				if(gridRow + i< NUM_ROWS && gridCol +k < NUM_COLS){
			
					if(tetrisMatrix[gridRow + i][gridCol +k] && tetromino.isFilled(rot, i, k)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks if placing the piece at grid position would
	 * cause an out of bounds condition
	 * @param tetromino
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 * @return true if there would be a bounding error
	 */
	public boolean detectOutOfBounds(Tetrominoes tetromino, int rot, int gridRow, int gridCol)
	{
		//goes through tetromino array
		for(int i = 0; i<4; i++){
			for(int k = 0; k<4; k++ ){
				//if tetromino is full 
				if(tetromino.filledSquares[tetromino.getPieceRotation()][i][k]==true){	
					//and if it is out of bounds returns true
					if(gridRow + i > NUM_ROWS -1  || gridCol + k > NUM_COLS -1  || gridCol < 0){
					return true;
					}
				}
			}
		}
		return false;
	}	
	
	/**
	 * Checks if placing the piece at grid position (row, col)
	 * with the rotation rot(that i didn't get) is a valid move
	 * @param tetromino
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 * @return true of no collision or bound error
	 */
	public boolean validMove(Tetrominoes tetromino, int rot, int gridRow, int gridCol)
	{
		//if tetromino hasn't collided or in't out of bounds the move is valid returns true
		if(detectOutOfBounds(tetromino, rot, gridRow, gridCol) == false && detectCollision(tetromino, rot, gridRow, gridCol)== false){
			return true;
		
		}
		return false;
	}
	/**
	 * Checks if there is a block in the row and column
	 * @param row
	 * @param col
	 * @return tetrisMatrix with row and col
	 */
	public boolean hasBlock(int row, int col)
	{
		//sets ints to grid positions
		int x = currentTetPosition[0];
		int y = currentTetPosition[1];
		
		
		for( int i= 0; i<4; i++){
			for(int k = 0; k < 4; k++){	
				//boolean variable set to filled tetromino
				hasTetromino = tetromino.isFilled(tetromino.getPieceRotation(), i, k);
				
				if(hasTetromino && x + i  == row && y+k ==col){
					return true;
				}
			}
		}
		return tetrisMatrix[row][col];	
	}
	/**
	 * Check if there is a full line at the row
	 * @param row
	 * @return true if full
	 */
	public boolean fullLine(int row)
	{
		for( int i = 0; i < NUM_COLS; i++ ){
			if(!tetrisMatrix[row][i]){
				return false;
			} 
		}
		return true;
	}
	
	/**
	 * Remove the line at row in the board.
	 * Shifts all values for rows at a lower index 
	 * to be at one row higher.
	 * Make row 0 full of false values.
	 * it isn't working
	 * @param row
	 */
	public void removeLine(int row)
	{
		while (row >0){
			
			for(int k = 0; k< NUM_COLS; k++){
				tetrisMatrix[row][k] = tetrisMatrix[row-1][k];
			
			}
			row--;
		}
	}
	/**
	 * gets the number of lines formed
	 * @return number of lines formed
	 */
	public int numFormedLines() {
		int formedLines = 0;
		for (int i = 0; i < NUM_ROWS; i++) {
			if (fullLine(i)) {
				removeLine(i);				
				formedLines++;
				lines++;
			}
		}
		return lines;
	}
	
	
	/**
	 * returns matrix
	 * @return block matrix
	 */
	public boolean [][] getBlockMatrix()
	{
		return tetrisMatrix;
	}
	
	/**
	 * the numCols in the block matrix
	 * @return
	 */
	public int getNumCols()
	{
		return numCol;
	}
	
	/**
	 * the numRows in the block matrix
	 * @return
	 */
	public int getNumRows()
	{
		return numRow;
	}
}