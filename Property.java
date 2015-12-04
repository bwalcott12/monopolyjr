import java.awt.Color;

/**
 * Property extends Space
 * Property has a value a color and a reference to the board
 * the Owner of this property is initially set to null
 * If the property is landed on, it can be bought by that player
 * else the player has to pay the owner rent.
 */
public class Property extends Space
{
	// attributes
	private int _value;
	private Color _color;
	private Board _board;
	private Player _owner;
	
	/**
	 * Constructor for the Property Space
	 * @param name
	 * @param location
	 * @param value
	 * @param color
	 * @param theBoard
	 */
	public Property(String name, int location, int value, Color color, Board theBoard)
	{
		super(name, location);
		_value = value;
		_color = color;
		_board = theBoard;
		_owner = null;
	}
	
	
	/**
	 * Returns the value of the property
	 * @return the value of the property
	 */
	public int getValue()
	{
		return _value;
	}
	
	
	/**
	 * Returns the color of the property
	 * @return the color of the property
	 */
	public Color getColor()
	{
		return _color;
	}
	
	
	/**
	 * Returns the owner of the property
	 * null if there is no owner
	 * @return the owner of the property
	 */
	public Player getOwner()
	{
		return _owner;
	}
	
	
	/**
	 * Sets the owner of the property
	 * @param player the player to be the owner of the property
	 */
	public void setOwner(Player player)
	{
		_owner = player;
	}
	
	
	/**
	 * checks if there is a neighboring property that is owned
	 * by the same player or not.
	 * @return if the owning player of a neighboring property is the same
	 */
	public boolean checkNeighbor()
	{
		boolean neighborIsOwnedBySamePlayer = false;
		Space neighboringSpace1 = _board.findSpace(super.getLocation() + 1);
		Space neighboringSpace2 = _board.findSpace(super.getLocation() - 1);
		
		// have to check for instanceof separately 
		// due to casting warnings from java
		
		// check neighboring space to the left if its a property 
		// and if it is owned by the same person
		if (neighboringSpace1 instanceof Property)
		{
			if (((Property) neighboringSpace1).getOwner() != null && 
					((Property) neighboringSpace1).getOwner().equals(_owner))
			{
				neighborIsOwnedBySamePlayer = true;
			}
		}
		// check neighboring space to the right
		else if (neighboringSpace2 instanceof Property)
		{
			if (((Property) neighboringSpace2).getOwner() != null && 
					((Property) neighboringSpace2).getOwner().equals(_owner))
			{
				neighborIsOwnedBySamePlayer = true;
			}
		}
		
		return neighborIsOwnedBySamePlayer;
	}
	
	
	/**
	 * Overrides the space method
	 * If the property is owned, the player has to pay rent
	 * else the player must buy the property from the bank
	 * @param player the player that landed on the space
	 */
	@Override
	public void performRole(Player player)
	{
		// if this has no owner
		if (_owner == null)
		{
			// take money from player
			player.takeMoney(_value);
			
			// player is now owner
			_owner = player;
		}
		// else if owned not by player 
		// and neighbor is not owned by the same player
		else if(!_owner.equals(player) && !checkNeighbor())
		{
			// transfer money from player to owner
			player.transferMoney(_value, _owner);
		}
		// else if owned not by player and
		// neighbor is owned by the same player
		else if(!_owner.equals(player) && checkNeighbor())
		{
			// transfer money from player to owner
			player.transferMoney(_value * 2, _owner);
		}		
	}
}
