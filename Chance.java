/**
 * Chance extends space
 * Chance's role is to tell the ChanceCardManager to 
 * 
 */
public class Chance extends Space 
{
	// attributes
	private ChanceCardManager _manager;
	
	/**
	 * Constructs a Chance space with a name, laocation
	 * and a reference to the card manager.
	 * @param name
	 * @param location
	 * @param manager
	 */
	public Chance(String name, int location, ChanceCardManager manager) 
	{
		super(name, location);
		_manager = manager;
	}

	@Override
	public void performRole(Player player) 
	{
		// need to chose a random card from chance card manager
			// the manager should choose a card and the card should
			// perform its role on the player and it should
			// add money to the player if they pass go
	}

}

