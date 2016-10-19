import java.awt.Color;
import java.awt.Graphics;

public class Building{
	private int width, height, x, y, window;
	private Color color;

	//-----------------------------------------------------------------
	//  Constructor which sets up the buildings and windows
	//-----------------------------------------------------------------
	public Building(Color shade, int upperX, int upperY, int buildWidth, int buildHeight){
		width = buildWidth;
		height = buildHeight;
		color = shade;
		x = upperX;
		y = upperY;
		window = 3+(int)(Math.random()*10); // set the number of windows randomly
	}

	public void draw(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
		//draw windows
		for(int count = 0; count < window; count++){
			g.setColor(Color.lightGray);
			g.fillRect ((x + 10) + (int)(Math.random() * (width  - 20)), (y + 10) + (int)(Math.random() * (height - 20)), 5, 5);		
		}

	}
	
	// set width
	public void setWidth(int buildWidth){
		width = buildWidth;
	}
	//set height
	public void setHeight(int buildHeight){
		height = buildHeight;
	}
	// set color
	public void setColor(Color shade){
		color = shade;
	}
	// set x
	public void setX(int upperX){
		x = upperX;
	}
	// set y
	public void setY(int upperY){
		y = upperY;
	}
	// get width
	public int getWidth(){
		return width;
	}
	// get height
	public int getHeight(){
		return height;
	}
	//get color
	public Color getcolor(){
		return color;
	}
	// get x
	public int getX(){
		return x;
	}
	// get y
	public int getY(){
		return y;
	}
}