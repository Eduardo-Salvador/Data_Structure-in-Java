package E_Algorithms.a_Recursion.DivideAndConquer;
import java.util.ArrayList;
import java.util.List;

public class MaxValueInListArray {
    public static Integer max(List<Integer> list, int index, Integer maxValue){
        if (index >= list.size()){
            return maxValue;
        }
        if (list.get(index) > maxValue){
            maxValue = list.get(index);
        }
        return max(list, (index + 1), maxValue);
    }

    public static Integer max(Integer[] array, int index, Integer maxValue){
        if (index >= array.length){
            return maxValue;
        }
        if (array[index] > maxValue){
            maxValue = array[index];
        }
        return max(array, (index + 1), maxValue);
    }


}