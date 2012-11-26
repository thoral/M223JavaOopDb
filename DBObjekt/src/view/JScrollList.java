package view;

import java.util.Vector;

import javax.swing.JScrollPane;


						// Ind er KLasse listFAbrik wird erwarten die Funktionen von Jpane
public class JScrollList extends JScrollPane{
	
	private Vector<String> list;

	public void addListElement(String string){
		
		list.add(string);
		
	}

	public void setList(Vector<String> list) {
		// 
		this.list = list;
	}
	

}
