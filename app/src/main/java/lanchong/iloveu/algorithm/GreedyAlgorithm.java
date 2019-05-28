package lanchong.iloveu.algorithm;

import java.util.Arrays;

/**
 * 贪心算法
 */
public class GreedyAlgorithm {



    int ret = 0;

    /**
     * 122. 买卖股票的最佳时机 II
     */
    public int maxProfit(int[] prices) {
        if (prices==null||prices.length<=1) return 0;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (isBtm(i,prices)){
                //买在低点
                i++;
                //卖在高点
                i = saleOnTop(i,prices,price);
            }
        }
        return ret;
    }

    private boolean isBtm(int i,int[] prices){
        if (i==0){
            return prices[1] > prices[0];
        }else if (i==prices.length-1){
            return false;
        }else {
            return prices[i] < prices[i + 1];
        }
    }

    private int saleOnTop(int i, int[] prices, int price) {
        while (i<prices.length-1&&prices[i] < prices[i + 1]){
            i++;
        }
        ret+=prices[i]-price;
        return i;
    }



    /**
     * 455. 分发饼干
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0,gi = g[i],ret = 0;
        for (int j = 0; j < s.length; j++) {
            int sj = s[j];
            if (sj>=gi){
                ret++;
                i++;
                if (i>=g.length){
                    return ret;
                }
                gi = g[i];
            }
        }
        return ret;
    }


    /**
     * 134. 加油站
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ret = -1;
        int remain = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += gas[i]-cost[i];
            if (remain>=0){
                if (ret==-1){
                    ret = i;
                }
            }else {
                ret = -1;
                remain = 0;
            }
        }
        for (int i = 0; i < ret; i++) {
            remain += gas[i]-cost[i];
            if (remain<0){
                return -1;
            }
        }
        return ret;
    }







}
