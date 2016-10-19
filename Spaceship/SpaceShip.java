/**
 * SpaceShip.java
 * Demonstrates to use the principles of object-oriented design to create appropriate classes, methods, instance data, components, event listeners and handlers.
 * Made SpaceShip program
 *
 *@author Minho Cha
 *@version 1.0
 *@since 2016-04-14
 */

import javax.swing.JFrame;

public class SpaceShip {
	
	//---------------------------------------------
	//  Creates and displays the application frame
	//---------------------------------------------
	public static void main (String[] args){
		
		JFrame frame = new JFrame("Spaceship");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new SpaceShipPanel());
	      
		frame.pack();
		frame.setVisible(true);
	}

}
