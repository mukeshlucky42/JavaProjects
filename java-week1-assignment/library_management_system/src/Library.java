import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(int id, String title, String author) {
        // do not allow two books with the same id
        for (Book b : books) {
            if (b.getBookId() == id) {
                System.out.println("A book with this ID already exists.");
                return;
            }
        }
        Book newBook = new Book(id, title, author);
        books.add(newBook);
        System.out.println("Book added successfully.");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library yet.");
            return;
        }
        System.out.println("----- Book List -----");
        for (Book b : books) {
            b.printDetails();
            System.out.println("----------------------");
        }
    }

    public Book searchById(int id) {
        for (Book b : books) {
            if (b.getBookId() == id) {
                return b;
            }
        }
        return null;
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.printDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with this title.");
        }
    }

    public void issueBook(int id) {
        Book b = searchById(id);
        if (b == null) {
            System.out.println("Book not found.");
        } else if (!b.isAvailable()) {
            System.out.println("This book is already issued.");
        } else {
            b.setAvailable(false);
            System.out.println("Book issued successfully.");
        }
    }

    public void returnBook(int id) {
        Book b = searchById(id);
        if (b == null) {
            System.out.println("Book not found.");
        } else if (b.isAvailable()) {
            System.out.println("This book was not issued.");
        } else {
            b.setAvailable(true);
            System.out.println("Book returned successfully.");
        }
    }

    public void removeBook(int id) {
        Book b = searchById(id);
        if (b == null) {
            System.out.println("Book not found.");
        } else {
            books.remove(b);
            System.out.println("Book removed successfully.");
        }
    }
}
