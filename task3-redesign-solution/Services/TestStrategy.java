/**
 * Interface that defines a strategy for testing items.
 * This is part of the Strategy design pattern implementation, allowing for different testing approaches.
 * Implementations of this interface should provide specific testing logic for different types of items.
 */
public interface TestStrategy {
    void test(Item item);
}