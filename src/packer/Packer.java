package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bunta
 * Refactored and ruined by RobT
 * 
 * Packer class puts products in boxes and updates the manifest
 */
public class Packer {
    
    private static int boxCounter = 1; // numbers the boxes
    private static Box b = null; // box for products
    
    // List of boxes of products
    private static List<Box> packedBoxes = new ArrayList<>();

    /**
     * Packs boxes and updates the manifest
     * 
     * @param c Customer
     * @param d Depot 
     * @param m Manifest
     * @return List packedBoxes
     */
    public static List<Box> packProducts(Customer c, Depot d, Manifest m) {
        
        while (!m.isEmpty()) { // repeat until all manifest items are packed
            
            if (b == null) { //if there's no box, build a box
                b = buildBox(b, c, d);
            }
            
            // Pick the heaviest item in the manifest that will fit in the box
            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());
                        
            // Put a product in the box
            b.addProduct(prodToAdd);
            
            // Remove product from manifest
            m.removeProduct(prodToAdd);

            // Stop if no products left that will fit in the box
            if ((b.remainingCapacity() < 1) || (prodToAdd == null)) {
                b = packBox(b, packedBoxes);
            }
            
            // Reset prodToAdd for the next run through
            prodToAdd = null;
        }
        
        // Once manifest is empty, add last box to packedBoxes
        if (b != null) {
            packBox(b, packedBoxes);
        }
        
        System.out.println("\nBoxes Loaded.");
        return packedBoxes;
    }
    
    /**
     * Adds box to packedBoxes list and increments the box Counter
     * @param b Box
     * @param packedBoxes List of packed boxes
     * @return Box
     */
    public static Box packBox(Box b, List<Box> packedBoxes) {
        
        packedBoxes.add(b);
        System.out.println("Box " + boxCounter + " Packed with " + b.remainingCapacity() + "kg remaining");
        boxCounter += 1; 
        b = null;
        return b;
    }
    
    /**
     * Builds a box
     * @param b Box
     * @param c Customer
     * @param d Depot
     * @return Box
     */
    public static Box buildBox(Box b, Customer c, Depot d) {
        
        b = new Box(c,d);
        System.out.println("\nBox " + boxCounter + " Built.");
        return b;
    }
}
