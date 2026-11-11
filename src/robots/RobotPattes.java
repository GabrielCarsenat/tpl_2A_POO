package robots;

import carte.NatureTerrain;
import carte.Position;

public class RobotPattes extends Robot{
    private static final int VITESSE_DEFAUT = 100;
    private static final int VITESSE_MAX = 150;
    private static final int CAPACITE = 150;

    /**
     * 
     * @param position position initiale du robot
     * @param vitesseFichier vitesse du robot, limitee internalement, fournir valeur negative pour vitesse par defaut
     */
    public RobotPattes(Position position, int vitesseFichier){
        super(position, 30); //vitesse de 30 auoi qu'il arrive
    }

    @Override
    public int getCapacite() {
        // TODO Auto-generated method stub
        return -1; //for inf
    }

    @Override
    public double getVitesse(NatureTerrain t) {
        return switch (t) {
            case ROCHE -> 10;
            case EAU -> 0; //non traversable
            default->30;
        };
    }

    
}
