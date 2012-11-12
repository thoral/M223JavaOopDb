package jlistEinfach;

import java.awt.*;
 import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JList3 extends JFrame implements ActionListener{
	 
	public JList3(String[] labels) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {
		    String labels[] = { "A", "B", "C", "D","E", "F", "G", "H","I", "J" };

		    String title = "JList Sample";
		    JFrame f = new JFrame(title);
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    JList3 list = new JList3 (labels);
		    JScrollPane scrollPane = new JScrollPane(list);

		    Container contentPane = f.getContentPane();
		    contentPane.add(scrollPane, BorderLayout.CENTER);

		    f.setSize(200, 200);
		    f.setVisible(true);
		  }
}
