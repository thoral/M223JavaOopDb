package gridbagLayouteEinfach;


import java.awt.*;
import java.awt.peer.LabelPeer;

import javax.swing.*;




public class Gbl2 extends JFrame {
	

//Globale Referenz vom Typ des Interface LayoutManager
private static LayoutManager layout; 
//Konstruktordefinition
	public Gbl2(String title){
		
		super(title);
		setBounds(10,50,200,100);
	}
	
	public Gbl2(JFrame frame, LayoutManager layout2) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		//Lokale Referenz vom Typ der Klasse GrundMaskefuerSwing
		Gbl2 maske; 
		//Ein im Programmaufruf angegebenes Argument definiert den 
		//Namen des Layout-Managers als String
		JFrame frame = new JFrame(args[0]);
		if(args[0].equals("FlowLayout")) {
		layout = new FlowLayout();
		}
		else if(args[0].equals("GridLayout")) {
		layout = new GridLayout(2,3);
		}
		else if(args[0].equals("BorderLayout")) {
		layout = new BorderLayout();
		}
		maske = new Gbl2(frame, layout);
		maske.anzeige();
		
		}

	private void anzeige() {
		// TODO Auto-generated method stub
		
	}

}
