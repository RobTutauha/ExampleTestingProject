/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import packer.Address;
import packer.Coordinates;
import packer.Customer;
import packer.Depot;

/**
 *
 * @author bunta
 */
public class CustomerTest {

    // Test data
    Coordinates depotCoordinates1 = new Coordinates(0,0);
    Coordinates depotCoordinates2 = new Coordinates(1000, 1000);
    Coordinates depotCoordinates3 = new Coordinates(500, 500);
    Coordinates testCoordinates1 = new Coordinates(1,1);
    Coordinates testCoordinates2 = new Coordinates(499,499);
    Coordinates testCoordinates3 = new Coordinates(749,749);
    Coordinates testCoordinates4 = new Coordinates(999, 999);
    
    
    Address depotAddress1 = new Address("111 Emerge Rd", "Really", "Inn Town", "D444", depotCoordinates1);
    Address depotAddress2 = new Address("22 No St", "where", "Else", "E555", depotCoordinates2);
    Address depotAddress3 = new Address("55 Some St", "Some", "where", "E555", depotCoordinates3);
    Address testAddress1 = new Address("1 First St", "Aplace", "Citadel City", "A111", testCoordinates1);
    Address testAddress2 = new Address("123 Count St", "Brooklyn", "Welling Town", "B222", testCoordinates2);
    Address testAddress3 = new Address("666 Hell St", "Brimstone", "Fireton", "V666", testCoordinates3);
    Address testAddress4 = new Address("321 Back St", "Christly", "Holly Oaks", "C333", testCoordinates4);
    
    
    Depot testDepot1 = new Depot("Test Depot", depotAddress1);
    Depot testDepot2 = new Depot("Test Depot", depotAddress2);
    Depot testDepot3 = new Depot("Test Depot", depotAddress3);
        
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Customer class...");
    }

    /**
     * Test of getClosestAddressTo method, of class Customer.
     */
    @Test
    public void testGetClosestAddressTo() {
        System.out.println("getClosestAddressTo");
        Customer testCustomer;
        testCustomer = new Customer("Test Customer", testAddress4);
        
        assertEquals(testAddress4, testCustomer.getClosestAddressTo(testDepot1));
        assertEquals(testAddress4, testCustomer.getClosestAddressTo(testDepot2));
        testCustomer.addAddress(testAddress1);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot1));
        assertEquals(testAddress4, testCustomer.getClosestAddressTo(testDepot2));
        testCustomer.addAddress(testAddress3);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot1));
        assertEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot3));
        assertEquals(testAddress4, testCustomer.getClosestAddressTo(testDepot2));
        testCustomer.addAddress(testAddress2);
        assertEquals(testAddress1, testCustomer.getClosestAddressTo(testDepot1));
        assertNotEquals(testAddress3, testCustomer.getClosestAddressTo(testDepot3));
        assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot3));
        assertEquals(testAddress4, testCustomer.getClosestAddressTo(testDepot2));
    }
}
