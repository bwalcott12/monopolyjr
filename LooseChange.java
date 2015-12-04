/**
 * LooseChange extends space
 * It has a pool where it keeps all the money collected
 * from tax locations, and if a player lands on this space
 * it gives that player all the collected money
 */
public class LooseChange extends Space 
{
	// attributes
	private int _pool;
	
	/**
	 * Constructs a LooseChange space with a name and a location
	 * and an empty pool to start
	 * @param name the name of the space
	 * @param location the location of the space
	 */
	public LooseChange(String name, int location)
	{
		super(name, location);
		_pool = 0;
	}
	
	
	/**
	 * Removes all money from the pool
	 * @return the amount removed from the pool
	 */
	public int emptyPool()
	{
		int poolAmount = _pool;
		_pool = 0;
		return poolAmount;
	}
	
	
	/**
	 * Adds money to the pool
	 * @param money the amount to add to the pool
	 */
	public void addToPool(int money)
	{
		_pool += money;
	}
	
	
	/**
	 * Returns the pool
	 * @return the pool
	 */
	public int getPool()
	{
		return _pool;
	}
	
	
	/**
	 * Overrides the PerformRole method in space
	 * and this empties the pool and gives the money to the player
	 * @param the player that landed on the space
	 */
	@Override
	public void performRole(Player player)
	{
		player.giveMoney(emptyPool());
	}

}
