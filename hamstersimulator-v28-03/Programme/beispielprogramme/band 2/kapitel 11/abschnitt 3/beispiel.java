import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class beispiel implements de.hamster.model.HamsterProgram {class DrehHamster extends Hamster {

    DrehHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    void rechtsUm() {
        this.linksUm();
        this.linksUm();
        this.linksUm();
    }
}

class SammelHamster extends Hamster {

    SammelHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    void sammle() {
        while (this.kornDa()) {
            this.nimm();
        }
    }
}

class FaulerHamster extends Hamster {

    Hamster knecht;

    FaulerHamster(int r, int s, int b, int k, Hamster hamster) {
        super(r, s, b, k);
        this.knecht = hamster;
    }

    public void vor() {
        this.knecht.vor(); // Delegation
    }
}

public void main() {
    /* 1 */ DrehHamster otto = new DrehHamster(2, 4,
                Hamster.NORD, 0);
    /* 2 */ SammelHamster paul = new SammelHamster(3, 5,
                Hamster.OST, 0);
    /* 3 */ FaulerHamster sepp = new FaulerHamster(4, 4,
                Hamster.WEST, 0, otto);
    /* 4 */ FaulerHamster karl = new FaulerHamster(7, 7,
                Hamster.WEST, 0, paul);
    /* 5 */ sepp.vor();
    /* 6 */ karl.vor();
}}