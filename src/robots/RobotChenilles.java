package robots;

import carte.NatureTerrain;
import carte.Position;

public class RobotChenilles extends Robot{
    private static final int VITESSE_DEFAUT = 60;
    private static final int VITESSE_MAX = 80;
    public RobotChenilles(Position position, int vitesseFichier){
        super(position, vitesseFichier, VITESSE_DEFAUT, VITESSE_MAX);
    }
    
    @Override 
    public int getCapacite(){
        return 2000;
    }

    @Override
    public double getVitesse(NatureTerrain t) {
        double multiplier = switch (t) {
            case ROCHE -> 0;
            case EAU -> 0;
            case FORET->0.5;
            default->1;
        };

        return (int) (getVitesse()*multiplier);
    }
}
