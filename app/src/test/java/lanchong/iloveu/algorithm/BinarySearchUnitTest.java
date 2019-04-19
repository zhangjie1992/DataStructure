package lanchong.iloveu.algorithm;


import org.junit.Test;

public class BinarySearchUnitTest {

    @Test
    public void binarySearchTemp() {
        BinarySearch s = new BinarySearch();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println("result:"+s.search(nums,4));
        System.out.println("result:"+s.search(nums,5));
        System.out.println("result:"+s.search(nums,6));
        System.out.println("result:"+s.search(nums,7));
        System.out.println("result:"+s.search(nums,0));
        System.out.println("result:"+s.search(nums,1));
        System.out.println("result:"+s.search(nums,2));
        System.out.println("result:"+s.search(nums,8));
        System.out.println("result:"+s.search(nums,-1));
    }


    @Test
    public void search() {
        BinarySearch s = new BinarySearch();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println("result:"+s.search(nums,4));
        System.out.println("result:"+s.search(nums,5));
        System.out.println("result:"+s.search(nums,6));
        System.out.println("result:"+s.search(nums,7));
        System.out.println("result:"+s.search(nums,0));
        System.out.println("result:"+s.search(nums,1));
        System.out.println("result:"+s.search(nums,2));
        System.out.println("result:"+s.search(nums,8));
        System.out.println("result:"+s.search(nums,-1));

//        int[] nums = {5,1,3};
//        System.out.println("result:"+s.search(nums,5));

//         int[] nums = {5,1,2,3,4};
//         System.out.println("result:"+s.search(nums,1));
    }


    @Test
    public void searchRange() {
        BinarySearch s = new BinarySearch();
        int[] nums = {1,1,1,2,2,2,3,3};
        int[] result = s.searchRange(nums,1);
        System.out.println("result:"+result[0] +"  "+result[1]);
    }

    @Test
    public void infiniteSearch() {
        BinarySearch s = new BinarySearch();
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,3,3,4,5};
        System.out.println("result:"+s.infiniteSearch(nums,1));
    }


    @Test
    public void mySqrt() {
        BinarySearch s = new BinarySearch();
        System.out.println("result:"+s.mySqrt(0));
        System.out.println("result:"+s.mySqrt(1));
        System.out.println("result:"+s.mySqrt(2));
        System.out.println("result:"+s.mySqrt(3));
        System.out.println("result:"+s.mySqrt(4));
        System.out.println("result:"+s.mySqrt(10));
        System.out.println("result:"+s.mySqrt(2147483647));
        System.out.println("--------------------");

        System.out.println("result:"+(int)Math.sqrt(0));
        System.out.println("result:"+(int)Math.sqrt(1));
        System.out.println("result:"+(int)Math.sqrt(2));
        System.out.println("result:"+(int)Math.sqrt(3));
        System.out.println("result:"+(int)Math.sqrt(4));
        System.out.println("result:"+(int)Math.sqrt(10));
        System.out.println("result:"+(int)Math.sqrt(2147483647));
    }

    @Test
    public void findMin() {
        BinarySearch s = new BinarySearch();
        int[] nums = {1,2,3};
        int[] nums2 = {1,2};
        int[] nums3 = {1,2,3,4,0};
        int[] nums4 = {4,0,1,2,3};
        int[] nums5 = {4,5,6,2,3};

        System.out.println("result:"+s.findMin(nums));
        System.out.println("result:"+s.findMin(nums2));
        System.out.println("result:"+s.findMin(nums3));
        System.out.println("result:"+s.findMin(nums4));
        System.out.println("result:"+s.findMin(nums5));
    }








}
