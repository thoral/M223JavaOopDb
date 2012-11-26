package view;


import view.JListFabrik;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import dbObjekt.buecher;
import dbObjekt.kind;

public class view extends JFrame implements ActionListener{

	
	
	JLabel laIsbn = new JLabel("isbn");
	JLabel laTitel = new JLabel("Titel");
	JLabel laSuchbegriff = new JLabel("Suchbegriff");
	
	JLabel laKiNa = new JLabel("Kind Name");
	JLabel laKiKl = new JLabel("Kind Klasse");
	
	JTextField jtIsbn = new JTextField(15);
	JTextField jtTitel = new JTextField(15);
	JTextField jtSuchbegriff = new JTextField(15);
		
	JTextField jtKiNa = new JTextField(15);
	JTextField jtKiKl = new JTextField(15);
	
	//JTable tabelle = new JTable();
	
	JScrollList comp = JListFabrik.createList("meine Liste");
	
	JButton neu = new JButton("new");		
	public view()
	{
		super ("Buchbibliothek");
		GridBagLayout  gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.getContentPane().setLayout(gbl);
		gbc.insets = new Insets(2,2,2,2);
	
		/*
		 * Isbn
		 */
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbl.setConstraints(laIsbn, gbc);
		add(laIsbn);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbl.setConstraints(jtIsbn, gbc);
		add(jtIsbn);
		
		/*
		 * Titel
		 */
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbl.setConstraints(laTitel, gbc);
		add(laTitel);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbl.setConstraints(jtTitel, gbc);
		add(jtTitel);
		
		
		/*
		 * Suchbegriff
		 */
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbl.setConstraints(laSuchbegriff, gbc);
		add(laSuchbegriff);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbl.setConstraints(jtSuchbegriff, gbc);
		add(jtSuchbegriff);
		
		/*
		 * Kind Name
		*/
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbl.setConstraints(laKiNa, gbc);
		add(laKiNa);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbl.setConstraints(jtKiNa, gbc);
		add(jtKiNa);
		
		/*
		 * JButtonClass
		
		gbc.gridx=0; 
		gbc.gridy=5;
		gbc.gridheight = 4;
		gbc.gridwidth = 2;
		JButton b = new DefaultButton("ok");
		gbl.setConstraints(b, gbc);
		add(b);
		 */
		
		/*
		 * Kind Klasse
		 */
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbl.setConstraints(laKiKl, gbc);
		add(laKiKl);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbl.setConstraints(jtKiKl, gbc);
		add(jtKiKl);
		
		/*
		 * Tabelle		 		
		gbc.gridx = 0;
		gbc.gridy = 5;
		tabelle.setModel(new dbObjektTableModel() );
		JScrollPane sp  = new JScrollPane( tabelle) ;
		gbl.setConstraints(sp, gbc);
		add(sp);
		*/  
		   
		/*
		 *List 
		*/
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 4;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth= 1;
		
		for ( int i = 1; i < 100; i++)  
			//comp.addListElement("Test " + i);
		gbl.setConstraints(comp,gbc);
		add(comp);
		setSize(200,400);
		
		 
		/*
		 * RadioButton
		
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
		
		RadioButtonPanel rbp2 = new RadioButtonPanel("Info");
		JRadioButton r201 = rbp.createRadioButton("Wo" ,"e");
		JRadioButton r202 = rbp.createRadioButton("Was", "d");
		JRadioButton r203 = rbp.createRadioButton("Warum", "g");
		gbc.gridx=0; 
		gbc.gridy=10;
		gbc.gridheight = 4;
		gbc.gridwidth = 2;
		add(rbp2, gbc);	
		 */
		
		
		/*
		 *  Button neu 
		*/
		gbc.gridx = 1;
		gbc.gridy = 6;
		neu.addActionListener(this);
		gbl.setConstraints(neu, gbc);
		add(neu);
		 
		pack();
	}



	@Override
	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getSource()  ==  neu) dispose();  
		{
			kind k = new kind(jtKiNa.getText(), jtKiKl.getText() );
			buecher b = new buecher (jtIsbn.getText(), jtTitel.getText(), jtSuchbegriff.getText() );
			b.load();
			
		}
		
	}
	
	public static void main(String[] args){
		
		view demo = new view();
		demo.setVisible(true);
	}
	
	
}
