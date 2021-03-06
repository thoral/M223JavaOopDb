/*
Windows:
  CLASSPATH: Programme\beispielprogramme\band 2\kapitel 15
Linux, Solaris:
  CLASSPATH: Programme/beispielprogramme/band 2/kapitel 15
*/
package kalah;

// repraesentiert die Spielregeln des Kalah-Spiels
import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class Spielregeln {
  
  private Spielbrett brett; // das zu kontrollierende Brett
  
  // initialisiert die Regeln; uebergeben wird das zu kontrollierende
  // Spielbrett
  public Spielregeln(Spielbrett brett) {
    this.brett = brett;
  }
  
  // kontrolliert, ob der angegebene Spielzug des angegebenen
  // Spielers korrekt ist
  public boolean istSpielzugOk(boolean istSpielerA, 
                               Spielzug zug) {
    if (zug == null) {
      return false;
    }

    // es muss eine Mulde sein, die dem Spieler gehoert
    int nummer = zug.liefereMulde();
    if (istSpielerA) {
      if (!(0 <= nummer && nummer < Spielbrett.KALAH_A)) {
        return false;
      }
    } else {
      if (!(Spielbrett.KALAH_A < nummer && 
            nummer < Spielbrett.KALAH_B)) {
        return false;
      }
    }
    
    // die Mulde darf nicht leer sein
    if (this.brett.liefereAnzahlKoerner(nummer) == 0) {
      return false;
    }
    
    // Spielzug ist ok
    return true;
  }

  // liefert die Information, ob A als naechster ziehen muss;
  // uebergeben wird die Information, ob A als letzter gezogen hat,
  // sowie die Nummer der Mulde, in der der letzte Zug geendet hat
  public boolean istAAmZug(boolean aLetzterSpieler, int mulde) { 
    if (aLetzterSpieler) {
      return mulde == Spielbrett.KALAH_A;
    } else {
      return mulde != Spielbrett.KALAH_B;
    }
  }
  
  // ueberprueft; ob das Spiel beendet ist; uebergeben wird die
  // Information, ob A am Zug ist
  public boolean istSpielBeendet(boolean istA) {
    // das Spiel ist beendet, wenn alle Mulden des Spielers leer
    // sind
    return this.brett.liefereAnzahlKoernerVonSpieler(istA) == 0;
  }
  
  // ueberprueft auf Unentschieden;
  // Bedingung: Spiel ist beendet und die uebrig gebliebenen Koerner
  //            wurden in das entsprechende Kalah gepackt
  public boolean istUnentschieden() {
    return this.brett.liefereAnzahlKoernerInKalahA() ==
           this.brett.liefereAnzahlKoernerInKalahB();
  }
  
  // liefert true, wenn Spieler A Sieger ist;
  // liefert false, wenn Spieler B Sieger ist;
  // Bedingung: Spiel ist beendet und nicht unentschieden
  public boolean istSpielerASieger() {
    return this.brett.liefereAnzahlKoernerInKalahA() >
           this.brett.liefereAnzahlKoernerInKalahB();
  }

  // liefert das Spielbrett
  public Spielbrett getBrett() {
    return this.brett;
  }
}
