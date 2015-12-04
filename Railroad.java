/**
 * Railroad extends Space
 * Railroad makes the player take an extra turn and
 * a chance card that points to it.
 */
public class Railroad extends Space
{
	/**
	 * Constructs a Railroad with a name and a location
	 * @param name the name of the space
	 * @param location the location of the space
	 */
	public Railroad(String name, int location)
	{
		super(name, location);
	}

	/**
	 * Overrides the performRole of space
	 * when the player lands on this space they take an additional turn
	 */
	@Override
	public void performRole(Player player) 
	{
		player.takeTurn();
	}
}
