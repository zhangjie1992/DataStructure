package lanchong.iloveu.algorithm;

import java.util.LinkedList;

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
    public int findPeak(int[] nums) {


        return -1;
    }

    /**
     * 习题3，查找中值/查找第K小个元素(下标为K) 条件未排序无重复 partition(分区)算法：快排中也用过
     */
    public int findK(int[] nums, int K) {
        if (K < 0 || nums == null || nums.length == 0 || K > nums.length - 1) {
            return -1;
        }
        return partition(nums, 0, nums.length - 1, K);
    }

    private int partition(int[] nums, int start, int end, int K) {
        if (start >= end) {
            if (start == K) {
                return nums[start];
            }
            return -1;
        }
        processPivot(nums, start, end);
        int pivotValue = nums[start];

        int l = start + 1;
        int r = end;
        while (true) {// 0 2 5 l=1 r=2 //l=1 r=1
            while (r >= start + 1 && nums[r] > pivotValue) {
                // nums[r] > pivotValue 是肯定成立的
                r--;
            }
            while (r > l && l <= end && nums[l] < pivotValue) {
                l++;
            }
            if (r > l) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
            } else if (r <= l) {
                if (r == K)
                    return nums[start];

                nums[start] = nums[r];
                nums[r] = pivotValue;
                break;
            }
        }
        int result = partition(nums, start, start - 1, K);
        if (result == -1) {
            result = partition(nums, start + 1, end, K);
        }
        return result;
    }

    /**
     * 取最左边，最右边及中间的数值，并将其排序
     */
    private void processPivot(int[] nums, int l, int r) {
        int lValue = nums[l];
        int rValue = nums[r];
        if (l + 1 == r) {
            nums[l] = Math.min(lValue, rValue);
            nums[r] = Math.max(lValue, rValue);
            return;
        }

        int mid = l + ((r - l) >> 1);
        int mValue = nums[mid];

        int max = Math.max(Math.max(lValue, rValue), mValue);
        int min = Math.min(Math.min(lValue, rValue), mValue);

        nums[l] = min;
        nums[r] = max;
        if (lValue != max && lValue != min) {
            nums[mid] = lValue;
        } else if (rValue != max && rValue != min) {
            nums[mid] = rValue;
        }
    }

    /**
     * 习题4，两数组的交集
     * 条件未排序
     * 给2个大小不一的数组，找出这两个数组的交集
     * 输出中不能有重复
     * [1,2,2,1] [2,2] return [2]
     * <p>
     * 根据大小不一设计不同的算法
     * 1.使用set
     * 2.sort + binarySearch解法排序大的
     * 3.sort + two points排序后双指针
     */
    public int test2() {


        return -1;
    }


    /**
     * 习题5，两数组的交集
     * 输出中有重复数据
     */
    public int test3() {

        return -1;

    }


    /**
     * 703. 数据流中的第K大元素
     */
    public static class KthLargest {
        int k;
        LinkedList<Integer> mList;
        int min = Integer.MIN_VALUE;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            mList = new LinkedList<>();

            for (int i : nums) {
                if (mList.size() < k || i > min) {
                    boolean b = true;
                    for (int j = 0; j < mList.size(); j++) {
                        Integer jValue = mList.get(j);
                        if (jValue >= i) {
                            mList.add(j, i);
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        mList.addFirst(i);
                    }
                    if (mList.size() > k) {
                        mList.removeFirst();
                    }
                    min = mList.getFirst();
                }
            }
        }

        public int add(int val) {
            if (val > min) {
                for (int j = 0; j < mList.size(); j++) {
                    Integer jValue = mList.get(j);
                    if (jValue >= val) {
                        mList.add(j, val);
                        break;
                    }
                }
                if (mList.size() > k) {
                    mList.removeFirst();
                }
                min = mList.getFirst();
            }

            return min;
        }
    }


}
