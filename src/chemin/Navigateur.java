package chemin;

import carte.Carte;
import carte.Case;
import robots.Robot;
import simulation.Simulateur;
import simulation.events.EvenementDeplacement;

/**
 * Fait le lien entre le calcul de chemin et le simulateur : estime un temps
 * de trajet et programme les déplacements élémentaires d'un robot.
 */
public class Navigateur {
    private final CalculateurChemin calculateur;

    public Navigateur(Carte carte) {
        this.calculateur = new CalculateurChemin(carte);
    }

    /** Temps (s) pour que le robot rejoigne dest, ou +infini si inaccessible. */
    public double tempsPour(Robot robot, Case dest) {
        try {
            return calculateur.calculer(robot, dest).getDuree();
        } catch (PasDeCheminException e) {
            return Double.POSITIVE_INFINITY;
        }
    }

    /**
     * Programme dans le simulateur les déplacements case par case jusqu'à dest.
     *
     * @param dateDebut date courante du simulateur (le robot doit être inactif)
     * @throws PasDeCheminException si dest est inaccessible
     */
    public void allerVers(Robot robot, Case dest, Simulateur sim, long dateDebut)
            throws PasDeCheminException {
        Chemin chemin = calculateur.calculer(robot, dest);
        long datePrecedente = dateDebut;
        for (int i = 0; i < chemin.getNbEtapes(); i++) {
            long date = dateDebut + (long) Math.ceil(chemin.getInstant(i));
            date = Math.max(date, datePrecedente + 1); // dates strictement croissantes
            sim.ajouteEvenement(new EvenementDeplacement(date, robot, chemin.getCase(i)));
            datePrecedente = date;
        }
    }
}