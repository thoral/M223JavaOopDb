package jlistEinfach;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;



public class JList2 extends JFrame implements ActionListener{

	  private JList jList;
	  private JScrollPane jScrollPane;
	  private DefaultListModel defaultListModel;
	  private JButton jButton;

	  public JList2() {
	    super();
	    initGUI();
	  }

	  private void initGUI() {
	    try {
	      BorderLayout thisLayout = new BorderLayout();
	      this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	      this.getContentPane().setLayout(thisLayout);

	      defaultListModel = new DefaultListModel();

	      jList = new JList();
	      jList.setModel(defaultListModel);

	      jScrollPane = new JScrollPane();
	      jScrollPane.setPreferredSize(new java.awt.Dimension(392, 245));
	      jScrollPane.setViewportView(jList);
	     
	      jButton = new JButton();
	      jButton.setText("add");
	      jButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	          // Wichtig ist dass das Hinzufügen alles in einem seperaten
	          // Thread abläuft damit die Oberfläche nicht hängen bleibt
	          // und damit es keine Fehler beim dem Scrollen gibt(IndexOutOfBoundsException).
	          SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	              // Element dem DefaultListModel hinzufügen.
	              // Angezeigt wird dann die toString Methode des
	              // Objektes, in diesem Fall ist das der String
	              // selbst.
	              defaultListModel.addElement(new String(System.currentTimeMillis() + ""));
	             
	              // Anschließend den letzten index des Model sichtbar setzen,
	              // dies Bewirkt den automatischen Scroll nach unten.
	              jList.ensureIndexIsVisible(defaultListModel.size() - 1);
	            }
	          });
	        }
	      });

	      this.getContentPane().add(jScrollPane, BorderLayout.CENTER);
	      this.getContentPane().add(jButton, BorderLayout.SOUTH);

	      this.setTitle("JList Auto-Scroll Beispiel");
	      this.pack();
	      this.setSize(400, 300);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

	  public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        JList2 inst = new JList2();
	        inst.setLocationRelativeTo(null);
	        inst.setVisible(true);
	      }
	    });
	  }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	}
	
	
	

