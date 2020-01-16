package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bunta
 * 
 * Packer class puts products in boxes and updates the manifest
 */
public class Packer {

    /**
     * Packs boxes and updates the manifest
     * 
     * @param c Customer customer
     * @param d Depot depot 
     * @param m Manifest manifest
     * @return List<Box> packedBoxes
     */
    static int boxCounter = 1;
    static Box b = null;
    
    public static List<Box> packProducts(Customer c, Depot d, Manifest m) {
        
        List<Box> packedBoxes = new ArrayList<>();
        
        while (!m.isEmpty()) { // repeat until all manifest items are packed
            
            if (b == null) { //if there's no box, create a box
                b = boxBuilder(b, c, d);
            }
            
            // Pick the heaviest item in the manifest that will fit in the box
            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());
                        
            // Put a product in the box
            b.addProduct(prodToAdd);
            
            //remove product from manifest
            m.removeProduct(prodToAdd);

            // Stop if no products left that will fit in the box
            if ((b.remainingCapacity() < 1) || (prodToAdd == null)) {
                packedBoxes.add(b);
//                System.out.println("\nMANIFEST still contains the following:");
//                System.out.println(m);
                System.out.println("Box " + boxCounter + " Packed with " + b.remainingCapacity() + "kg remaining");

                boxCounter += 1; 
                b = null;
            }

            prodToAdd = null;
            
        }
        // Once finished, add last box to packedBoxes
        
        if (b != null) {
            boxFull(b, m, packedBoxes);
        }
        System.out.println("\nBoxes Loaded.");
        return packedBoxes;
    }
    
    private static void boxFull(Box b, Manifest m, List<Box> packedBoxes) {
        
        packedBoxes.add(b);
        if (m.isEmpty()) {
            System.out.println("\nMANIFEST is EMPTY");
        }
        System.out.println("\nBox " + boxCounter + " Packed with " + b.remainingCapacity() + "kg remaining");
        b = null;
    }

    private static Box boxBuilder(Box b, Customer c, Depot d) {

        b = new Box(c,d);
        System.out.println("\nBox " + boxCounter + " Built.");

        return b;
    }
    
}
