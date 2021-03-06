import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    do {

      // ermittle Richtung, in die der Hamster sich wenden muss
      int richtung = ermittleDrehungen();
      if (richtung == -1) return;  
        // -1: auf keinem der Nachbarfelder
        // existiert ein Korn -> Aufgabe geloest

      // drehe dich entsprechend oft
      while (richtung > 0) {
          linksUm();
          richtung--;
      }

      // gefunden, also fressen
      vor();
      while (kornDa()) {
          nimm();
      }
    } while (true);  
    // Endlosschleife wird durch obiges return vermieden
}

/*
 * ermittelt die Richtung, in die der Hamster sich drehen muss;
 * liefert die Anzahl an Linksdrehungen, die der Hamster 
 * durchfuehren muss, um in die korrekte Richtung zu blicken;
 * korrekt ist die Richtung mit der benachbarten Kachel mit 
 * den meisten Koernern (ohne Seiteneffekte);
 * liefert -1, falls kein Nachbarfeld mehr Koerner enthaelt
 */
int ermittleDrehungen() {
    int drehungen = 0;
    int koernerAnzahl = koernerAnzahlVorn();
    int schleifenZaehler = 1;

    while (schleifenZaehler <= 3) {
        linksUm();
        int neueKoernerAnzahl = koernerAnzahlVorn();
        if (neueKoernerAnzahl > koernerAnzahl) {
            drehungen = schleifenZaehler;
            koernerAnzahl = neueKoernerAnzahl;
        }
        schleifenZaehler++;
    }

    // zur Vermeidung von Seiteneffekten
    linksUm();
    if (koernerAnzahl == 0) {
        return -1;  // keine Koerner mehr auf Nachbarfeldern
    }

    return drehungen;
}

/*
 * liefert die Anzahl Koerner auf der Kachel vor dem Hamster
 * (ohne Seiteneffekte)
 */
int koernerAnzahlVorn() {
    if (!vornFrei()) {
        return 0;
    }
    vor();
    int anzahl = koernerAnzahl();

    // zur Vermeidung von Seiteneffekten
    kehrt(); 
    vor(); 
    kehrt();

    return anzahl;
}

/*
 * liefert die Anzahl Koerner auf einer Kachel 
 * (ohne Seiteneffekte)
 */
int koernerAnzahl() {
    int anzahl = 0;
    while (kornDa()) {
        nimm();
        anzahl++;
    }

    // zur Vermeidung von Seiteneffekten
    int koerner = anzahl;
    while (koerner > 0) {
        gib();
        koerner--;
    }

    return anzahl;
}

void kehrt() {
    linksUm(); 
    linksUm();
}}