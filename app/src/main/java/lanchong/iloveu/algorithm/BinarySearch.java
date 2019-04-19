package lanchong.iloveu.algorithm;



//习题9 供暖设备 1.5节课
//  heaters进行排序 找房子左右heaters，保留最小的   对全部取最大的
//  并不是二分查找法


//习题11-14 该做 矩阵搜索
//习题15,16 该做 很难 合并区间 :  1、找到两个有序书中的中值（相同大小）  2、找到两个有序数组的中值
/**
 * 二分查找及变种
 * sqrt 二分法 倍增法   很多解不了的数学题都可以使用这种方式
 *
 * 之前计算mid使用 (r+l)>>1 。实际上会出现超出int范围的问题
 *
 */
public class BinarySearch {

    /**
     * 常用模板
     */
    public int binarySearchTemp(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l + 1 < r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }

    /**
     * 范围搜索
     */
    private int range(int[] nums, int l, int r, int target) {
        if (nums == null || nums.length <= 0) return -1;
        if (l > r || r >= nums.length || l < 0) return -1;
        int mid;
        while (l + 1 < r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }

    /**
     * 搜索第一个
     */
    public int searchFrist(int[] nums, int target, int l, int r) {
        int mid;
        while (l + 1 < r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid;
            }
        }
        return (nums[l] == target) ? l : r;
    }

    /**
     * 搜索最后一个
     */
    public int searchLast(int[] nums, int target, int l, int r) {
        int mid;
        while (l + 1 < r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                l = mid;
            } else if (nums[mid] > target) {
                r = mid;
            }
        }
        return (nums[r] == target) ? r : l;
    }
    /**
     * ##########################################
     */


    /**
     * 33. 搜索旋转排序数组
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l + 1 < r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (isInl(nums, l, mid, r, target)) {
                    r = mid;
                } else {
                    l = mid;
                }
            } else {
                if (isInr(nums, l, mid, r, target)) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
        }
        if (nums[l] == target) {
            return l;
        }
        if (nums[r] == target) {
            return r;
        }
        return -1;
    }

    private boolean isInl(int[] nums, int l, int mid, int r, int target) {
        if (nums[r] > nums[mid]) {
            return true;
        }
        return target >= nums[l];
    }

    private boolean isInr(int[] nums, int l, int mid, int r, int target) {
        if (nums[l] < nums[mid]) {
            return true;
        }
        return target <= nums[r];
    }


    /**
     * LeetCode 34. 在排序数组中查找元素的第一个和最后一个位置
     * 习题6，搜索一个区间 排好序的数组,有重复数据
     * 解法，先找到存在,再找第一个，再找最后一个
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums==null||nums.length==0)return result;
        int l = 0;
        int r = nums.length-1;
        int mid = 0 ;
        while(l+1<r){
            mid = l+((r-l)>>1);
            if (nums[mid]==target) {
                break;
            }else if (nums[mid]<target) {
                l = mid;
            }else{
                r = mid;
            }
        }
        if (nums[mid]==target) {
            result[0] = searchFrist(nums,target,l,mid);
            result[1] = searchLast(nums,target,mid,r);
        }else{
            if (nums[l]==target){
                result[0] = l;
                result[1] = l;
            }else if(nums[r]==target){
                result[0] = r;
                result[1] = r;
            }
        }
        return result;
    }


    //习题7，在用空字符串隔开的字符串的有序列中查找    1  2  3  4  里找2
    //O(n) 没法优化 直接用api就行

    /**
     * 习题8，在无限序列中找到某元素的第一个出现位置  数据流,排好序的,不知道序列长度
     * 倍增法
     * l是第一位 l,r是动态的 第一次下标为1 第二次下标为l=r+1 r=r*2
     */
    public int infiniteSearch(int[] infinite, int target) {
        if (infinite == null || infinite.length <= 0) return -1;

        int l = 0;
        int r = 1;
        int result = -1;
        while (r < infinite.length) {
            if (infinite[r] < target) {
                l = r;
                r = r * 2;
                continue;
            }
            result = range(infinite, l, r, target);
            break;
        }
        if (r >= infinite.length) {
            result = range(infinite, l, infinite.length - 1, target);
        }

        if (result != -1) {
            return searchFrist(infinite, l, result, target);
        }
        return -1;
    }





    /**
     * LeetCode 69 x的平方根
     * 使用二分法 倍增法
     * 很多数学问题都可以使用倍增法
     * 注意int的最大值
     */
    public int mySqrt(int x) {
        int l = 0;
        int r = 1;
        while (r <= 46340 && (int) Math.pow(r, 2) < x) {
            l = r;
            r = r * 2;
        }
        r = Math.min(r, 46340);

        int mid;
        while (l + 1 < r) {
            mid = (r + l) / 2;
            int pow = (int) Math.pow(mid, 2);
            if (pow == x) {
                return mid;
            } else if (pow < x) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if ((int) Math.pow(r, 2) <= x) {
            return r;
        }
        return l;
    }

    /**
     * 153. 寻找旋转排序数组中的最小值
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length <= 0) return -1;

        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + ((r - l) >> 1);
            int value = nums[mid];
            if (value > nums[l]) {
                if (value > nums[r]) {
                    l = mid;
                } else {
                    r = mid;
                }
            } else {
                if (value < nums[r]) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
        }
        return Math.min(nums[l], nums[r]);
    }


    /**
     * 习题11 矩阵搜索
     * 矩阵的行与列都排好序了
     * <p>
     * 1 5  10 11
     * 6 9  15 17
     * 7 12 16 20
     */
    public int matrixSearch(int[][] matrix, int target) {

        return -1;
    }


}
