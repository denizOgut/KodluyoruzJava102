import java.util.Comparator;

public class Book implements Comparable<Book> {
    private String name;
    private String publishDate;
    private int pageNumber;


    public Book(String name, String publishDate, int pageNumber) {
        this.name = name;
        this.publishDate = publishDate;
        this.pageNumber = pageNumber;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Book(String name, int pageNumber) {
        this.name = name;
        this.pageNumber = pageNumber;
    }

    @Override
    public int compareTo(Book book) {
        if (this.pageNumber > book.pageNumber) {
            return 1;
        } else if (this.pageNumber == book.pageNumber) {
            return 0;
        } else {
            return -1;
        }
    }


}
