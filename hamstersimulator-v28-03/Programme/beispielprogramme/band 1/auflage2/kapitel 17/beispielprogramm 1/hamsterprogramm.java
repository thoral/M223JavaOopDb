import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    // suche den vorderen Teil der Koernerspur ab
    sucheGeradeAb();
    // suche evtl. den hinteren Teil der Koernerspur ab
    if (vornKorn())
    {
      vor();
      sucheGeradeAb();
      vor();
    }
}

// Implementierung des Backtracking-Verfahrens
void sucheGeradeAb()
{

    // Abarbeiten von Abzweigungen links
    if (linksKorn())
    {
      linksUm();
      vor();
      sucheGeradeAb();
      vor();
      linksUm();
    }

    // Abarbeiten von Abzweigungen rechts
    if (rechtsKorn())
    {
      rechtsUm();
      vor();
      sucheGeradeAb();
      vor();
      rechtsUm();
    }

    // vorne Abarbeiten 
    if (vornKorn())
    {
      vor();
      sucheGeradeAb();
      vor();
    }
    else
    {
      kehrt();
    }

    // auf dem Rueckweg sammelt der Hamster die Koerner ein
    while (kornDa())
    {
      nimm();
    }
}

// liefert true, wenn auf der Kachel vor dem Hamster ein Korn
// liegt (ohne Seiteneffekte)
boolean vornKorn()
{
    if (!vornFrei()) return false;
    vor();
    boolean korn_gefunden = kornDa();
    kehrt();
    vor();
    kehrt();
    return korn_gefunden;
}

// liefert true, wenn auf der Kachel links vom Hamster ein Korn
// liegt (ohne Seiteneffekte)
boolean linksKorn()
{
    linksUm();
    boolean korn_gefunden = vornKorn();
    rechtsUm();
    return korn_gefunden;
}

// liefert true, wenn auf der Kachel rechts vom Hamster ein Korn
// liegt (ohne Seiteneffekte)
boolean rechtsKorn()
{
    rechtsUm();
    boolean korn_gefunden = vornKorn();
    linksUm();
    return korn_gefunden;
}

void rechtsUm() { kehrt(); linksUm(); }

void kehrt() { linksUm(); linksUm(); }}