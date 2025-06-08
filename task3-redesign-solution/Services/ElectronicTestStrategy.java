/**
 * A strategy for testing electronic products.
 * This class implements the TestStrategy interface to specifically handle the testing
 * of electronic items.
 * 
 * When testing an electronic product, there's a 10% chance that the product will be 
 * marked as broken.
 */
public class ElectronicTestStrategy implements TestStrategy {
    @Override
    public void test(Item item) {
        if (item instanceof ElectronicProduct ep) {
            ep.setBroken(Math.random() < 0.1);
        }
    }
}