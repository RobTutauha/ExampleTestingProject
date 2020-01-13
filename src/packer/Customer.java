package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author I.M.Bad
 * 
 * customer class defines customer info
 * contains the following methods:
 * Customer(String name, Address address)
 * addAddress(Address address
 * getName()
 * getClosestAddressTo(Depot d)
 * toString()
 */
public class Customer {
    
    private String name;
    private List<Address> addresses;

    /**
     * Customer Constructor
     * @param name string
     * @param address address
     */
    public Customer(String name, Address address) {
        addresses = new ArrayList<>();
        this.name = name;
        this.addresses.add(address);
    }
    
    /**
     * adds address to customer address list
     * @param address address
     */
    public void addAddress(Address address) {
        this.addresses.add(address);
    }
    
    /**
     * gets customer name
     * @return string
     */
    public String getName() {
        return name;
    }

    /**
     * calculates customer address closest to depot
     * @param d depot
     * @return string
     */
    public Address getClosestAddressTo(Depot d) {
        double bestDistance = Double.MAX_VALUE;
        Address bestAddress = null;
        for (Address a : addresses) {
            double distance = a.getCoordinates().companyDistanceTo(d.getCoordinates());
            if (distance < bestDistance) {
                bestAddress = a;
            }
        }
        return bestAddress;
    }

    //THIS TOSTRING IS PROBABLY HOW ALL THE OTHERS SHOULD BE WORKING
    /**
     * gets customer name
     * @return string
     */
    public String toString() {
        return this.getName();
    }
}
