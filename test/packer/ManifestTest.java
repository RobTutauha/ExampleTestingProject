package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import packer.Product;
/**
 *
 * @author RobT
 */
public class ManifestTest {
    
    // Test data
    Manifest testManifest = new Manifest();
    
    public void packTestManifest(){
        testManifest.addProduct(new Product("Hammer", 3, false, false), 1);
        testManifest.addProduct(new Product("Nails", 1, false, false), 1);
        testManifest.addProduct(new Product("Ladder", 15, false, false), 1);
        testManifest.addProduct(new Product("Saw", 5, false, false), 1);
        testManifest.addProduct(new Product("Light Bulbs", 1, false, true), 1);
        testManifest.addProduct(new Product("Weedkiller", 2, true, false), 1);
    }

    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Manifest class...");
    }
    

    @Test
    public void testSingleAddProduct() {
        System.out.println("testing single addProduct()");

    }
    
    @Test
    public void testMultipleAddProduct() {
        // If the product () {
        System.out.println("testing addProduct()");

    }
    
    @Test
    public void testRemoveProduct() {
    System.out.println("testing removeProduct()");

    }
    
    @Test
    public void testGetTotalWeight() {
    System.out.println("testing getTotalWeight()");

    }
    
    @Test
    public void testGetTotalManifestWeight() {
    System.out.println("testing getTotalManifestWeight()");

    }
    
    @Test
    public void testGetHeaviestUnder() {
    System.out.println("testing getHeaviestUnder()");

    }
    
    @Test
    public void testIsEmpty() {
    System.out.println("testing isEmpty()");

    }
    
    @Test
    public void testContainsProduct() {
    System.out.println("testing containsProduct()");

    }
    
    @Test
    public void testToString() {
    System.out.println("testing toString()");

    }
    
    @Test
    public void testHasFragileItems() {
    System.out.println("testing hasFragileItems()");

    }
    
    @Test
    public void testHasHazardousItems() {
    System.out.println("testing hasHazardousItems()");

    }
    
    
}

