package view;

/*********************
 * Imports
 ***********************/
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import model.rezept;


public class DetailView extends JFrame implements ActionListener
{
	JPanel content;
	JButton ok;
	private JTextField rezept;
	private JTextField kategorie;
	private JTextField saison;
	
/********************************
 * Constructor
 ********************************/
	//erhält  den String
	public DetailView(String t){
	// Der Rahmentitle wird übergeben
	setTitle(t);
	//ein Objekt Fensterinhalt wird erzeugt
	content = new JPanel();
	
	//Dem Fensterinhalt wird ein Layout BoxLayout übergeben
	content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
	
	//Layout wird platziert
	this.add(content,BorderLayout.NORTH);
	//Die Textfelder werden  erzeugt und die Paramater übergeben
	rezept= addField("Rezept",40);
	kategorie= addField("Kategorie",40);
	saison = addField("Saison",40);
	
	//ein Objekt Button mit der Beschriftung wird erzeugt
	JButton ok = new JButton("OK");
	//Objekt Button wird den Fensterrahmen hinzugefügt
	content.add(ok);
	// actionliestener wird mit dem Button verbunden
	ok.addActionListener(this);
	//macht alles sichtbar
	setVisible(true);
	//????
	pack();
}

	/********************************
	 * Methode Textfeld erzeugen
	 ********************************/
	/**
	* Fügt ein Label und Textfeld auf neuer Zeile ein
	* @param lbl Label zu diesem Feld
	* @param w Breite des Textfeldes
	*/
	private JTextField addField(String lbl, int w)
	{
	// Ein Objekt Textfeld wird erzeugt
	JTextField tf = new JTextField(w);
	// Ein Objekt PAner wird erzeugt
	JPanel p = new JPanel();
	
	p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
	p.add(new JLabel(lbl));
	p.add(tf);
	content.add(p);
	return tf;
	}
	
	/********************************
	 * Constructor
	 ********************************/
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("OK geklickt.");
		rezept b  = new rezept();
		b.setRezept(rezept.getText() );
		b.setKategorie(kategorie.getText() );
		b.setSaison(saison.getText() );
		
		b.save();
		
	}

}