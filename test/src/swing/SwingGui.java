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
					//laVorname.setHorizontalAlignment(JLabel.LEFT);
					gbl.setConstraints(LaName, gbc);
					add(LaName);
			/********Feld**************/	
					gbc.gridx = 4;
					gbc.gridy = 0;
					gbc.gridheight = 1;
					gbl.setConstraints(jtName, gbc);
					add(jtName);
					
			/*
			 * Strasse
			 */
					gbc.gridx = 0;
					gbc.gridy = 1;
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
					gbc.gridheight = 1;				
					gbl.setConstraints(jtOrt, gbc);
					add(jtOrt);
					
			/*
			 * JLIst
			 */
					JPanel jlpanel = new JPanel(new GridLayout(0, 1));
				    Border border = BorderFactory.createTitledBorder("Funktionen");
				    jlspanel.setBorder(border);
					gbc.gridx = 4;
					gbc.gridy = 4;
					gbc.gridwidth = 1;
					gbc.gridheight = 4;
					gbc.weightx = 0;
					gbc.weighty = 0;
					gbc.gridwidth= 1;
					JScrollPane scrollPane = new JScrollPane(list);
				//	gbc.fill = GridBagConstraints.BOTH;
					gbl.setConstraints(scrollPane, gbc);
					add(scrollPane);		
			/*
			 * Radio Button
			 */
					gbc.gridx = 0;
					gbc.gridy = 4;
					gbc.gridheight = 1;
					gbc.gridwidth = 2;
					RadioButtonPanel rbp = new RadioButtonPanel("Anrede ");
					//Action Command Frau bleibt
					JRadioButton r01 = rbp.createRadioButton("Herr", "f");
					JRadioButton r02 = rbp.createRadioButton("Frau", "m");
					JRadioButton r03 = rbp.createRadioButton("Neutral", "n");				
					add(rbp, gbc);		
			/*
			 * Checkbox		
			 */	
					gbc.gridx = 0;
					gbc.gridy = 6;
					gbc.gridheight = 1;
					gbc.gridwidth = 3;
					JPanel panel = new JPanel(new GridLayout(0, 1));
				    Border border = BorderFactory.createTitledBorder("Zustellen");
				    panel.setBorder(border);
				    JCheckBox check = new JCheckBox("Newsletter Papier");
				    check.setBorderPaintedFlat(true);
				    panel.add(check);
				    check = new JCheckBox("Newsletter EMail");
				    panel.add(check);
				    check = new JCheckBox("Einladung zu GV");
				    check.setBorderPaintedFlat(true);
				    panel.add(check);
				    check = new JCheckBox("Rechnung und Jahresbericht");
				    check.setBorderPaintedFlat(true);
				    panel.add(check);
				    gbl.setConstraints(panel, gbc);
					add(panel);
				    
				    
			
			/*
			 *speichern
			 */
					gbc.gridx = 0;
					gbc.gridy = 10;							
					gbl.setConstraints(speichern, gbc);
					add(speichern);
					
			/*
			 *schliessen
			 */
					gbc.gridx = 2;
					gbc.gridy = 10;	
					//schliessen.addActionListener((ActionListener) this);
					gbl.setConstraints(schliessen, gbc);
					add(schliessen);
						
			/*
			 *neu
			*/
					gbc.gridx = 4;
					gbc.gridy = 10;							
					gbl.setConstraints(neu, gbc);
					add(neu);
			 
					
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
