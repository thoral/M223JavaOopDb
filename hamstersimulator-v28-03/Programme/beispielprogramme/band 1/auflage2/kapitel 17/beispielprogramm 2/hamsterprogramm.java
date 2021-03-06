import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    uebersteigeBerg();
}

void uebersteigeBerg()
{
    if (!gipfelErreicht())
    {
      klettereStufeHoch();
      uebersteigeBerg();  // rekursiver Aufruf
      klettereStufeHinunter();
    }
}

boolean gipfelErreicht()
{
    return vornFrei();
}

void klettereStufeHoch()
{
    linksUm();
    vor();
    rechtsUm();
    vor();
}

void klettereStufeHinunter()
{
    vor();
    rechtsUm();
    vor();
    linksUm();
}

void rechtsUm() { kehrt(); linksUm(); }

void kehrt() { linksUm(); linksUm(); }}