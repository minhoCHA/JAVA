import javax.swing.JFrame;

public class Choice {
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame ("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ChoicePanel());
		frame.pack();
		frame.setVisible(true);
	}

}
