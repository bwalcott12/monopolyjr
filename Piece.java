import java.awt.Color;

/**
 * This class is a representation of a Piece
 * A piece has a color and a location on the board.
 * 
 * A piece can move itself to another space.
 * 
 * @author Chase
 *
 */
public class Piece 
{
	private Color _color;
	private Space _location;
	private Board _board;
	
	public Piece(Color color, Space location, Board theBoard)
	{
		_color = color;
		_location = location;
		_board = theBoard;
	}
	
	public void move(int numSpaces)
	{
		_location = _board.findSpace(_location.getLocation() + numSpaces);
	}
	
	public void moveTo(Space space)
	{
		_location = space;
	}
	
	
	public Color getColor()
	{
		return _color;
	}
	
	public Space getLocation()
	{
		return _location;
	}
}
