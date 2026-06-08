package main.E_SortingAlgorithms.c_BubbleSort;
import main.B_LinearStructures.b_Lists.ArrayList.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();

        long startTime = System.currentTimeMillis();
        Integer[] array = new Integer[10000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
        }
        bubbleSort.sortArray(array);
        long endTime = System.currentTimeMillis();

        long startTime1 = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<>(10000);

        for (int i = 0; i < 10000; i++) {
            list.add(ThreadLocalRandom.current().nextInt(100000));
        }
        bubbleSort.sortList(list);
        long endTime1 = System.currentTimeMillis();

        System.out.println("Time taken to Bubble Sort array: " + (endTime - startTime) + "ms");
        System.out.println("Time taken to Bubble Sort list: " + (endTime1 - startTime1) + "ms");
    }
}