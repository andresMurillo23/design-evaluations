/**
 * Represents an electronic product item.
 * This class implements the Item interface and uses a test strategy to verify functionality.
 * 
 * Electronic products have a name, price, and a status that indicates if they're broken or not.
 * By default, electronic products are initialized as not broken.
 * 
 * The testing functionality is delegated to an ElectronicTestStrategy object through
 * the Strategy pattern.
 */
public class ElectronicProduct implements Item {
    private String name;
    private double price;
    private boolean isBrokenValue;
    private TestStrategy testStrategy;

    public ElectronicProduct(String name, double price) {
        this.name = name;
        this.price = price;
        this.isBrokenValue = false;
        this.testStrategy = new ElectronicTestStrategy();
    }

    @Override
    public String getName() { return this.name; }

    @Override
    public double getPrice() { return this.price; }

    @Override
    public void testFunctionality() {
        testStrategy.test(this);
    }

    @Override
    public boolean isBroken() { return this.isBrokenValue; }

    public void setBroken(boolean broken) {
        this.isBrokenValue = broken;
    }
}
