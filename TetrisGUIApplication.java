import javax.swing.JFrame;

/**
 * Tetris Application class
 * creates and draws canvas
 * I didn't have time to add the audio :(
 * @author Carla Gonzalez-Vazquez
 *
 */
public class TetrisGUIApplication {

	//sets width and height of canvas
	private static int C_WIDTH = 300;
	private static int C_HEIGHT = 600;

	/**
	 * main constructor
	 * creates and draws the frame for the canvas
	 * @param args
	 */
	public static void main(String[] args) {
		//makes frame
	 	JFrame tetrisCanvas = new JFrame("YAS Tetris!");
		//adds controller class to canvas
		tetrisCanvas.add(new TetrisGUIController());
		//sets the size
		tetrisCanvas.setSize(C_WIDTH, C_HEIGHT);
		tetrisCanvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tetrisCanvas.setVisible(true);				
	}
}


