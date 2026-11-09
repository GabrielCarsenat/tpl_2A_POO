package simulation;

import java.util.ArrayList;
import java.util.Hashtable;

import carte.Carte;
import carte.Incendie;
import carte.Position;
import robots.Robot;

/**
 * DonneesSimulation
 */
public class DonneesSimulation {
    //pas d'elements a garantir, acces public envisageable
    private Carte carte;
    private Hashtable<Position,Incendie> incendies; //un incendie est associe a une case, la case doit donc implementer l'interface Hahsable
    private ArrayList<Robot> robots; //initialisation rapide et acces indexe rapide

    public DonneesSimulation(Carte carte, Hashtable<Position,Incendie> incendies, ArrayList<Robot> robots){
        this.carte = carte;
        this.incendies = incendies;
        this.robots = robots;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        StringBuilder s = new StringBuilder();
        s.append("Donnees Simulation: \n")
        .append(String.format("No of robots: %d", robots.size()));

        return s.toString();
    }

    //getter and setter methods?
}
