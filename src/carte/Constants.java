package carte;


//TODO: see if it's really ok but this way of sharing constants seems alright
public final class Constants {
    // Private constructor prevents instantiation
    private Constants() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static final int DEFAULT_ROBOT_SPEED = 3000;
}