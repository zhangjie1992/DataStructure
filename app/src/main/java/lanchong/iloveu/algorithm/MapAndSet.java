package lanchong.iloveu.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        Arrays.sort(nums);
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

    /**
     * 242. 有效的字母异位词
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }else if (s.length() == 0 && t.length() == 0) {
            return true;
        }else if (s.length() != t.length()) {
            return false;
        }

        int[] sArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sArray [c-97] += 1;
        }

        int[] tArray = new int[26];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tArray [c-97] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (sArray[i]!=tArray[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 49. 字母异位词分组
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> result = new ArrayList<>();
        HashMap<Integer,List<String>> map = new HashMap<>();
        for (String str : strs) {
            List<String> strings = map.get(str.length());
            if (strings == null) {
                strings = new ArrayList<>();
                map.put(str.length(),strings);
            }
            strings.add(str);
        }

        Set<Integer> keys = map.keySet();
        for (Integer key:keys){
            List<String> strings = map.get(key);
            if (strings.size()==1){
                result.add(strings);
            }else {
                HashMap<String,int[]> intArrayMap = new HashMap<>();
                for (; 0 < strings.size(); ) {
                    ArrayList<String> inStrs = new ArrayList<>();

                    String iStr = strings.remove(0);
                    inStrs.add(iStr);
                    int[] sArray = getIntArray(iStr);

                    for (int j = 0; j < strings.size(); j++) {
                        String jStr = strings.get(j);
                        int[] jArray = getIntArrayByMap(jStr, intArrayMap);

                        if (isAnagram(sArray,jArray)){
                            inStrs.add(jStr);

                            strings.remove(j);
                            j--;
                        }
                    }
                    result.add(inStrs);
                }
            }
        }
        return result;
    }

    private int[] getIntArrayByMap(String str,HashMap<String,int[]> map){
        int[] ints = map.get(str);
        if (ints!=null){
            return ints;
        }else {
            ints = getIntArray(str);
            map.put(str,ints);
        }
        return ints;
    }
    private int[] getIntArray(String str){
        int[] result = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result [c-97] += 1;
        }
        return result;
    }
    public boolean isAnagram(int[] sArray, int[] tArray) {
        for (int i = 0; i < 26; i++) {
            if (sArray[i]!=tArray[i]){
                return false;
            }
        }
        return true;
    }






}
