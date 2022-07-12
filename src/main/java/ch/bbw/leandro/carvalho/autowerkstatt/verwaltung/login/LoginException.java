package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.login;

/**
 * Diese Exception wird aufgerufen, falls beim Anmelden ein Fehler auftritt.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */
public class LoginException extends Exception{
    /**
     * Dies ist der Constructor für die LoginException.
     * @param message Diese Nachricht wird aufgerufen, falls diese Exception auftritt.
     */
    public LoginException(String message) {
        super(message);
    }
}
