package view;

import gui.JScrollList;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;

public class JListFabrik {

	
	/*
	 * @param t title
	 *
	 *@autor tw
	 */
	public static  JScrollList createList(String title) {
		
		JScrollList c = new JScrollList();
		// JCompoment hat einen Rahmen
		Vector<String> list = new Vector<String>();	
		JList jl = new JList(list);		
		c.setBorder(BorderFactory.createTitledBorder(title));
		c.setViewportView(jl);
		c.setList(list);
		return c;		
	}
	
	
	

}
