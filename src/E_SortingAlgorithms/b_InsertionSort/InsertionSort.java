package E_SortingAlgorithms.b_InsertionSort;
import B_LinearStructures.b_Lists.ArrayList.ArrayList;

public class InsertionSort<T extends Comparable<T>> {

    public InsertionSort() {}

    public T[] sortArray(T[] arr) {
        insertionSort(arr);
        return arr;
    }

    public ArrayList<T> sortList(ArrayList<T> list) {
        insertionSort(list);
        return list;
    }

    private void insertionSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    private void insertionSort(ArrayList<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }
}