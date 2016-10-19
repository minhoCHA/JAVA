/**
 * TwoSorts.java
 * Demonstrate the command of arrays and simple sorting techniques.
 * Minho Cha
 * Date 2016-05-03
 */

import javax.swing.JFrame;

public class TwoSorts{
   //-----------------------------------------------------------------
   //  Creates the main program frame.
   //-----------------------------------------------------------------
   public static void main (String[] args){
      JFrame frame = new JFrame ("TwoSorts");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new TwoSortsPanel());

      frame.pack();
      frame.setVisible(true);
   }
}
