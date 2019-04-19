package lanchong.iloveu.algorithm;

/**
 * 分治法
 */
public class DivideAndConquer {

    /**
     * 习题1 快速指数
     * 2的-2次方是 1/4; 为2的2次方的倒数
     * -2的2次方是 4;
     * -2的3次方是 -8；
     * <p>
     * 任何数的零次幂都等于1 (0的0次方=1是微积分)
     * 0的负N次方=0的N次方分之一 微积分结果是个无限大的值
     */
    public int pow(int a, int n) {
        if (a == 0 && n < 0) return Integer.MAX_VALUE;
        if (n == 0) return 1;
        if (a == 0) return 0;
        if (a == 1) return 1;
        int result = powRecursion(a, Math.abs(n));
        if (n < 0) result = 1 / result;
        return result;
    }

    private int powRecursion(int a, int n) {
        if (n == 1) return a;
        int pow = pow(a, n >> 1);
        return (n & 1) == 1 ? pow * pow * a : pow * pow;
    }


    /**
     * 斐波那契数列:非常完美的斐波那契数列求法
     * 使用矩阵乘法,矩阵的n次方，fib(n) = arr[0][1]
     * [1,1]
     * [1,0]
     * 来实现O(lgn)
     * <p>
     * [1*1+1*1 1*1+1*0]
     * [1*1+0*1 1*1+0*0]
     * <p>
     * 得到的答案
     * [fib(n+1),fib(n)]
     * [fib(n),fib(n-1)]
     */
    private int[][] fibMatrix = {{1, 1}, {1, 0}};

    public int fib(int n) {
        int[][] resultArr = fibRecursion(n);
        return resultArr[0][0];
    }

    private int[][] fibRecursion(int n) {
        if (n == 1 || n == 0) {
            return fibMatrix;
        }
        int[][] matrix = fibRecursion(n / 2);
        return (n & 1) == 1 ? matrixMultiply(matrixMultiply(matrix, matrix), fibMatrix) : matrixMultiply(matrix, matrix);
    }

    private int[][] matrixMultiply(int[][] matirx, int[][] matirx2) {
        return
                new int[][]
                        {
                                {
                                        matirx[0][0] * matirx2[0][0] + matirx[0][1] * matirx2[1][0], matirx[0][0] * matirx2[0][1] + matirx[0][1] * matirx2[1][1]
                                },
                                {
                                        matirx[1][0] * matirx2[0][0] + matirx[1][1] * matirx2[1][0], matirx[1][0] * matirx2[0][1] + matirx[1][1] * matirx2[1][1]
                                }
                        };
    }

    /**
     * 习题2，搜索峰值
     * 第一个和最后一个是负无从小
     */
    public int findPeak(int[] nums){

        return -1;
    }

    /**
     * 习题3，查找中值/查找第K小个元素(下标为K)
     * 条件未排序
     * partition(分区)算法：快排中也用过
     */
    public int find(int[] nums){

        return -1;
    }

    /**
     * 习题4，两数组的交集
     * 条件未排序
     * 给2个大小不一的数组，找出这两个数组的交集
     * 输出中不能有重复
     * [1,2,2,1] [2,2] return [2]
     *
     * 根据大小不一设计不同的算法
     * 1.使用set
     * 2.sort + binarySearch解法排序大的
     * 3.sort + two points排序后双指针
     *
     */
    public int test2(){

    }


    /**
     * 习题5，两数组的交集
     * 输出中有重复数据
     */
    public int test3(){


    }









}
