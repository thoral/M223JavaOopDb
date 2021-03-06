import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    loeseSpringerProblem();
}
 
int feld_anzahl = 25;
boolean geloest = false;
 
void loeseSpringerProblem()
{
    gib();
    feld_anzahl = feld_anzahl - 1;
    if (feld_anzahl == 0) // Problem geloest!
    {
      geloest = true;
      return;
    }

    // von einem Feld aus hat der Hamster maximal 8 
    // Sprungmoeglichkeiten und zwar in jeder Blickrichtung 2;
    // wenn eine Sprungmoeglichkeit erreichbar ist und dort noch
    // kein Korn liegt, springt der Hamster dorthin und ruft
    // den Algorithmus rekursiv auf
    int richtungen = 0;
    while (!geloest && (richtungen < 4))
    {
      if (erstesSprungZielBelegbar())
      {  
        geheZumErstenSprungZiel();
        loeseSpringerProblem();
        if (geloest) return;
        geheZurueckVomErstenSprungZiel();
      }
      if (zweitesSprungZielBelegbar())
      {
        geheZumZweitenSprungZiel();
        loeseSpringerProblem();
        if (geloest) return;
        geheZurueckVomZweitenSprungZiel();
      }
      linksUm();
      richtungen = richtungen + 1;
    }
    nimm();
    feld_anzahl = feld_anzahl + 1;
}
 
// ueberprueft, ob das erste Sprungziel in einer Sprungrichtung
// belegbar ist (erreichbar und kein Korn vorhanden)
// (ohne Seiteneffekte)
boolean erstesSprungZielBelegbar()
{
    if (!vornFrei()) return false;
    vor();
    linksUm();
    if (!vornFrei())
    {
      linksUm(); vor(); kehrt();
      return false;
    }
    vor();
    if (!vornFrei())
    {
      linksUm(); vor(); linksUm(); vor(); linksUm();
      return false;
    }
    vor();
    boolean belegt = kornDa();
    linksUm(); vor();
    linksUm(); vor(); vor();
    linksUm();
    return !belegt;
}
 
void geheZumErstenSprungZiel()
{
    vor(); linksUm(); vor(); vor();
}
 
void geheZurueckVomErstenSprungZiel()
{
    linksUm(); vor();
    linksUm(); vor(); vor();
    linksUm();
}

// ueberprueft, ob das zweite Sprungziel in einer Sprungrichtung
// belegbar ist (erreichbar und kein Korn vorhanden)
// (ohne Seiteneffekte)
boolean zweitesSprungZielBelegbar()
{
    if (!vornFrei()) return false;
    vor();
    if (!vornFrei())
    {
      kehrt(); vor(); kehrt();
      return false;
    }
    vor();
    linksUm();
    if (!vornFrei())
    {
      linksUm(); vor(); vor(); kehrt();
      return false;
    }
    vor();
    boolean belegt = kornDa();
    linksUm(); vor(); vor();
    linksUm(); vor(); linksUm();
    return !belegt;
}
 
void geheZumZweitenSprungZiel()
{
    vor(); vor(); linksUm(); vor();
}

void geheZurueckVomZweitenSprungZiel()
{
    linksUm(); vor(); vor();
    linksUm(); vor(); linksUm();
}

void kehrt() { linksUm(); linksUm(); }}