package eins;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class zwei extends JFrame implements ActionListener 
{

	JTextField name = new JTextField(15);
	JPasswordField password = new JPasswordField(15);
	JTextArea comments = new JTextArea(4,15);
	JButton kontrolle = new JButton("Kontrolle");
	JCheckBox grossKlein = new JCheckBox("Gross = Klein");
	JButton senden = new JButton("=");
	
	public zwei ()
	{
	
	super("Rueckmelde Formular");
	setSize(260, 260);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	JPanel pane = new JPanel();
	JLabel usernameLabel = new JLabel("Bemerkungen");
	JLabel passwordLabel = new JLabel("Password");
	
	JLabel commmentsLabel = new JLabel("Bemerkungen:");
	comments.setLineWrap(true);	
	comments.setWrapStyleWord(true);
	senden.addActionListener(this);							// die Buttons werden mit dem listener verbunden
	kontrolle.addActionListener(this);
	kontrolle.addActionListener(this);
	grossKlein.addActionListener(this);
	
	pane.add(usernameLabel);
	pane.add(name);
	pane.add(passwordLabel);
	pane.add(password);
	pane.add(comments);	
	pane.add(comments);
	pane.add(senden);
	pane.add(kontrolle);
	pane.add(grossKlein);
	setContentPane(pane);
	
	this.setVisible(true);
}
	
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource() == kontrolle) comments.setText("Kontrolle");
		else
		{
			if(evt.getSource() == grossKlein)
			{
				if(grossKlein.isSelected() )
				{
					comments.setText("Gross = klein");
				}
				else
				{
					comments.setText("Gross <> Klein");
				}
			}
			else
			{
				String ausgabe;
				ausgabe = name.getText() + " = " +
				password.getText();
				comments.setText(ausgabe);							
			}
		}
		
	}
		
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		zwei zwei = new zwei();
		zwei.addWindowListener(null);

	}

}
