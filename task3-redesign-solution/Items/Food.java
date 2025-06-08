/**
 * A class representing food items that can be purchased.
 * Food items implement the Item interface to be part of the store's inventory.
 * Food items have a name, price, and use a TestStrategy for functionality testing.
 * Food items cannot be broken as indicated by the always-false isBroken method.
 * By default, food items use NoTestStrategy which performs no actual testing.
 */
public class Food implements Item {
    private String name;
    private double price;
    private TestStrategy testStrategy;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
        this.testStrategy = new NoTestStrategy();
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
    public boolean isBroken() {
        return false;
    }
}
