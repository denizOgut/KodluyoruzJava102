import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static List<Integer> numberList = new ArrayList<>();
    static List<Integer> oddList = new ArrayList<>();
    static List<Integer> evenList = new ArrayList<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 1; i <= 10000; i++) {
            numberList.add(i);
        }
        CustomThread customThread = new CustomThread();

        for (int i = 1; i <= numberList.size(); i++) {
            executorService.execute(customThread);
        }
        executorService.shutdown();

        System.out.println("Size of evenList: " + evenList.size());
        System.out.println("Size of oddList: " + oddList.size());
    }
}
