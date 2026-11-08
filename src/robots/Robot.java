package robots;
import objetscarte.*;
import data.Constants;
import data.NatureTerrain;

public abstract class Robot {

    // public abstract String getReservoir(); 
    // public abstract String getReservoirMax(); 

    int vitesse = Constants.DEFAULT_ROBOT_SPEED;
    private Position position;

    public Robot(Position position){
        this.position=position;
    }

    public Robot(Position position, int vitesse){
        this(position);
        this.vitesse=vitesse;
    }
    public Position getPosition(){
        return this.position;
    };

    public void setPosition(Position pos){
        this.position=pos;
    }

    //TODO: implement movement

    double getVitesse(NatureTerrain terrain){
        if (terrain==NatureTerrain.ROCHE){
            return 0.1;
        }
        return 1.;
    };

    // public void deverserEau(int vol){
    //     //TODO:on doit garantir reservoir >0
    //     reservoir-=vol; 
    // }
}
