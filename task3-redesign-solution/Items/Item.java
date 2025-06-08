/**
 * Represents an item that can be purchased or used.
 * This interface provides methods for retrieving item information
 * and testing its functionality.
 *
 * @author Your Name
 * @version 1.0
 */
public interface Item {
    String getName();
    double getPrice();
    void testFunctionality();
    boolean isBroken();
}