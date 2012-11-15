package gridBackLayoutKomplex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class Gbl3 extends JFrame implements ActionListener{
	
	
	Button btClose; 
	//JTextField
	JTextField benutzername = new JTextField(15);
	JTextField password = new JTextField(15);
	JTextArea kommentar = new JTextArea(4,15);
	JButton senden = new JButton("senden");
	JButton schliessen = new JButton("schliessen");
	
	//Jlist 
	String[] listData = { "Shinguz", "Glapum'tianer", "Suffus", "Zypanon", "Tschung" };
	JComponent jList = new JList( listData );
				JScrollPane srollPane = new JScrollPane(jList);
	//Labels
	JLabel LaBenutzername = new JLabel("Benutzername");
	JLabel LaPassord = new JLabel("Password");
	JLabel LaKommentar = new JLabel("Kommentar");
	
	public Gbl3(){
		
		super("Benutzer Formular");
		
		//neues Objekt gbl instanzieren
		GridBagLayout gbl = new GridBagLayout();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Objekt gbl dem Fenster zuweisen
		this.getContentPane().setLayout(gbl);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.insets = new Insets(0, 5, 0, 5);
		Label header = new Label("Benutzereingabe"); 
		header.setFont(new Font ("Helvetica", Font.BOLD, 20));
		add(header, gbc);
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE; // den Remainder wieder zurückstellen
		
		
/*
 * Elemente hinzufügen
 */
		gbc.insets = new Insets(2,2,2,2);
/*
 * Benutzername
 */
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbl.setConstraints(LaBenutzername, gbc);
		add(LaBenutzername);
/******Feld********/
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		benutzername.addActionListener(this);
		gbl.setConstraints(benutzername, gbc);
		add(benutzername);

/*
 * Password
 */
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbl.setConstraints(LaPassord, gbc);
		add(LaPassord);
/********Feld**************/	
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		password.addActionListener(this);
		gbl.setConstraints(password, gbc);
		add(password);
		
		
/*
 * Textfeld Kommentar
 */
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbl.setConstraints(LaKommentar, gbc);
		add(LaKommentar);
/***********Feld***************/		
		gbc.gridx = 1;
		gbc.gridy = 3;
		kommentar.setLineWrap(true);
		kommentar.setWrapStyleWord(true);
		gbl.setConstraints(kommentar, gbc);
		add(kommentar);

		
		/*
		 * JLIst
		 */
		gbl.setConstraints(srollPane,gbc);
		add.(srollPane);

/*
 * Button senden
 */
		gbc.gridx = 2;
		gbc.gridy = 4;
		senden.addActionListener(this);
		gbl.setConstraints(senden, gbc);
		add(senden);

/*
 * Radio Button
 */
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		
		RadioButtonPanel rbp = new RadioButtonPanel("woher kennen Sie uns ");
		//Action Command Frau bleibt
		JRadioButton r01 = rbp.createRadioButton("Bekannte", "f");
		JRadioButton r02 = rbp.createRadioButton("Internet", "m");
		JRadioButton r03 = rbp.createRadioButton("Werbung", "n");
		JRadioButton r04 = rbp.createRadioButton("Fernseh", "n");
		add(rbp, gbc);
			
/*
 * schliessen
 */
		gbc.gridx = 1;
		gbc.gridy = 6;			
		schliessen.addActionListener(this);
		gbl.setConstraints(schliessen, gbc);
		add(schliessen);
			
		pack();
				
	}
	
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == senden) kommentar.setText("kontrolle");
		
	if(evt.getSource()  == schliessen ) dispose();  
		
		/*if (evt.getSource() == btClose)
			dispose();
		*/
	}
	

	
	public static void main(String[] args){
		Gbl_1 demo = new Gbl_1();
		demo.setVisible(true);
		
		
	}

}
