/**
 * Represents the S-shaped Tetromino
 * and its Clockwise and Counter-Clockwise rotations
 * 
 * @author Carla Gonzalez-Vazquez
 *
 */
public class TetrominoS extends Tetrominoes{
	
	public TetrominoS(){
		//calls super class
		super();
			filledSquares = new boolean [][][]{
				{
					{true, false,false,false},
					{true, true, false, false},
					{false, true, false, false},
					{false, false, false, false},
				},

				{
					{false, true, true, false},
					{true, true, false, false},
					{false, false, false, false},
					{false, false, false, false},

				},

				{
					{false, true, false, false},
					{false, true, true, false},
					{false, false, true, false},
					{false, false, false, false},
				},

				{
					{false, false, false, false},
					{false, true, true, false},
					{true, true, false, false},
					{false, false, false, false},
				}
			};

	}
}
