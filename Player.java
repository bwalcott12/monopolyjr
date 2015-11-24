import java.util.Random;

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
public class Player 
{
	private Piece _ownsPiece;
	private int _money;
	private int _previousNumberRolled;
	
	public Player(Piece ownsPiece, int money)
	{
		_ownsPiece = ownsPiece;
		_money = money;
		_previousNumberRolled = 0;
	}
	
	public void takeTurn()
	{
		
		// roll dice
		rollDice();
		
		// tell piece to move
		_ownsPiece.move(_previousNumberRolled);
		
		// piece performs role on space or player performs role
		_ownsPiece.getLocation().performRole(this);
		
	}
	
	public int rollDice()
	{
		Random rand = new Random();
		_previousNumberRolled = rand.nextInt(6) + 1;
		return _previousNumberRolled;
	}
	
	public void transferMoney(int value, Player recipient)
	{
		if (value > _money)
		{
			giveMoney(_money);
			recipient.takeMoney(_money);
		}
		else
		{
			giveMoney(value);
			recipient.takeMoney(value);
		}
	}
	
	public int getMoney()
	{
		return _money;
	}
	
	public void giveMoney(int money)
	{
		_money -= money;
	}
	
	public void takeMoney(int money)
	{
		_money += money;
	}
	
	public int getPreviousRoll()
	{
		return _previousNumberRolled;
	}

}
