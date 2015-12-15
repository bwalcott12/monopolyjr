/**
 * This class is a representation of a Space on the board.
 * A space has a name and location.
 */
public abstract class Space 
{
	// attributes
	private String _name;
	private int _location;
	
	/**
	 * Constructs a Space with a name and location
	 * @param name the name of the space
	 * @param location the location of the space on the board
	 */
	public Space(String name, int location)
	{
		_name = name;
		_location = location;
	}
	
	
	/**
	 * returns the name of the space
	 * @return the name of the space
	 */
	public String getName()
	{
		return _name;
	}
	
	
	/**
	 * returns the location of the space
	 * @return the location of the space
	 */
	public int getLocation()
	{
		return _location;
	}
	
	
	/**
	 * Override this method in order to cause the 
	 * space to act on a specified player. This can
	 * be used to cause a player to draw a chance, buy
	 * a property, or pay money
	 */
	abstract public void performRole(Player player);
}

