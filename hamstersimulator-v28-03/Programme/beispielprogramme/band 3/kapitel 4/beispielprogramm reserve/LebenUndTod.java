import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class LebenUndTod implements de.hamster.model.HamsterProgram {public void main() {
  SterbenderHamster paul = new SterbenderHamster();
  paul.start();
  HelferHamster willi = new HelferHamster(Hamster.getStandardHamster());
  willi.start();
}
}