import javax.swing.JComponent;

import java.awt.Graphics;
import java.awt.Color;

/**
* View class of Tetris
*@authorCarla Gonzalez-Vazquez
*@param board  board of the game
*@param g  Graphic g
*@param int blockSize size of block
*@param int row  row of board
*@param int col column of board
*/
public class TetrisGUIView extends JComponent
{	
	//instance variable of the board
	private TetrisBoard board;
	
	
	/**
	* class constructor
	*@param board
	*/
	public TetrisGUIView (TetrisBoard board){
		this.board = board; 

	}

	/**
	* paints the game
	*@param Graphics g 
	*/
	public void paint(Graphics g)
	{
		int blockSize = computeBlockSize();
		for (int i = 0; i < board.NUM_ROWS; i++){
			for (int k = 0; k < board.NUM_COLS; k++){
				if(board.hasBlock(i,k)){
					paintBlock(g, i, k, blockSize);
				}
			}
		}
		paintBoardOutline(g, blockSize);
	}

	/**
	*paints the outline of the board
	*@param Graphics g
	*@param blockSize
	*/
	public void paintBoardOutline(Graphics g, int blockSize)
	{
		g.drawRect(0,0, board.getNumCols() * blockSize, board.getNumRows() *blockSize);
	}

	/**
	*Paint the block and its outline.
	*@param g Graphics
	*@param row
	*@param col
	*@param blockSize
	*/
	public void paintBlock(Graphics g, int row, int col, int blockSize)
	{
		 g.setColor(Color.CYAN);
		 g.fillRect(blockSize*col, blockSize*row, blockSize, blockSize);

		 g.setColor(Color.BLACK);
		 g.drawRect(blockSize*col, blockSize*row, blockSize, blockSize);

	}
	/**
	*Computes the best block size for the current width and height.
	*@return bSize
	*/
	public int computeBlockSize()
	{
		int x =this.getHeight()/board.getNumRows();
		int y = this.getWidth()/board.getNumCols();
		

		int bSize = Math.min(x,y);
		return bSize;


	}
}