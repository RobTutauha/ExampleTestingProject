/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author MOTU
 */
public class PackerTest {
    
    // Test Data
    Address depotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
    Depot depot = new Depot("Main Depot", depotAddress);
    Address customerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
    Address customerAddress2 = new Address("88 Camp Mine St", "Ridgeway", "Lowe Valley", "I998", new Coordinates(100, 34));
    Customer customer = new Customer("Andy Bravo", customerAddress1);
    
    Box testBox = new Box(customer, depot);
    
    Manifest testManifest = new Manifest();
   
    public void packTestData(){
        testManifest.addProduct(new Product("Hammer", 3, false, false), 1);
        testManifest.addProduct(new Product("Nails", 1, false, false), 1);
        testManifest.addProduct(new Product("Ladder", 15, false, false), 1);
        testManifest.addProduct(new Product("Saw", 5, false, false), 1);
        testManifest.addProduct(new Product("Light Bulbs", 1, false, true), 1);
        testManifest.addProduct(new Product("Weedkiller", 2, true, false), 1);
        
        customer.addAddress(customerAddress2);
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }
    

    @Test
    public void testPackProducts() {
        System.out.println("testing packProducts()");

    }
    
    @Test
    public void testPackBox() {
        System.out.println("testing packBox()");

    }
    
    @Test
    public void testBuildBox() {
        System.out.println("testing buildBox()");

    }
}