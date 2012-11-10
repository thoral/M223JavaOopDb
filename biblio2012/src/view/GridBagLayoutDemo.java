package view;


 

 
/*
 * GridBagLayoutDemo.java requires no other files.
 */
 
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
 

import java.awt.*;
import javax.swing.*;

class GridBagLayoutDemo
{
	/*
	 * Methode Constraint mit Parameter
	 * addComponent( c, gbl, new JButton("1"), 0, 0, 2, 2, 1.0, 1.0 );
	 */
	  static void addComponent( Container cont,
	                            GridBagLayout gbl,
	                            Component c,
	                            int x, int y,
	                            int width, int height,
	                            double weightx, double weighty )
	  {
		// Für 
	    GridBagConstraints gbc = new GridBagConstraints();	//
	    // 
	    gbc.fill = GridBagConstraints.BOTH;
	    gbc.gridx = x; gbc.gridy = y;
	    gbc.gridwidth = width; gbc.gridheight = height;
	    gbc.weightx = weightx; gbc.weighty = weighty;
	    gbl.setConstraints( c, gbc );
	    cont.add( c );
	  }
	
	  public static void main( String[] args )
	  {
		  // Ein Frame Container erstellen
	    JFrame f = new JFrame();
	    // Wenn das Fenster geschlossen wird, Programm beenden
	    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    
	    Container c = f.getContentPane();
	  //Als erstes das Objekt gbl instanzieren
	    GridBagLayout gbl = new GridBagLayout();
	    
	    c.setLayout( gbl );
	
	    //                                      x  y  w  h  wx   wy
	// Fügt den Constraint hinzu
	    addComponent( c, gbl, new JButton("1"), 0, 0, 2, 2, 1.0, 1.0 );
	    addComponent( c, gbl, new JButton("2"), 2, 0, 1, 1, 0  , 1.0 );
	    addComponent( c, gbl, new JButton("3"), 2, 1, 1, 1, 0  , 0   );
	    addComponent( c, gbl, new JButton("4"), 0, 2, 3, 1, 0  , 1.0 );
	    addComponent( c, gbl, new JButton("5"), 0, 3, 2, 1, 0  , 0   );
	    addComponent( c, gbl, new JButton("6"), 0, 4, 2, 1, 0  , 0   );
	    addComponent( c, gbl, new JButton("7"), 2, 3, 1, 2, 0  , 0   );
	
	    f.setSize( 300, 200 );
	    f.setVisible( true );
	  }
}
