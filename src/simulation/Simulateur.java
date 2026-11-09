package simulation;

import java.util.PriorityQueue;

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

    public Simulateur(){
        super();
        this.dateSimulation=0;
        //init all state and map load
    }

    public Simulateur(GUISimulator gs){
        this();
        this.setGUISim(gs);
        //init all state and map load
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
        int x=0;
        int y=0;
        Color invaderColor = Color.RED;	
        gui.addGraphicalElement(new Rectangle(x + 30, y     , invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 40, y     , invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 50, y     , invaderColor, invaderColor, 10));

        gui.addGraphicalElement(new Rectangle(x + 20, y + 10, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 30, y + 10, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 40, y + 10, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 50, y + 10, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 60, y + 10, invaderColor, invaderColor, 10));

        gui.addGraphicalElement(new Rectangle(x + 10, y + 20, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 20, y + 20, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 30, y + 20, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 40, y + 20, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 50, y + 20, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 60, y + 20, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 70, y + 20, invaderColor, invaderColor, 10));

        gui.addGraphicalElement(new Rectangle(x     , y + 30, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 10, y + 30, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 40, y + 30, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 70, y + 30, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 80, y + 30, invaderColor, invaderColor, 10));

        gui.addGraphicalElement(new Rectangle(x     , y + 40, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 10, y + 40, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 40, y + 40, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 70, y + 40, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 80, y + 40, invaderColor, invaderColor, 10));

        gui.addGraphicalElement(new Rectangle(x     , y + 50, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 10, y + 50, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 20, y + 50, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 30, y + 50, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 40, y + 50, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 50, y + 50, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 60, y + 50, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 70, y + 50, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 80, y + 50, invaderColor, invaderColor, 10));

        gui.addGraphicalElement(new Rectangle(x + 20, y + 60, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 30, y + 60, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 40, y + 60, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 50, y + 60, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 60, y + 60, invaderColor, invaderColor, 10));

        gui.addGraphicalElement(new Rectangle(x + 10, y + 70, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 20, y + 70, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 30, y + 70, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 40, y + 70, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 50, y + 70, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 60, y + 70, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 70, y + 70, invaderColor, invaderColor, 10));

        gui.addGraphicalElement(new Rectangle(x + 10, y + 80, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 20, y + 80, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 30, y + 80, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 40, y + 80, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 50, y + 80, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 60, y + 80, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 70, y + 80, invaderColor, invaderColor, 10));

        gui.addGraphicalElement(new Rectangle(x     , y + 90, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 20, y + 90, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 60, y + 90, invaderColor, invaderColor, 10));
        gui.addGraphicalElement(new Rectangle(x + 80, y + 90, invaderColor, invaderColor, 10));

        gui.addGraphicalElement(new Text(x + 40, y + 120, invaderColor, "INVADER"));
    }

    // @Override
    // public void selectedItem(String arg0) {
    //     // TODO Auto-generated method stub
    // }
}
