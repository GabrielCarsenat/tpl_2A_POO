package robots;
import carte.Position;
/**
 * RobotEnum
 */
public class RobotFactory {

    public static Robot createRobot(String nomTypeRobot, Position position) {
        if (nomTypeRobot == null) {
            throw new IllegalArgumentException("Robot type cannot be null");
        }

        return switch (nomTypeRobot.trim().toUpperCase()) {
            case "PATTES" -> new RobotPattes(position);
            case "DRONE" -> new RobotDrone(position);
            case "ROUES" -> new RobotRoues(position);
            default -> throw new IllegalArgumentException("Unknown robot type: " + nomTypeRobot);
        };
    }
}