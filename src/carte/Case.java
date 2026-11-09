package carte;

import java.awt.Color;

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

    public Color getColor(){
        switch (this.nature) {
            case EAU:
                return new Color(107, 159, 242);
            case ROCHE:
                return new Color(128, 128, 128);
            case FORET:
                return new Color(34, 139, 34);
            case TERRAIN_LIBRE:
                return new Color(144, 238, 144);
            case HABITAT:
                return new Color(205, 133, 63);
            default:
                return new Color(227, 20, 199);
        }
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
