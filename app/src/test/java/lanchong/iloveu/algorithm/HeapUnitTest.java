package lanchong.iloveu.algorithm;


import org.junit.Test;

public class HeapUnitTest {

    @Test
    public void findMedianSortedArrays() {
        Heap s = new Heap();

//        int[] num1 = {1, 2, 3};
//        int[] num2 = {4, 5};
        int[] num1 = {1, 3};
        int[] num2 = {2};
        double medianSortedArrays = s.findMedianSortedArrays(num1, num2);
        System.out.println("result:" + medianSortedArrays);
    }


}
