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
        int count = 0;
        T []  newArray;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == null) {
                this.array[i] = data;
                break;
            }
        }

            newArray = getArray();
            this.array = (T[]) new Object[getDefLength() * 2];
            for (int i = 0; i < newArray.length; i++) {
                array[i] = newArray[i];
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


    public void remove(int index) {
        if ((index >= 0) && (index < array.length && this.array[index] != null)){
            for(int i =index; i<getArray().length; i++){
                if (i + 1 < getArray().length){
                    this.array[i] = this.array[i+1];
                    if(this.array[i]==null){
                        break;
                    }
                }else{
                    this.array[i] = null;
                }
            }
        }

    }

    public T set(int index, T data) {
        if ((index >= 0) && (index < array.length)) {
            return this.array[index] = data;
        } else {
            return null;
        }
    }

    public String toString() {
        StringBuilder text = new StringBuilder(" ");

        for (T t : this.array) {
            if (t != null) {
                text.append(t).append(",");
            }

        }
        return "[" + text.substring(0, text.length() - 1) + "]";
    }

}
