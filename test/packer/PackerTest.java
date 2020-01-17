/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 *
 * @author RobT
 */
public class PackerTest {
    
    // Test Data
    Address testDepotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
    Depot testDepot = new Depot("Main Depot", testDepotAddress);
    Address testCustomerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
    Address testCustomerAddress2 = new Address("88 Camp Mine St", "Ridgeway", "Lowe Valley", "I998", new Coordinates(100, 34));
    Customer testCustomer = new Customer("Andy Bravo", testCustomerAddress1);
    
    Box testBox1 = new Box(testCustomer, testDepot);
    Box testBox2 = new Box(testCustomer, testDepot);
    Box testBox3 = new Box(testCustomer, testDepot);
    
    Manifest testManifest = new Manifest();
    List<Box> testPackedBoxes = new ArrayList<>();

   
    public void packTestData(){
        testManifest.addProduct(new Product("Hammer", 3, false, false), 1);
        testManifest.addProduct(new Product("Nails", 1, false, false), 1);
        testManifest.addProduct(new Product("Ladder", 15, false, false), 1);
        testManifest.addProduct(new Product("Saw", 5, false, false), 1);
        testManifest.addProduct(new Product("Light Bulbs", 1, false, true), 1);
        testManifest.addProduct(new Product("Weedkiller", 2, true, false), 1);
        
        testCustomer.addAddress(testCustomerAddress2);
        
        
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }
    

    @Test
    public void testPackProducts() {
        System.out.println("testing packProducts()");
        
        //Create test condition
        testBox1.addProduct(new Product("Ladder", 15, false, false), 1);
        testBox1.addProduct(new Product("Saw", 5, false, false), 1);
        
        testBox2.addProduct(new Product("Hammer", 3, false, false), 1);
        testBox2.addProduct(new Product("Weedkiller", 2, true, false), 1);
        testBox2.addProduct(new Product("Nails", 1, false, false), 1);
        testBox2.addProduct(new Product("Light Bulbs", 1, false, true), 1);
        
        testPackedBoxes.add(testBox1);
        testPackedBoxes.add(testBox2);
        
        //Run the method
        List<Box> testPackedBoxes2 = new ArrayList<>();
        testPackedBoxes2 = Packer.packProducts(testCustomer, testDepot, testManifest);
        
        //Test the result
        assertNotNull("Shouldn't be Null", testPackedBoxes2);
        assertEquals("Should be Equal", testPackedBoxes.contains(this), testPackedBoxes2.contains(this));
    }
  

    @Test
    public void testPackBox() {
        System.out.println("testing packBox()");
        
        //Create test condition
        testBox1.addProduct(new Product("Hammer", 3, false, false), 1);
        testPackedBoxes.add(testBox1);
        
        //Run the method
        List<Box> testPackedBoxes2 = new ArrayList<>();
        Packer.packBox(testBox1, testPackedBoxes2);
        
        //Test the result
        assertNotNull("Shouldn't be Null", testPackedBoxes2);
        assertEquals("Should be Equal", testPackedBoxes.contains(this), testPackedBoxes2.contains(this));
    }
    
    @Test
    public void testBuildBox() {
        System.out.println("testing buildBox()");
        Box box2 = null;
        assertNotNull("Shouldn't be Null", box2 = Packer.buildBox(box2, testCustomer, testDepot));
    }
}