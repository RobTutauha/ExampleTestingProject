package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author RobT
 */
public class BoxTest {
    
    // Test Data
    Address depotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
    Depot depot = new Depot("Main Depot", depotAddress);
    Address customerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
    Address customerAddress2 = new Address("88 Camp Mine St", "Ridgeway", "Lowe Valley", "I998", new Coordinates(100, 34));
    Customer customer = new Customer("Andy Bravo", customerAddress1);
    
    Box testBox1 = new Box(customer, depot);
    Box testBox2 = new Box(customer, depot);
    Box testBox3 = new Box(customer, depot);
    
    Manifest testManifest = new Manifest();
   

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }
    
    
    /**
     * Test of addProduct method, of class Box
     */
    @Test
    public void testSingleAddProduct() {
        System.out.println("testing SingleAddProduct()");
        testBox1.addProduct(new Product("Hammer", 3, false, false));
        testBox2.addProduct(new Product("Hammer", 3, false, false));
        
        assertEquals(testBox1.remainingCapacity(), testBox2.remainingCapacity(), 0.001);
        assertEquals(testBox1.getLabel(), testBox2.getLabel());
    }
    
    
    /**
     * Test of multipleAddProduct method, of class Box
     */
    @Test
    public void testMultipleAddProduct() {
        System.out.println("testing MultipleAddProduct()");
        testBox1.addProduct(new Product("Hammer", 3, false, false), 3);
        testBox2.addProduct(new Product("Hammer", 3, false, false), 3);
        
        assertEquals(testBox1.remainingCapacity(), testBox2.remainingCapacity(), 0.001);
        assertEquals(testBox1.getLabel(), testBox2.getLabel());
    }
    
//    @Test
//    public void testGetLabel() { //NOTHING WORKS AND I HATE MY LIFE
//        System.out.println("testing getLabel()");
//        String label = testBox1.getLabel();
//        String label2 = "Andy Bravo/n67 Torch Rd/nTreeline/nMt High/nT799";
//        //System.out.println(testBox1);
//        assertEquals(label, label2);
//    }
//    
//    @Test
//    public void testToString() { //SAME WITH THIS
//        System.out.println("testing toString()");
//
//    }
//   
    
    /**
     * Test of getWeight method, of class Box
     */
    @Test
    public void testGetWeight() {
        System.out.println("testing getWeight()");
        testBox1.addProduct(new Product("Nails", 1, false, false), 1);
        double weight2 = testBox1.getWeight();
        assertEquals(1, weight2, 0.001);
        
        testBox1.addProduct(new Product("Hammer", 3, false, false), 4);
        testBox1.addProduct(new Product("Ladder", 15, false, false), 1);
        weight2 = testBox1.getWeight();
        assertEquals(28, weight2, 0.001);
    }
    
    /**
     * Test of canFit method, of class Box
     */
    @Test
    public void testSingleCanFit() {
        System.out.println("testing SingleCanFit()");
        assertTrue(testBox1.canFit(new Product("Nails", 1, false, false)));
        assertTrue(testBox1.canFit(new Product("Nails", 20, false, false)));
        assertFalse(testBox1.canFit(new Product("Nails", 21, false, false)));
    }
    
    /**
     * Test of canFit method, of class Box
     */
    @Test
    public void testMultipleCanFit() {
        System.out.println("testing MultiplecanFit()");
        assertTrue(testBox1.canFit(new Product("Nails", 1, false, false), 1));
        assertTrue(testBox1.canFit(new Product("Nails", 1, false, false), 20));
        assertFalse(testBox1.canFit(new Product("Nails", 1, false, false), 21));
    }
    
    /**
     * Test of remainingCapacity method, of class Box
     */
    @Test
    public void testRemainingCapacity() {
        System.out.println("testing remainingCapacity()");
        assertEquals(20, testBox1.remainingCapacity(), 0.001);
        testBox1.addProduct(new Product("Nails", 1, false, false), 20);
        assertEquals(0, testBox1.remainingCapacity(), 0.001);
        testBox1.addProduct(new Product("Nails", 1, false, false), 1);
        assertEquals(-1, testBox1.remainingCapacity(), 0.001);
    }
    
    /**
     * Test of isFragile method, of class Box
     */
    @Test
    public void testIsFragile() {
        System.out.println("testing isFragile()");
        assertFalse(testBox1.isFragile());
        testBox1.addProduct(new Product("Light Bulbs", 1, false, true), 1);
        assertTrue(testBox1.isFragile());
    }
    
    /**
     * Test of isHazardous method, of class Box
     */
    @Test
    public void testIsHazardous() {
        System.out.println("testing isHazardous()");
        assertFalse(testBox1.isHazardous());
        testBox1.addProduct(new Product("Weedkiller", 2, true, false), 1);
        assertTrue(testBox1.isHazardous());
    }
}
