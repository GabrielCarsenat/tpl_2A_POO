package robots;
import carte.*;

public abstract class Robot {

    // public abstract String getReservoir(); 
    // public abstract String getReservoirMax(); 

    //declaration d'attributs de la classe abstraite
    double vitesse;
    private Position position;
    private int reservoir;

    //fonction utilitaire statique pour choisir la vitesse a donner au robot
    //vitesse donnee, par defaut, ou maximum autorise
    static protected double capVitesse(double vitesse, double vitesseDefaut, double vitesseMax){
        return Math.min(vitesse>0?vitesse:vitesseDefaut, vitesseMax);
    }

    /**
     * Constructeur de la {@code Robot}, les classes heritant de {@code Robot} doivent s'en servir pour initialiser la position et la vitesse du robot. 
     * @param positionFichier la {@code Position} initiale du robot
     * @param vitesseFichier la vitesse lue depuis le fichier de carte > 0
     */
    public Robot(Position positionFichier, double vitesseFichier){
        if(vitesse<=0){
            throw new IllegalArgumentException("Vitesse robot >0 dans le constructeur de Robot.");    
        }
        this.position=positionFichier;
        this.vitesse=vitesseFichier;
        this.reservoir=0;
    }

    //permet eviter appel redondant a capvitesse dans les sous-classes.
    public Robot(Position positionFichier, double vitesseFichier, double vitesseDefaut, double vitesseMax){
        this(positionFichier, capVitesse(vitesseFichier, vitesseDefaut, vitesseMax));
    }

    public Position getPosition(){
        return this.position;
    };

    public void setPosition(Position pos){
        this.position=pos;
    }

    //TODO: implement movement

    public double getVitesse(){
        return this.vitesse;
    }

    //this method should be implemented by each robot to define speed modifiers on certain tiles
    public abstract double getVitesse(NatureTerrain t);

    public boolean estTraversable(Case case1){
        return this.getVitesse(case1.getNature())>0;
    }

    public abstract int getCapacite();

    /**
     * 
     * @param vol le volume en L a deverser
     * @return int : le volume effectif deverse (dans la limite du reservoir)
     */
    protected int deverserEau(int vol){ 
        if (getCapacite()==-1){ //capacite infinie
            return vol;
        }
        if (reservoir>=vol){
            reservoir-=vol; 
            return vol;
        }
        int tmp = reservoir;
        reservoir=0;
        return tmp;
        //TODO:on doit garantir reservoir >0
    }

    
}
