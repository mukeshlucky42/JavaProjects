import java.util.ArrayList;

public class ArrayListChallenge {

    public static void run() {
        System.out.println("\n--- ArrayList Challenge (Book Titles) ---");

        ArrayList<String> books = new ArrayList<>();

        // add elements
        books.add("Java Basics");
        books.add("OOP in Practice");
        books.add("Data Structures");
        System.out.println("After adding books: " + books);

        // update an element
        books.set(1, "OOP Concepts");
        System.out.println("After updating index 1: " + books);

        // search for an element
        String searchTitle = "Data Structures";
        if (books.contains(searchTitle)) {
            System.out.println(searchTitle + " found at index " + books.indexOf(searchTitle));
        } else {
            System.out.println(searchTitle + " not found.");
        }

        // remove an element
        books.remove("Java Basics");
        System.out.println("After removing Java Basics: " + books);

        // iterate and display
        System.out.println("Final book list:");
        for (String title : books) {
            System.out.println("- " + title);
        }
    }
}
