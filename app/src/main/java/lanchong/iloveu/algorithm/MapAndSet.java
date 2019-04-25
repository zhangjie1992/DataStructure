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
     *
     * 先sort后用set我的这个解法有点忙
     */
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
//        Arrays.sort(nums);
        HashSet<Integer> lSet = new HashSet<>();
        HashSet<Integer> rUsedSet = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            lSet.add(nums[i-1]);
            int iNum = nums[i];
            if (i > 1 && nums[i - 2] == iNum) {
                continue;
            }
            if (nums[i - 1] != iNum){
                rUsedSet.clear();
            }
            for (int j = i + 1; j < nums.length; j++) {
                int jNum = nums[j];
                if (rUsedSet.contains(jNum)){
                    continue;
                }
                int xNum = -(jNum + iNum);
                if (lSet.contains(xNum)) {
                    ArrayList<Integer> list = new ArrayList<>(3);
                    list.add(iNum);
                    list.add(jNum);
                    list.add(xNum);
                    result.add(list);

                    rUsedSet.add(jNum);
                }
            }

        }
        return result;
    }


}
