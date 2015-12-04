import java.awt.Color;

/**
 * This class is a representation of a Piece
 * A piece has a color and a location on the board.
 * 
 * A piece can move itself to another space.
 */
public class Piece 
{
	// attributes
	private Color _color;
	private Space _location;
	private Board _board;
	
	/**
	 * Constructs a Piece with a color, location, and a reference to the board
	 * @param color
	 * @param location
	 * @param theBoard that the piece is on
	 */
	public Piece(Color color, Space location, Board theBoard)
	{
		_color = color;
		_location = location;
		_board = theBoard;
	}
	
	
	/**
	 * Moves the piece a certain number of spaces forward on the board
	 * @param numSpaces the number of spaces to move forward on the board
	 */
	public void move(int numSpaces)
	{
		// if we are at not at the end of the board, move
		if (_location.getLocation() + numSpaces <= 31)
			_location = _board.findSpace(_location.getLocation() + numSpaces);
		// else move to the begining of the board
		else
			_location = _board.findSpace(_location.getLocation() + numSpaces - 32);

	}
	
	
	/**
	 * Moves the piece to the desired space
	 * @param space the space to move to
	 */
	public void moveTo(Space space)
	{
		_location = space;
	}
	
	
	/**
	 * Returns the color of the piece
	 * @return the color of the piece
	 */
	public Color getColor()
	{
		return _color;
	}
	
	
	/**
	 * returns the location of the piece
	 * @return the location of the piece
	 */
	public Space getLocation()
	{
		return _location;
	}
}
