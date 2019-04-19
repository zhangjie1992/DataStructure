package lanchong.iloveu.algorithm;


import org.junit.Test;

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







}
