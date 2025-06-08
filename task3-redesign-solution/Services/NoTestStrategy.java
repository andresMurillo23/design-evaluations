/**
 * NoTestStrategy implements the TestStrategy interface and provides a no-operation implementation
 * for items that do not require testing (e.g., Food items).
 * 
 * This strategy is used when an item should not undergo any testing procedures.
 * The test method deliberately does nothing when called.
 */
public class NoTestStrategy implements TestStrategy {
    @Override
    public void test(Item item) {
        // Food is not testable
    }
}