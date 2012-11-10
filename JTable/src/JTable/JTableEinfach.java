package JTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableEinfach extends JFrame implements ActionListener   {

		boolean tableModel;
	     
	     Container mainContainer;
	     JFrame frame;
	     
	     JButton wechseln;
	     JTable tabelle;
	     DefaultTableModel tabellenmodellGruppeA;
	     DefaultTableModel tabellenmodellGruppeB;

	     // Spalten anlegen
	     String spalten[] = { "Mannschaft", "Punkte"};
	     

	     // Datenmodelle anlegen
	     String gruppeA[][] = {
	               { "Die Gelben Uboote", "9.6" },
	               { "FatFighters", "8.1" },
	               { "Biertrinker", "6.2" }
	     };
	     
	     String gruppeB[][] = {
	               { "KillerBienen", "10.4" },
	               { "Citties", "6.2" },
	               { "Team ohne Namen", "5.8" }
	     };

	     public JTableEinfach() {
	          frame = new JFrame();
	          mainContainer = frame.getContentPane();
	          frame.setLayout(new BorderLayout());

	          wechseln = new JButton("wechseln");
	          wechseln.addActionListener(this);

	          mainContainer.add(wechseln, BorderLayout.NORTH);
	          
	          tabellenmodellGruppeA = new DefaultTableModel(gruppeA, spalten);
	          tabellenmodellGruppeB = new DefaultTableModel(gruppeB, spalten);
	          
	          tabelle = new JTable(tabellenmodellGruppeA);

	          // Um die Spalten der Tabelle anzuzeigen muss die Tabelle
	          // über eine ScrollPane hinzugefügt werden
	          mainContainer.add(new JScrollPane(tabelle));
	          
	          frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	          frame.pack();
	          frame.setTitle("JTable Beispiel");
	          frame.setVisible(true);
	     }

	     public void actionPerformed(ActionEvent arg0) {
	          if (tableModel){
	               tabelle.setModel(tabellenmodellGruppeA);     
	               tableModel = false;
	          }else{
	               tabelle.setModel(tabellenmodellGruppeB);
	               tableModel = true;
	          }
	     }
	     
	     public static void main(String[] args) {
	          new JTableEinfach();
	     }
	}
