/**
 * Represents the J-shaped Tetromino
 * and its Clockwise and Counter-Clockwise rotations
 * 
 * @author Carla Gonzalez-Vazquez
 *
 */
public class TetrominoJ extends Tetrominoes{
	
	public TetrominoJ(){
		//calls super class
		super();
			filledSquares = new boolean [][][]{
				{
					{false, true,true,false},
					{false, true, false, false},
					{false, true, false, false},
					{false, false, false, false},
				},

				{
					{false, false, false, false},
					{true, true, true, false},
					{false, false, true, false},
					{false, false, false, false},

				},

				{
					{false, true, false, false},
					{false, true, false, false},
					{true, true, false, false},
					{false, false, false, false},
				},

				{
					{true, false, false, false},
					{true, true, true, false},
					{false, false, false, false},
					{false, false, false, false},
				}
			};

	}
}