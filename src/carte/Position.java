package carte;

import java.util.Objects;

public class Position {
    private int x;
    private int y;
    
    /**
     * Position Constructor
     * @param x
     * @param y
     */
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**Position Copy Constructor
     * @param p a Position to copy
     */
    public Position(Position p){
        this.x=p.x;
        this.y=p.y;
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

    //a decommenter si besoin

    // public Position nord(){
    //     return new Position(x, y-1);
    // }


    // public Position sud(){
    //     return new Position(x, y+1);
    // }

    // public Position est(){
    //     return new Position(x+1, y);
    // }

    // public Position ouest(){
    //     return new Position(x-1, y);
    // }

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
