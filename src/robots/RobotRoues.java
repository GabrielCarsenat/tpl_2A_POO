package robots;

import carte.NatureTerrain;
import carte.Position;

public class RobotRoues extends Robot{
    private static final double VITESSE_DEFAUT = 80;
    private static final double VITESSE_MAX = 150;
    public RobotRoues(Position position, int vitesseFichier){
        super(position, vitesseFichier, VITESSE_DEFAUT, VITESSE_MAX);
    }

    @Override
    public int getCapacite() {
        return 5000;
    }

    @Override
    public double getVitesse(NatureTerrain t) {
        return  switch (t) {
            case TERRAIN_LIBRE -> getVitesse();
            case HABITAT -> getVitesse();
            default->0;
        };
    }
}
