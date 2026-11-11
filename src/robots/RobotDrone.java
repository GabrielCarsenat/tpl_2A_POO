package robots;

import carte.NatureTerrain;
import carte.Position;

public class RobotDrone extends Robot{
    private static final int VITESSE_DEFAUT = 100;
    private static final int VITESSE_MAX = 150;
    public RobotDrone(Position position, int vitesseFichier){
        super(position, vitesseFichier, VITESSE_DEFAUT, VITESSE_MAX);
    }
    @Override 
    public int getCapacite(){
        return 10000;
    }

    @Override
    public double getVitesse(NatureTerrain t) {
        // TODO Auto-generated method stub
        return 0;
    }
}
