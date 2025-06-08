import java.util.Random;

/**
 * Class responsible for creating items and adding them to the shopping cart.
 * Uses the Factory pattern to create different types of items based on the specified type.
 * 
 * This class maintains a reference to the singleton ShoppingCart instance and
 * ensures that items are only added when the cart is not full.
 */
public class ItemCreator {
    private ShoppingCart shoppingCart;

    public ItemCreator() {
        this.shoppingCart = ShoppingCart.getInstance();
    }

    public void CreateItem(String type) {
        ItemFactory factory;

        if (type.equals("ElectronicProduct")) {
            factory = new ElectronicItemFactory();
        } else if (type.equals("Food")) {
            factory = new FoodItemFactory();
        } else {
            // Random selection if unknown
            factory = new Random().nextBoolean()
                    ? new ElectronicItemFactory()
                    : new FoodItemFactory();
        }

        Item item = factory.createItem();

        if (this.shoppingCart.getItemCount() >= ShoppingCart.MAX_ITEMS) {
            System.out.println("Shopping cart is full. Cannot add more items.");
            return;
        }

        this.shoppingCart.addItem(item);
    }
}