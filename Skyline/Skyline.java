//********************************************************************
//  Skyline.java       
//  Made by: Minho Cha
//  Date: 2/23/16
//  Demonstrates drawing methods and the use of color.
//  Made skyline with 5 buildings and windows. 
//********************************************************************

import javax.swing.JFrame;

public class Skyline 
{

	public static void main(String[ ] args)
	{
		JFrame frame = new JFrame ("Skyline");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the program when I close the program
		
		frame.getContentPane().add(new SkylinePanel());
		
		frame.pack();
		frame.setVisible(true);
	}
}
