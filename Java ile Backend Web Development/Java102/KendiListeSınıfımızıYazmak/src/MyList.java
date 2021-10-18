public class MyList<T> {
    private int defLength;
    private T[] array;

    public MyList(int defLength) {
        this.defLength = defLength;
        this.array = (T[]) new Object[this.defLength];
    }

    public MyList() {
        this.defLength = 10;
        this.array = (T[]) new Object[this.defLength];
    }

    public void add(T data) {
        //T[] newArray = (T[]) new Object[this.array.length * 2];
        for (int i = 0; i < this.array.length - 1; i++) {
            if (this.array[i] == null) {
                this.array[i] = data;
                break;
            }
        }
    }

    public int getDefLength() {
        return defLength;
    }

    public void setDefLength(int defLength) {
        this.defLength = defLength;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public int getCapacity() {
        return this.array.length;
    }

    public int size() {
        int count = 0;
        for (T t : this.array) {
            if (t != null) {
                count++;
            }
        }
        return count;
    }

    public int get(int index) {
        if ((index >= 0) && (index < array.length)) {
            return (int) this.array[index];
        } else {
            return Integer.parseInt(null);
        }
    }

    // remove funct yazılacak

   public T set (int index , T data){
       if ((index >= 0) && (index < array.length)){
          return this.array[index] = data;
       }else
       {
           return null;
       }
   }

   public String toString(){
        StringBuilder text = new StringBuilder(" ");

       for (T t : this.array) {
           text.append(t).append(",");
       }
       return "[" + text.substring(0, text.length()-1) + "]";
   }

}
