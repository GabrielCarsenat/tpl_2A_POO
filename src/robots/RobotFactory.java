package robots;
import carte.Position;
/**
 * RobotEnum
 */
public class RobotFactory {

    public static Robot createRobot(String type, Position position) {
        if (type == null) {
            throw new IllegalArgumentException("Robot type cannot be null");
        }

        return switch (type.trim().toUpperCase()) {
            case "PATTES" -> new RobotPattes(position);
            case "DRONE" -> new RobotDrone(position);
            case "ROUES" -> new RobotRoues(position);
            default -> throw new IllegalArgumentException("Unknown robot type: " + type);
        };
    }
}