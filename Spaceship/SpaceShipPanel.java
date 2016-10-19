import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class SpaceShipPanel extends JPanel{
	
   private Point point;
   private Button reset;
   private Label label;
   private Button sound;
   private int count;
   private int click;
   private boolean shot;
   private boolean sounds;


   //-----------------------------------------------------------------
   //  Constructor: Sets up this panel to listen for mouse events.
   //-----------------------------------------------------------------
   public SpaceShipPanel(){
	   
      SpaceShipListener listener = new SpaceShipListener();
      addMouseListener (listener);
      addMouseMotionListener (listener);
      
      // make the reset button
      reset = new Button("Reset");
      reset.addActionListener(new Butn1Handler());
      add(reset);
      count = 0;
      shot = false;
      
      // make the sound control button
      sound = new Button("Sound On/Off");
      sound.addActionListener(new Butn2Handler());
      add(sound);
            
      // make the shot counter label
	  label = new Label(count + " shots");
      label.setBackground (Color.white);
      label.setFont(new Font("Arial", 10, 15));
      add(label);

      setBackground (Color.black);
      setPreferredSize (new Dimension(600, 400));
      
   }
   
   
   File Fire = new File("LaserSound.wav");

   static void PlaySound(File Sound){
	   
      try{
         Clip clip = AudioSystem.getClip();
         clip.open(AudioSystem.getAudioInputStream(Sound));
         clip.start();
         
         //Thread.sleep(clip.getMicrosecondLength()/1000);
      }catch(Exception e){
      
      }
         
   }

   //-----------------------------------------------------------------
   //  Draws the current line from the intial mouse-pressed point to
   //  the current position of the mouse.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page){
	   
	  int setX = 0;
	  int setY = 0;
	  
      super.paintComponent (page);
      
      if(shot == true){
    	  
    	  // change the color each time it is fired
    	  if(count%4 == 0){
    		  page.setColor(Color.blue);
    	  }
    	  else if(count%4 == 1){
    		  page.setColor(Color.green);
    	  }
    	  else if(count%4 == 2){
    		  page.setColor(Color.red);
    	  }
    	  else if(count%4 == 3){
    		  page.setColor(Color.yellow);
    	  }
		      	  
    	  // set the laser points randomly
    	  setX = (int) (1000*Math.random());
    	  setY = (int) (100*Math.random());
    	  
    	  page.drawLine(setX, setY, point.x-20, point.y-30);
    	  
    	  //---------------------------------
    	  //  count the shots
    	  //---------------------------------
			count = count + 1;
			label.setText(count + " shots");     
      }
      
      //------------------------------
      //  Draw spaceship
      //------------------------------
      if(point != null){
    	  			
    	  page.setColor(Color.red);
          page.fillOval(point.x-35, point.y+20, 20, 40);
          page.setColor(Color.yellow);
          page.fillOval(point.x-30, point.y+20, 10, 30);
          page.setColor(Color.gray);
          page.fillOval(point.x-40, point.y-50, 30, 50);
          page.setColor(Color.gray);
          page.fillRect(point.x-40, point.y-30, 30, 60);
          page.setColor(Color.gray);
          page.fillRect(point.x-10, point.y, 30, 20);
          page.setColor(Color.gray);
          page.fillRect(point.x-70, point.y, 30, 20);
          page.setColor(Color.yellow); 
          page.fillRect(point.x-18, point.y-30, 5, 5);
          page.setColor(Color.yellow);
          page.fillRect(point.x-35, point.y-30, 5, 5);
      }
      

   }

   //*****************************************************************
   //  Represents the listener for all mouse events.
   //*****************************************************************
   private class SpaceShipListener implements MouseListener,
                                         MouseMotionListener{
	   
	  //--------------------------------------------------------------
      //  Shots laser at which the mouse button is
      //  pressed.
      //--------------------------------------------------------------
      public void mousePressed (MouseEvent event){
    	  
         point = event.getPoint();
         shot = true;
         repaint();
         
         if (shot = true){
              PlaySound(Fire);
         }
      }

      //--------------------------------------------------------------
      //  Gets the current position of the mouse as it is dragged and
      //  redraws the shapes to create the spaceship.
      //--------------------------------------------------------------
      public void mouseDragged (MouseEvent event){
    	  
    	  shot = false;
          point = event.getPoint();
          repaint();
      }
      
      public void mouseMoved (MouseEvent event){
    	  
    	  shot = false;
     	  point = event.getPoint();
     	  repaint();
      }

    
      //--------------------------------------------------------------
      //  Provide empty definitions for unused event methods.
      //--------------------------------------------------------------
      public void mouseClicked (MouseEvent event) {}
      public void mouseReleased (MouseEvent event) {}
      public void mouseEntered (MouseEvent event) {}
      public void mouseExited (MouseEvent event) {}
   }
   
   
   //------------------------------
   //  Control the reset button
   //------------------------------
   private class Butn1Handler implements ActionListener{

	   
	public void actionPerformed(ActionEvent e) {

			count = 0;
			label.setText(count + " shots");
	}   
   }
   
   //------------------------------
   //  Control the sound effects
   //------------------------------
   private class Butn2Handler implements ActionListener{

		  public void actionPerformed (ActionEvent e){
			  
				if(click%2 == 0){
					sounds = true;
				}
				else if(click%2 == 1){
					sounds = false;
				}
	      }
	}
   
   
}
