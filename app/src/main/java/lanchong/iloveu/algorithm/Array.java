package lanchong.iloveu.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Array {

    /**
     * 打印九宫图
     * N宫图，横竖斜的数字相加的大小相等
     */
    public int[][] magic_square(int n) {
        int[][] matrix = new int[n][n];

        int row = n - 2;
        int col = (n - 1) / 2 - 1;

        for (int i = 1; i <= Math.pow(n, 2); i++) {
            row++;
            col++;

            if (row >= n && col >= n) {
                //只处理右下角回到上一位的头上
                row = n - 2;
                col = n - 1;
            } else if (row == 1 && col >= n) {
                //只处理右上角
                row = 0;
                col = 0;
            }
            //行越界 回第一行
            if (row >= n) {
                row = 0;
            }
            //列越界 回第一列
            if (col >= n) {
                col = 0;
            }
            //如果已存在又回到自己的头上
            if (matrix[row][col] != 0) {
                row--;
                row--;
                col--;
            }
            matrix[row][col] = i;
        }
        return matrix;

    }

    /**
     * 九宫格 未写完
     * 使用int和位运算 值得学习
     */
    public void square() {
        int[] matrix = {5, 3, 4, 6, 7, 8, 9, 1, 2};
        if (matrix.length != 9) {
//            false 不是9位肯定不是
        }
        int tmp = 0;
        for (int i = 0; i < matrix.length; i++) {
            tmp = tmp + (1 << i);
        }

        //判断方式1  0xF=15=1111b
        if (tmp == 0x1FF) {
            //实际上只要是 0x1FF 就是二进制000...111111111
            System.out.print("tmp:" + tmp + " 0xFF" + 0x1FF);
        }

        //判断方式2
        boolean b = true;
        for (int i = 0; i < 9; i++) {
            //用 & and运算符来判断
            if ((tmp & (1 << i)) == 0) {
                b = false;
                break;
            }
        }
        System.out.print("tmp:" + tmp + " b:" + b);
    }


    /**
     * 验证数独
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9) {
            return false;
        }
        for (int i = 0; i < 9; i++) {
            int tmp = 0;
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value >= 49 && (tmp & (1 << (value - 49))) != 0) {
                    return false;
                }
                tmp = tmp + (1 << (value - 49));
            }
        }
        for (int i = 0; i < 9; i++) {
            int tmp = 0;
            for (int j = 0; j < 9; j++) {
                int value = board[j][i];
                if (value >= 49 && (tmp & (1 << (value - 49))) != 0) {
                    return false;
                }
                tmp = tmp + (1 << (value - 49));
            }
        }
        for (int i = 0; i <= 6; i = i + 3) {
            for (int j = 0; j <= 6; j = j + 3) {
                int xi = 0;
                int tmp = 0;
                while (xi <= 2) {
                    int xj = 0;
                    while (xj <= 2) {
                        char value = board[i + xi][j + xj];
                        if (value >= 49 && (tmp & (1 << (value - 49))) != 0) {
                            return false;
                        }
                        tmp = tmp + (1 << (value - 49));
                        xj++;
                    }
                    xi++;
                }
            }
        }
        return true;
    }

    /**
     * 1. 两数之和
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                int[] ret = new int[2];
                ret[0] = i;
                ret[1] = map.get(key);
                return ret;
            }
            map.put(nums[i], i);
        }
        return null;
    }


    /**
     * 15. 三数之和
     * 是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 注意：答案中不可以包含重复的三元组。
     * [-2,0,0,2,2]
     * 0 1 2 3 4
     */
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        HashSet<Integer> lSet = new HashSet<>();
        HashSet<Integer> rUsed = new HashSet<>();
        for (int i = 1; i < nums.length-1; i++) {
            int l = nums[i - 1];
            lSet.add(l);
            int curr = nums[i];

            if (i > 1 && curr == nums[i - 2]) {
                continue;
            }
            if (curr != l) {
                rUsed.clear();
            }
            for (int j = i+1; j < nums.length; j++) {
                int r = nums[j];
                if (rUsed.contains(r)){
                    continue;
                }
                int key = -(curr+r);
                if (lSet.contains(key)){
                    rUsed.add(r);

                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(key);
                    list.add(curr);
                    list.add(r);
                    result.add(list);
                }
            }
        }
        return result;
    }

    /**
     * 169. 求众数
     */
    public int majorityElement(int[] nums) {
        int curr = nums[0];
        int count = 0;
        for (int i : nums) {
            if (curr==i){
                count++;
            }else {
                if (count==0){
                    curr = i;
                    count++;
                }else {
                    count--;
                }
            }
        }
        return curr;
    }



}
