package E_SortingAlgorithms.d_MergeSort;
import B_LinearStructures.b_Lists.ArrayList.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        MergeSort<Integer> mergeSort = new MergeSort<>();

        long startTime = System.currentTimeMillis();
        Integer[] array = new Integer[10000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
        }
        mergeSort.sortArray(array);
        long endTime = System.currentTimeMillis();

        long startTime1 = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<>(10000);

        for (int i = 0; i < 10000; i++) {
            list.add(ThreadLocalRandom.current().nextInt(100000));
        }
        mergeSort.sortList(list);
        long endTime1 = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        mergeSort.classicSortArray(array, 10, 9010);
        long endTime2 = System.currentTimeMillis();

        long startTime3 = System.currentTimeMillis();
        mergeSort.classicSortList(list, 10, 9010);
        long endTime3 = System.currentTimeMillis();

        System.out.println("Time taken to Merge Sort array: " + (endTime - startTime) + "ms");
        System.out.println("Time taken to Merge Sort list: " + (endTime1 - startTime1) + "ms");
        System.out.println("Time taken to Classic Merge Sort array with interval between 10 and 9010: " + (endTime2 - startTime2) + "ms");
        System.out.println("Time taken to Classic Merge Sort list with interval between 10 and 9010: " + (endTime3 - startTime3) + "ms");
    }
}