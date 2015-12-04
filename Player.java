import java.util.Random;

/**
 * This class is a representation of a Player.
 * A player owns a piece and has money. 
 * 
 * They can receive and give money as well as 
 * take their turn.
 */
public class Player 
{
	// attributes
	private Piece _ownsPiece;
	private int _money;
	private int _previousNumberRolled;
	
	/**
	 * Constructs a player with a piece and initial money amount
	 * @param ownsPiece the Piece that the player owns
	 * @param money the amount of money the player owns
	 */
	public Player(Piece ownsPiece, int money)
	{
		_ownsPiece = ownsPiece;
		_money = money;
		_previousNumberRolled = 0;
	}
	
	/**
	 * Takes the turn of the player by rolling the dice
	 * and moving the desired amount of spaces and if the player
	 * passed go they collect $2
	 */
	public void takeTurn()
	{
		
		// roll dice
		rollDice();
		
		System.out.print("Dice Rolled: " + _previousNumberRolled + "| Money Before: " + _money + "| ");
		
		// see if we are going to pass go
		if (_ownsPiece.getLocation().getLocation() + _previousNumberRolled > 31)
		{
			getGoMoney();
			System.out.print("Passed GO| ");
		}
		
		// tell piece to move
		_ownsPiece.move(_previousNumberRolled);
		
		System.out.print("Moved To: " + _ownsPiece.getLocation().getName() + "| ");
		
		// piece performs role on space or player performs role
		_ownsPiece.getLocation().performRole(this);
		
		System.out.print("End Money: " + _money + "| \n");
	}
	
	/**
	 * Generates a random number between 1 and 6 and
	 * sets the previous number rolled to it
	 * @return the number rolled between 1 and 6
	 */
	public int rollDice()
	{
		Random rand = new Random();
		_previousNumberRolled = rand.nextInt(6) + 1;
		return _previousNumberRolled;
	}
	
	
	/**
	 * Takes money from the current player and gives it to the
	 * Receiving player
	 * @param value the amount to be transfered
	 * @param recipient the player to receive the money
	 */
	public void transferMoney(int value, Player recipient)
	{
		// if the player has no money left to give, give all they have
		if (value > _money)
		{
			// take money from the player
			takeMoney(_money);
			// give it to the recipient
			recipient.giveMoney(_money);
		}
		else
		{
			takeMoney(value);
			recipient.giveMoney(value);
		}
	}
	
	
	/**
	 * Returns the players money amount
	 * @return the players money amount
	 */
	public int getMoney()
	{
		return _money;
	}
	
	
	/**
	 * Gives the player the desired amount of money
	 * @param money the amount to receive
	 */
	public void giveMoney(int money)
	{
		_money += money;
	}
	
	/**
	 * Takes the desired amount of money away from the player
	 * @param money the amount to take away from the player
	 */
	public void takeMoney(int money)
	{
		_money -= money;
	}
	
	
	/**
	 * Returns the piece of the player
	 * @return the player's piece
	 */
	public Piece getPiece()
	{
		return _ownsPiece;
	}
	
	
	/**
	 * gets the previous roll of the player
	 * @return the previous roll of the player
	 */
	public int getPreviousRoll()
	{
		return _previousNumberRolled;
	}
	
	
	/**
	 * gives the player money for passing GO
	 */
	public void getGoMoney()
	{
		giveMoney(2);
	}

}
