package objetscarte;

public class Incendie {
    private Case position;
    private int eauNecessaire;
    public Incendie(Case position, int eauNecessaire){
        this.position=position;
        this.eauNecessaire=eauNecessaire;
    }
    public Incendie(Case position){
        this(position, 0);
    }
    public int getEauNecessaire(){
        return eauNecessaire;
    }
}
