package data;

import java.util.ArrayList;
import java.util.HashMap;

import objetscarte.Case;
import objetscarte.Incendie;

/**
 * DonneesSimulation
 */
public class DonneesSimulation {
    //pas d'elements a garantir, acces public envisageable
    public Carte carte;
    public HashMap<Case,Incendie> incendies; //un incendie est associe a une case, la case doit donc implementer l'interface Hahsable
    public ArrayList robots; //initialisation rapide et acces indexe rapide

}
