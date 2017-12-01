import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.image.ImageObserver;
import java.util.EventListener;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.JComponent; 
import java.awt.event.KeyEvent;
import javax.swing.JLabel; 

/**
 * Controller class of Tetris
 * 
 * @author Carla Gonzalez-Vazquez
 *
 */
public class TetrisGUIController extends JPanel implements KeyListener{
	
	//speed for falling tetromino
	public static final int DROP_RATE = 400;
	//instace variable for TetrisGame class
	private TetrisGame game;
	//instance variable for View class
	private TetrisGUIView view;
	//instance variable of the board
	private TetrisBoard board;
	//instanciates JLabels
	private JLabel lLabel;
	private JLabel tLabel;
	//intance of Timer
	private Timer gameTimer;

	/**
	 * Contructor of controller class
	 */
	public TetrisGUIController(){
		//sets it to border style
		super(new BorderLayout());
		//instanciates game
		game = new TetrisGame();
		board= new TetrisBoard();
		setFocusable(true);
		addKeyListener(this);
		createView();
		
		setTimer();
		createScore();
		refreshDisplay();
	}
    /**
     * sets the timer for the game
     * makes pieces fall at a constant speed
     */
	public void setTimer()
	{
		ActionListener gameTimer = new ActionListener(){
			public void actionPerformed (ActionEvent e)
			{
				game.attemptMove(game.DOWN);
				refreshDisplay();
			}
				
		};
		//starts the timer
		new Timer (DROP_RATE, gameTimer).start();
	}
		
	
	/**
	 * Creates the view 
	 */
	public void createView()
	{	
		//gets tetris board
		view = new TetrisGUIView(game.getTetrisBoard());
		//sets border layout
		setLayout(new BorderLayout());
		//adds the view to the center of layout
		add(view, BorderLayout.CENTER);
	}

	/**
	 * creates the labels for the score
	 */
	public void createScore()
	{
		JPanel score = new JPanel();
		score.setLayout(new BorderLayout());
		//line and tetrises label
		tLabel = new JLabel();
		lLabel= new JLabel();
		//adds labels to north and south of layout
		score.add(lLabel, BorderLayout.NORTH);
		score.add(tLabel, BorderLayout.SOUTH);
		//adds layout to the north of the frame
		add(score, BorderLayout.NORTH);
		
	}
	/**
	 * refreshes the display
	 *should get number of lines and tetrises cleared but doesn't
	 */
	public void refreshDisplay()
	{
		lLabel.setText("cleared lines:" + "    " + board.numFormedLines());
		tLabel.setText("cleared tetrises" + "   " + game.getNumTetrises());
		//repaints the view
		view.repaint();
	}
	
	/**
	 * Do something when a key is typed
	 * @param e the key that is pressed
	 */
	@Override
	public void keyTyped(KeyEvent e){}
	/**
	 * Do something when a key is released
	 * @param e the key that is pressed
	 */
	@Override
	public void keyReleased(KeyEvent e){}

	/**
	 *Move the circle when a key is pressed
	 *refreshes displaya fter each key is pressed
	 * @param e the key that is release	 
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		System.out.println(e.getKeyCode());
		int key = e.getKeyCode();

	    if (key == KeyEvent.VK_DOWN) {
	    	game.attemptMove(game.DOWN)  ;
	        refreshDisplay();
	    }
	    else if(key == KeyEvent.VK_RIGHT){
	    	game.attemptMove(game.RIGHT);
	    	refreshDisplay();
	    }
	    else if(key == KeyEvent.VK_LEFT){
	    	game.attemptMove(game.LEFT);
	    	refreshDisplay();
	    }
	    else if(key == KeyEvent.VK_C){
	    	game.attemptMove(game.CW);
	    	refreshDisplay();
	    }
	    else if(key == KeyEvent.VK_N){
	    	game.attemptMove(game.CCW);
	    	refreshDisplay();
	    }
	    //repaints when view when one key is pressed
	    repaint();
	}
}