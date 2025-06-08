// Services/ItemFactory.java
/**
 * Factory interface for creating Item objects.
 * <p>
 * This interface defines a factory method pattern for creating instances of the Item class.
 * Implementations of this interface will provide specific implementations of the createItem method,
 * allowing for the creation of different types of items.
 * </p>
 */
public interface ItemFactory {
    Item createItem();
}