

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Book> treeSet = new TreeSet<>();
        treeSet.add(new Book("X", "2008", 100));
        treeSet.add(new Book("Y", "1993", 250));
        treeSet.add(new Book("Z", "2020", 50));
        treeSet.add(new Book("W", "1985", 500));
        treeSet.add(new Book("Q", "1950", 20));

        for (Book book : treeSet) {
            System.out.println(book.getName() + ", " + book.getPageNumber());
        }
        System.out.println(" ");

        Set<Book> newTreeSet = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        newTreeSet.addAll(treeSet);
        for (Book book : newTreeSet) {
            System.out.println(book.getName() + ", " + book.getPageNumber());
        }
    }
}
