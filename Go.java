/**
 * Go extends Space
 * Go doesn't do anything, its just a special space that has
 * a chance card that points to it.
 */
public class Go extends Space
{
	/**
	 * Constructs a Go space by calling the space constructor
	 * @param name the name of the space
	 * @param location the location of the space
	 */
	public Go(String name, int location) 
	{
		super(name, location);
	}

	/**
	 * Overrides the performRole in space
	 * but Go doesn't do anything specific
	 * @param player the player to perform the role on
	 */
	@Override
	public void performRole(Player player) {}

}
