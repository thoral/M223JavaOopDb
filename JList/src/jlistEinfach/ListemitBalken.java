package jlistEinfach;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ListemitBalken extends JFrame implements KeyListener, ActionListener {

/**
	 * 
	 */

JList myList;	//
JScrollPane jsp;	//
DefaultListModel dlm;	//

JButton loeschen;
JButton einlesen;
JTextField eingabe;

JPanel pane;



public ListemitBalken() {

super("ListeMitBalken");
setSize(500, 500);

loeschen = new JButton("gewaehltes Objekt loeschen");
loeschen.addActionListener(this);

einlesen = new JButton("in die Liste");
einlesen.addActionListener(this);
eingabe = new JTextField("ungebraucht");


dlm = new DefaultListModel();
dlm.addElement("MontagMorgenSonne");
dlm.addElement("DI");
dlm.addElement("Mi");
dlm.addElement("Do");
dlm.addElement("Fr");
dlm.addElement("Sa");
dlm.addElement("So");


myList = new JList();
myList.setModel(dlm);
jsp = new JScrollPane(myList);

pane = new JPanel();
pane.add(einlesen);
pane.add(eingabe);
pane.add(loeschen);
pane.add(jsp);
setContentPane(pane);

}

public void keyPressed(KeyEvent e) { }	
public void keyTyped(KeyEvent ke) { }
public void keyReleased(KeyEvent ke) { }

public void actionPerformed(ActionEvent evt) {

if( evt.getSource() == einlesen )
dlm.addElement(eingabe.getText() );	

else
{
dlm.removeElementAt(myList.getSelectedIndex() );
}
}


public static void main(String[] args) {

ListemitBalken lr = new ListemitBalken();
lr.setVisible(true);

}






}