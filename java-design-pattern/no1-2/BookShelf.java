import java.util.Vector;

public class BookShelf implements Aggregate {

    private Vector<Book> books;

    public BookShelf(int initialSize) {
        this.books = new Vector<Book>(initialSize);
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public int getLength() {
        return books.size();
    }
    
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}