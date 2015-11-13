package gui;
import java.util.Random;

public class testDice 
{	
	
	public int testDice()
	{
		
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(6);
		
		randomInt += 1;
		
		return(randomInt);
	}


}