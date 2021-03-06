import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class BotschaftsHamster extends Hamster {

    final static int MAX_BOTSCHAFTEN = 50;

    int anzahlBotschaften;

    BotschaftsHamster(int r, int s, int b) {
        // egal, wohin ein Botschaftshamster platziert wird,
        // er laeuft immer direkt zur Kachel (0/0)
        this.init(r, s, b, 0);
        this.anzahlBotschaften = 0;
        while (this.getBlickrichtung() != Hamster.NORD) {
            this.linksUm();
        }
        this.renneZurMauer();
        this.linksUm();
        this.renneZurMauer();
        this.linksUm();
        // nun steht der Hamster mit Blickrichtung SUED auf
        // Kachel (0/0)
    }

    void renneZurMauer() {
        while (this.vornFrei()) {
            this.vor();
        }
    }

    void ueberbringeBotschaft() {
        // der Hamster nimmt das Botschaftskorn,
        // rennt in die naechste Ecke und legt das Korn dort ab
        this.nimm();
        this.renneZurMauer();
        this.linksUm();
        this.gib();
        this.anzahlBotschaften = this.anzahlBotschaften + 1;
    }

    boolean istAmEnde() {
        return this.anzahlBotschaften > BotschaftsHamster.MAX_BOTSCHAFTEN;
    }
}