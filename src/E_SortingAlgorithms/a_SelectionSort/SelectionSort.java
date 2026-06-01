package E_SortingAlgorithms.a_SelectionSort;
import B_LinearStructures.b_Lists.ArrayList.ArrayList;

public class SelectionSort<T extends Comparable<T>> {

    public SelectionSort() {}

    public T[] sortArray(T[] array) {
        selectionSort(array);
        return array;
    }

    public ArrayList<T> sortList(ArrayList<T> list) {
        selectionSort(list);
        return list;
    }

    private void selectionSort(T[] arr) throws IllegalArgumentException {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Array is empty");
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    private void selectionSort(ArrayList<T> list) throws IllegalArgumentException {
        if (list == null || list.isEmpty()) throw new IllegalArgumentException("Array is empty");
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }
}