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
    public static List<Box> packProducts(Customer c, Depot d, Manifest m) {
        
        List<Box> packedBoxes = new ArrayList<>();
        Box b = null;
        while (!m.isEmpty()) { // repeat until all manifest items are packed
            if (b == null) { //if there's no box, create a box
                b = new Box(c,d);
                System.out.println("\nNew Box Built.");
            }
            
            // Pick the heaviest item in the manifest that will fit in the box
            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());
                        
            // Put a product in the box
            b.addProduct(prodToAdd);
            System.out.println("\nAdding Product " + prodToAdd.getName() + " to box.");
            System.out.println("\nBox has " + b.remainingCapacity() + "kg remaining");
            m.removeProduct(prodToAdd);
            //System.out.println("\nRemoved Product from manifest.");
            
            // Stop if no products left that will fit in the box
            if ((b.remainingCapacity() < 1) || (prodToAdd == null)) {
                packedBoxes.add(b);
                System.out.println("\nTOTAL MANIFEST WEIGHT: " + m.getTotalManifestWeight());
                System.out.println("\nBox Packed with " + b.remainingCapacity() + "kg remaining");
                b = null;
            }

            prodToAdd = null;
            
        }
        // Once finished, add last box to packedBoxes
        if (b != null) {
            packedBoxes.add(b);
        }
        System.out.println("\nBoxes Loaded.");
        return packedBoxes;
    }
    
    
}
