package lanchong.iloveu.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 排序算法
 * <p>
 * 二叉搜索树排序
 * 堆排序
 * 煎饼排序 非常非常的有意思 1979盖茨也参与 2009冯昆吾的老师改进
 */
public class Sort {

    /**
     * 快速排序 分治法
     */
    public void quickSort(List<Integer> list) {
        quickSortRecursion(list, 0, list.size());
    }

    private void quickSortRecursion(List<Integer> list, int i, int size) {
        if (size <= 1) {
            return;
        }
        int r = partition(list, i, size);
        int lLength = r - i;
        quickSortRecursion(list, i, lLength);
        quickSortRecursion(list, r, size - lLength - 1);
    }

    private int partition(List<Integer> list, int i, int size) {
        getPivot(list, i, size - 1);
        int pivotValue = list.get(i);
        int l = i + 1,r = i + size - 1;
        while (true) {
            while (r > i && list.get(r) > pivotValue) {
                r--;
            }
            while (r > l && list.get(l) < pivotValue) {
                l++;
            }
            if (r <= l) {
                break;
            }
            Integer tmp = list.get(r);
            list.set(r, list.get(l));
            list.set(l, tmp);
        }
        if (r != i) {
            list.set(i, list.get(r));
            list.set(r, pivotValue);
        }
        return r;
    }

    private void getPivot(List<Integer> list, int lIdx, int rIdx) {
        int length = rIdx - lIdx;
        if (length <= 1) {
            return;
        }
        int mIdx = lIdx + (length >> 1);
        int l = list.get(lIdx),r = list.get(rIdx),m = list.get(mIdx);

        int max = Math.max(l, Math.max(r, m));
        int min = Math.min(l, Math.min(r, m));
        if (r <= max && r >= min) {
            list.set(lIdx, r);
            list.set(rIdx, l);
        } else if (m <= max && m >= min) {
            list.set(lIdx, m);
            list.set(mIdx, l);
        }
    }


    /**
     * 归并排序,并归排序(分治法) 使用递归
     */
    public List<Integer> mergeSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int mid = list.size() >> 1;
        List<Integer> left = list.subList(0, mid);
        List<Integer> right = list.subList(mid, list.size());
        return merge(mergeSort(left), mergeSort(right));
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        int newSize = left.size() + right.size();
        ArrayList<Integer> list = new ArrayList<>(newSize);
        int i = 0, j = 0;
        for (; i < left.size() && j < right.size(); ) {
            int iValue = left.get(i);
            for (; j < right.size(); j++) {
                int jValue = right.get(j);
                if (iValue <= jValue) {
                    list.add(iValue);
                    i++;
                    break;
                } else {
                    list.add(jValue);
                }
            }
        }
        while (i < left.size()) {
            int iValue = left.get(i);
            list.add(iValue);
            i++;
        }
        while (j < right.size()) {
            int jValue = right.get(j);
            list.add(jValue);
            j++;
        }
        return list;
    }


    /**
     * 计数排序
     */
    public Integer[] countingSort(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        int length = max - min + 1;
        //存放计数的个数
        int[] intArr = new int[length];
        //将个数存放进去
        for (int i = 0; i < list.size(); i++) {
            int data = list.get(i);

            int idx = data - min;
            int intArrValue = intArr[idx];
            intArr[idx] = ++intArrValue;
        }

        //将个数转化成排序后的下标
        for (int i = 1; i < intArr.length; i++) {
            intArr[i] = intArr[i-1]+intArr[i];
        }

        //结果集
        Integer[] result = new Integer[list.size()];
        //获得结果
        for (int i = list.size()-1; i >=0; i--) {
            Integer data = list.get(i);
            int idx = intArr[data-min] -1;
            result[idx] = data;

            intArr[data-min] = idx;
        }
        return result;
    }

//    /**
//     * 基数排序
//     */
//    public int[] RadixSort(int[] nums) {
//
//        for (int i = 0; i < nums.length; i++) {
//
//        }
//
//
//    }



    /**
     * 插入排序
     * 缺点：每次只能移动一位数据
     */
    public void insertionSort(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int iValue = list.get(i);
            for (int j = i - 1; j >= 0; j--) {
                int jValue = list.get(j);
                if (iValue < jValue) {
                    int temp = iValue;
                    list.set(j + 1, jValue);
                    list.set(j, temp);
                } else {
                    break;
                }
            }
        }
    }

    //插入排序
    public void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > value) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
    }

    /**
     * 选择排序
     */
    public void selectSort(ArrayList<Integer> list) {
        int size = 0;
        while (size <= list.size() - 1) {
            int maxValue = Integer.MIN_VALUE;
            int maxIdx = -1;

            int n = list.size() - size;
            for (int i = 0; i < n; i++) {
                int value = list.get(i);
                if (value > maxValue) {
                    maxIdx = i;
                    maxValue = value;
                }
            }
            if (maxIdx != n - 1) {
                list.set(maxIdx, list.get(n - 1));
                list.set(n - 1, maxValue);
            }

            size++;
        }
    }


    /**
     * 冒泡排序
     */
    public void bobbleSort(int[] nums) {
        int orderlyCount = 0;

        while (orderlyCount < nums.length - 1) {
            boolean flag = false;
            for (int i = 0; i < (nums.length - 1 - orderlyCount); i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(i, i + 1, nums);
                    flag = true;
                }
            }
            orderlyCount++;
            if (!flag) {
                break;
            }
        }
    }


    /**
     * 堆排序
     * 1.堆化
     * 2.排序
     * 原地排序 in-places
     */
    public void heapSort(int[] ints) {
        if (ints == null || ints.length == 0) return;
        //堆化
        heapify(ints);

        //排序
        int max = ints.length - 1;
        while (max > 0) {
            swap(0, max, ints);
            max--;

            shiftDown(0, ints, max + 1);
        }
    }

    /**
     * 堆化
     * 选取最优的堆化方式，从最后一个非叶子结点到0
     * 最后一个非叶子结点 = 最后一个结点的父节点
     */
    private void heapify(int[] ints) {
        for (int i = getParentNodeIndex(ints.length - 1); i >= 0; i--) {
            shiftDown(i, ints, ints.length);
        }
    }

    private void shiftDown(int idx, int[] datas, int size) {
        int lChild = getlChildNodeIndex(idx);
        int rChild = getrChildNodeIndex(idx);
        if (lChild >= size && rChild >= size) {
            return;
        }
        int tmp = datas[idx];
        if (rChild < size) {
            //两个都有
            int max = Math.max(datas[lChild], datas[rChild]);
            if (tmp < max) {
                datas[idx] = max;
                if (datas[lChild] == max) {
                    datas[lChild] = tmp;
                    shiftDown(lChild, datas, size);
                } else {
                    datas[rChild] = tmp;
                    shiftDown(rChild, datas, size);
                }
            }
        } else {
            if (tmp < datas[lChild]) {
                datas[idx] = datas[lChild];
                datas[lChild] = tmp;
            }
        }
    }

    /**
     * 父节点下标
     *
     * @return -1表示不存在父节点
     */
    private int getParentNodeIndex(int i) {
        return (i - 1) >> 1;
    }

    /**
     * 左孩子节点下标
     */
    private int getlChildNodeIndex(int i) {
        return (i << 1) + 1;
    }

    /**
     * 右孩子节点下标
     */
    private int getrChildNodeIndex(int i) {
        return (i << 1) + 2;
    }

    private void swap(int i, int j, int[] ints) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }


}
