package A_RecursionAlgorithms.DivideAndConquer;

public class ArraySum {
    private static Integer sumHelper(Integer[] array, int index){
        if(index >= array.length){
            return 0;
        }
        return array[index] + sumHelper(array, index + 1);
    }

    public static Integer sum(Integer[] array) {
        return sumHelper(array, 0);
    }


}