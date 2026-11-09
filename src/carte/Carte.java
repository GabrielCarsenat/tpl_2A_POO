package carte;

public class Carte {
    private int tailleCases;
    private int largeur;
    private int hauteur;
    private Case[] cases;
    /**
     * Takes a number and returns its square root
     * @param largeur taille selon X
     * @param longueur taille selon Y
     * @param tailleCases taille des cases pour le delai de traversee.
     */
    public Carte(int largeur, int longueur, int tailleCases){
        this.tailleCases=tailleCases;
        this.hauteur=longueur;
        this.largeur=largeur;
        cases = new Case[longueur*largeur];
    }

    //Required getter follow
    public int getTailleCases(){
        return this.tailleCases;
    };
    
    public int getNbLignes(){
        return hauteur;
    }
    public int getNbColonnes(){
        return largeur;
    }

    public void inBound(int col, int lig){
        if (lig>=0 && col >=0 && lig<this.hauteur && col<this.largeur){
            return;
        }
        throw new IndexOutOfBoundsException("Les coordonnees de la case demandee sortent de la carte.");
    }

    public Case getVoisin(Case src, Direction d){
        int x = src.getX();
        int y = src.getY();
        switch (d) {
            case EST: return getCase(x+1, y);
            case OUEST: return getCase(x-1, y);
            case NORD: return getCase(x, y+1);
            case SUD: return getCase(x, y-1);
            default:
                break;
        }
        throw new IllegalArgumentException("Direction should be NORTH|SOUTH|WEST|EAST");
    }

    public Case getCase(int col, int lig){
        inBound(col, lig); //throws exception if invalid
        return cases[col+lig*largeur];
    }

    public void setCase(int col, int lig, Case nouvCase){
        inBound(col, lig);//throws exception if invalid
        cases[col+lig*largeur]=nouvCase;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Carte: ");
        for (int j = 0; j < hauteur; j++) {
            for (int i = 0; i < largeur; i++) {
                s.append(cases[i+largeur*j]);
            }
            s.append("\n");
        }
        return s.toString();
    }
}
