import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    RennHamster paul = new RennHamster(Hamster.getStandardHamster());
    paul.renneWandAb();
}

class RennHamster extends AllroundHamster {

    boolean[][] raum;
    int startR, startS;
    boolean gelaufen;

    RennHamster(Hamster hamster) {
      super(hamster);
      // erzeugt boolean-Array, das so gross ist wie das Territorium
      this.raum = 
        new boolean[Territorium.getAnzahlReihen()]
                   [Territorium.getAnzahlSpalten()];
      // initialisiert das Array mit den Werten der mauerDa-Methode
      for (int z=0; z<this.raum.length; z++) {
        for (int s=0; s<this.raum[z].length; s++) {
          this.raum[z][s] = Territorium.mauerDa(z, s);
        }
      }
    }

    void renneWandAb() {
      this.startR = this.getReihe();
      this.startS = this.getSpalte();
      this.gelaufen = false;
      this.renn();
    }

    void renn() {
      if (gelaufen && this.getSpalte() == this.startS && 
          this.getReihe() == this.startR) {
        return; // Ausgangspunkt erreicht
      }
      if (this.rechtsFrei()) {
        this.rechtsUm();
        this.vor();
        this.renn();
      } else if (this.vornFrei()) {
        this.vor();
        this.renn();
      } else if (this.linksFrei()) {
        this.linksUm();
        this.vor();
        this.renn();
      } else {
        this.kehrt();
        if (this.vornFrei()) {
          this.vor();
          this.renn();
        }
      }
    }

    // Ueberschreiben des Standard-Befehls
    public void vor() {
      super.vor();
      this.gelaufen = true;
    }

    // Ueberschreiben des Standard-Testbefehls
    public boolean vornFrei() {
      if (this.getBlickrichtung() == Hamster.NORD) {
        if (this.getReihe() == 0) 
          return false;
        else 
          return !this.raum[this.getReihe()-1][this.getSpalte()];
      } else if (this.getBlickrichtung() == Hamster.SUED) {
        if (this.getReihe() == Territorium.getAnzahlReihen()-1) 
          return false;
        else 
          return !this.raum[this.getReihe()+1][this.getSpalte()];
      } else if (this.getBlickrichtung() == Hamster.WEST) {
        if (this.getSpalte() == 0) 
          return false;
        else 
          return !this.raum[this.getReihe()][this.getSpalte()-1];
      } else { // this.getBlickrichtung() == Hamster.OST
        if (this.getSpalte() == Territorium.getAnzahlSpalten()-1) 
          return false;
        else 
          return !this.raum[this.getReihe()][this.getSpalte()+1];
      }
    }
}
}