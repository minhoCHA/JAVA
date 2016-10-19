/*
 * MagazineView.java
 * Creates the main frame of the program.
 *@author Lewis/Loftus
 *@modifer Ha Yee Chan, Minho Cha
 *@version 1.0
 *@since 2016-05-16
 */

import javax.swing.JFrame;

public class MagazineView
{
   //  Creates the main frame of the program.

   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("MagazineView");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      MagazineViewPanel panel = new MagazineViewPanel();

      frame.getContentPane().add(panel);
      frame.pack();
      frame.setVisible(true);

   }
}