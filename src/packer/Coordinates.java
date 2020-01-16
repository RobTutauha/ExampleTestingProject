package packer;

/**
 *
 * @author I.M.Bad
 * 
 * coordinates class defines and calculates coordinate info
 */
public class Coordinates {
    
    private final double x;
    private final double y;
    
    /**
     * Coordinate Constructor
     * @param x double
     * @param y double
     */
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get the x coordinate
     * @return double
     */
    public double getX() {
        return x;
    }

    /**
     * get the y coordinate
     * @return double
     */
    public double getY() {
        return y;
    }
    
    /**
     * calculates euclidean distance
     * @param other coordinates
     * @return double
     */
    public double euclideanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.pow((xDiff * xDiff + yDiff * yDiff),0.5);
        return dist;
    }
    
    /**
     * calculates manhattan distance
     * @param other coordinates
     * @return double
     */
    public double manhattanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.abs(xDiff) + Math.abs(yDiff);
        return dist;
    }
    
    /**
     * calculates company distance
     * @param other coordinates
     * @return double
     */
    public double companyDistanceTo(Coordinates other) {
        double dist1 = euclideanDistanceTo(other);
        double dist2 = manhattanDistanceTo(other);
        return (dist1 + dist2)/2 + 1;
    }

}
