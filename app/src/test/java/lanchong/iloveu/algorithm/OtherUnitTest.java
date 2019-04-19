package lanchong.iloveu.algorithm;


import org.junit.Test;

public class OtherUnitTest {


    @Test
    public void deleteDuplicates() {
        Other s = new Other();
        //1->2->3->3->4->4->5
        Other.ListNode head = new Other.ListNode(1);
        Other.ListNode tmp = head;
        tmp.next = new Other.ListNode(1);
        tmp = tmp.next;
        tmp.next = new Other.ListNode(2);
        tmp = tmp.next;
        tmp.next = new Other.ListNode(2);
        tmp = tmp.next;
        tmp.next = new Other.ListNode(3);
        tmp = tmp.next;
        tmp.next = new Other.ListNode(3);
        tmp = tmp.next;
        tmp.next = new Other.ListNode(4);
        tmp = tmp.next;
        tmp.next = new Other.ListNode(4);
        tmp = tmp.next;
        tmp.next = new Other.ListNode(4);
        tmp = tmp.next;
        // tmp.next =  new ListNode(5);
        // tmp = tmp.next;
        tmp.next = new Other.ListNode(5);

        head = s.deleteDuplicates(head);
        Other.ListNode curr = head;
        while (curr != null) {
            System.out.println("result:" + curr.val);
            curr = curr.next;
        }
    }

    @Test
    public void permuteUnique() {
        Other s = new Other();
        int[] nums = {2, 2, 1, 1};

        System.out.println(s.permuteUnique(nums));
    }

    @Test
    public void rotate() {
        Other s = new Other();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 1;
        s.rotate(nums, k);

        for (int i : nums) {
            System.out.println("result:" + i);
        }
    }

    @Test
    public void rotateString() {
        Other s = new Other();
//        String A = "abcde";
//        String B = "cdeab";
//        String A = "abcda";
//        String B = "acdab";
//        String A = "";
//        String B = "";


        String A = "bbbacddceeb";
        String B = "ceebbbbacdd";

//        String A = "bbab";
//        String B = "babb";


        System.out.println("result:" + s.rotateString(A, B));
    }


}
