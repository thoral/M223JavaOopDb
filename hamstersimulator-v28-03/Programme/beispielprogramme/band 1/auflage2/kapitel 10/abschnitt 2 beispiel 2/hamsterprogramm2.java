import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm2 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    laufeBisZurNaechstenWand();
    linksUm();
    laufeBisZurNaechstenWand();
}

void laufeBisZurNaechstenWand()
{
    while (vornFrei())
    {
      vor();
    }
}
}