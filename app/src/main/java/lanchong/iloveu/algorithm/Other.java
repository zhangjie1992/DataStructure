package lanchong.iloveu.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Other {


    /**
     * 寻找丢失的数字
     */
    public static int find2(int[] arr) {
        int result = 0;
        for (int i = 2; i <= arr.length - 1; i++) {
            result = result ^ i;
        }
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;
    }

    /**
     * 寻找丢失的两个数
     */
    public int find(int n, int[] arr) {
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            temp = temp ^ i;
        }
        for (int i = 0; i < arr.length; i++) {
            temp = temp ^ arr[i];
        }

        int temp2 = temp;
        int first_not_zero = 0;
        /*找出异或和的最低1的位数*/
        while ((temp2 & 1) == 0) {
            first_not_zero++;
            temp2 = temp2 >> 1;
        }

        int lost2 = 0;
        for (int i = 1; i <= n; i++) {
            if (((i >> first_not_zero) & 1) == 0) lost2 = lost2 ^ i;
        }
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            if (((value >> first_not_zero) & 1) == 0) lost2 = lost2 ^ value;
        }

        int lost1 = lost2 ^ temp;

        return lost2;
    }


    /**
     * 82. 删除排序链表中的重复元素 II
     * 112233445
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        int i = 0;
        while (head.next != null && head.val == head.next.val) {
            head = head.next;
            i++;
        }
        if (i == 0) {
            head.next = deleteDuplicates(head.next);
            return head;
        }
        return deleteDuplicates(head.next);
    }


    /**
     * nums存在可能重复的数
     * 全排列II
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        used = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUnique(nums, 0, result, new ArrayList<Integer>());

        return result;
    }

    private boolean[] used;

    private void permuteUnique(int[] nums, int start, List<List<Integer>> result, List<Integer> list) {
        if (nums.length == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i]) continue;

            if (i != 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;

            used[i] = true;
            list.add(nums[i]);
            permuteUnique(nums, start, result, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }


    /**
     * 189. 旋转数组
     * 实现旋转数组
     * swap3次就ok啦
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k = k % nums.length;

        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }

    private void swap(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }


    /**
     * 123
     * 231
     * <p>
     * ab cde
     * cdeab cdeab
     * <p>
     * bbab
     * babb
     */
    public boolean rotateString(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) return false;
        if (A.length()==0)return true;

        char[] aChars = A.toCharArray();
        char[] bChars = B.toCharArray();

        int count = 0;
        int firstOffset = 0;
        for (int i = 0; i < aChars.length; i++) {
            char ai = aChars[i];
            for (; firstOffset < bChars.length; firstOffset++) {
                int j = (i + firstOffset) % bChars.length;
                char bj = bChars[j];
                if (ai == bj) {
                    count++;
                    if (count == aChars.length) return true;
                    break;
                } else if (i != 0) {
                    //只能相同
                    i = -1;
                    firstOffset++;
                    count = 0;
                    break;
                }
            }
        }

        return false;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
