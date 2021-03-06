/*
Windows:
  CLASSPATH: Programme\beispielprogramme\band 2\Anhang B
Linux, Solaris:
  CLASSPATH: Programme/beispielprogramme/band 2/Anhang B
*/
package kalah;

// repraesentiert ein Kalah-Spielbrett
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class Spielbrett {

    // Konstanten
    public final static int ANZAHL_MULDEN = 14;

    public final static int ANZAHL_KOERNER_PRO_MULDE = 6;

    public final static int ANZAHL_MULDEN_PRO_SPIELER = (Spielbrett.ANZAHL_MULDEN - 2) / 2;

    public final static int KALAH_A = // Nummer von Kalah A
    Spielbrett.ANZAHL_MULDEN_PRO_SPIELER;

    public final static int KALAH_B = // Nummer von Kalah B
    Spielbrett.KALAH_A + Spielbrett.ANZAHL_MULDEN_PRO_SPIELER
            + 1;

    public final static int ANZAHL_KOERNER = 2
            * Spielbrett.ANZAHL_MULDEN_PRO_SPIELER
            * Spielbrett.ANZAHL_KOERNER_PRO_MULDE;

    // Attribute
    protected int[] mulden;

    // repraesentiert die Mulden; der gespeicherte Wert gibt
    // jeweils an, wie viele Koerner sich in der Mulde befinden
    // Spieler A gehoren die Mulden 0 - 5, Spieler B die Mulden 7
    // - 12; Kalah A ist Mulde 6, Kalah B ist Mulde 13

    // initialisiert ein Anfangsspielbrett
    public Spielbrett() {
        this.mulden = new int[Spielbrett.ANZAHL_MULDEN];
        for (int i = 0; i < Spielbrett.ANZAHL_MULDEN_PRO_SPIELER; i++) {
            this.mulden[i] = Spielbrett.ANZAHL_KOERNER_PRO_MULDE;
        }
        this.mulden[Spielbrett.KALAH_A] = 0;
        for (int i = 0; i < Spielbrett.ANZAHL_MULDEN_PRO_SPIELER; i++) {
            this.mulden[Spielbrett.KALAH_A + 1 + i] = Spielbrett.ANZAHL_KOERNER_PRO_MULDE;
        }
        this.mulden[Spielbrett.KALAH_B] = 0;
    }

    // Copy-Konstruktor; erzeugt eine Kopie des uebergebenen
    // Spielbrettes
    public Spielbrett(Spielbrett brett) {
        this.mulden = new int[brett.mulden.length];
        for (int i = 0; i < this.mulden.length; i++) {
            this.mulden[i] = brett.mulden[i];
        }
    }

    // ueberprueft zwei Spielbretter auf Gleichheit
    public boolean equals(Object obj) {
        Spielbrett brett = (Spielbrett) obj;
        if (this.mulden.length != brett.mulden.length) {
            return false;
        }
        for (int i = 0; i < this.mulden.length; i++) {
            if (this.mulden[i] != brett.mulden[i]) {
                return false;
            }
        }
        return true;
    }

    // liefert die Anzahl an Koernern der Mulde mit der
    // angegebenen Nummer
    public int liefereAnzahlKoerner(int muldenNummer) {
        return this.mulden[muldenNummer];
    }

    // liefert die Anzahl an Koernern in Kalah A
    public int liefereAnzahlKoernerInKalahA() {
        return this.liefereAnzahlKoerner(Spielbrett.KALAH_A);
    }

    // liefert die Anzahl an Koernern in Kalah B
    public int liefereAnzahlKoernerInKalahB() {
        return this.liefereAnzahlKoerner(Spielbrett.KALAH_B);
    }

    // liefert die Anzahl an Koernern im angegebenen Kalah
    public int liefereAnzahlKoernerInKalah(boolean kalahA) {
        if (kalahA) {
            return this.liefereAnzahlKoernerInKalahA();
        } else {
            return this.liefereAnzahlKoernerInKalahB();
        }
    }

    // liefert die Gesamtanzahl an Koernern in den Mulden von
    // Spieler A
    public int liefereAnzahlKoernerVonSpielerA() {
        int anzahl = 0;
        for (int i = 0; i < Spielbrett.ANZAHL_MULDEN_PRO_SPIELER; i++) {
            anzahl = anzahl + this.mulden[i];
        }
        return anzahl;
    }

    // liefert die Gesamtanzahl an Koernern in den Mulden von
    // Spieler B
    public int liefereAnzahlKoernerVonSpielerB() {
        int anzahl = 0;
        for (int i = 0; i < Spielbrett.ANZAHL_MULDEN_PRO_SPIELER; i++) {
            anzahl = anzahl
                    + this.mulden[Spielbrett.KALAH_A + 1 + i];
        }
        return anzahl;
    }

    // liefert die Gesamtanzahl an Koernern in den Mulden des
    // angegebenen Spielers
    public int liefereAnzahlKoernerVonSpieler(boolean spielerA) {
        if (spielerA) {
            return this.liefereAnzahlKoernerVonSpielerA();
        } else {
            return this.liefereAnzahlKoernerVonSpielerB();
        }
    }

    // fuehrt den angegebenen Spielzug des angegebenen Spielers
    // auf dem Spielbrett aus;
    // Bedingung: Der Spielzug ist korrekt;
    // liefert die Nummer der Mulde, in die das letzte Korn
    // gelegt wurde
    public int fuehreSpielzugAus(boolean istSpielerA,
            Spielzug zug) {
        int nummer = zug.liefereMulde();
        int anzahlKoerner = this.mulden[nummer];

        // die betroffene Mulde wird geleert
        this.mulden[nummer] = 0;

        // die Koerner werden gegen den Uhrzeigersinn verteilt
        int i = 1;
        while (i <= anzahlKoerner) {
            nummer = (nummer + 1) % Spielbrett.ANZAHL_MULDEN;
            if (!((istSpielerA && nummer == Spielbrett.KALAH_B) || (!istSpielerA && nummer == Spielbrett.KALAH_A))
            // die Kalah des Gegners wird uebergangen
            ) {
                this.mulden[nummer] = this.mulden[nummer] + 1;
                i = i + 1;
            }
        }

        // entsprechend den Regeln muessen evtl. einige Koerner
        // in ein Kalah uebertragen werden
        if (nummer != Spielbrett.KALAH_A
                && nummer != Spielbrett.KALAH_B
                && this.mulden[nummer] == 1
                && this.mulden[Spielbrett
                        .gegenueberMulde(nummer)] > 0) {
            if (istSpielerA && 0 <= nummer
                    && nummer < Spielbrett.KALAH_A) {
                this.mulden[Spielbrett.KALAH_A] = this.mulden[Spielbrett.KALAH_A]
                        + this.mulden[nummer]
                        + this.mulden[Spielbrett
                                .gegenueberMulde(nummer)];
                this.mulden[nummer] = 0;
                this.mulden[Spielbrett.gegenueberMulde(nummer)] = 0;
            } else if (!istSpielerA
                    && Spielbrett.KALAH_A < nummer
                    && nummer < Spielbrett.KALAH_B) {
                this.mulden[Spielbrett.KALAH_B] = this.mulden[Spielbrett.KALAH_B]
                        + this.mulden[nummer]
                        + this.mulden[Spielbrett
                                .gegenueberMulde(nummer)];
                this.mulden[nummer] = 0;
                this.mulden[Spielbrett.gegenueberMulde(nummer)] = 0;
            }
        }

        return nummer;
    }

    // packt nach Spielende uebrig gebliebene Koerner ins
    // Kalah des entsprechenden Spielers
    public void spielBeenden() {
        // zunaechst Spieler A betrachten
        int anzahl = 0;
        for (int i = 0; i < Spielbrett.ANZAHL_MULDEN_PRO_SPIELER; i++) {
            anzahl = anzahl + this.mulden[i];
            this.mulden[i] = 0;
        }
        this.mulden[Spielbrett.KALAH_A] = this.mulden[Spielbrett.KALAH_A]
                + anzahl;

        // jetzt Spieler B
        anzahl = 0;
        for (int i = 0; i < Spielbrett.ANZAHL_MULDEN_PRO_SPIELER; i++) {
            anzahl = anzahl
                    + this.mulden[Spielbrett.KALAH_A + 1 + i];
            this.mulden[Spielbrett.KALAH_A + 1 + i] = 0;
        }
        this.mulden[Spielbrett.KALAH_B] = this.mulden[Spielbrett.KALAH_B]
                + anzahl;
    }

    // liefert die Nummer der gegenueber liegenden Mulde
    public static int gegenueberMulde(int nummer) {
        return Spielbrett.ANZAHL_MULDEN - 2 - nummer;
    }
}
