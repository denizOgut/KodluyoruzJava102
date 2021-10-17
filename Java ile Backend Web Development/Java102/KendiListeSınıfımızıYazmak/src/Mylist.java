public class Mylist <T> {
    private int defLength;

    public Mylist(int defLength) {
        this.defLength = defLength;
    }

    public int getDefLength() {
        return defLength;
    }

    public void setDefLength(int defLength) {
        this.defLength = defLength;
    }

    public  Mylist () {
        this.defLength = 10;
    }
}
