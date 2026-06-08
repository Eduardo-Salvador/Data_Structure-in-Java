package main.E_SortingAlgorithms.d_MergeSort;
import main.B_LinearStructures.b_Lists.ArrayList.ArrayList;

public class MergeSort<T extends Comparable<T>> {
    public MergeSort() {}

    public T[] sortArray(T[] array) {
        mergeSort(array);
        return array;
    }

    public ArrayList<T> sortList(ArrayList<T> list) {
        mergeSort(list);
        return list;
    }

    @SuppressWarnings("unchecked")
    private void mergeSort(T[] arr) throws IllegalArgumentException {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Array is null");
        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        T[] left = (T[]) new Comparable[mid];
        T[] right = (T[]) new Comparable[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private void merge(T[] arr, T[] left, T[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            } k++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    private void mergeSort(ArrayList<T> list) throws IllegalArgumentException {
        if (list == null || list.isEmpty()) throw new IllegalArgumentException("Array is null");
        if (list.size() < 2) {
            return;
        }

        int mid = list.size() / 2;
        ArrayList<T> left = new ArrayList<>(mid);
        ArrayList<T> right = new ArrayList<>(list.size() - mid);

        for (int i = 0; i < mid; i++) {
            left.add(list.get(i));
        }
        for (int i = mid; i < list.size(); i++) {
            right.add(list.get(i));
        }
        mergeSort(left);
        mergeSort(right);
        merge(list, left, right);
    }

    private void merge(ArrayList<T> list, ArrayList<T> left, ArrayList<T> right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    public void classicSortArray(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public void classicSortArray(T[] array, int start, int end) {
        if (start >= end) throw new IllegalArgumentException("Start is greater than end");
        mergeSort(array, start, end);
    }

    private void mergeSort(T[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        mergeSort(array, start, middle);
        mergeSort(array, middle + 1, end);
        merge(array, start, middle, end);
    }

    @SuppressWarnings("unchecked")
    private void merge(T[] array, int start, int middle, int end) {
        T[] temp = (T[]) new Comparable[end - start + 1];
        int leftIndex = start;
        int rightIndex = middle + 1;
        int tempIndex = 0;

        while (leftIndex <= middle && rightIndex <= end) {
            if (array[leftIndex].compareTo(array[rightIndex]) <= 0) {
                temp[tempIndex++] = array[leftIndex++];
            } else {
                temp[tempIndex++] = array[rightIndex++];
            }
        }
        while (leftIndex <= middle) {
            temp[tempIndex++] = array[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[tempIndex++] = array[rightIndex++];
        }
        for (int i = 0; i < temp.length; i++) {
            array[start + i] = temp[i];
        }
    }

    public ArrayList<T> classicSortList(ArrayList<T> list) {
        mergeSort(list, 0, list.size() - 1);
        return list;
    }

    public ArrayList<T> classicSortList(ArrayList<T> list, int start, int end) {
        if (start >= end) throw new IllegalArgumentException("Start is greater than end");
        mergeSort(list, 0, list.size() - 1);
        return list;
    }

    private void mergeSort(ArrayList<T> list, int start, int end) {
        if (start >= end) return;
        int middle = start + (end - start) / 2;
        mergeSort(list, start, middle);
        mergeSort(list, middle + 1, end);
        merge(list, start, middle, end);
    }

    @SuppressWarnings("unchecked")
    private void merge(ArrayList<T> list, int start, int middle, int end) {
        ArrayList<T> temp = new ArrayList<>(end - start + 1);
        int leftIndex = start;
        int rightIndex = middle + 1;

        while (leftIndex <= middle && rightIndex <= end) {
            if (list.get(leftIndex).compareTo(list.get(rightIndex)) <= 0) {
                temp.add(list.get(leftIndex));
                leftIndex++;
            } else {
                temp.add(list.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex <= middle) {
            temp.add(list.get(leftIndex));
            leftIndex++;
        }
        while (rightIndex <= end) {
            temp.add(list.get(rightIndex));
            rightIndex++;
        }
        for (int i = 0; i < temp.size(); i++) {
            list.set(start + i, temp.get(i));
        }
    }
}