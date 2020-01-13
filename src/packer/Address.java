package packer;

/**
 *
 * @author I.M.Bad
 * 
 * address class defines and exposes address info
 */
public class Address {
    private String street;
    private String suburb;
    private String city;
    private String postcode;
    private Coordinates coordinates;

    /**
     * Address Constructor
     * 
     * @param street string
     * @param suburb string
     * @param city string
     * @param postcode string
     * @param coordinates coordinates
     */
    public Address(String street, String suburb, String city, String postcode, Coordinates coordinates) {
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }

    /**
     * Concatenates address values for easy display
     * @return concatenated string of address
     */
    public String toString() {
        return 
                street + "\n" +
                suburb + "\n" +
                city + "\n" +
                postcode;
    }
    /**
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    
}
