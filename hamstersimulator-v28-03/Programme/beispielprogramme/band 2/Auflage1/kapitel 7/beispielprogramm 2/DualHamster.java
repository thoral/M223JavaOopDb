import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class DualHamster extends AllroundHamster {
  // Konstruktor
  DualHamster(int r, int s, int b, int k) {
    super(r, s, b, k);
  }
  
  // zeichnet eine 0 aus Koernern
  void zeichne0() {
    this.vorUndGib(3);
    this.rechtsUm();
    this.vorUndGib(4);
    this.rechtsUm();
    this.vorUndGib(2);
    this.rechtsUm();
    this.vorUndGib(3);
    this.vor();
    this.linksUm(); 
    this.vor();
    this.kehrt();
  }
  
  // zeichnet eine 1 aus Koernern
  void zeichne1() {
    this.vor();
    this.rechtsUm();
    this.vor();
    this.vor();
    this.linksUm();
    this.gib();
    this.vor();
    this.linksUm();
    this.vor();
    this.rechtsUm();
    this.gib();
    this.linksUm();
    this.vor();
    this.rechtsUm();
    this.vor();
    this.rechtsUm();
    this.gib();
    this.vorUndGib(4);
    this.rechtsUm();
    this.vor(2);
    this.rechtsUm();
    this.vor(4);
    this.linksUm();
    this.vor();
    this.kehrt();
  }
  
  // zeichnet die uebergebene Dezimalzahl als Dualzahl
  // aus Koernern
  void zeichne(int dezimalZahl) {
    this.setzeBlickrichtung(Hamster.OST);
    if (dezimalZahl < 2) {
      this.zeichneZiffer(dezimalZahl);
      this.vor(4);
    } else {
      this.zeichne(dezimalZahl / 2); // Rekursion!
      this.zeichneZiffer(dezimalZahl % 2);
      this.vor(4);
    }
  }
  
  // zeichnet die uebergebene Ziffer aus Koernern
  void zeichneZiffer(int ziffer) {
    if (ziffer == 0) {
      this.zeichne0();
    } else if (ziffer == 1) {
      this.zeichne1();
    }
  }
  
  // Hilfsmethoden
  void vorUndGib(int anzahl) {
    while (anzahl > 0) {
      this.vor();
      this.gib();
      anzahl = anzahl - 1;
    }
  }
}
