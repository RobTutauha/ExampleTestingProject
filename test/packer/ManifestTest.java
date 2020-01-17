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
    Manifest testManifest2 = new Manifest();
    
    public void packTestData(Manifest m){
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
        assertTrue(testManifest.isEmpty());
        testManifest.addProduct(new Product("Nails", 1, false, false));
        assertFalse(testManifest.isEmpty());

    }
    
    @Test
    public void testMultipleAddProduct() {
        System.out.println("testing addProduct()");
        assertTrue(testManifest.isEmpty());
        testManifest.addProduct(new Product("Nails", 1, false, false), 5);
        assertFalse(testManifest.isEmpty());

    }
    
    @Test
    public void testRemoveProduct() {
        System.out.println("testing removeProduct()");
        Product nails = new Product("Nails", 1, false, false);
        assertTrue(testManifest.isEmpty());
        testManifest.addProduct(nails);
        assertFalse(testManifest.isEmpty());
        testManifest.removeProduct(nails);
        assertTrue(testManifest.isEmpty());
    }
    
    @Test
    public void testGetTotalWeight() {
        System.out.println("testing getTotalWeight()");
        Product nails = new Product("Nails", 1, false, false);
        assertTrue(testManifest.isEmpty());
        double weight1 = testManifest.getTotalWeight();
        testManifest.addProduct(nails);
        assertFalse(testManifest.isEmpty());
        double weight2 = testManifest.getTotalWeight();
        assertNotEquals(weight1, weight2, 0.001);
        
        assertTrue(testManifest2.isEmpty());
        double weight3 = testManifest2.getTotalWeight();
        testManifest2.addProduct(nails);
        assertFalse(testManifest2.isEmpty());
        double weight4 = testManifest2.getTotalWeight();
        assertNotEquals(weight3, weight4, 0.001);
        
        assertEquals(weight1, weight3, 0.001);
        assertEquals(weight2, weight4, 0.001);

    }
    
    @Test
    public void testGetTotalManifestWeight() {
        System.out.println("testing getTotalManifestWeight()");
        Product nails = new Product("Nails", 1, false, false);
        assertTrue(testManifest.isEmpty());
        double weight1 = testManifest.getTotalManifestWeight();
        testManifest.addProduct(nails);
        assertFalse(testManifest.isEmpty());
        double weight2 = testManifest.getTotalManifestWeight();
        assertNotEquals(weight1, weight2, 0.001);
        
        assertTrue(testManifest2.isEmpty());
        double weight3 = testManifest2.getTotalManifestWeight();
        testManifest2.addProduct(nails);
        assertFalse(testManifest2.isEmpty());
        double weight4 = testManifest2.getTotalManifestWeight();
        assertNotEquals(weight3, weight4, 0.001);
        
        assertEquals(weight1, weight3, 0.001);
        assertEquals(weight2, weight4, 0.001);

    }
    
    @Test
    public void testGetHeaviestUnder() {
        System.out.println("testing getHeaviestUnder()");
        testManifest.addProduct(new Product("Hammer", 3, false, false), 1);
        testManifest.addProduct(new Product("Nails", 1, false, false), 1);
        testManifest.addProduct(new Product("Ladder", 15, false, false), 1);
        testManifest.addProduct(new Product("Saw", 5, false, false), 1);
        testManifest.addProduct(new Product("Light Bulbs", 1, false, true), 1);
        testManifest.addProduct(new Product("Weedkiller", 2, true, false), 1);
        Product p = testManifest.getHeaviestUnder(16);
        testManifest2.addProduct(p);
        assertEquals(15, testManifest2.getTotalWeight(), 0.001);
        
        p = testManifest.getHeaviestUnder(6);
        testManifest2.addProduct(p);
        assertEquals(20, testManifest2.getTotalWeight(), 0.001);
        
        p = testManifest.getHeaviestUnder(4);
        testManifest2.addProduct(p);
        assertEquals(23, testManifest2.getTotalWeight(), 0.001);
        
        p = testManifest.getHeaviestUnder(3);
        testManifest2.addProduct(p);
        assertEquals(25, testManifest2.getTotalWeight(), 0.001);
        
        p = testManifest.getHeaviestUnder(2);
        testManifest2.addProduct(p);
        assertEquals(26, testManifest2.getTotalWeight(), 0.001);

    }
    
//    @Test
//    public void testIsEmpty() { // NO IDEA HOW TO TEST THIS
//    System.out.println("testing isEmpty()");
//
//    }
//    
    @Test
    public void testContainsProduct() {
        System.out.println("testing containsProduct()");
        Product nails = new Product("Nails", 1, false, false);
        assertTrue(testManifest.isEmpty());
        testManifest.addProduct(nails);
        assertFalse(testManifest.isEmpty());
        assertTrue(testManifest.containsProduct(nails));

    }
    
//    @Test
//    public void testToString() { // NO IDEA HOW TO TEST THIS
//    System.out.println("testing toString()");
//
//    }
//    
    @Test
    public void testHasFragileItems() {
        System.out.println("testing hasFragileItems()");
        Product nails = new Product("Nails", 1, true, true);
        assertTrue(testManifest.isEmpty());
        assertFalse(testManifest.hasFragileItems());
        testManifest.addProduct(nails);
        assertFalse(testManifest.isEmpty());
        assertTrue(testManifest.hasFragileItems());

    }
    
    @Test
    public void testHasHazardousItems() {
        System.out.println("testing hasHazardousItems()");
        Product nails = new Product("Nails", 1, true, true);
        assertTrue(testManifest.isEmpty());
        assertFalse(testManifest.hasHazardousItems());
        testManifest.addProduct(nails);
        assertFalse(testManifest.isEmpty());
        assertTrue(testManifest.hasHazardousItems());

    }
    
    
}

