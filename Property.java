import java.awt.Color;

public class Property extends Space
{
	private int _value;
	private Color _color;
	private Board _board;
	private Player _owner;
	
	
	public Property(String name, int location, int value, Color color, Board theBoard)
	{
		super(name, location);
		_value = value;
		_color = color;
		_board = theBoard;
		_owner = null;
	}
	
	public int getValue()
	{
		return _value;
	}
	
	public Color getColor()
	{
		return _color;
	}
	
	public Player getOwner()
	{
		return _owner;
	}
	
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
		if (neighboringSpace1 instanceof Property)
		{
			if (((Property) neighboringSpace1).getOwner().equals(_owner))
			{
				neighborIsOwnedBySamePlayer = true;
			}
		}
		else if (neighboringSpace2 instanceof Property)
		{
			if (((Property) neighboringSpace2).getOwner().equals(_owner))
			{
				neighborIsOwnedBySamePlayer = true;
			}
		}
		
		return neighborIsOwnedBySamePlayer;
	}
	
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
