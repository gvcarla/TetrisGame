/**
 * TetrisGame is the model of the logic of Tetris
 * @author Carla Gonzalez-Vazquez
 *
 */
public class TetrisGame {
	
	//constant int variables for moving the pieces
	public static final int DOWN =1;
	public static final int LEFT =2;
	public static final int RIGHT =3;	
	public static final int CW =4;
	public static final int CCW =5;
	//intance variable of number of line
	private int numLines;
	//intance variable for number of tetrises
	private int numTetrises ;
	private TetrisBoard tetrisBoard;
	
	
	/**
	 * Constructor of TetrisGame
	 */
	public TetrisGame()
	{
		//instance of tetris board
		tetrisBoard = new TetrisBoard();
	}
	/**
	 * attempts moves and calls them form the board
	 * @param moveType
	 */
	public void attemptMove(int moveType)
	{
		if(moveType == DOWN){
			tetrisBoard.moveDown();	
			endRound();
			
		}
		else if(moveType ==LEFT){
			tetrisBoard.moveLeft();
		}
		else if(moveType == RIGHT){
			tetrisBoard.moveRight();
		}
		else if(moveType ==CW){
			tetrisBoard.rotateCW();
		}
		else if(moveType ==CCW){
			tetrisBoard.rotateCCW();
		}
	}
	/**
	 * ended the game and counted the lines 
	 * and tetries
	 * when i tried to implement it got my
	 * tetrominos together and merged them
	 */
	public void endRound()
	{
		//tetrisBoard.landTetromino();
		int tetrominos = tetrisBoard.numFormedLines();
		numLines+= tetrominos;
		//if there are 4 formed line removes lines
		if(tetrominos==4){
			numTetrises++;
		}
		
	}
	
	/**
	 * gets number of lines cleared
	 * @return numLines
	 */
	public int getNumLines()
	{
		return numLines;
	}
	/**
	 * return the number of tetrises (4lines together) cleared
	 * @return numTetrises
	 */
	public int getNumTetrises()
	{
		return numTetrises;
	}
	
	/**
	 * returns the board
	 * @return tetrisBoard
	 */
	public TetrisBoard getTetrisBoard()
	{
		return tetrisBoard;
	}

}
