package objetscarte;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    //those let us index a fire by Case or directly with Position;
    @Override
    public boolean equals(Object arg0) {
        
        if (arg0 instanceof Position){
            Position position = (Position) arg0;
            return position.x==x && position.y==y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    /**
     * 
     * @param width
     * @param height
     * @return Whether this position is out of bounds according to the width and height provided.
     */
    public boolean outOfBounds(int width, int height){
        return (this.x>=0 && this.y>=0 && this.x<width && this.y< height);
    }

}
