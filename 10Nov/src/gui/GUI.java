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
		this.addListElement("Test 1");
		this.addListElement("Test 2");
		setSize(600,400);	
		setVisible(true);
		add(JListFabrik.createList("meine Liste"));
	}
	


	public static void main(String[] args) {
		
		new GUI();
		// TODO Auto-generated method stub

	}

}
