package robots;

import carte.NatureTerrain;
import carte.Position;

public class RobotChenilles extends Robot{
    private static final int VITESSE_DEFAUT = 60;
    private static final int VITESSE_MAX = 80;
    private static final int CAPACITE = 2000;
    /**
     * @param position position initiale du robot
     * @param vitesseFichier vitesse du robot, limitee internalement, fournir valeur negative pour vitesse par defaut
     */
    public RobotChenilles(Position position, int vitesseFichier){
        super(position, vitesseFichier, VITESSE_DEFAUT, VITESSE_MAX);
    }
    
    @Override 
    public int getCapacite(){
        return CAPACITE;
    }

    @Override
    public double getVitesse(NatureTerrain t) {
        double multiplier = switch (t) {
            case ROCHE -> 0;
            case EAU -> 0;
            case FORET->0.5;
            default->1;
        };

        return getVitesse()*multiplier;
    }
}
