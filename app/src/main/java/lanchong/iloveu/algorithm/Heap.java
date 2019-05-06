package lanchong.iloveu.algorithm;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 合并两个二叉堆
 * * 最优方法是把两个二叉堆首尾相连放在一个数组中，再建堆。时间复杂度为O(log<sub>2</sub>(n+k))，其中n、k为两个堆的元素数目
 * * 如果经常需要合并两个堆的操作，那么使用二项式堆更好，其时间复杂度为logn
 */
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


    /**
     * 23 合并K个排序链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Math.max(lists.length, 10), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        ListNode result = null;
        ListNode curr = null;
        while (!heap.isEmpty()) {
            ListNode poll = heap.poll();
            if (poll.next != null) {
                heap.offer(poll.next);
            }
            if (result == null) {
                result = poll;
                curr = result;
            }else {
                curr.next = poll;
                curr = poll;
            }
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 215. 数组中的第K个最大元素
     */
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//
//
//
//    }

}
