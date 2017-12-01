/**
 * Represents the I-shaped Tetromino
 * and its Clockwise and Counter-Clockwise rotations
 * 
 * @author Carla Gonzalez-Vazquez
 *
 */
public class TetrominoI extends Tetrominoes{
	
	public TetrominoI(){
		//calls super class
		super();
			filledSquares = new boolean [][][]{
				{
					{true, false,false,false},
					{true, false, false, false},
					{true, false, false, false},
					{true, false, false, false},
				},

				{
					{true, true, true, true},
					{false, false, false, false},
					{false, false, false, false},
					{false, false, false, false},

				},

				{
					{false, false, true, false},
					{false, false, true, false},
					{false, false, true, false},
					{false, false, true, false},
				},

				{
					{false, false, false, false},
					{false, false, false, false},
					{true, true, true, true},
					{false, false, false, false},
				}
			};

	}
}