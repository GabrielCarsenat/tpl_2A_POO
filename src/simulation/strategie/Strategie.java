package simulation.strategie;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import org.w3c.dom.Node;

import jeu.Position;
import jeu.robots.Robot;
import simulation.DonneesSimulation;
import simulation.Simulateur;

public abstract class Strategie {
    protected Simulateur simulation;
    protected static int heuristic(Position tocalc, Position goal){
        //todo 
        return tocalc.manhattanDst(goal);
    }

    //simulation.set_strategie(...)

    public LinkedList<Position> pathFindTo(DonneesSimulation data, Robot r, Position start, Position goal){
        //check if the robot can move at all from the start position
        if (!r.estTraversable(data.getCarte().getCase(start))){
            return new LinkedList<Position>(); //return empty list of movements
        };
        
        
        //TODO A* path find en utilisant l'heuristique de la distance de mahattan
        //en faisant attention aux cases non traversables qui doivent etre ignorees quelle que soit l'heuristique.

    };
}
