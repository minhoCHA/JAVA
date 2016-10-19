import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class ChoicePanel extends JPanel{
	private JLabel quote;
	private JRadioButton messi, ronaldo, park;
	private String messiQuote, ronaldoQuote, parkQuote;
	
	public ChoicePanel(){
		messiQuote = "I'm the best in the world.\n";
		ronaldoQuote = "No one can catch me.\n";
		parkQuote = "I can run for 24 hours\n";
		
		quote = new JLabel (messiQuote);
		quote.setFont(new Font ("Helvetica", Font.BOLD, 24));
		
		messi = new JRadioButton ("Messi", true);
		messi.setBackground(Color.green);
		ronaldo = new JRadioButton("Ronaldo");
		ronaldo.setBackground(Color.green);
		park = new JRadioButton("Park");
		park.setBackground(Color.green);
		
		ButtonGroup group = new ButtonGroup();
		group.add(messi);
		group.add(ronaldo);
		group.add(park);
		
		QuoteListener listener = new QuoteListener();
		messi.addActionListener(listener);
		ronaldo.addActionListener(listener);
		park.addActionListener(listener);
		
		add(quote);
		add(messi);
		add(ronaldo);
		add(park);
		
		setBackground(Color.green);
		setPreferredSize(new Dimension(300, 100));
	}

	private class QuoteListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			Object source = event.getSource();
			
			if (source == messi){
				quote.setText(messiQuote);
			}
			else if(source == ronaldo){
				quote.setText(ronaldoQuote);
			}
			else{
				quote.setText(parkQuote);
			}
		}
	}
}
