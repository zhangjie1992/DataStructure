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

        while (node!=null){
            System.out.println("result:" + node.val);
            node=node.next;
        }

    }


}
