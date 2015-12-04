import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/*
Prints "Hello, World". By tradition, this is everyone's first program.
This is the first Java file that everyone will see, woot!

Roses are red, violets are blue...
Coding is cool, so are cats... mic drop
*/

public class HelloWorld {

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");
        
        Map<Integer, Space> spaces = new HashMap<Integer, Space>();
        ChanceCardManager manager = new ChanceCardManager();
        Board theBoard = new Board(spaces);
        LooseChange looseChangeSpace= new LooseChange("LooseChange", 16);
        Lunch lunchSpace = new Lunch("Lunch", 10);

        
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
        spaces.put(1, new Chance("Chance 1", 1, manager));
        spaces.put(2, new Property("Magenta 1", 2, 1, Color.MAGENTA, theBoard));
        spaces.put(3, new Property("Magenta 2", 3, 1, Color.MAGENTA, theBoard));
        spaces.put(4, new Chance("Chance 2", 4, manager));
        spaces.put(5, new Railroad("Railroad 1", 5));
        spaces.put(6, new Property("White 1", 6, 2, Color.WHITE, theBoard));
        spaces.put(7, new Property("White 2", 7, 2, Color.WHITE, theBoard));
        spaces.put(8, new Tax("Fireworks Tax", 8, 2, looseChangeSpace));
        spaces.put(9, new Chance("Chance 3", 9, manager));
        spaces.put(10, lunchSpace);
        spaces.put(11, new Property("Pink 1", 11, 2, Color.PINK, theBoard));
        spaces.put(12, new Property("Pink 2", 12, 2, Color.PINK, theBoard));
        spaces.put(13, new Railroad("Railroad 2", 13));
        spaces.put(14, new Property("Orange 1", 14, 3, Color.ORANGE, theBoard));
        spaces.put(15, new Property("Orange 2", 15, 3, Color.ORANGE, theBoard));
        spaces.put(16, looseChangeSpace);
        spaces.put(17, new Chance("Chance 4", 17, manager));
        spaces.put(18, new Property("Red 1", 18, 3, Color.RED, theBoard));
        spaces.put(19, new Property("Red 2", 19, 3, Color.RED, theBoard));
        spaces.put(20, new Chance("Chance 5", 20, manager));
        spaces.put(21, new Railroad("Railroad 3", 21));
        spaces.put(22, new Property("Yellow 1", 22, 4, Color.YELLOW, theBoard));
        spaces.put(23, new Property("Yellow 2", 23, 4, Color.YELLOW, theBoard));
        spaces.put(24, new Tax("Dolphin Show Tax", 24, 2, looseChangeSpace));
        spaces.put(25, new Chance("Chance 6", 25, manager));
        spaces.put(26, new GoToLunch("Go To Lunch", 26, 3, looseChangeSpace, lunchSpace));
        spaces.put(27, new Property("Green 1", 27, 4, Color.GREEN, theBoard));
        spaces.put(28, new Property("Green 2", 28, 4, Color.GREEN, theBoard));
        spaces.put(29, new Railroad("Railroad 4", 29));
        spaces.put(30, new Property("Blue 1", 30, 5, Color.BLUE, theBoard));
        spaces.put(31, new Property("Blue 2", 31, 5, Color.BLUE, theBoard));
  

        
        Piece player1Piece = new Piece(Color.BLUE, theBoard.findSpace(0), theBoard);
        Piece player2Piece = new Piece(Color.RED, theBoard.findSpace(0), theBoard);
        Player player1 = new Player(player1Piece, 20);
        Player player2 = new Player(player2Piece, 20);
        
        for (int i = 0; i < 10; i++)
        {
        	System.out.print("Player 1| ");
        	player1.takeTurn();
        	System.out.print("Player 2| ");
        	player2.takeTurn();
        }
        
/*
        // test and see if everything was entered correctly
        for (int i = 0; i < 32; i++)
        {
        	System.out.println(theBoard.findSpace(i).getLocation() + " " + theBoard.findSpace(i).getName());
        }
      */  

        

        
        System.out.println("This is a " + theBoard.findSpace(1).getName() + " with location: " + theBoard.findSpace(1).getLocation());
        
    }
}
// eof

// Cats are cool.

// test

//BitterPoison is in the System
//secondTest