package gridBackLayoutKomplex;

public class Gbl2 {

}
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
		