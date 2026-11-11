package robots;

import carte.NatureTerrain;
import carte.Position;

public class RobotRoues extends Robot{
    private static final double VITESSE_DEFAUT = 80;
    private static final double VITESSE_MAX = 150;
    private static final int CAPACITE = 5000;
    /**
     * Classe implementant le robot a roues: ID="ROUES".
     * 
     * @param position position initiale du robot
     * @param vitesseFichier vitesse du robot, limitee internalement, fournir valeur negative pour vitesse par defaut
     * @see Robot 
     */
    public RobotRoues(Position position, int vitesseFichier){
        super(position, vitesseFichier, VITESSE_DEFAUT, VITESSE_MAX);
    }

    @Override
    public int getCapacite() {
        return CAPACITE;
    }

    @Override
    public double getVitesse(NatureTerrain t) {
        return  switch (t) {
            case TERRAIN_LIBRE -> getVitesse();
            case HABITAT -> getVitesse();
            default->0; //case non traversable
        };
    }
}
