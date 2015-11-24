/**
 * This class is a representation of a Player.
 * A player owns a piece and has money. 
 * 
 * They can receive and give money as well as 
 * take their turn.
 * 
 * @author Chase
 *
 */
public class Tax extends Space {
	
	private int _taxValue;
	private LooseChange _moneyPool;
	
	/**
	 * Construct the Tax space, with the 
	 * same constructor as Space, but with the addition
	 * of a value parameter. This indicated the amout
	 * the player will be taxed upon landing on the space;
	 */
	public Tax(String name, int location, int taxValue, LooseChange moneyPool)
	{
		super(name, location);
		_taxValue = taxValue;
		_moneyPool = moneyPool;
	}
	
	@Override
	public void performRole(Player player)
	{
		player.takeMoney(_taxValue);
		_moneyPool.addToPool(_taxValue);
	}
}
