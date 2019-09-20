package lanchong.iloveu.algorithm;


import org.junit.Test;

import java.util.ArrayList;

public class DynamicProgrammingUnitTest {


    /**
     * 0-1背包 动态规划解法
     */
    @Test
    public void package01() {
        DynamicProgramming s = new DynamicProgramming();
        int[] arr = {2,2,6,5,9};
//        int[] arr = {15,2,6,5,9};
        System.out.println("result:" + s.package01(10,arr));

    }


    @Test
    public void shopping() {
        DynamicProgramming s = new DynamicProgramming();
        int[] arr = {50,38,120,90,10,5};
        System.out.println("result:" + s.shopping(200,arr));
    }


    @Test
    public void yh() {
        DynamicProgramming s = new DynamicProgramming();
        int[][] w = new int[5][];
        int[] row1= {5};
        int[] row2= {7,8};
        int[] row3= {2,3,4};
        int[] row4= {4,9,6,1};
        int[] row5= {2,7,9,4,5};
        w[0]=row1;
        w[1]=row2;
        w[2]=row3;
        w[3]=row4;
        w[4]=row5;

        System.out.println("result:" + s.yh(w));
    }

}