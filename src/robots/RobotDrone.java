package robots;

import carte.NatureTerrain;
import carte.Position;

public class RobotDrone extends Robot{
    private static final int VITESSE_DEFAUT = 100;
    private static final int VITESSE_MAX = 150;
    private static final int CAPACITE = 10000;
    /**
     * Classe implementant le robot drone: ID="DRONE".
     * 
     * @param position position initiale du robot
     * @param vitesseFichier vitesse du robot, limitee internalement, fournir valeur negative pour vitesse par defaut
     * @see Robot 
     */
    public RobotDrone(Position position, int vitesseFichier){
        super(position, vitesseFichier, VITESSE_DEFAUT, VITESSE_MAX);
    }

    @Override
    public int getCapacite() {
        return CAPACITE;
    }

    @Override
    public double getVitesse(NatureTerrain t) {
        return getVitesse();
    }
}
