package view;

//package com.sowas.javademo.awt;

import java.awt.*;
import java.awt.event.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class GridBagLayoutDemo2 extends JFrame implements ActionListener{
	Button btClose;
	
	
	
	public GridBagLayoutDemo2(){
		super("GridBagLayoutDemo");
		
		//neues Objekt gbl instanzieren
		GridBagLayout gbl = new GridBagLayout();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Objekt gbl dem Fenster zuweisen
		this.getContentPane().setLayout(gbl);
			
		/*
		 * Überschrift
		*/ 		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1; //Zeilen 2
		gbc.insets = new Insets(0, 5, 0 ,5);
		Label header = new Label("Rezeptekiste");
		header.setFont(new Font("Helvetica", Font.BOLD, 16));
		add(header, gbc);
		gbc.gridwidth = 1;		
		// Festlegen, dass die GUI-Elemente die Gitterfelder in 
                // waagerechter Richtung ausfüllen:
		gbc.fill = GridBagConstraints.NONE;
		
		// Die Abständer der einzelnen GUI-Elemente zu den gedachten 
                // Gitterlinien festgelegen:
		gbc.insets = new Insets(2,2,2,2);  

		gbc.gridx = 3;  // x-Position im gedachten Gitter
		gbc.gridy = 3;  // y-Position im gedachten Gitter
		gbc.gridheight = 2;  // zwei Gitter-Felder hoch
		// Objekt Liste
		
		
		gbc.anchor = GridBagConstraints.CENTER;
		JList list = new JList();
		gbc.gridx = 2;
		gbc.gridy = 1;
		
		DefaultListModel dlm = new DefaultListModel();
		dlm.addElement("Suppe");
		dlm.addElement("Vorspeise");
		dlm.addElement("warme Vorspeise");
		dlm.addElement("Hauptgang");
		dlm.addElement("Käse");
		dlm.addElement("Dessert");
		dlm.addElement("Amuse Bouche");
		
		list.setModel(dlm);
	
		// zweite
	//	gbl.setConstraints(list, gbc);
	//	add(list);
		// zweite Variante
		add(list, gbc);
		
		gbc.anchor =GridBagConstraints.FIRST_LINE_END;
		gbc.gridx=0; 
		gbc.gridy=1;
		gbc.gridheight = 1;
		JButton jb = new JButton("Bitte suche ein Rezept");
	//	Label label = new Label("Bitte suche ein Rezept");
		add(jb,gbc);
		
		gbc.gridx=1; 
		gbc.gridy=10;
		gbc.gridheight = 1;
		btClose = new Button("Schließen");
		btClose.addActionListener(this);
		gbl.setConstraints(btClose, gbc);
		add(btClose);
		
		
/*
 * Panel RadioButton
 */
		RadioButtonPanel rbp = new RadioButtonPanel("Anrede");
															//Action Command Frau bleibt
		JRadioButton r01 = rbp.createRadioButton("Dessert", "f");
		JRadioButton r02 = rbp.createRadioButton("vorspeise", "m");
		JRadioButton r03 = rbp.createRadioButton("Suppe", "n");
		JRadioButton r04 = rbp.createRadioButton("unbekannt", "n");
		
		gbc.gridx=0; 
		gbc.gridy=5;
		gbc.gridheight = 4;
		gbc.gridwidth = 1;

		add(rbp, gbc);		
		pack();
		
	}
	
			
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == btClose)
			dispose();
	}
	
	public static void main(String[] args){
		GridBagLayoutDemo2 demo = new GridBagLayoutDemo2();
		demo.setVisible(true);
	}
}
 