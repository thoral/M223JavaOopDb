package jlistEinfach;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class Jlist1 extends JFrame implements ActionListener
{

	public Jlist1(String[] entries) 
	{
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame f = new JFrame("JList");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JList list = new JList(entries);
	    // otherwise minsize is length of list
	    list.setMinimumSize(new Dimension(10,10));
	    f.getContentPane().add(list);
	    f.pack();
	    f.setVisible(true);
	}
	  
	  public static void main(String[] args) {
	    String defaultlist[] = {"Entry 0", "Entry 1", "Entry 2", "Entry 3",
	      "Last entry"};

	    if (args.length == 0) 
	      args = defaultlist;
	    Jlist1 r = new Jlist1 (args);
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}