/**
 * Hamster-Exception die den Fehler repraesentiert, das dem init-Befehl
 * ungueltige Werte uebergeben werden.
 * 
 * @author Dietrich Boles (Universitaet Oldenburg)
 * @version 2.5.2 (11.04.2008)
 * 
 */
public class HamsterInitialisierungsException extends HamsterException {

	/**
	 * Konstruktor, der die Exception mit dem Hamster initialisiert, der die
	 * Exception verschuldet hat.
	 * 
	 * @param hamster
	 *            der Hamster, der die Exception verschuldet hat
	 */
	public HamsterInitialisierungsException(Hamster hamster) {
		super(hamster);
	}

	/**
	 * liefert eine der Exception entsprechende Fehlermeldung
	 * 
	 * @return Fehlermeldung
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return "Die bei der Initialisierung des Hamsters "
				+ "uebergebenen Parameterwerte sind nicht korrekt!";
	}
}

