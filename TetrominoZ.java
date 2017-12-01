/**
 * Represents the Z-shaped Tetromino
 * and its Clockwise and Counter-Clockwise rotations
 * 
 * @author Carla Gonzalez-Vazquez
 *
 */
public class TetrominoZ extends Tetrominoes{
	
	public TetrominoZ(){
		//calls super class
		super();
			filledSquares = new boolean [][][]{
				{
					{false, true,false,false},
					{true, true, false, false},
					{true, false, false, false},
					{false, false, false, false},
				},

				{
					{true, true, false, false},
					{false, true, true, false},
					{false, false, false, false},
					{false, false, false, false},

				},

				{
					{false, false, true, false},
					{false, true, true, false},
					{false, true, false, false},
					{false, false, false, false},
				},

				{
					{false, false, false, false},
					{true, true, false, false},
					{false, true, true, false},
					{false, false, false, false},
				}
			};

	}
}
