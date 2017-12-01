/**
 * Represents the L-shaped Tetromino
 * and its Clockwise and Counter-Clockwise rotations
 * 
 * @author Carla Gonzalez-Vazquez
 *
 */
public class TetrominoL extends Tetrominoes{
	
	public TetrominoL(){
		//calls super class
		super();
			filledSquares = new boolean [][][]{
				{
					{true, true,false,false},
					{false, true, false, false},
					{false, true, false, false},
					{false, false, false, false},
				},

				{
					{false, false, true, false},
					{true, true, true, false},
					{false, false, false, false},
					{false, false, false, false},

				},

				{
					{false, true, false, false},
					{false, true, false, false},
					{false, true, true, false},
					{false, false, false, false},
				},

				{
					{false, false, false, false},
					{true, true, true, false},
					{true, false, false, false},
					{false, false, false, false},
				}
			};

	}
}
