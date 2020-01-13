package packer;

/**
 *
 * @author I.M.Bad
 * 
 * depot class defines Depot info
 */
public class Depot {
    private String name;
    private Address address;

    /**
     * depot constructor
     * @param name string
     * @param address address
     */
    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    /**
     * gets depot name/address
     * @return string
     */
    public String getName() {
        return address.toString();
    }
    
    /**
     * get depot address coordinates
     * @return coordinates
     */
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    
    /**
     * get name/address
     * @return string
     */
    public String toString() {
        return this.getName();
    }
    
}
