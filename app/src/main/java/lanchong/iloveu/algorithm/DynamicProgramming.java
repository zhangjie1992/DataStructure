package lanchong.iloveu.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 动态规划
 */
public class DynamicProgramming {


    /**
     * 0-1背包 动态规划解法
     * @param capicity 背包容量(重量)
     * @param w 物品重量
     * @return
     */
    public int package01(int capicity,int[] w){
        if (capicity<=0||w==null||w.length==0){
            return 0;
        }

        boolean[] sets = new boolean[capicity+1];
        //不加第一个数据
        sets[0] = true;
        if (w[0]<=capicity){
            //加第一个数据
            sets[w[0]] = true;
        }

        for (int i = 1; i < w.length; i++) {
            int wi = w[i];
            for (int j = capicity; j >=0; j--) {
                if (sets[j]){
                    if (j+wi<=capicity){
                        //加
                        sets[j+wi] = true;
                    }
                }
            }
        }

        for (int i = capicity ; i >=0; i--) {
            if (sets[i]) return i;
        }
        return 0;
    }

    /**
     * 淘宝的“双十一”购物节有各种促销活动，比如“满 200 元减 50 元”。
     *     假设你女朋友的购物车中有 n 个想买的商品，她希望从里面选几个，在凑够满减条件的前提下，
     *     让选出来的商品价格总和最大程度地接近满减条件（200 元），这样就可以极大限度地“薅羊毛”。
     *     作为程序员的你，能不能编个代码来帮她搞定呢？
     */
    public int shopping(int capicity,int[] w){
        final int max = capicity+50;
        //可以装下0-250元商品
        boolean[] sets = new boolean[max+1];

        sets[0] = true;
        if (w[0]<=max){
            sets[w[0]] = true;
        }
        for (int i = 1; i < w.length; i++) {
            int wi = w[i];
            for (int j = max; j >=0 ; j--) {
                if (sets[j]&&j+wi<=max){
                    sets[j+wi] = true;
                }
            }
        }
        for (int i = 200 ; i <=max; i++) {
            if (sets[i]) return i;
        }
        return 0;
    }


    /**
     * 杨辉三角变体问题
     *  00
     *  10 11
     *  20 21- 22
     *  30 31- 32- 33
     *
     *  int[] row1= {5};
     *  int[] row2= {7,8};
     *  int[] row3= {2,3,4};
     *  int[] row4= {4,9,6,1};
     *  int[] row5= {2,7,9,4,5};
     */
    public int yh(int[][] w){
        int[][] sets = new int[w.length][w.length];

        sets[0][0] = w[0][0];
        //填充每行的首列
        for (int row = 1; row < w.length; row++) {
            sets[row][0] = w[row][0]+sets[row-1][0];
        }
        //填充每行的最后一列
        for (int row = 1; row < w.length; row++) {
            sets[row][row] = w[row][row]+sets[row-1][row-1];
        }

        for (int row = 2; row < w.length; row++) {
            for (int col = 1; col < row; col++) {
                sets[row][col] = w[row][col]+Math.min(sets[row-1][col-1],sets[row-1][col]);
            }
        }

        int ret = Integer.MAX_VALUE;

        for (int i = 0; i < w.length; i++) {
            ret = Math.min(ret,sets[sets.length-1][i]);
        }
        return ret;
    }










    /**
     * 斐波那契数列 自頂而下
     * 1 1 2 3 5 8
     */
    public int fibFromTop(int n) {
        if (n <= 1) {
            return 1;
        }
        return fibFromTop(n - 1) + fibFromTop(n - 2);
    }

    /**
     * 斐波那契数列 自底而上
     */
    public int fibFromBtm(int n) {
        int prev = 1;
        int prevv = 1;

        int fibI = 1;
        for (int i = 2; i <= n; i++) {
            fibI = prev + prevv;
            prevv = prev;
            prev = fibI;
        }
        return fibI;
    }


}
