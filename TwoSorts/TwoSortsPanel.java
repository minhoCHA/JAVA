/**
 * TwoSortsPanel.java
 * Shows the output of two sorting algorithms: insertion sort and selection sort
 * Minho Cha
 * Date 2016-05-03
 */

/**
 * Generate and store random numbers in arrays
 * Add a buttom and a label
 * Draw rectangles
 * Do insertion sort and selection sort
 * Redraw rectangles
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class TwoSortsPanel extends JPanel{
   private static int count1=0, count2=1;
   private JButton sort;
   private JLabel label;
   private int[] rect1 = new int[15];
   private int[] rect2 = new int[15];
   Random generator = new Random();
   boolean s = false;


   //-----------------------------------------------------------------
   //  Constructor: Sets up the GUI.
   //-----------------------------------------------------------------
   public TwoSortsPanel (){
      //Create a button
      sort = new JButton ("Sort Me!");
      sort.addActionListener (new ButtonListener());

      //Create a label
      label = new JLabel ("Yellow Selection/Red Bubble");

      add (sort);
      add (label);

      //Generate and store random numbers in arrays
      int n;
      for(int i=0; i<15; i++){
        n = generator.nextInt(100);
        rect1[i] = n;
        rect2[i] = n;
        //Check and recover repeated values
        for(int m = 0; m<i; m++){
			if(n == rect1[m])
			  i--;
     	}
       }
      setPreferredSize (new Dimension(550, 300));
      setBackground (Color.cyan);
   }

   public void paintComponent(Graphics page){
	   super.paintComponent(page);

       //Sign my name
	   page.setColor(Color.black);
	   page.drawString("Minho Cha", 10, 20);

        //Draw rectangles
 	    int x = 0;
	    for(int j=0; j<rect1.length; j++){
	    	page.setColor(Color.red);
	    	page.fillRect(20+x, 150, 20, rect1[j]);
	        page.setColor(Color.yellow);
	     	page.fillRect(20+x, 150-rect2[j], 20, rect2[j]);
	    	x = x+25;
		}

       //Use selection sort and insertion sort
	   if(s == true && count1<rect1.length-1 && count2<rect2.length){
		   selectionSort(rect1);
		   insertionSort(rect2);
		   count1++;
		   count2++;
	   }
	   else if(count1>=rect1.length-1 && count2>=rect2.length){
		   //Rename the buttom and the label and redraw rectangles after sorting is done
		   x = 0;
           for(int j=0; j<rect1.length; j++){
                page.setColor(Color.white);
		   	    page.fillRect(20+x, 150, 20, rect1[j]);
                page.setColor(Color.white);
		   	    page.fillRect(20+x, 150-rect2[j], 20, rect2[j]);
	        	x = x+25;
	       }
		   label.setText("Done!");
		   sort.setText("Done!");
	   }
   }

   //  Sorts the specified array of objects using the selection
   //  sort algorithm.
  public static void selectionSort (int[] list){
       int min, temp;

          min = count1;
          for (int scan = count1+1; scan < list.length; scan++){
             if (list[scan] < list[min]){
                min = scan;}
          }

          // Swap the values
          temp = list[min];
          list[min] = list[count1];
          list[count1] = temp;

    }

    //  Sorts the specified array of objects using the insertion
    //  sort algorithm.
    public static void insertionSort (int[] list){
          int key = list[count2];
          int position = count2;

          //  Shift larger values to the right
          while (position > 0 && key < list[position-1]){
             list[position] = list[position-1];
             position--;
          }

          list[position] = key;
    }

   //  Represents a listener for button push (action) events.
   private class ButtonListener implements ActionListener{

      //  Updates the counter and label when the button is pushed.
      public void actionPerformed (ActionEvent event){
         s = true;
         repaint();
      }
   }
}
