import carte.Carte;
import carte.Case;
import carte.Position;
import chemin.Navigateur;
import io.LecteurDonnees;
import robots.Robot;
import simulation.DonneesSimulation;
import simulation.Simulateur;

public class TestChemin {
    public static void main(String[] args) throws Exception {
        DonneesSimulation donnees = LecteurDonnees.lire("cartes/carteSujet.map");
        Carte carte = donnees.getCarte();
        Simulateur sim = new Simulateur();
        Navigateur nav = new Navigateur(carte);

        Robot drone = donnees.getRobots().get(0);
        Case dest = carte.getCase(0, 0);

        double duree = nav.tempsPour(drone, dest);
        System.out.println("Durée estimée : " + duree + " s");

        nav.allerVers(drone, dest, sim, 0);
        for (long t = 0; t <= (long) duree + 2; t++) {
            sim.incrementDate();
        }
        Position p = drone.getPosition();
        System.out.println("Position finale : (" + p.getX() + ", " + p.getY() + ")");
    }
}