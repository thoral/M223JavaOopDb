import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class BergHamster extends AllroundHamster {
  
  int bergHoehe;
  int erklommeneStufen;
  
  BergHamster(Hamster hamster) {
    super(hamster);
    this.bergHoehe = 0;
    this.erklommeneStufen = 0;
  }
  
  void erklimmeStufe() {
    this.linksUm();
    this.vor();
    this.rechtsUm();
    this.vor();
    this.erklommeneStufen = this.erklommeneStufen + 1;
  }
  
  boolean gipfelErreicht() {
    if (this.vornFrei()) {
      // Gifel ist erreicht
      this.bergHoehe = this.erklommeneStufen;
      return true;
    } else {
      return false;
    }
  }
  
  boolean hoeheErfahren() {
    String antwort = 
      this.liesZeichenkette("Ich bin nicht schwindelfrei.\n" +
                            "Kannst du mir die Hoehe des " +
                            "Berges verraten (ja/nein)?");
    if (antwort.equals("ja")) {
      this.bergHoehe = 
        this.liesZahl("Danke. Wie hoch ist der Berg denn?");
      return true;
    }
    return false;
  }
  
  boolean talErreicht() {
    return this.erklommeneStufen == 0;
  }
  
  void klettereStufeHinab() {
    this.vor();
    this.linksUm();
    this.vor();
    this.rechtsUm();
    this.erklommeneStufen = this.erklommeneStufen - 1;
  }
  
  int getBergHoehe() {
    return this.bergHoehe;
  }
}
