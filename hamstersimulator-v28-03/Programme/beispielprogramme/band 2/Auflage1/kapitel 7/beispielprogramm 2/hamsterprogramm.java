import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
  Hamster willi = Hamster.getStandardHamster();
  DualHamster heidi = 
    new DualHamster(0, 0, Hamster.OST, 100000);
  OktalHamster paul = 
    new OktalHamster(10, 0, Hamster.OST, 100000);
  heidi.zeichne(willi.getAnzahlKoerner());
  paul.zeichne(willi.getAnzahlKoerner());
}
}