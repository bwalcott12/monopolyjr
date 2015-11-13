package gui;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class displayDice
{	 
	public displayDice(int num)
	{
		ImageIcon icon = new ImageIcon();
				
		  JFrame frame = new JFrame();
		  if (num == 1)
		  {
			  icon = new ImageIcon("MonopolyJr/gui/dice1.jpeg");
		  }
		  if( num == 2)
		  {
			  icon = new ImageIcon("MonopolyJr/gui/dice2.jpeg");
		  }
		  
		  if( num == 3)
		  {
			  icon = new ImageIcon("MonopolyJr/gui/dice3.jpeg");
		  }
		  
		  if( num == 4)
		  {
			  icon = new ImageIcon("MonopolyJr/gui/dice4.jpeg");
		  }
		  
		  if( num == 5)
		  {
			  icon = new ImageIcon("MonopolyJr/gui/dice5.jpeg");
		  }
		  
		  if( num == 6)
		  {
			  icon = new ImageIcon("MonopolyJr/gui/dice6.jpeg");
		  }
		  
		  JLabel label = new JLabel(icon);
		  frame.add(label);
		  frame.setDefaultCloseOperation
		         (JFrame.EXIT_ON_CLOSE);
		  frame.pack();
		  frame.setVisible(true);	
	}
}