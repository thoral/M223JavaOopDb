import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class QuadratHamster extends AllroundHamster {
  // Konstruktor
  QuadratHamster(int r, int s, int b, int k) {
    super(r, s, b, k);
  }
  
  // zeichnet ab der Kachel (r/s) mit Koernern ein Quadrat 
  // mit der angegebenen Seitenlaenge;
  // der Hamster tut nichts und liefert false, wenn er
  // nicht genuegend Koerner zum Zeichnen im Maul hat oder
  // ab der angegebenen Kachel nicht mehr genuegend Platz ist
  boolean zeichne(int r, int s, int laenge) {
    if (laenge <= 0 ||
        !this.genuegendKoernerImMaul(laenge) ||
        !this.genuegendPlatz(r, s, laenge)
       ) {
      return false;
    }
    
    this.merkenDerStartPosition();
    this.gotoKachel(r, s);
    this.setzeBlickrichtung(Hamster.OST);
    this.zeichneWirklich(laenge);
    this.geheZurStartPosition();
    return true;
  }

  // Hilfsmethoden

  boolean genuegendKoernerImMaul(int laenge) {
    int benoetigteAnzahl = 0;
    if (laenge == 1) {
      benoetigteAnzahl = 1;
    } else {
      benoetigteAnzahl = (laenge-1) * 4;
    }
    return benoetigteAnzahl <= this.getAnzahlKoerner();
  }
  
  boolean genuegendPlatz(int r, int s, int laenge) {
    return s + laenge <= Territorium.getAnzahlSpalten() &&
           r + laenge <= Territorium.getAnzahlReihen();
  }
  
  int rAlt, sAlt, bAlt;
  
  void merkenDerStartPosition() {
    this.rAlt = this.getReihe();
    this.sAlt = this.getSpalte();
    this.bAlt = this.getBlickrichtung();
  }
  
  void geheZurStartPosition() {
    this.gotoKachel(this.rAlt, this.sAlt);
    this.setzeBlickrichtung(this.bAlt);
  }
  
  void zeichneWirklich(int laenge) {
    this.gib();
    if (laenge > 1) {
      this.vorUndGib(laenge-1);
      this.rechtsUm();
      this.vorUndGib(laenge-1);
      this.rechtsUm();
      this.vorUndGib(laenge-1);
      this.rechtsUm();
      this.vorUndGib(laenge-2);
      this.vor();
      this.rechtsUm();
    }
  }
    
  void vorUndGib(int anzahl) {
    while (anzahl > 0) {
      this.vor();
      this.gib();
      anzahl = anzahl - 1;
    }
  }
}
