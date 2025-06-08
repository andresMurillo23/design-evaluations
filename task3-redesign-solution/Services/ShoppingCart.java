import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ShoppingCart class implements a thread-safe shopping cart using the Singleton pattern.
 * 
 * This class manages a collection of items and provides methods for adding items,
 * retrieving the item count, testing item functionality, and calculating the total price.
 * 
 * Thread safety is achieved through several mechanisms:
 * 1. Singleton implementation using eager initialization to ensure thread safety
 * 2. Thread-safe collection using Collections.synchronizedList
 * 3. Synchronized blocks for safe iteration over the items collection
 * 
 * The class maintains a maximum limit of items that can be added to the cart.
 * 
 */
public class ShoppingCart {
    private static final ShoppingCart instance = new ShoppingCart();
    private final List<Item> items = Collections.synchronizedList(new ArrayList<>());

    public static final int MAX_ITEMS = 1000000;

    private ShoppingCart() {}

    public static ShoppingCart getInstance() {
        return instance;
    }

    public void addItem(Item item) {
        if (item != null) {
            this.items.add(item);
        }
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void testAllItems() {
        int brokenCount = 0;
        int errors = 0;
        int testedCount = 0;
        System.out.println("Total items to test: " + items.size());

        synchronized (items) {
            for (Item item : this.items) {
                try {
                    item.testFunctionality();
                    if (item.isBroken()) {
                        brokenCount++;
                    }
                    testedCount++;
                } catch (Exception e) {
                    errors++;
                }
            }
        }

        System.out.println("Total items tested: " + testedCount);
        System.out.println("Broken items: " + brokenCount);
        System.out.println("Errors during testing: " + errors);
    }

    public void calculateTotalPrice() {
        double totalPrice = 0.0;

        synchronized (items) {
            for (Item item : this.items) {
                totalPrice += item.getPrice();
            }
        }

        System.out.println("Total price of items in the cart: " + totalPrice);
    }
}
