package robots;

import carte.Position;

public class RobotRoues extends Robot{
    private static final int VITESSE_DEFAUT = 100;
    private static final int VITESSE_MAX = 150;
    public RobotRoues(Position position, int vitesseFichier){
        super(position, vitesseFichier, VITESSE_DEFAUT, VITESSE_MAX);
    }

    @Override
    public int getCapacite() {
        return 5000;
    }
}
