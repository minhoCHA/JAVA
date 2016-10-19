
/*
 * MagazineViewPanel.java
 * Driver to exercise the MagazineList collection.
 *@author Lewis/Loftus
 *@modifer Ha Yee Chan, Minho Cha
 *@version 1.0
 *@since 2016-05-16
 */

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class MagazineViewPanel extends JPanel
{
	private String text;
	private TextField AddMag, DelMag;
	private TextArea ListMag;
	private Button DelAll, ListAll;
	private Label label1, label2;
	private Panel panel1, panel2;

   //  Creates a MagazineList object, adds magazines to the
   //  list, then prints it.

    MagazineList rack = new MagazineList();

   //  Constructor: Sets up this panel for action events.

   public MagazineViewPanel()
   {
      setLayout(new BorderLayout());

      AddMag = new TextField(20);
      DelMag = new TextField(20);

      ListMag = new TextArea(text, 20, 50);

      DelAll = new Button("Delete All");
      ListAll = new Button("List Magazines");

      label1 = new Label("Add Magazine:");
      label2 = new Label("Delete Magazine:");

      setSize(400, 500);

      AddMag.addActionListener(new AddMagHandler());
      DelMag.addActionListener(new DelMagHandler());
      ListAll.addActionListener(new ListAllHandler());
      DelAll.addActionListener(new DelAllHandler());
      ListMag.setEditable(false);

      panel1 = new Panel();
      panel1.add(AddMag);
      panel1.add(ListAll);
      panel1.add(label1);
      panel2 = new Panel();
      panel2.add(DelMag);
	  panel2.add(DelAll);
	  panel2.add(label2);
      add(panel1,BorderLayout.NORTH);
      add(panel2,BorderLayout.SOUTH);
      add(ListMag);
   }

   //Represents listeners for action events

   private class AddMagHandler implements ActionListener
   {
	   public void actionPerformed(ActionEvent event)
	   {
		   if(!AddMag.getText().equals(""))
		   {
			   text = AddMag.getText();
			   rack.insert(new Magazine(text));
			   AddMag.setText("");
			   ListMag.setText(" ");
			   ListMag.insert(rack.toString(), 0);
		   }
	    }
    }

    private class DelMagHandler implements ActionListener
    {
		public void actionPerformed(ActionEvent event)
		{
			text = DelMag.getText();
			rack.delete(new Magazine(text));
			DelMag.setText("");
			ListMag.setText(" ");
			ListMag.insert(rack.toString(), 0);
	    }
    }

    private class ListAllHandler implements ActionListener
    {
		public void actionPerformed(ActionEvent event)
		{
			ListMag.setText(" ");
			ListMag.insert(rack.toString(), 0);
	     }
    }

    private class DelAllHandler implements ActionListener
    {
		public void actionPerformed(ActionEvent event)
		{
			rack.DelAll();
			ListMag.setText(" ");
	     }
     }

}
