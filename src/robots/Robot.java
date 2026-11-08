package robots;
import objetscarte.*;
import data.NatureTerrain;

public abstract class Robot {
    int maxReservoir;
    int reservoir;
    int vitesseRemplissage;
    private Case position;
    public Robot(Case position){
        this.position=position;
        this.reservoir=0;
    }
    public Case getPosition(){
        return this.position;
    };
    public void setPosition(Case pos){
        this.position=pos;
    }

    double getVitesse(NatureTerrain terrain){
        if (terrain==NatureTerrain.ROCHE){
            return 0.1;
        }
        return 1.;
    };

    public void deverserEau(int vol){
        //TODO:on doit garantir reservoir >0
        reservoir-=vol; 
    }
}
