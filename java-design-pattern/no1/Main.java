public class Main {
    public static void main(String[] args) {
        BookShelf bookshelf = new BookShelf(4);
        bookshelf.appendBook(new Book("Test1"));
        bookshelf.appendBook(new Book("Test2"));
        bookshelf.appendBook(new Book("Test3"));
        bookshelf.appendBook(new Book("Test4"));

        Iterator it = bookshelf.iterator();

        while(it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println("" + book.getName());
        }
    }
}