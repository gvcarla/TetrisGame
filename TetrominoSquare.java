/**
 * Represents Square-shaped Tetromino
 * and its Clockwise and Counter-Clockwise rotations
 * 
 * 
 * @author Carla Gonzalez-Vazquez
 *
 */
public class TetrominoSquare extends Tetrominoes{
	//public boolean filledSquares;
	public TetrominoSquare(){
		super();
			filledSquares = new boolean [][][]{
				{
					{false, false, false, false},
				 	{true, true, false, false}, 
				 	{true, true, false, false}, 
				 	{false, false, false, false},
				},

				{
					{false, false, false, false},
					{false, true, true, false},
					{false, true, true, false},
					{false, false, false, false},

				},

				{
					{false, false, false, false},
					{false, true, true, false},
					{false, true, true, false},
					{false, false, false, false},
				},

				{
					{false, false, false, false},
					{false, true, true, false},
					{false, true, true, false},
					{false, false, false, false},
				}
			};

	}
}
