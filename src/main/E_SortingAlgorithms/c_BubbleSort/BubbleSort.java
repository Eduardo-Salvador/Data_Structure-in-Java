package main.E_SortingAlgorithms.c_BubbleSort;
import main.B_LinearStructures.b_Lists.ArrayList.ArrayList;

public class BubbleSort<T extends Comparable<T>> {

    public BubbleSort() {}

    public T[] sortArray(T[] arr) {
        bubbleSort(arr);
        return arr;
    }

    public ArrayList<T> sortList(ArrayList<T> list) {
        bubbleSort(list);
        return list;
    }

    private void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    private void bubbleSort(ArrayList<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }
}