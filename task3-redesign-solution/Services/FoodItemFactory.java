/**
 * A factory class that implements the ItemFactory interface for creating Food items.
 * This factory produces Food objects with a default name and a random price value.
 * 
 * @see ItemFactory
 * @see Food
 * @see Item
 */
public class FoodItemFactory implements ItemFactory {
    @Override
    public Item createItem() {
        return new Food("Default Food", Math.random());
    }
}