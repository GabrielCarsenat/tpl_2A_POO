package chemin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

import carte.Carte;
import carte.Case;
import carte.Direction;
import carte.Position;
import robots.Robot;

/**
 * Calcule le plus court chemin (en temps) d'un robot vers une case, avec
 * l'algorithme de Dijkstra. Le coût d'un pas dépend des vitesses du robot
 * sur les natures de terrain des deux cases.
 */
public class CalculateurChemin {
    private final Carte carte;

    public CalculateurChemin(Carte carte) {
        this.carte = carte;
    }

    /** Case de la file de priorité avec son coût au moment de l'insertion. */
    private static class Noeud implements Comparable<Noeud> {
        final Case courante;
        final double cout;

        Noeud(Case courante, double cout) {
            this.courante = courante;
            this.cout = cout;
        }

        @Override
        public int compareTo(Noeud autre) {
            return Double.compare(cout, autre.cout);
        }
    }

    /** Voisin de src dans la direction d, ou null s'il sort de la carte. */
    private Case voisinOuNull(Case src, Direction d) {
        try {
            return carte.getVoisin(src, d);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /** Temps (s) pour passer de src à dst voisines, +infini si dst est interdite au robot. */
    private double tempsEntre(Robot robot, Case src, Case dst) {
        double vDst = robot.getVitesse(dst.getNature());
        if (vDst <= 0) {
            return Double.POSITIVE_INFINITY;
        }
        double vSrc = robot.getVitesse(src.getNature());
        // si le robot démarre sur un terrain interdit, on ne considère que dst
        double vMoyenne = (vSrc <= 0) ? vDst : (vSrc + vDst) / 2.0;
        return carte.getTailleCases() / (vMoyenne / 3.6); // km/h -> m/s, tailleCases en m
    }

    /**
     * Plus court chemin depuis la position actuelle du robot jusqu'à dest.
     *
     * @throws PasDeCheminException si dest est inaccessible pour ce robot
     */
    public Chemin calculer(Robot robot, Case dest) throws PasDeCheminException {
        Position p = robot.getPosition();
        Case depart = carte.getCase(p.getX(), p.getY());

        Map<Case, Double> dist = new HashMap<>();
        Map<Case, Case> predecesseur = new HashMap<>();
        PriorityQueue<Noeud> file = new PriorityQueue<>();

        dist.put(depart, 0.0);
        file.add(new Noeud(depart, 0.0));

        while (!file.isEmpty()) {
            Noeud n = file.poll();
            if (n.cout > dist.get(n.courante)) {
                continue; // entrée périmée : un meilleur coût a été trouvé depuis
            }
            if (n.courante.equals(dest)) {
                break;
            }
            for (Direction dir : Direction.values()) {
                Case voisin = voisinOuNull(n.courante, dir);
                if (voisin == null) {
                    continue;
                }
                double t = tempsEntre(robot, n.courante, voisin);
                if (Double.isInfinite(t)) {
                    continue;
                }
                double nouveauCout = n.cout + t;
                if (nouveauCout < dist.getOrDefault(voisin, Double.POSITIVE_INFINITY)) {
                    dist.put(voisin, nouveauCout);
                    predecesseur.put(voisin, n.courante);
                    file.add(new Noeud(voisin, nouveauCout));
                }
            }
        }

        if (!dist.containsKey(dest)) {
            throw new PasDeCheminException("Aucun chemin vers la case ("
                    + dest.getX() + ", " + dest.getY() + ")");
        }

        // reconstruction en remontant les prédécesseurs depuis dest
        LinkedList<Case> parcours = new LinkedList<>();
        for (Case c = dest; c != null; c = predecesseur.get(c)) {
            parcours.addFirst(c);
        }
        Chemin chemin = new Chemin();
        for (int i = 1; i < parcours.size(); i++) { // i=1 : on exclut la case de départ
            Case c = parcours.get(i);
            chemin.ajouterEtape(c, dist.get(c));
        }
        return chemin;
    }
}
