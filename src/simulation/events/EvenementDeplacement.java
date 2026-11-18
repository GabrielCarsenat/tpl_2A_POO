package simulation.events;

import jeu.Case;
import jeu.Position;
import jeu.robots.Robot;

/** Déplace un robot sur une case voisine à une date donnée. */
public class EvenementDeplacement extends Evenement {
    private final Robot robot;
    private final Case destination;

    public EvenementDeplacement(long date, Robot robot, Case destination) {
        super(date);
        this.robot = robot;
        this.destination = destination;
    }

    @Override
    public void execute() {
        if (!robot.estTraversable(destination)) {
            throw new IllegalStateException("Terrain " + destination.getNature()
                    + " interdit à ce robot");
        }
        robot.setPosition(new Position(destination));
    }
}