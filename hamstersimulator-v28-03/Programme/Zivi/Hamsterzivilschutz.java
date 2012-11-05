/*object-oriented program*/import java.util.*;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class Hamsterzivilschutz implements de.hamster.model.HamsterProgram {public void main()
{
    ZivilSchutzChef zsc = new ZivilSchutzChef();
    ZivilSchuetzer zs = new ZivilSchuetzer();
zsc.init(1,2,Hamster.OST,20);
zsc.aufbieten();
}

class ZivilSchuetzer extends Hamster
{
void rechtsUm()
{ linksUm();
kehrt();
}

void kehrt()
{ linksUm();linksUm();
}

void tuerAufZu(){
while(true)
{
if(kornDa())
{ nimm();
if(!tuerAuf)
{ tuerAuf();
tuerAuf=true;
}else{
tuerZu();
tuerAuf=false;
}
}
}
}
}


class ZivilSchutzChef extends ZivilSchuetzer
{
List<Tuersteher> tuersteher = new ArrayList<Tuersteher>();
boolean tuerAuf = false;

void tuerAuf()
{
for(Tuersteher t : tuersteher)
{
t.tuerAuf();
}
}

void tuerZu()
{
for(Tuersteher t : tuersteher)
t.tuerZu();
}

void aufbieten()
{
while(getSpalte()!=1 || getReihe()!=1)
{
if(beiWand())
vor();
else if(inTuer())
{
tuerSteherPlazieren();
vor();
}
else
{
rechtsUm();
vor();
}
}

zs.tuerAufZu();

}

boolean beiWand()
{ rechtsUm();
boolean b = !vornFrei();
linksUm();
return b;
}

boolean inTuer()
{ boolean b = false;
rechtsUm();
vor();
linksUm();
b = !vornFrei();
kehrt();
b &= !vornFrei();
rechtsUm();
vor();
rechtsUm();
return b;
}

void tuerSteherPlazieren()
{ Tuersteher tst = new Tuersteher();
tuersteher.add(tst);
int r,s,rtg;
r=this.getReihe();
s=this.getSpalte();
rtg=this.getBlickrichtung();
tst.init(r,s,rtg,0);
tst.inPosition();
}
}

class Tuersteher extends ZivilSchuetzer
{
public void inPosition()
{ rechtsUm();
vor();
kehrt();
}

public void tuerAuf()
{ vor();
rechtsUm();
vor();
linksUm();
}

public void tuerZu()
{ linksUm();
vor();
linksUm();
vor();
kehrt();
}
}}