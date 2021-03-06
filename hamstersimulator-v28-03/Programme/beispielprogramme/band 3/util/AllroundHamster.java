package util;

/**
 * die Klasse erweitert den Befehlssatz eines normalen Hamsters
 * um viele nuetzliche Befehle
 * 
 * @author Dietrich Boles (Universitaet Oldenburg)
 * @version 1.0 (25.01.2006)
 * 
 */
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class AllroundHamster extends Hamster {

    /**
     * initialisiert einen neuen AllroundHamster mit den
     * uebergebenen Werten
     * 
     * @param r
     *            Reihe
     * @param s
     *            Spalte
     * @param b
     *            Blickrichtung
     * @param k
     *            Anzahl Koerner im Maul
     */
    public AllroundHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    /**
     * initialisiert einen neuen AllroundHamster mit den
     * Attributwerten eines bereits existierenden Hamsters
     * 
     * @param existierenderHamster
     *            ein bereits existierender Hamster
     */
    public AllroundHamster(Hamster existierenderHamster) {
        super(existierenderHamster);
    }

    /**
     * der Hamster dreht sich "anzahlDrehungen" mal um 90 Grad
     * nach links
     * 
     * @param anzahlDrehungen
     *            Anzahl der linksum-Drehungen
     */
    public synchronized void linksUm(int anzahlDrehungen) {
        for (int i = 0; i < anzahlDrehungen; i++) {
            this.linksUm();
        }
    }

    /**
     * der Hamster dreht sich um 180 Grad
     */
    public synchronized void kehrt() {
        this.linksUm(2);
    }

    /**
     * der Hamster dreht sich um 90 Grad nach rechts
     */
    public synchronized void rechtsUm() {
        this.linksUm(3);
    }

    /**
     * der Hamster laeuft "anzahl" Schritte, maximal jedoch bis
     * zur naechsten Mauer; geliefert wird die tatsaechliche
     * Anzahl gelaufener Schritte
     * 
     * @param anzahl
     *            maximal zu laufende Schritte
     * @return tatsaechliche Anzahl gelaufener Schritte
     */
    public synchronized int vor(int anzahl) {
        int schritte = 0;
        while (this.vornFrei() && anzahl > 0) {
            this.vor();
            schritte = schritte + 1;
            anzahl = anzahl - 1;
        }
        return schritte;
    }

    /**
     * der Hamster legt "anzahl" Koerner ab, maximal jedoch so
     * viele, wie er im Maul hat; geliefert wird die
     * tatsaechliche Anzahl abgelegter Koerner
     * 
     * @param anzahl
     *            maximal abzulegende Kerner
     * @return tatsaechliche Anzahl ablegter Koerner
     */
    public synchronized int gib(int anzahl) {
        int abgelegteKoerner = 0;
        while (!this.maulLeer() && anzahl > 0) {
            this.gib();
            abgelegteKoerner = abgelegteKoerner + 1;
            anzahl = anzahl - 1;
        }
        return abgelegteKoerner;
    }

    /**
     * der Hamster frisst "anzahl" Koerner, maximal jedoch so
     * viele, wie auf der aktuellen Kachel liegen
     * 
     * @param anzahl
     *            maximal aufzunehmende Koerner
     * @return tatsaechlich Anzahl aufgenommener Koerner
     */
    public synchronized int nimm(int anzahl) {
        int gefresseneKoerner = 0;
        while (this.kornDa() && anzahl > 0) {
            this.nimm();
            gefresseneKoerner = gefresseneKoerner + 1;
            anzahl = anzahl - 1;
        }
        return gefresseneKoerner;
    }

    /**
     * der Hamster legt alle Koerner, die er im Maul hat, auf der
     * aktuellen Kachel ab; geliefert wird die Anzahl abgelegter
     * Koerner
     * 
     * @return Anzahl abgelegter Koerner
     */
    public synchronized int gibAlle() {
        int abgelegteKoerner = 0;
        while (!this.maulLeer()) {
            this.gib();
            abgelegteKoerner = abgelegteKoerner + 1;
        }
        return abgelegteKoerner;
    }

    /**
     * der Hamster frisst alle Koerner auf der aktuellen Kachel;
     * geliefert wird die Anzahl gefressener Koerner
     * 
     * @return Anzahl aufgenommener Koerner
     */
    public synchronized int nimmAlle() {
        int gefresseneKoerner = 0;
        while (this.kornDa()) {
            this.nimm();
            gefresseneKoerner = gefresseneKoerner + 1;
        }
        return gefresseneKoerner;
    }

    /**
     * der Hamster laeuft bis zur naechsten Mauer; geliefert wird
     * die Anzahl ausgefuehrter Schritte
     * 
     * @return Anzahl ausgefuehrter Schritte
     */
    public synchronized int laufeZurWand() {
        int schritte = 0;
        while (this.vornFrei()) {
            this.vor();
            schritte = schritte + 1;
        }
        return schritte;
    }

    /**
     * der Hamster testet, ob links von ihm die Kachel frei ist
     * 
     * @return true, falls die Kachel links vom Hamster frei ist,
     *         false sonst
     */
    public synchronized boolean linksFrei() {
        this.linksUm();
        boolean frei = this.vornFrei();
        this.rechtsUm();
        return frei;
    }

    /**
     * der Hamster testet, ob rechts von ihm die Kachel frei ist
     * 
     * @return true, falls die Kachel rechts vom Hamster frei
     *         ist, false sonst
     */
    public synchronized  boolean rechtsFrei() {
        this.rechtsUm();
        boolean frei = this.vornFrei();
        this.linksUm();
        return frei;
    }

    /**
     * der Hamster testet, ob hinter ihm die Kachel frei ist
     * 
     * @return true, falls die Kachel hinter dem Hamster frei
     *         ist, false sonst
     */
    public synchronized boolean hintenFrei() {
        this.kehrt();
        boolean frei = this.vornFrei();
        this.kehrt();
        return frei;
    }

    /**
     * der Hamster dreht sich so lange um, bis er in die
     * uebergebene Blickrichtung schaut
     * 
     * @param richtung
     *            die Richtung, in die der Hamster schauen soll
     */
    public synchronized void setzeBlickrichtung(int richtung) {
        while (this.getBlickrichtung() != richtung) {
            this.linksUm();
        }
    }

    /**
     * der Hamster laeuft in der Spalte, in der er gerade steht,
     * zur angegebenen Reihe; Voraussetzung: die Reihe existiert
     * und es befinden sich keine Mauern auf dem gewaehlten Weg
     * 
     * @param reihe
     *            Reihe, in die der Hamster laufen soll
     */
    public synchronized  void laufeZuReihe(int reihe) {
        if (reihe == this.getReihe()) {
            return;
        }
        if (reihe > this.getReihe()) {
            this.setzeBlickrichtung(Hamster.SUED);
        } else {
            this.setzeBlickrichtung(Hamster.NORD);
        }
        while (reihe != this.getReihe()) {
            this.vor();
        }
    }

    /**
     * der Hamster laeuft in der Reihe, in der er gerade steht,
     * zur angegebenen Spalte; Voraussetzung: die Spalte
     * existiert und es befinden sich keine Mauern auf dem
     * gewaehlten Weg
     * 
     * @param spalte
     *            Spalte, in die der Hamster laufen soll
     */
    public synchronized void laufeZuSpalte(int spalte) {
        if (spalte == this.getSpalte()) {
            return;
        }
        if (spalte > this.getSpalte()) {
            this.setzeBlickrichtung(Hamster.OST);
        } else {
            this.setzeBlickrichtung(Hamster.WEST);
        }
        while (spalte != this.getSpalte()) {
            this.vor();
        }
    }

    /**
     * der Hamster laeuft zur Kachel (reihe/spalte);
     * Voraussetzung: die Kachel existiert und es befinden sich
     * keine Mauern im Territorium bzw. auf dem gewaehlten Weg
     * 
     * @param reihe
     *            Reihe der Zielkachel
     * @param spalte
     *            Spalte der Zielkachel
     */
    public synchronized void laufeZuKachel(int reihe, int spalte) {
        this.laufeZuReihe(reihe);
        this.laufeZuSpalte(spalte);
    }

    /**
     * ueberprueft, ob auf der Kachel, auf der der Hamster
     * aktuell steht, mindestens eine bestimmte Anzahl an
     * Koernern liegt
     * 
     * @param anzahl
     *            Anzahl der geforderten Koerner
     * @return true, falls auf der aktuellen Kachel mindestens
     *         "anzahl"-Koerner liegen
     */
    public synchronized boolean koernerDa(int anzahl) {
        return Territorium.getAnzahlKoerner(this.getReihe(),
                this.getSpalte()) >= anzahl;
    }

    /**
     * liefert die Kachel, auf der der Hamster gerade steht; das
     * Objekt kann als Sperr-Objekt fuer Aktionen auf der
     * entsprechenden Kachel genutzt werden kann
     * 
     * @return die Kachel, auf der der Hamster gerade steht
     */
    public synchronized Object getKachel() {
        return Territorium.getKachel(this.getReihe(), this
                .getSpalte());
    }

    /**
     * Hamster schlaeft die uebergebene Zeit (in Millisekunden)
     * 
     * @param millisekunden
     *            die zu schlafende Zeit
     */
    public synchronized void schlafen(int millisekunden) {
        try {
            Thread.sleep(millisekunden);
        } catch (InterruptedException exc) {
        }
    }

}
