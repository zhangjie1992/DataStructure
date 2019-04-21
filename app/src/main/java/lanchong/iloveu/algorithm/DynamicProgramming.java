package lanchong.iloveu.algorithm;

/**
 * 动态规划
 */
public class DynamicProgramming {

    //斐波那契数列 自頂而下
    //

    /**
     * 斐波那契数列 自底而上
     * 1 1 2 3 5 8
     */
    public int fibFromTop(int n) {
        if (n <= 1) {
            return 1;
        }
        return fibFromTop(n - 1) + fibFromTop(n - 2);
    }

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
