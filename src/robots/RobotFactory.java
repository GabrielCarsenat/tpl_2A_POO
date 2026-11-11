package robots;
import carte.Position;
/**
 * RobotEnum
 */
public class RobotFactory {
    
    public static Robot createRobot(String nomTypeRobot, Position position) {
        return createRobot(nomTypeRobot, position, -1);
    }

    public static Robot createRobot(String nomTypeRobot, Position position, int vitesse) {
        if (nomTypeRobot == null) {
            throw new IllegalArgumentException("Robot type cannot be null");
        }

        return switch (nomTypeRobot.trim().toUpperCase()) {
            case "PATTES" -> new RobotPattes(position, vitesse);
            case "DRONE" -> new RobotDrone(position, vitesse);
            case "ROUES" -> new RobotRoues(position, vitesse);
            case "CHENILLES" -> new RobotChenilles(position, vitesse);
            default -> throw new IllegalArgumentException("Unknown robot type: " + nomTypeRobot);
        };
    }
}