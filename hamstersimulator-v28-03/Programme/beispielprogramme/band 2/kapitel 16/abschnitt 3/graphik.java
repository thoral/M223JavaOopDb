import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class graphik implements de.hamster.model.HamsterProgram {class GraphikHamster extends AllroundHamster {

    private ArrayList<Kachel> besuchteKacheln;

    private ZeichenPanel panel;

    public GraphikHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
        this.besuchteKacheln = new ArrayList<Kachel>();
        this.besuchteKacheln.add(new Kachel(this.getReihe(),
                this.getSpalte()));

        // Fenster erzeugen
        JFrame fenster = new JFrame("Weg-Skizze");
        fenster
                .setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.panel = new ZeichenPanel(this.besuchteKacheln);
        fenster.add(this.panel);
        fenster.setLocation(100, 200);
        fenster.pack();
        fenster.setVisible(true);
    }

    public void vor() {
        super.vor();
        this.besuchteKacheln.add(new Kachel(this.getReihe(),
                this.getSpalte()));

        // Zeichenpanel aktualisieren
        panel.repaint();
        /* eigentlich korrekt:
        try {
            EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    panel.repaint();
                }
            });
        } catch (Exception exc) {
        }
        */
    }

    public ArrayList<Kachel> getBesuchteKacheln() {
        return this.besuchteKacheln;
    }
}

class Kachel {
    private int reihe;

    private int spalte;

    public Kachel(int r, int s) {
        this.reihe = r;
        this.spalte = s;
    }

    public int getReihe() {
        return this.reihe;
    }

    public int getSpalte() {
        return this.spalte;
    }
}

class ZeichenPanel extends JPanel {

    private ArrayList<Kachel> kacheln;

    private final int kachelGroesse;

    private ImageIcon kachelIcon;

    private int anzahlSpalten;

    private int anzahlReihen;

    public ZeichenPanel(ArrayList<Kachel> kacheln) {
        this.kacheln = kacheln;
        this.kachelIcon = new ImageIcon("Programme\\beispielprogramme\\band 2\\kapitel 16\\abschnitt 3\\kachel.jpg");
        this.kachelGroesse = this.kachelIcon.getIconWidth();
        this.anzahlReihen = Territorium.getAnzahlReihen();
        this.anzahlSpalten = Territorium.getAnzahlSpalten();
    }

    public Dimension getPreferredSize() {
        return new Dimension(this.anzahlSpalten
                * this.kachelGroesse, this.anzahlReihen
                * this.kachelGroesse);
    }

    protected void paintComponent(Graphics g) {
        if (this.kacheln.size() < 2) {
            return;
        }

        // Zeichne Territorium
        for (int r = 0; r < this.anzahlReihen; r++) {
            for (int s = 0; s < this.anzahlSpalten; s++) {
                g.drawImage(this.kachelIcon.getImage(), s
                        * this.kachelGroesse, r
                        * this.kachelGroesse, null);
            }
        }

        // Zeichne Weg
        g.setColor(Color.RED);
        Kachel vonKachel = this.kacheln.get(0);
        int zaehler = 1;
        while (zaehler < this.kacheln.size()) {
            Kachel nachKachel = this.kacheln.get(zaehler);
            int vonX = vonKachel.getSpalte()
                    * this.kachelGroesse + this.kachelGroesse
                    / 2;
            int vonY = vonKachel.getReihe() * this.kachelGroesse
                    + this.kachelGroesse / 2;
            int nachX = nachKachel.getSpalte()
                    * this.kachelGroesse + this.kachelGroesse
                    / 2;
            int nachY = nachKachel.getReihe()
                    * this.kachelGroesse + this.kachelGroesse
                    / 2;
            g.drawLine(vonX, vonY, nachX, nachY);
            vonKachel = nachKachel;
            zaehler++;
        }
    }
}

// Demoprogramm
public void main() {
    GraphikHamster paul = new GraphikHamster(0, 0,
            Hamster.OST, 0);
    Random zufall = new Random();
    int haeufigkeit = zufall.nextInt(10) + 1;
    for (int i = 0; i < haeufigkeit; i++) {
        int r = zufall
                .nextInt(Territorium.getAnzahlReihen());
        int s = zufall.nextInt(Territorium
                .getAnzahlSpalten());
        paul.gotoKachel(r, s);
    }
}
}