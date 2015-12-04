import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
Prints "Hello, World". By tradition, this is everyone's first program.
This is the first Java file that everyone will see, woot!

Roses are red, violets are blue...
Coding is cool, so are cats... mic drop
*/

public class MonopolyJr {

    public static void main(String[] args) {       
        Map<Integer, Space> spaces = new HashMap<Integer, Space>();
        ChanceCardManager manager = new ChanceCardManager();
        Board theBoard = new Board(spaces);
        LooseChange looseChangeSpace= new LooseChange("Loose Change", 16);
        Lunch lunchSpace = new Lunch("Cafe", 10);
        Scanner input = new Scanner(System.in);
        
        // variable declaration
        boolean winner = false;
        
        // display board on screen
        ImageIcon icon = new ImageIcon();

		JFrame frame = new JFrame();

		icon = new ImageIcon("board_mid.png");
		
		JLabel label = new JLabel(icon);
		frame.add(label);
		frame.setDefaultCloseOperation
		(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setAlwaysOnTop (true);
		frame.setVisible(true);	

        
        // 2 pieces
        // 2 players
        // 16 properties
        // 1 LooseChange
        // 2 tax
        // 1 go
        // 1 lunch
        // 1 GoToLunch
        // 1 chanceCardManager
        // 6 chance
        // 4 railroad
        // 32 spaces total
        // 1 board
        
        spaces.put(0, new Go("Go", 0));
        spaces.put(1, new Chance("Chance", 1, manager));
        spaces.put(2, new Property("Balloon Stand", 2, 1, Color.MAGENTA, theBoard));
        spaces.put(3, new Property("Candy Floss", 3, 1, Color.MAGENTA, theBoard));
        spaces.put(4, new Chance("Chance", 4, manager));
        spaces.put(5, new Railroad("Yellow Line Railway", 5));
        spaces.put(6, new Property("Puppet Show", 6, 2, Color.WHITE, theBoard));
        spaces.put(7, new Property("Magic Show", 7, 2, Color.WHITE, theBoard));
        spaces.put(8, new Tax("Fireworks Tax", 8, 2, looseChangeSpace));
        spaces.put(9, new Chance("Chance", 9, manager));
        spaces.put(10, lunchSpace);
        spaces.put(11, new Property("Merry-Go-Round", 11, 2, Color.PINK, theBoard));
        spaces.put(12, new Property("Paddle Boats", 12, 2, Color.PINK, theBoard));
        spaces.put(13, new Railroad("Green Line Railway", 13));
        spaces.put(14, new Property("Water Slide", 14, 3, Color.ORANGE, theBoard));
        spaces.put(15, new Property("Mini Golf", 15, 3, Color.ORANGE, theBoard));
        spaces.put(16, looseChangeSpace);
        spaces.put(17, new Chance("Chance", 17, manager));
        spaces.put(18, new Property("Video Arcade", 18, 3, Color.RED, theBoard));
        spaces.put(19, new Property("Haunted House", 19, 3, Color.RED, theBoard));
        spaces.put(20, new Chance("Chance", 20, manager));
        spaces.put(21, new Railroad("Blue Line Railway", 21));
        spaces.put(22, new Property("Heliocopter Ride", 22, 4, Color.YELLOW, theBoard));
        spaces.put(23, new Property("Pony Ride", 23, 4, Color.YELLOW, theBoard));
        spaces.put(24, new Tax("Water Show Tax", 24, 2, looseChangeSpace));
        spaces.put(25, new Chance("Chance", 25, manager));
        spaces.put(26, new GoToLunch("Go To Cafe", 26, 3, looseChangeSpace, lunchSpace));
        spaces.put(27, new Property("Dodgems", 27, 4, Color.GREEN, theBoard));
        spaces.put(28, new Property("Big Wheel", 28, 4, Color.GREEN, theBoard));
        spaces.put(29, new Railroad("Red Line Railway", 29));
        spaces.put(30, new Property("Loop The Loop", 30, 5, Color.BLUE, theBoard));
        spaces.put(31, new Property("Roller Coaster", 31, 5, Color.BLUE, theBoard));
  
        // each player starts with $31 dollars (1x $5, 1x $4, 3x $3, 4x @$2, 5x $1)
        Piece player1Piece = new Piece(Color.BLUE, theBoard.findSpace(0), theBoard);
        Piece player2Piece = new Piece(Color.RED, theBoard.findSpace(0), theBoard);
        Player player1 = new Player(player1Piece, 31);
        Player player2 = new Player(player2Piece, 31);
        
        // while either player still has money continue the game
        while (!winner)
        {
        	if (player1.getMoney() > 0 && player2.getMoney() > 0)
        	{
	        	System.out.print("Player 1| Press enter to roll...");
	        	input.nextLine();
	        	System.out.print("Player 1| ");
	        	player1.takeTurn();
	        	System.out.println("");
	        	if (player1.getMoney() <= 0)
	        	{
	        		System.out.println("Congratulations! Player 2 Wins!!!");
	        		winner = true;
	        	}
        	}
        	
        	if (player1.getMoney() > 0 && player2.getMoney() > 0)
        	{
	        	System.out.print("Player 2| Press enter to roll...");
	        	input.nextLine();
	        	System.out.print("Player 2| ");
	        	player2.takeTurn();
	        	System.out.println("");
	        	if (player2.getMoney() <= 0)
	        	{
	        		System.out.println("Congratulations! Player 1 Wins!!!");
	        		winner = true;
	        	}
        	}

        }
    }
}
// eof