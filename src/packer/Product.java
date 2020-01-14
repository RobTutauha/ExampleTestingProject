package packer;

/**
 *
 * @author I.M.Bad
 * 
 * Product class defines and exposes product info 
 */
public class Product {

    private String name;
    private int weight;
    private boolean hazardous;
    private boolean fragile;

    public Product(String name, int weight, boolean hazardous, boolean fragile) {
        this.name = name;
        this.weight = weight;
        this.hazardous = hazardous;
        this.fragile = fragile;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the hazardous
     */
    public boolean isHazardous() {
        return hazardous;
    }

    /**
     * @return the fragile
     */
    public boolean isFragile() {
        return fragile;
    }

    /**
     * @return the name in a dumb way
     */
    public String toString() {
        return this.getName();
    }
    
    /**
     * Checks if Object is a Product
     * if so it compares the names of the object and the product
     * and returns a boolean
     * @return boolean
     */
    public boolean equals(Object o) {
        if (!(o instanceof Product)) {
            return false;
        }
        Product p = (Product)o;
        return p.getName().equals(this.getName());
    }
    
}
