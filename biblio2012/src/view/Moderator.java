package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Moderator implements ActionListener {

	// Instanzvariable Referenzwerte
	JFrame frame;
	JButton button;
	
	// Pane mehrere SChichten
	// Panel ein Bereich 
	
	
	public Moderator()
	{
		// Gruppenmitglieder instanzieren
		frame = new JFrame();
		button = new JButton("Close");
		frame.getContentPane().add(button);
		frame.setVisible(true);
		frame.setSize(600,400);
		
		// Button soll an Gruppenleeiter geschickt werden
		button.addActionListener(this);	
		
	}
	

	public static void main(String[] args) {
		
		new Moderator();
	
		
	}
	
	public void actionPerformed(ActionEvent arg0)
	{
		frame.setVisible(false);
		System.exit(0); 
	}

}
