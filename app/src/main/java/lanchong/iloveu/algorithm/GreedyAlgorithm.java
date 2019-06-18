package lanchong.iloveu.algorithm;

import android.text.TextUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法
 */
public class GreedyAlgorithm {


    int ret = 0;

    /**
     * 122. 买卖股票的最佳时机 II
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (isBtm(i, prices)) {
                //买在低点
                i++;
                //卖在高点
                i = saleOnTop(i, prices, price);
            }
        }
        return ret;
    }

    private boolean isBtm(int i, int[] prices) {
        if (i == 0) {
            return prices[1] > prices[0];
        } else if (i == prices.length - 1) {
            return false;
        } else {
            return prices[i] < prices[i + 1];
        }
    }

    private int saleOnTop(int i, int[] prices, int price) {
        while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
            i++;
        }
        ret += prices[i] - price;
        return i;
    }


    /**
     * 455. 分发饼干
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, gi = g[i], ret = 0;
        for (int j = 0; j < s.length; j++) {
            int sj = s[j];
            if (sj >= gi) {
                ret++;
                i++;
                if (i >= g.length) {
                    return ret;
                }
                gi = g[i];
            }
        }
        return ret;
    }


    /**
     * 134. 加油站
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ret = -1;
        int remain = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if (remain >= 0) {
                if (ret == -1) {
                    ret = i;
                }
            } else {
                ret = -1;
                remain = 0;
            }
        }
        for (int i = 0; i < ret; i++) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                return -1;
            }
        }
        return ret;
    }


    /**
     * 435. 无重叠区间
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;

        //根据左排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int ret = 0;
        int prevR = intervals[0][1];
        int[] interval;
        for (int i = 1; i < intervals.length; i++) {
            interval = intervals[i];
            int r = interval[1];
            if (interval[0] >= prevR) {
                //无重叠
                prevR = interval[1];
                continue;
            }

            //有重叠需要删除src或tar
            ret++;
            if (prevR > r) {
                //选中src
                prevR = r;
            }
        }
        return ret;
    }


    /**
     * 649. Dota2 参议院
     * DDRRRR
     */
    public String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        char r = 'R';
        char d = 'D';
        int idx = 0;

        while (true) {
            char aChar = chars[idx];
            if (aChar != 0) {
                char target = aChar == r ? d : r;
                if (!find(chars, target, idx)) return aChar == r ? "Radiant" : "Dire";
            }

            idx++;
            if (idx >= chars.length) {
                idx -= chars.length;
            }
        }
    }

    private boolean find(char[] chars, char target, int idx) {
        for (int i, j = idx + 1; j < chars.length + idx + 1; j++) {
            if (j >= chars.length) {
                i = j - chars.length;
            } else {
                i = j;
            }
            if (chars[i] == target) {
                chars[i] = 0;
                return true;
            }
        }
        return false;
    }


    /**
     * 402. 移掉K位数字
     */
    public String removeKdigits(String num, int k) {
        if (num.isEmpty()) return "0";
        if (k <= 0) return num;
        if (num.length() <= k) return "0";

        //0前面数的个数
        int indexOf = num.indexOf("0");
        if (indexOf != -1 && k >= indexOf) {
            k -= indexOf;
            num = num.substring(indexOf + 1);
            while (num.startsWith("0")) {
                num = num.substring(1);
            }
            return removeKdigits(num, k);
        } else {
            while (k > 0) {
                char[] chars = num.toCharArray();
                int top = getTop(chars);
                num = num.substring(0, top) + num.substring(top + 1);
                k--;
            }
            return num;
        }
    }

    private int getTop(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] > chars[i + 1]) {
                return i;
            }
        }
        return chars.length - 1;
    }


    /**
     * 55. 跳跃游戏
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        return canJump(nums, 0);
    }

    private boolean canJump(int[] nums, int start) {
        int length = nums[start];
        if (length == 0) return false;

        int max = 0;
        int nextStart = 0;
        for (int i = 1; i <= length; i++) {
            int next = start + i;
            if (next >= nums.length - 1) return true;

            int nextFar = nums[next] + next;
            if (nextFar>max) {
                max = nextFar;
                nextStart = next;
            }
        }
        return canJump(nums, nextStart);
    }


}
