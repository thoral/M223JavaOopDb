package view;

/*********************
 * Imports
 ***********************/
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Buch;


public class DetailView extends JFrame implements ActionListener
{
	JPanel content;
	JButton ok;
	private JTextField titel;
	private JTextField isbn;
	private JTextField suchbegriff;
	
/********************************
 * Constructor
 ********************************/
	public DetailView(String t){

	setTitle(t);
	content = new JPanel();
	
	content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
	this.add(content,BorderLayout.NORTH);
	titel=addField("Titel",60);
	isbn=addField("ISBN",20);
	suchbegriff =addField("Suchbegriffe",60);
	
	JButton ok = new JButton("OK");
	content.add(ok);
	ok.addActionListener(this);
	setVisible(true);
	pack();
}

	/**
	* Fügt ein Label und Textfeld auf neuer Zeile ein
	* @param lbl Label zu diesem Feld
	* @param w Breite des Textfeldes
	*/
	private JTextField addField(String lbl, int w)
	{
		JTextField tf = new JTextField(w);
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.add(new JLabel(lbl));
		p.add(tf);
		content.add(p);
		return tf;
	}
	
	/********************************
	 * Constructor
	 ********************************/
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("OK geklickt.");
		Buch b  = new Buch();
		b.setTitle(titel.getText() );
		b.setIsbn(isbn.getText() );
		b.setSuchbegriffe(suchbegriff.getText() );
		
		b.save();	
	}

}