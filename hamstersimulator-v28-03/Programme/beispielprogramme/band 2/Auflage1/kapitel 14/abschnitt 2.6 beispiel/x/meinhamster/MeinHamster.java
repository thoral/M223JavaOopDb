package meinhamster;

import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class MeinHamster extends Hamster {

    public MeinHamster(int r, int s, int b, int k) { 
      super(r, s, b, k);
    }

    public void rechtsUm() {
      this.linksUm();
      this.linksUm();
      this.linksUm();
    }
}