package lanchong.iloveu.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class Linkage {

    /**
     * 141. 环形链表
     */
    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 21. 合并两个有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1!=null){
            curr.next = l1;
        }else {
            curr.next = l2;
        }
        return head.next;
    }


    /**
     * 23. 合并K个排序链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0){
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        while (!heap.isEmpty()){
            ListNode poll = heap.poll();
            if (poll.next!=null){
                heap.add(poll.next);
            }
            curr.next = poll;
            curr = curr.next;
        }
        return head.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}
