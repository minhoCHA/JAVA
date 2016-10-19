/**
 * RandomSkyline.java       
 * Made by: Minho Cha
 * Date: 3/17/16
 * Demonstrates drawing methods and the use of color.
 * Made Random skyline with windows and stars
 */

import javax.swing.JFrame;

public class RandomSkyline{

	public static void main(String[ ] args){
		JFrame frame = new JFrame ("RandomSkyline");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the program when I close the program
		
		frame.getContentPane().add(new SkylinePanel());
		
		frame.pack();
		frame.setVisible(true);
	}
}
