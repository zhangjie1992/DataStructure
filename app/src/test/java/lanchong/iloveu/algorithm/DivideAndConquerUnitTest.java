package lanchong.iloveu.algorithm;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DivideAndConquerUnitTest {


    @Test
    public void pow() {
        DivideAndConquer s = new DivideAndConquer();
        s.pow(1, 2);

        System.out.println("result:" + s.pow(2, 2));
        System.out.println("result:" + s.pow(-2, 2));
        System.out.println("result:" + s.pow(2, -2));
        System.out.println("result:" + s.pow(0, -2));
        System.out.println("result:" + s.pow(0, 0));
        System.out.println("result:" + s.pow(2, 0));
        System.out.println("result:" + s.pow(5, 5));
        System.out.println("result:" + s.pow(5, 6));
        System.out.println("result:" + s.pow(2, 10));


        System.out.println("----------------------");
        System.out.println("result:" + (int) Math.pow(2, 2));
        System.out.println("result:" + (int) Math.pow(-2, 2));
        System.out.println("result:" + (int) Math.pow(2, -2));
        System.out.println("result:" + (int) Math.pow(0, -2));
        System.out.println("result:" + (int) Math.pow(0, 0));
        System.out.println("result:" + (int) Math.pow(2, 0));
        System.out.println("result:" + (int) Math.pow(5, 5));
        System.out.println("result:" + (int) Math.pow(5, 6));
        System.out.println("result:" + (int) Math.pow(2, 10));

    }

    @Test
    public void fib() {
        DivideAndConquer s = new DivideAndConquer();
        System.out.println("result:" + s.fib(0));
        System.out.println("result:" + s.fib(1));
        System.out.println("result:" + s.fib(2));
        System.out.println("result:" + s.fib(3));
        System.out.println("result:" + s.fib(4));
        System.out.println("result:" + s.fib(5));
        System.out.println("result:" + s.fib(6));
    }


    @Test
    public void findK() {
        DivideAndConquer s = new DivideAndConquer();
        int[] nums = {0, 5, 7, 4, 2};
//        int[] nums = {0,1,2,3,4,5};
        System.out.println("result:" + s.findK(nums, 0));
        System.out.println("result:" + s.findK(nums, 1));
        System.out.println("result:" + s.findK(nums, 2));
        System.out.println("result:" + s.findK(nums, 3));
        System.out.println("result:" + s.findK(nums, 4));
        System.out.println("result:" + s.findK(nums, 5));
    }

    /**
     * 计算逆序对
     */
    @Test
    public void test6() {
        DivideAndConquer s = new DivideAndConquer();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println("result:" + s.test6(list));
    }
    @Test
    public void test7(){
        DivideAndConquer s = new DivideAndConquer();
        int[] nums1 = {1,2,3,5};
        int[] nums2 = {1,2,3,4,5};
//        int[] nums2 = {1,2,3,5,6};
        System.out.println("result:" + s.test7(nums1,nums2));

    }




}
