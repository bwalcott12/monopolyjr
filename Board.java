import java.util.ArrayList;
import java.util.Map;

/**
 * This class is a representation of a Board.
 * A board has spaces to which it can reference.
 *
 */
public class Board 
{
	
	// variable declaration
	private Map<Integer, Space> _spaces;
	
	/**
	 * Creates a board with a map of spaces
	 * @param spaces the spaces that make up the board
	 */
	public Board(Map<Integer, Space> spaces)
	{
		_spaces = spaces;
	}
	
	/**
	 * Returns a list of the spaces on the board
	 * @return the spaces
	 */
	public ArrayList<Space> getSpaces()
	{
		return new ArrayList<Space>(_spaces.values());
	}
	
	/**
	 * Gets and returns the space at the desired location
	 * if the location is present, if not it returns null
	 * @param spaceNum the integer of the location
	 * @return the space at desired location, else returns null
	 */
	public Space findSpace(int spaceNum)
	{
		if (_spaces.containsKey(spaceNum))
			return _spaces.get(spaceNum);
		else
			return null;
	}
	
}
