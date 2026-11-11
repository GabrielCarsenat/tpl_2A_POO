import simulation.Simulateur;
import simulation.events.*;

public class TestEvenements {
    public static void main(String[] args) {
        // On crée un simulateur
        // GUISimulator gs = new Gui()
        Simulateur simulateur = new Simulateur() ;
        // On poste un événement [PING] tous les deux pas de temps
        for (int i = 2 ; i <= 10 ; i += 2) {
            simulateur.ajouteEvenement(new EvenementMessage(i, " [PING]")) ;
        }
        // On poste un événement [PONG] tous les trois pas de temps
        for (int i = 3 ; i <= 9 ; i += 3) {
            simulateur.ajouteEvenement(new EvenementMessage(i, " [PONG]")) ;
        }
        // et on suppose que la simulation démarre
        for(int i=0;i<20;i++){
            System.out.println(String.format("Step: %d", i));
            simulateur.incrementDate();
        }
    }
}
