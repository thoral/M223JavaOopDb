import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class SpielHamster extends Hamster {
  Wuerfel wuerfel;
  
  SpielHamster(int r, int s, Wuerfel w) {
    super(r, s, Hamster.OST, 0);
    this.wuerfel = w;
  }
  
  Wuerfel gibWuerfel() {
    return this.wuerfel;
  }
  
  boolean vor(int anzahl) {
    while (anzahl > 0 && this.vornFrei()) {
      this.vor();
      anzahl = anzahl - 1;
    }
    return !this.vornFrei();
    // liefert true, wenn der Hamster vor einer Mauer steht,
    // also gewonnen hat
  }

  void freuen() {
    this.linksUm();
    this.linksUm();
    this.linksUm();
    this.linksUm();
  }
}
