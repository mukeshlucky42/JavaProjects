import java.util.LinkedList;
import java.util.Queue;

public class QueueChallenge {

    public static void run() {
        System.out.println("\n--- Queue Challenge (Customer Tokens) ---");

        Queue<String> queue = new LinkedList<>();

        // add items to queue
        queue.add("Customer1");
        queue.add("Customer2");
        queue.add("Customer3");
        System.out.println("Queue after adding customers: " + queue);

        // peek at the front item
        System.out.println("Next customer to be served: " + queue.peek());

        // remove items from queue
        String served = queue.remove();
        System.out.println("Served: " + served);

        // display queue contents
        System.out.println("Queue after serving one customer: " + queue);
    }
}
