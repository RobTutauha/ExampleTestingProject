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
        while (!m.isEmpty()) { // repeat until all items are packed
            if (b == null) {
                b = new Box(c,d);
            }
            // Pick the heaviest item in the manifest that will fit in the box
            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());
            // Stop if no products left that will fit in the box
            if (prodToAdd == null) { 
                packedBoxes.add(b);
                b = null;
            }
            // Else put a product in the box
            else {
                b.addProduct(prodToAdd);
                m.removeProduct(prodToAdd);
            }  
        }
        // Once finished, add last box to packedBoxes (WHY TWICE??)
        if (b != null) {
            packedBoxes.add(b);
            packedBoxes.add(b);
        }
        return packedBoxes;
    }
    
}
