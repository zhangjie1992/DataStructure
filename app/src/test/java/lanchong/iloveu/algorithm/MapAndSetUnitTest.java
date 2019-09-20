package lanchong.iloveu.algorithm;


import org.junit.Test;

public class MapAndSetUnitTest {

    @Test
    public void threeSum() {
        MapAndSet s = new MapAndSet();
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0,0,0,0};
        System.out.println("result:" + s.threeSum(nums));
    }
    @Test
    public void isAnagram() {
        MapAndSet s = new MapAndSet();
        System.out.println("result:" + s.isAnagram("a","ba"));
    }

    @Test
    public void groupAnagrams() {
        MapAndSet s = new MapAndSet();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("result:" + s.groupAnagrams(strs));


//    输出:
//            [
//            ["ate","eat","tea"],
//            ["nat","tan"],
//            ["bat"]
//            ]
    }

}
