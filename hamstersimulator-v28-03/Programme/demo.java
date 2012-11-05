import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class demo implements de.hamster.model.HamsterProgram {public void main() {
	Hamster h = new Hamster();
	Hamster a = new Hamster();
	h.init(2,8,Hamster.SUED,10);
	h.vor(); h.vor();
	h.linksUm();	h.linksUm();	h.linksUm(); 
		h.vor();	h.vor();	h.vor();	h.vor();
		
	a.init(2,8,Hamster.SUED,10);
	a.vor(); h.vor();
	a.linksUm();	a.linksUm();	a.linksUm(); 
		h.vor();
}

class VorsichtigerHamster extends Hamster
{
	public void vor()
	{	
		if(vornFrei() )
		{
			super.vor();
		}
	} 
}		}