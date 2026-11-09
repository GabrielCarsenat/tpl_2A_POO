package carte;

public class Case extends Position{
    private NatureTerrain nature;
    
    public Case(int x, int y, NatureTerrain nature){
        super(x,y);
        this.nature = nature;
    }

    public Case(int x, int y, String natureString){
        NatureTerrain n = NatureTerrain.valueOf(natureString);
        this(x, y, n);
    }

    public NatureTerrain getNature(){
        return this.nature;
    }

    @Override
    public String toString() {
        switch (nature) {
            case ROCHE:
                return "#";
            case FORET:
                return "F";
            case EAU:
                return "~";
            case TERRAIN_LIBRE:
                return " ";
            case HABITAT:
                return "@";
            default:
                return "?";
        }
    }
}
