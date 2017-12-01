/**
 * The Tetrominoes class represents a piece
 * made of 4 TetrisBlocks. It has 4 rotations (0 degree,
 * 90 degrees, 180 degrees and 270 degrees),
 * and each tetromino is made in a 4x4 grid.
 *  
 * @author Carla Gonzalez-Vazquez
 * @param row current row
 * @param col current col
 * @param rot current rot 
 *
 */
public class Tetrominoes{

	//instance for the tetrominoes array
	protected static boolean [][][] filledSquares;
	private int pieceRotation;

	/**
	 * constructor
	 */
	public Tetrominoes()
	{
		//makes boolean for 3D array for the board
		//4 rotations and 4x4 grid
		filledSquares = new boolean [4][4][4];
		pieceRotation = 0;
	}

	/**
	*rotates piece clockwise by 90 degrees
	*/
	public void rotateClock()
	{
		pieceRotation++;
		if(pieceRotation>3){
			pieceRotation = 0;
		}
	}
	
	/**
	*rotates piece counter-clockwise by 90 degrees
	*/
	public void rotateNotClock()
	{
		pieceRotation--;
		if(pieceRotation<0){
			pieceRotation = 3;
		}
	}
	
	/**
	 * gets the rotation of the piece
	 * @return pieceRotation
	 */
	public int getPieceRotation()
	{
		return pieceRotation;
	}
	
	/**
	 * Checks if there is a TetrisBlock at
	 * the (row, col) position 
	 * @return true if there is a block in the position
	 * 
	 */
	public boolean isFilled(int rot, int row, int col)
	{
		if(filledSquares[rot][row][col]){
			return true;
		}
		else{
		return false;
	}
}
}