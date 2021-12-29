import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Dune", 550, "DuneAuthor", 1972));
        bookList.add(new Book("Harry Potter", 1100, "HPAuthor", 2000));
        bookList.add(new Book("Lord Of The Rings", 2437, "LotrAuthor", 1930));
        bookList.add(new Book("Effective Java", 735, "JavaAuthor", 2017));
        bookList.add(new Book("Anna Karenina", 200, "AnnaAuthor", 1919));
        bookList.add(new Book("Madame Bovary", 814, "MadameAuthor", 1931));
        bookList.add(new Book("War and Peace ", 3000, "WarAuthor", 1890));
        bookList.add(new Book(" The Great Gatsby", 900, "GreatAuthor", 1919));
        bookList.add(new Book(" Middlemarch", 444, "MiddleAuthor", 1768));
        bookList.add(new Book("In Search of Lost Time", 888, "TimeAuthor", 2010));

        ArrayList<Book> bookListByPageNum = new ArrayList<>(bookList.stream().filter(book -> book.getPageNum() > 500).toList());
        for (Book book : bookListByPageNum) {
            System.out.println(book.getName() + " - " + book.getPageNum());
        }

        Map<String, String> bookMap = new HashMap(bookList.stream().collect(Collectors.toMap(Book::getName, Book::getAuthorName)));

        bookMap.forEach((key, value) -> {
            System.out.println("---------------------------------------------------------- ");
            System.out.println(key + " - " + value + " ");
        });

    }
}
