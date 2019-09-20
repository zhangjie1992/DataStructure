package lanchong.iloveu.algorithm;


import org.junit.Test;

public class LinkageUnitTest {


    @Test
    public void majorityElement() {
        Linkage.ListNode listNode = new Linkage.ListNode(1);
        System.out.print("result:" + new Linkage().hasCycle(listNode));
    }

    @Test
    public void mergeKLists() {
        Linkage.ListNode[] array = new Linkage.ListNode[2];

        System.out.print("result:" + new Linkage().mergeKLists(array));
    }













}
