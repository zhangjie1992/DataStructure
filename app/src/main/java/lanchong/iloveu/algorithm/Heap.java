package lanchong.iloveu.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {


    /**
     * 4. 寻找两个有序数组的中位数
     * lStack大顶堆
     * rStack小顶堆
     * 奇数时 lStack的长度是n/2+1 中位数就在lStack
     * rStack的长度是n/2
     * 偶数时 lStack的长度是n/2
     * rStack的长度是n/2
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums1.length == 1 ? nums1[0] : nums2[0];
        }
        boolean odd = (n & 1) == 1;

        PriorityQueue<Integer> lHeap = new PriorityQueue<>(n / 2 + 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> rHeap = new PriorityQueue<>(n / 2);

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                i = addNum(n, odd, lHeap, rHeap, i, nums1[i]);
            } else {
                j = addNum(n, odd, lHeap, rHeap, j, nums2[j]);
            }
        }

        while (i < nums1.length) {
            i = addNum(n, odd, lHeap, rHeap, i, nums1[i]);
        }
        while (j < nums2.length) {
            j = addNum(n, odd, lHeap, rHeap, j, nums2[j]);
        }

        if (odd) {
            return lHeap.peek();
        } else {
            return (lHeap.peek() + 0d) / 2 + (rHeap.peek() + 0d) / 2;
        }
    }
    private int addNum(int n, boolean odd, PriorityQueue<Integer> lHeap, PriorityQueue<Integer> rHeap, int i, int min) {
        if (odd) {
            if (lHeap.size() < n / 2 + 1) {
                lHeap.offer(min);
            } else {
                rHeap.offer(min);
            }
        } else {
            if (lHeap.size() < n / 2) {
                lHeap.offer(min);
            } else {
                rHeap.offer(min);
            }
        }
        i++;
        return i;
    }


}
