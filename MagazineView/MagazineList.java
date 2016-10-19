
/*
 * MagazineList.java
 * Represents a collection of magazines.
 *@author Lewis/Loftus
 *@modifer Ha Yee Chan, Minho Cha
 *@version 1.0
 *@since 2016-05-16
 */

public class MagazineList
{
   private MagazineNode list;

   //  Sets up an initially empty list of magazines.

   public MagazineList()
   {
      list = null;
   }

   //  Creates a new MagazineNode object and adds it to the end of
   //  the linked list.

   public void insert(Magazine mag)
   {
	   MagazineNode node = new MagazineNode(mag);

	   if(list == null)
	     list = node;
	   else
	   {
		   node.next = list;
		   list = node;
	   }
   }

   public void DelAll()
   {
	  if(list == null)
	  {
      }
      else if(list != null)
      {
		 list = null;
      }
   }

   public void delete(Magazine mag)
   {
	   if(list.magazine.toString().equals(mag.toString()))
	   {
		   list = list.next;
		   return;
        }

        MagazineNode current = list;
        MagazineNode previous = null;

        while(current != null && !current.magazine.toString().equals(mag.toString()))
        {
			previous = current;
			current = current.next;
	    }

	    previous.next = current.next;
   }

   //  Returns this list of magazines as a string.

   public String toString ()
   {
      String result = "";

      MagazineNode current = list;

      while (current != null)
      {
         result += current.magazine + "\n";
         current = current.next;
      }

      return result;
   }

   //  An inner class that represents a node in the magazine list.
   //  The public variables are accessed by the MagazineList class.

   private class MagazineNode
   {
      public Magazine magazine;
      public MagazineNode next;

      //  Sets up the node

      public MagazineNode (Magazine mag)
      {
         magazine = mag;
         next = null;
      }
   }
}
