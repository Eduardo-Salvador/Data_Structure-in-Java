package main.E_SortingAlgorithms.e_QuickSort;

public class QuickSort<T extends Comparable<T>> {
    public QuickSort() {}

    private void quickSort(T[] arr, int left, int right) {
        if (left >= right) return;
        T pivot = median(arr[left], arr[(left + right) / 2], arr[right]);
        int i = left;
        int j = right;

        while (i <= j) {
            while (arr[i].compareTo(pivot) < 0) i++;

            while (arr[j].compareTo(pivot) > 0) j--;

            if (i <= j) {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(arr, left, j);
        quickSort(arr, i, right);
    }

    private T median(T mid, T low, T high) {
        if ((mid.compareTo(low) >= 0 && mid.compareTo(high) <= 0) ||
                (mid.compareTo(low) <= 0 && mid.compareTo(high) >= 0)) return mid;
        else if ((low.compareTo(mid) >= 0 && low.compareTo(high) <= 0) ||
                (low.compareTo(mid) <= 0 && low.compareTo(high) >= 0)) return low;
        else return high;
    }

}
