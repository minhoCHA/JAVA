
/*
 * Magazine.java
 * Represents a single magazine.
 *@author Lewis/Loftus
 *@modifer Ha Yee Chan, Minho Cha
 *@version 1.0
 *@since 2016-05-16
 */


public class Magazine
{
   private String title;

   //  Sets up the new magazine with its title.

   public Magazine (String newTitle)
   {
      title = newTitle;
   }

   //  Returns this magazine as a string.

   public String toString ()
   {
      return title;
   }
}
