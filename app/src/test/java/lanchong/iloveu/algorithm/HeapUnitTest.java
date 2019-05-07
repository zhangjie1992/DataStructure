package lanchong.iloveu.algorithm;


import org.junit.Test;

public class HeapUnitTest {

    @Test
    public void findMedianSortedArrays() {
        Heap s = new Heap();

//        int[] num1 = {1, 2, 3};
//        int[] num2 = {4, 5};
        int[] num1 = {1, 3};
        int[] num2 = {2};
        double medianSortedArrays = s.findMedianSortedArrays(num1, num2);
        System.out.println("result:" + medianSortedArrays);
    }


    @Test
    public void mergeKLists() {
        Heap s = new Heap();
        Heap.ListNode node1 = new Heap.ListNode(1);

        Heap.ListNode[] list = {node1};
        Heap.ListNode node = s.mergeKLists(list);

        while (node != null) {
            System.out.println("result:" + node.val);
            node = node.next;
        }

    }

    @Test
    public void medianFinder() {
        Heap.MedianFinder obj = new Heap.MedianFinder();
        obj.addNum(1);
        System.out.println("result:" + obj.findMedian());
        obj.addNum(2);
        System.out.println("result:" + obj.findMedian());// -> 1.5
        obj.addNum(3);
        System.out.println("result:" + obj.findMedian());// -> 2
        obj.addNum(4);
        System.out.println("result:" + obj.findMedian());
        obj.addNum(5);
        System.out.println("result:" + obj.findMedian());
        obj.addNum(6);
        System.out.println("result:" + obj.findMedian());
        obj.addNum(7);
        System.out.println("result:" + obj.findMedian());
        obj.addNum(8);
        System.out.println("result:" + obj.findMedian());
        obj.addNum(9);
        System.out.println("result:" + obj.findMedian());
        obj.addNum(10);
        System.out.println("result:" + obj.findMedian());
    }


}
