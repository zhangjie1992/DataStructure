package lanchong.iloveu.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SortUnitTest {

    @Test
    public void quickSort() {
        Sort sort = new Sort();

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(15);
        list.add(30);
        list.add(2);
        list.add(100);
        list.add(1);
        list.add(30);

        sort.quickSort(list);
        System.out.println(list);
    }

    @Test
    public void mergeSort() {
        Sort sort = new Sort();

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(15);
        list.add(30);
        list.add(2);
        list.add(100);
        list.add(1);
        list.add(30);

        System.out.println(sort.mergeSort(list));
    }
    @Test
    public void countingSort() {
        Sort sort = new Sort();

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(15);
        list.add(30);
        list.add(2);
        list.add(100);
        list.add(1);
        list.add(30);

        Integer[] ints = sort.countingSort(list);

        for (int i = 0; i < ints.length; i++) {
            System.out.println("result:"+ints[i]);
        }
    }


    @Test
    public void main() {
    }



    @Test
    public void heapSort() {
        Sort sort = new Sort();

        int[] ints = {3,15,30,2,100,1,999,25};

        sort.heapSort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println("result:"+ints[i]);
        }
    }

    @Test
    public void bobbleSort() {
        Sort sort = new Sort();

        int[] ints = {3,15,30,2,100,1,999,25};

        sort.bobbleSort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println("result:"+ints[i]);
        }
    }
    @Test
    public void insertionSort() {
        Sort sort = new Sort();

        int[] ints = {3,15,30,2,100,1,999,25};

        sort.insertionSort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println("result:"+ints[i]);
        }
    }






}
