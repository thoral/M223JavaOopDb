package eins;

import javax.swing.*;

public class Eins extends JFrame{

		
	JButton a = new JButton("Abbruch");
	JButton b = new JButton("Ja");
	JButton c = new JButton("Nein");
	
	
	public Eins()
	{
		super("dreiKnopf");
		setSize(400 ,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pane = new JPanel();
		pane.add(a);
		pane.add(b);
		pane.add(c);
		
		this.setContentPane(pane);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Eins e = new Eins();
		e.show();
	}

}
