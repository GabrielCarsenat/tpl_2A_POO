import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

import gui.GUISimulator;
import io.LecteurDonnees;
import simulation.DonneesSimulation;
import simulation.Simulateur;


public class TestAffichage {
    public static void main(String[] args) {

        DonneesSimulation d;
        try {
            d = LecteurDonnees.lire(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("fichier " + args[0] + " inconnu ou illisible");
            return;
        } catch (DataFormatException e) {
            System.out.println("\n\t**format du fichier " + args[0] + " invalide: " + e.getMessage());
            return;
        }


        // crée la fenêtre graphique dans laquelle dessiner
        GUISimulator gui = new GUISimulator(800, 600, Color.BLACK);
        // crée l'invader, en l'associant à la fenêtre graphique précédente
        Simulateur s = new Simulateur(gui);
        s.setDonnees(d);

        s.restart();
    }
}