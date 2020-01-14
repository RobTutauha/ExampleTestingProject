package packer;

/**
 *
 * @author I.M.Bad
 * 
 * Defines and exposes box info
 * runs the following methods:
 * Box(Customer customer, Depot depot)
 * addProduct(Product product)
 * addProduct(Product product, int quantity)
 * getLabel()
 * toString()
 * getWeight()
 * canFit(Product p)
 * canFit(Product p, int quantity)
 * remainingCapacity()
 * isFragile()
 * isHazardous()
 */
public class Box {
    
    
    private Manifest contents;
    private Customer customer;
    private Depot depot; 

    /**
     * Box Constructor
     * @param customer customer
     * @param depot depot
     */
    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }
    
    /**
     * Checks there is room and puts one product in the box
     * @param product product
     */
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }
    
    
    /**
     * Checks there is room and puts products in the box
     * @param product product
     * @param quantity quantity
     */
    public void addProduct(Product product, int quantity) {
        if (canFit(product,quantity)); {
            contents.addProduct(product, quantity);
        }
    }
   
    /**
     * Calculates nearest address to depot and creates label accordingly
     * @return 
     */
    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        label.append("\n");
        if (this.isFragile()) {
            label.append("FRAGILE\n");
        }
        return label.toString();
    }
    //ABOVE AND BELOW ARE CIRCULAR?
    /**
     * SEEMS TO RUIN MY BRAIN
     * @return 
     */
    public String toString() {
        return getLabel();
    }
    
    /**
     * retrieves box weight
     * @return TO BE DETERMINED
     */
    public double getWeight() {// determine what class holds weight information, create appropriate method to determine weight and tie it to this method
        return contents.getTotalWeight();
    }
    
    /**
     * determines if single product will fit in the box
     * @param p product
     * @return boolean
     */
    public boolean canFit(Product p) {
        return p.getWeight() < 40; //assuming this is kgs, All 40kgs should be 20. Should probably be a variable so can change easily
    }
    
    /**
     * determines if products will fit in the box
     * @param p product
     * @param quantity quantity
     * @return boolean
     */
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) < 40;
    }
    
    /**
     * determines room left in the box
     * @return integer
     */
    public double remainingCapacity() {
        return 40 - this.getWeight();
    }
    
    /**
     * checks box for fragile items
     * @return boolean
     */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    
    /**
     * checks box for hazardous items
     * @return boolean
     */
    public boolean isHazardous() {
        return contents.hasHazardousItems();
    }
}
