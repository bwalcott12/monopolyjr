/**
 * 
 */

/**
 * @author brandonwalcott
 *
 */
public class LooseChange extends Space 
{
	private int _pool;
	
	public LooseChange(String name, int location)
	{
		super(name, location);
		_pool = 0;
	}
	
	public int emptyPool()
	{
		int poolAmount = _pool;
		_pool = 0;
		return poolAmount;
	}
	
	public void addToPool(int money)
	{
		_pool += money;
	}
	
	public int getPool()
	{
		return _pool;
	}
	
	@Override
	public void performRole(Player player)
	{
		player.giveMoney(emptyPool());
	}

}
