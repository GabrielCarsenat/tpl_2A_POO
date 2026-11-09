package simulation;

import java.util.PriorityQueue;

import carte.Carte;
import event.Evenement;
import gui.GUISimulator;
import gui.Rectangle;
import gui.Simulable;
import gui.Text;

import java.awt.Color;

public class Simulateur implements Simulable{
    private long dateSimulation;
    private GUISimulator gui;
    private PriorityQueue<Evenement> eventHeap;

    private DonneesSimulation donnees;
    
    public Simulateur(GUISimulator gs){
        this.setGUISim(gs);
        gui.setSimulable(this);
        //init all state and map load
    }

    public void setDonnees(DonneesSimulation donnees) {
        this.donnees = donnees;
    }

    public void setGUISim(GUISimulator guisim) {
        this.gui = guisim;
        gui.setSimulable(this);
    }

    public void ajouteEvenement(Evenement e){
        this.eventHeap.add(e);
    }

    public void incrementDate() {
        this.dateSimulation+=100;
        while (!simulationTerminee()) {
            Evenement e = eventHeap.remove();
            //logic here
            e.execute();
        }
    }

    private boolean simulationTerminee(){
        Evenement e = eventHeap.peek();
        if (e==null) return true; //the heap is empty
        return e.getDate()>this.dateSimulation; //est ce que l'event est eligible pour l'execution
    }

    @Override
    public void next() {
        
    }

    //TODO: repris de invader
    @Override
    public void restart() {
        // planCoordinates();
        draw();
    }

    private void draw() {
        gui.reset();	// clear the window
        Carte c = donnees.getCarte();
        int tailleCases=c.getTailleCases();
        tailleCases=10;
        int w = c.getNbColonnes();
        int h = c.getNbLignes();

        for (int i =0; i<w; i++){
            for (int j =0; j<h; j++){
                Color color = c.getCase(i, j).getColor(); 
                gui.addGraphicalElement(new Rectangle(i*tailleCases, j*tailleCases, color, color, tailleCases));
            }
        }
        
        // gui.addGraphicalElement(new Text(x + 40, y + 120, invaderColor, "INVADER"));
    }

    // @Override
    // public void selectedItem(String arg0) {
    //     // TODO Auto-generated method stub
    // }
}
