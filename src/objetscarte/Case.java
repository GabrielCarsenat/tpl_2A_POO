package objetscarte;

import java.util.Objects;

import data.NatureTerrain;

public class Case{
    private int x;
    private int y;
    private NatureTerrain nature;
    
    public Case(int x, int y, NatureTerrain nature){
        this.x = x;
        this.y = y;
        this.nature = nature;
    }

    public Case(int x, int y, String natureString){
        NatureTerrain n = NatureTerrain.valueOf(natureString);
        this(x, y, n);
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public NatureTerrain getNature(){
        return this.nature;
    }

    @Override
    public boolean equals(Object arg0) {
        if (arg0 instanceof Case){
            Case casebis = (Case) arg0;
            return casebis.x==x && casebis.y==y;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
