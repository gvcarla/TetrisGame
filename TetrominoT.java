/**
 * Represents T-shaped Tetromino
 * and its Clockwise and Counter-Clockwise rotations
 * 
 * 
 * @author Carla Gonzalez-Vazquez
 *
 */
public class TetrominoT extends Tetrominoes{
	
	public TetrominoT(){
		//calls super class
		super();
			filledSquares = new boolean [][][]
			{
				{	
					{false, false,false,false},
					{true, true, true, false},
					{false, true, false, false},
					{false, false, false, false},
				},

				{
					{false, true, false, false},
					{false, true, true, false},
					{false, true, false, false},
					{false, false, false, false},

				},

				{
					{false, true, false, false},
					{true, true, true, false},
					{false, false, false, false},
					{false, false, false, false},
				},

				{
					{false, true, false, false},
					{true, true, false, false},
					{false, true, false, false},
					{false, false, false, false},
				}
			};

	}
}
