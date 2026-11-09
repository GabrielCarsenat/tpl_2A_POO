package carte;

public class Incendie {
    private Position position;
    private int intensite;

    //Initializers:
    public Incendie(Position position, int intensite){
        this.position=position;
        this.intensite=intensite;
    }
    public Incendie(Position position){
        this(position, 0);
    }
    
    //getter methods
    public int getIntensite(){
        return intensite;
    }

    public Position getPosition(){
        return this.position;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d) Intensite: %d\n", this.position.getX(), this.position.getY(), this.intensite);
    }
}
