package simulation;

import java.util.ArrayList;
import java.util.Hashtable;

import carte.Carte;
import carte.Incendie;
import carte.Position;
import robots.Robot;

/**
 * DonneesSimulation
 * 
 * Cette classe fait le wrapping de:
 *   - Une Carte carte;
 *   - Une HashTable<Position, Incendie> incendies;
 *   - Une ArrayList<Robot> robots;
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


    //getters renvoient directement l'objet, on laisse l'utilisateur assez libre sur la manipulation des donnees
    public Carte getCarte() {
        return carte;
    }

    public Hashtable<Position, Incendie> getIncendies() {
        return incendies;
    }

    public ArrayList<Robot> getRobots() {
        return robots;
    }

    /**
     * 
     * Renvoie une representation textuelle du contexte de simulation.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        StringBuilder s = new StringBuilder();
        s.append("Donnees Simulation: \n")
        .append(String.format("No of robots: %d\n", robots.size()))
        .append(carte)
        .append("Incendies parses:\n");
        for (Incendie i : incendies.values()) {
            s.append(i);
        }
        return s.toString();
    }

    //getter and setter methods?
}
