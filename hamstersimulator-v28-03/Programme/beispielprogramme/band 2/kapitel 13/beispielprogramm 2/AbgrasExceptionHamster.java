import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class AbgrasExceptionHamster extends ExceptionHamster {

    AbgrasExceptionHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    void kehrt() {
        this.linksUm();
        this.linksUm();
    }

    void rechtsUm() {
        this.kehrt();
        this.linksUm();
    }

    boolean linksFrei() {
        try {
            this.linksUm();
            this.vor();
            // geklappt; jetzt noch wieder zurueck
            this.kehrt();
            this.vor(); // hier kann nichts schiefgehen
            this.linksUm();
            return true;
        } catch (MauerDaException exc) {
            // vor hat nicht geklappt
            this.rechtsUm();
            return false;
        }
    }

    boolean rechtsFrei() {
        try {
            this.rechtsUm();
            this.vor();
            // geklappt; jetzt noch wieder zurueck
            this.kehrt();
            this.vor(); // hier kann nichts schiefgehen
            this.rechtsUm();
            return true;
        } catch (MauerDaException exc) {
            // vor hat nicht geklappt
            this.linksUm();
            return false;
        }
    }

    boolean weitereReiheExistiert() {
        if (this.getBlickrichtung() == Hamster.OST) {
            return this.rechtsFrei();
        } else {
            return this.linksFrei();
        }
    }

    void sammle() {
        try {
            while (true) {
                this.nimm();
            }
        } catch (KachelLeerException exc) {
            // auf der Kachel liegen keine Koerner mehr; also
            // kann die Methode beendet werden
        }
    }

    void begibDichInNaechsteReihe() {
        try {
            if (this.getBlickrichtung() == Hamster.OST) {
                this.rechtsUm();
                this.vor();
                this.rechtsUm();
            } else {
                this.linksUm();
                this.vor();
                this.linksUm();
            }
        } catch (MauerDaException exc) {
        }
    }

    void ernteEineReihe() {
        try {
            this.sammle();
            while (true) {
                this.vor();
                this.sammle();
            }
        } catch (MauerDaException exc) {
            // am Ende der Reihe angelangt; also kann die
            // Methode beendet werden
        }
    }
}