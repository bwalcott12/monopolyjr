package gui;
import java.util.Random;

public class testDice 
{	
	
	public static void main(String[] args) { 	
		
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(6);
		
		randomInt += 1;	
	}
}