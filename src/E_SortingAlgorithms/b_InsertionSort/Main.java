package E_SortingAlgorithms.b_InsertionSort;
import B_LinearStructures.b_Lists.ArrayList.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        InsertionSort<Integer> insertionSort = new InsertionSort<>();

        long startTime = System.currentTimeMillis();
        Integer[] array = new Integer[10000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
        }
        insertionSort.sortArray(array);
        long endTime = System.currentTimeMillis();

        long startTime1 = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<>(10000);

        for (int i = 0; i < 10000; i++) {
            list.add(ThreadLocalRandom.current().nextInt(100000));
        }
        insertionSort.sortList(list);
        long endTime1 = System.currentTimeMillis();

        System.out.println("Time taken to Insertion Sort array: " + (endTime - startTime) + "ms");
        System.out.println("Time taken to Insertion Sort list: " + (endTime1 - startTime1) + "ms");
    }
}