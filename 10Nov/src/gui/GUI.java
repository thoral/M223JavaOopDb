package gui;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class GUI extends JFrame{

/**
 * Fenster aufbauen	
 * 
 */
	public GUI() {
		
		// Wie die einzelene Zeile add(JListFabrik.createList("meine Liste"));
		JScrollList comp = JListFabrik.createList("meine Liste");
		this.add(comp);
		for ( int i = 1; i < 100; i++)  comp.addListElement("Test " + i);
		
		setSize(600,400);	
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new GUI();
		// TODO Auto-generated method stub

	}

}
