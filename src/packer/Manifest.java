package packer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author I.M.Bad
 * 
 * Manifest class describes box contents
 * 
 * runs the following methods:
 * addProduct(Product)
 * addProduct(Product, Quantity)
 * removeProduct(Product)
 * getTotalWeight()
 * getHeaviestUnder(Weight)
 * isEmpty()
 * containsProduct(Product p)
 * toString()
 * hasFragileItems()
 * 
 */
public class Manifest {
    
    
    // Tracks the quantity of each product in the manifest
    private Map<Product, Integer> quantities;
    // Keeps a list of all products ordered by weight
    private Set<Product> byWeight;

    /**
     * Manifest Constructor
     */
    public Manifest() {
        quantities = new HashMap<>();
        byWeight = new TreeSet<>(new ProductWeightComparator());
    }
    
    /**
     * Adds a single product to the manifest by calling the overloaded addProduct method
     */
    public void addProduct(Product p) {
        addProduct(p,1);
    }
    
    /**
     * Adds one or more of the same product to the manifest
     */ 
    public void addProduct(Product p, int quantity) {
        // If the product is already in the manifest, add to the total quantity (currently multiplies but that is probably wrong)
        if (quantities.containsKey(p)) {
            quantities.put(p,quantities.get(p)*quantity);
        }
        // Else add new product and quantity
        else {
            quantities.put(p,quantity);
            // If product is already in byWeight
            if(!byWeight.add(p)) {
                System.out.println("Couldn't add to Set");
            }
        }
    }
    
    /**
     * Removes a single product from the manifest
     */
    public void removeProduct(Product p) {
        //If there's more than none products, remove one from the manifest
        if (quantities.containsKey(p) && quantities.get(p) > 0) {
            quantities.put(p,quantities.get(p)-1);
        }
        // If there are none of the product, remove the product from the manifest
        if (quantities.get(p) == 0) {
            quantities.remove(p);
        }
        // If product is still in the manifest remove one from byWeight
        if (quantities.containsKey(p)) {
            byWeight.remove(p);
        }
    }
    
    /**
     * Returns the total weight for a single product
     */
    public double getTotalWeight() {
        double weight = 0;
        for (Product p : quantities.keySet()) {
            weight = quantities.get(p) * p.getWeight();
        }
        return weight;
    }
    
    /**
     * Returns the heaviest product in byWeight under a given weight value
     */
    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() <= weight) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Sets byWeight to empty
     */
    public boolean isEmpty() {
        return byWeight.isEmpty();
    }
    
    /**
     * Returns product and quantity (has no failsafe)
     */
    public boolean containsProduct(Product p) {
        return quantities.containsKey(p) && quantities.get(p) > 0;
    }
    
    /**
     * Returns a string version of a manifest for easy display
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product p : quantities.keySet()) {
            result.append(p.getName());
            result.append(" x ");
            result.append(quantities.get(p));
            result.append("\n");
        }
        return result.substring(0, result.length()-1);
    }
    
    /**
     * Checks manifest for fragile items and returns a boolean
     */
    public boolean hasFragileItems() {
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                return true;
            }
        }
        return false;
    }
}
    

