import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class GefuelltesQuadratHamster extends QuadratHamster {
    // Konstruktor
    GefuelltesQuadratHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    // zeichnet ab der Kachel (r/s) mit Koernern ein Quadrat
    // mit der angegebenen Seitenlaenge;
    // das Quadrat wird dabei mit Koernern gefuellt;
    // der Hamster tut nichts und liefert false, wenn er
    // nicht genuegend Koerner zum Zeichnen im Maul hat oder
    // ab der angegebenen Kachel nicht mehr genuegend Platz ist
    boolean zeichne(int r, int s, int laenge) {
        if (laenge <= 0 || !this.genuegendKoernerImMaul(laenge)
                || !this.genuegendPlatz(r, s, laenge)) {
            return false;
        }

        this.merkenDerStartPosition();
        this.laufeZuKachel(r, s);
        this.setzeBlickrichtung(Hamster.OST);
        while (laenge > 0) {
            super.zeichneWirklich(laenge);
            laenge = laenge - 2;
            if (laenge > 0) {
                this.vor();
                this.rechtsUm();
                this.vor();
                this.linksUm();
            }
        }
        this.geheZurStartPosition();
        return true;
    }
    
    // alternative Implementierung; aber nicht optimiert, da der
    // Hamster nach jedem Aufruf der geerbten Methode zeichne
    // wieder zunaechst zur Ausgangsposition laeuft
    /*
    boolean zeichnex(int r, int s, int laenge) {
        if (laenge <= 0 || !this.genuegendKoernerImMaul(laenge)
                || !this.genuegendPlatz(r, s, laenge)) {
            return false;
        }
        while (laenge > 0) {
            super.zeichne(r, s, laenge);
            laenge = laenge - 2;
            r = r + 1;
            s = s + 1;
        }
        return true;
    }
    */

    // Hilfsmethoden
    
    // muss ueberschrieben werden
    boolean genuegendKoernerImMaul(int laenge) {
        return laenge * laenge <= this.getAnzahlKoerner();
    }
}