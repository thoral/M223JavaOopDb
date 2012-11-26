package swing;





import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class SwingGui extends JFrame{

	
	String[] listData = { "Goenner", "Mitglied", "Vorstand", "Delegierter", "Turnleiter","Schwimmleiter", "Präsident", "Kassier", "Aktuar" };

	
	/*
	 * Button Close
	 */
		
		Button btClose;
	/*
	 * Labels
	 */
		JLabel LaVorname = new JLabel("Vorname");
		JLabel LaName = new JLabel("Name");
		JLabel LaStrasse = new JLabel("Strasse");
		JLabel LaPLZ = new JLabel("PLZ");
		JLabel LaOrt = new JLabel("Ort");
	/*
	 * Textfelder
	 */
		JTextField jtVorname = new JTextField(15);
		JTextField jtName = new JTextField(15);
		JTextField jtStrasse = new JTextField(15);
		JTextField jtPLZ = new JTextField(15);
		JTextField jtOrt = new JTextField(15);
		
		
	/*
	 * Buttons
	 */
		JButton speichern = new JButton("speichern");
		JButton schliessen = new JButton("schliessen");
		JButton neu = new JButton("Neu");
	/*
	 * JList
	 */
		JList list = new JList(listData);
		JScrollPane scrollPane; 
		
	
		public SwingGui (){
			
			super("Vereinsadresse Detail");
			GridBagLayout gbl = new GridBagLayout();

			GridBagConstraints gbc = new GridBagConstraints();
			
			// Objekt gbl dem Fenster zuweisen
			this.getContentPane().setLayout(gbl);
			
			
			/*
			 * Vorname
			 */
					gbc.gridx = 0;
					gbc.gridy = 0;
					//laVorname.setHorizontalAlignment(JLabel.LEFT);
					gbl.setConstraints(LaVorname, gbc);
					add(LaVorname);
			/********Feld**************/	
					gbc.gridx = 1;
					gbc.gridy = 0;
					gbc.gridheight = 1;
					gbl.setConstraints(jtVorname, gbc);
					add(jtVorname);
			/*
			 * Name
			 */
					gbc.gridx = 3;
					gbc.gridy = 0;
					//gbc.anchor = GridBagConstraints.EAST;
					//laVorname.setHorizontalAlignment(JLabel.LEFT);
					gbl.setConstraints(LaName, gbc);
					add(LaName);
			/********Feld**************/	
					gbc.gridx = 4;
					gbc.gridy = 0;
					gbc.gridheight = 1;
					gbc.gridwidth = 2;
					//gbc.anchor = GridBagConstraints.EAST;
					gbl.setConstraints(jtName, gbc);
					add(jtName);
					
			/*
			 * Strasse
			 */
					gbc.gridx = 0;
					gbc.gridy = 1;
					gbc.gridwidth = 1;
					//laVorname.setHorizontalAlignment(JLabel.LEFT);
					gbl.setConstraints(LaStrasse, gbc);
					add(LaStrasse);
			/********Feld**************/	
					gbc.gridx = 1;
					gbc.gridy = 1;
					gbc.gridheight = 1;				
					gbl.setConstraints(jtStrasse, gbc);
					add(jtStrasse);
			/*
			 * PLZ
			 */
					gbc.gridx = 0;
					gbc.gridy = 3;
					//laVorname.setHorizontalAlignment(JLabel.LEFT);
					gbl.setConstraints(LaPLZ, gbc);
					add(LaPLZ);
			/********Feld**************/	
					gbc.gridx = 1;
					gbc.gridy = 3;
					gbc.anchor = GridBagConstraints.EAST;
					gbc.ipadx = 2;
					gbc.gridheight = 1;				
					gbl.setConstraints(jtPLZ, gbc);
					add(jtPLZ);	
			/*
			 * Ort
			 */
					gbc.gridx = 2;
					gbc.gridy = 3;
					//laVorname.setHorizontalAlignment(JLabel.LEFT);
					gbl.setConstraints(LaOrt, gbc);
					add(LaOrt);
			/********Feld**************/	
					gbc.gridx = 3;
					gbc.gridy = 3;
					gbc.gridwidth = 2;
					gbc.gridheight = 1;				
					gbl.setConstraints(jtOrt, gbc);
					add(jtOrt);
					
			
			 
					
			pack();
					
		}
	
		public void actionPerformed(ActionEvent evt)
		{
			
			if(evt.getSource()  == schliessen ) dispose();  
			
			/*if (evt.getSource() == btClose)
				dispose();
			*/
		}
		

		
		public static void main(String[] args){
			SwingGui swing = new SwingGui();
			swing.setVisible(true);
			
			
		}
	
	
	
	
	
}
