import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class ManipulierterWuerfel extends Wuerfel {
  // Ueberschreiben der geerbten Methode
  int wuerfeln() {
    // liefert immer die Hoechstzahl 6
    return 6;
  }
}
