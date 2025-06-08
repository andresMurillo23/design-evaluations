/**
 * A factory class for creating electronic items.
 * Implements the ItemFactory interface to provide specific implementation
 * for creating instances of ElectronicProduct.
 * 
 * This factory creates electronic products with a default name "Default Electronic"
 * and a random price value.
 * 
 * @see ItemFactory
 * @see ElectronicProduct
 * @see Item
 */
public class ElectronicItemFactory implements ItemFactory {
    @Override
    public Item createItem() {
        return new ElectronicProduct("Default Electronic", Math.random());
    }
}