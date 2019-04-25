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


}
