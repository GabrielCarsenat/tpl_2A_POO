package carte;

public class Incendie {
    private Position position;
    private int eauNecessaire;

    //Initializers:
    public Incendie(Position position, int eauNecessaire){
        this.position=position;
        this.eauNecessaire=eauNecessaire;
    }
    public Incendie(Position position){
        this(position, 0);
    }
    
    //getter methods
    public int getEauNecessaire(){
        return eauNecessaire;
    }

    public Position getPosition(){
        return this.position;
    }
}
