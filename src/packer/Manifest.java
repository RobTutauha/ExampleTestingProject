package packer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author I.M.Bad
 * 
 * Manifest class describes list of products to be packed into boxes
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
 * hasHazardousItems()
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
     * Adds a single product to the manifest
     * @param p Product
     */
    public void addProduct(Product p) {
        addProduct(p,1);
    }
    
    /**
     * Adds one or more of the same product to the manifest
     * @param p Product
     * @param quantity Integer
     */
    public void addProduct(Product p, int quantity) {
        // If the product is already in the manifest, add to the total quantity
        if (quantities.containsKey(p)) {
            quantities.put(p,quantities.get(p)+quantity);
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
     * @param p Product
     */
    public void removeProduct(Product p) {

        // If there's more than none products, remove one from the manifest
        if (quantities.containsKey(p) && quantities.get(p) > 0) {
            quantities.put(p,quantities.get(p)-1);
        }
        
        // Totally remove products when exhausted
        if (quantities.get(p) < 1) {
            quantities.remove(p);
            byWeight.remove(p);
        }

    }
    
    /**
     * Returns the weight for every product in quantities
     * @return double
     */
    public double getTotalWeight() {
        double weight = 0;
        for (Product p : quantities.keySet()) {
            weight += quantities.get(p) * p.getWeight();
        }

        return weight;
    }
    
    /**
     * Returns the total weight for entire Manifest
     * @return double
     */
    public double getTotalManifestWeight() {
        double weight = 0;
        for (Product p : quantities.keySet()) {
            weight += quantities.get(p) * p.getWeight();
        }
        return weight;
    }
    
    /**
     * Returns the heaviest product in byWeight under a given weight value
     * @param weight double
     * @return Product
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
     * @return boolean
     */
    public boolean isEmpty() {
        return byWeight.isEmpty();
    }
    
    /**
     * Checks if a specific product is in quantities
     * @param p Product
     * @return boolean
     */
    public boolean containsProduct(Product p) {
        if (quantities.containsKey(p) && quantities.get(p) > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Returns a string version of a manifest for easy display
     * @return string
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
     * @return boolean
     */
    public boolean hasFragileItems() {
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks manifest for hazardous items and returns a boolean
     * @return boolean
     */
    public boolean hasHazardousItems() {
        for (Product p : quantities.keySet()) {
            if (p.isHazardous()) {
                return true;
            }
        }
        return false;
    }
}
    

