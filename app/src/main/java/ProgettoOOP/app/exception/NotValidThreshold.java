package ProgettoOOP.app.exception;

/**
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 *         Eccezione lanciata se la soglia che si vuole richiedere è errata o
 *         l'operatore condizionale non è disponibile.
 */

public class NotValidThreshold extends ExceptionAbstract {

	private static final long serialVersionUID = 1L;

	/**
	 * Ottiene il messaggio da stampare
	 *
	 * @return String
	 */

	@Override
	public String getMessage() {
		return "Attenzione: la soglia scelta è errata o l'operatore condizionale non è disponibile."
				+ "Gli operatori condizionali disponibili sono '$gt' (>) e '$lt' (<).";

	}

}
