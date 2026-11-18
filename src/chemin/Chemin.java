package chemin;

import java.util.ArrayList;
import java.util.List;

import carte.Case;

/**
 * Chemin d'un robot : suite de cases à parcourir (case de départ exclue)
 * avec l'instant relatif (en secondes depuis le départ) d'arrivée sur chacune.
 */
public class Chemin {
    private final List<Case> cases = new ArrayList<>();
    private final List<Double> instants = new ArrayList<>();

    /** Ajoute une étape : la case atteinte et l'instant d'arrivée. */
    public void ajouterEtape(Case c, double instantArrivee) {
        cases.add(c);
        instants.add(instantArrivee);
    }

    public int getNbEtapes() { return cases.size(); }
    public Case getCase(int i) { return cases.get(i); }
    public double getInstant(int i) { return instants.get(i); }

    /** Durée totale du trajet (0 si le robot est déjà sur place). */
    public double getDuree() {
        return instants.isEmpty() ? 0 : instants.get(instants.size() - 1);
    }
}