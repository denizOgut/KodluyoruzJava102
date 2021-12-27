public class CustomThread implements Runnable {
    int index;

    public CustomThread() {
        this.index = 0;
    }

    @Override
    public synchronized void run() {
        int number = Main.numberList.get(index);

        if (number % 2 == 0) {
            Main.evenList.add(number);
        } else {
            Main.oddList.add(number);
        }

        System.out.println("Process Finished"
                + Thread.currentThread().getName()
                + " Even Size:" + Main.evenList.size()
                + " Odd Size: " + Main.oddList.size());
        index++;

    }

}
