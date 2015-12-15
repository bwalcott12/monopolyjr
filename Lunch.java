/**
 * Lunch extends Space
 * Lunch doesn't do anything special, it is just used as a 
 * reference and a specific spot on the board so that when
 * the player lands on the GoToLunch space, the player
 * goes to this space.
 */
public class Lunch extends Space 
{
	/**
	 * Creates a Lunch space with a name and a location
	 * @param name the name of the space
	 * @param location the location of the space
	 */
	public Lunch(String name, int location) {
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

