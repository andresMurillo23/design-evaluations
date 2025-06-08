public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int THREAD_COUNT = 10;
        Thread[] threads = new Thread[THREAD_COUNT];

        // Stress test: 10 threads adding items concurrently
        System.out.println("Starting stress test with " + THREAD_COUNT + " threads, adding 100 items each...");
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    // Create a new item for each thread
                    ItemCreator itemCreator = new ItemCreator();
                    itemCreator.CreateItem("Random");
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        // Verify results
        ShoppingCart finalCart = ShoppingCart.getInstance();
        System.out.println("Actual total items: " + finalCart.getItemCount());
        finalCart.testAllItems();
        finalCart.calculateTotalPrice();
    }
}