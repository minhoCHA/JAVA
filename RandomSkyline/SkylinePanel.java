import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
//********************************************************************
//SkylinePanel class used for drawing shapes 
//********************************************************************
public class SkylinePanel extends JPanel{
	
	private Building building;
	private Star star;
	//-----------------------------------------------------------------
    //  Draws a RandomSkyline.
    //-----------------------------------------------------------------
	public SkylinePanel(){
		// set the color and the size of background
		setPreferredSize (new Dimension(680, 580));
		setBackground (Color.darkGray);
	}
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		final int MAX_STARS = 50;
		Random generator = new Random();
		int numBuildings = 5; // set the number of buildings
		int buildX = 10; // set the beginning of location of x
		int buildY = (int)(Math.random()*350 +125); // set the random location of y
		int buildWidth, buildHeight;
		int gap;

		//draw stars
		for(int i = 0; i < MAX_STARS; i++){
		star = new Star((int)(Math.random()*680),(int)(Math.random()*580), 2, 2); // set the random location of stars
		star.draw(g);
		}
		for(int count = 0; count < numBuildings; count++){
			gap = 10+(int)(Math.random()*40); // generate random gap
			buildWidth = (int)(Math.random()*50)+65; // generate random width
			buildHeight = 500-buildY; // generate random height
			
			// draw buildings
			building = new Building(Color.black, buildX, buildY, buildWidth, buildHeight);
			building.draw(g);
			
			// draw other buildings
			buildX = buildX + buildWidth + gap;
			buildY = buildY + (generator.nextInt() % 30);
		}
		
		//draw the ground
		g.setColor(Color.black);
		g.fillRect(0, 500, 680, 80);
		
		//name the city
		g.setColor(Color.white);
		g.drawString("Minho Cha's Random Skyline", 240, 545);
	}

}