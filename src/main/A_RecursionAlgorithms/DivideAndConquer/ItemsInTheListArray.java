package main.A_RecursionAlgorithms.DivideAndConquer;
import java.util.List;

public class ItemsInTheListArray {
    public static <T> Integer counterListElements(List<T> list, int index){
        if (index >= list.size()){
            return index;
        }
        return counterListElements(list, index + 1);
    }

    public static <T> Integer counterListElements(T[] array, int index){
        if (index >= array.length){
            return index;
        }
        return counterListElements(array, index + 1);
    }


}