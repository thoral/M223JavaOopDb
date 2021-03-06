/*
Windows:
  CLASSPATH: Programme\beispielprogramme\band 2\kapitel 15
Linux, Solaris:
  CLASSPATH: Programme/beispielprogramme/band 2/kapitel 15
*/
package hamsterkalah;

import kalah.*;

// repraesentiert einen Hamster als Schiedsrichter des
// Kalah-Spiels
import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class AbfrageSchiedsrichterHamster 
  extends SchiedsrichterHamster 
{
  // Konstruktor
  public AbfrageSchiedsrichterHamster() {
    super();
  }

  // erzeugt und liefert Spieler A
  public Spieler erzeugeSpielerA(Spielregeln regeln) {
    String antwort = 
      this.liesZeichenkette("Spieler A: Mensch oder Hamster?");
    while (!(antwort.equals("Mensch") || antwort.equals("Hamster"))) {
      antwort = 
        this.liesZeichenkette("Eingabefehler!\n" +
                              " Spieler A: Mensch oder Hamster?");
    }
    Spieler spieler;
    if (antwort.equals("Mensch")) {
      spieler = new MenschHamster(true, regeln);
    } else {
      int staerke = this.liesZahl("Staerke des Hamster?");
      spieler = new StrategieHamster(true, regeln, staerke);
    }
    return spieler;
  }
  
  // erzeugt und liefert Spieler B
  public Spieler erzeugeSpielerB(Spielregeln regeln) {
    String antwort = 
      this.liesZeichenkette("Spieler B: Mensch oder Hamster?");
    while (!(antwort.equals("Mensch") || antwort.equals("Hamster"))) {
      antwort = 
        this.liesZeichenkette("Eingabefehler!\n" +
                              " Spieler B: Mensch oder Hamster?");
    }
    Spieler spieler;
    if (antwort.equals("Mensch")) {
      spieler = new MenschHamster(false, regeln);
    } else {
      int staerke = this.liesZahl("Staerke des Hamster?");
      spieler = new StrategieHamster(false, regeln, staerke);
    }
    return spieler;
  }
}
