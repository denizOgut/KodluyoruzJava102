import java.util.Date;

public class Book {
    private String name;
    private int pageNum;
    private String authorName;
    private int publishDate;

    public Book(String name, int pageNum, String authorName, int publishDate) {
        this.name = name;
        this.pageNum = pageNum;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }
}
