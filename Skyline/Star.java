import java.awt.*;
import java.util.Random;

public class Star
{
   private int width, height, x , y;
    Random generator = new Random();
	//-----------------------------------------------------------------
	//  Constructor which sets up the stars
	//-----------------------------------------------------------------
   public Star (int starX, int starY, int starWidth, int starHeight){
	   x = starX;
	   y = starY;
	   width = starWidth;
	   height = starHeight;
   }
    
   public void draw (Graphics g){
	   g.setColor (Color.yellow);
       g.fillRect (x, y, width, height);
   }
}
