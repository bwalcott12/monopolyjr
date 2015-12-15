/**
 * GoToLunch extends Tax
 * only difference is that this has a reference to a Lunch space
 * which the player gets moved to when they land on this space
 */
public class GoToLunch extends Tax 
{
	// attributes
	private Lunch _lunchSpace;
	
	/**
	 * Constructs a GoToLunch space
	 * @param name
	 * @param location
	 * @param taxValue
	 * @param moneyPool
	 * @param lunchSpace
	 */
	public GoToLunch(String name, int location, int taxValue, LooseChange moneyPool, Lunch lunchSpace) 
	{
		super(name, location, taxValue, moneyPool);
		_lunchSpace = lunchSpace;
	}
	
	
	/**
	 * Overrides the performRole in tax and space
	 * performs the tax performRole and moves the player to Lunch space
	 * @param player the player to give money to and move to Lunch
	 */
	@Override
	public void performRole(Player player)
	{
		super.performRole(player);
		player.getPiece().moveTo(_lunchSpace);
	}

}

