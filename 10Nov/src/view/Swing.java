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
	JTextField genre = new JTextField(15);
	JButton senden = new JButton("senden");
	
	
	JLabel laBuch;
	JLabel laAutor = new JLabel("Autor");
	JLabel laGenre = new JLabel("Genre");
	JRadioButton r01 = new JRadioButton();
	JRadioButton r02 = new JRadioButton();
	JRadioButton r03 = new JRadioButton();
	// Variable deklarieren, um überall zu arbeiten
	private Factory rbp;
	private JPanel mainPanel;
	
	public Swing()
	{	
		super ("Buchverleih");
		
	
		Factory fac = new Factory();
		mainPanel = fac.getPanel();
		add(mainPanel);
		
		
		buch = fac.addField("Buchname");
		autor = fac.addField("autor");	
		genre = fac.addField("Genre");
		
		r01 = fac.createRadioButton("links", "links");
		r02 = fac.createRadioButton("rechts", "rechts");
		r03 = fac.createRadioButton("mitte", "mitte");
		
		setVisible(true);
	}
	

	public static void main(String[] args) {
		
		Swing sw = new Swing();
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
