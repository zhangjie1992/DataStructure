package lanchong.iloveu.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MapAndSet {


    /**
     * 15. 三数之和
     * 高频题
     * 两种解法
     * 1,使用set O(N2)
     * 2,sort find 枚举a，找b，c通过两边往中间的双指针 O(N2)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums.length<3){
            return result;
        }
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> contains = new ArrayList<>();
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int iNum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                int jNum = nums[j];
                int xNum = -(jNum+iNum);
                if (set.contains(xNum)) {
                    ArrayList<Integer> list = new ArrayList<>(3);
                    list.add(iNum);
                    list.add(jNum);
                    list.add(xNum);
                    result.add(list);
                }
            }
            set.add(nums[0]);
        }
        return result;
    }


}
