package chemin;

/** Levée quand aucune route n'existe entre un robot et une case. */
public class PasDeCheminException extends Exception {
    public PasDeCheminException(String message) {
        super(message);
    }
}