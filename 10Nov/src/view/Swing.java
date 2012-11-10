package view;

import java.awt.Button;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Swing extends JFrame implements ActionListener{

	
	Button btClose;   
	JTextField buch = new JTextField(15);
	JTextField autor  = new JTextField(15);
	JTextArea genre = new JTextArea(4,15);
	JButton senden = new JButton("senden");
	
	
	JLabel laBuch;
	JLabel laAutor = new JLabel("Autor");
	JLabel laGenre = new JLabel("Genre");
	// Variable deklarieren, um überall zu arbeiten
	private JPanel mainPanel;
	
	public Swing()
	{	
		super ("Buchverleih");
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout() );
	
		
		buch = addField("Buchname"); 
		autor = addField("autor");
		
		add(mainPanel);
		
		setVisible(true);
	}
	
	
	
	private JTextField addField(String name) {
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		JTextField tf = new JTextField(40);
		mainPanel.add(new JLabel (name) );
		mainPanel.add(tf, gbc);
		return tf;
	}



	public static void main(String[] args) {
		
		Swing sw = new Swing();
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
