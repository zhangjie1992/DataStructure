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
     * 稳定性：
     * 适应性：
     * 时间复杂度: O(n*logn)
     * 空间复杂度 O(1)
     * 使用范围: 使用最多比归并排序用的多
     */
    public void quickSort(List<Integer> list) {
        quickSortRecursion(list, 0, list.size());
    }

    public void quickSortRecursion(List<Integer> list, int pivotIndex, int length) {
        if (length <= 1) {
            return;
        }
        processPivot(list, pivotIndex, length);
        Integer pivot = list.get(pivotIndex);
        int maxIdx = pivotIndex + length - 1;
        int i = pivotIndex, j = maxIdx;
        int jValue;
        for (; i <= maxIdx && j >= pivotIndex; ) {
            jValue = list.get(j);
            while (jValue >= pivot && j - 1 >= pivotIndex) {
                j--;
                jValue = list.get(j);
            }

            int iValue = list.get(i);
            while (iValue <= pivot && i + 1 < maxIdx && i + 1 < j) {
                i++;
                iValue = list.get(i);
            }
            if (i < j) {
                list.set(i, jValue);
                list.set(j, iValue);

                i++;
                j--;
            } else {
                break;
            }
        }
        jValue = list.get(j);
        while (jValue >= pivot && j - 1 >= pivotIndex) {
            j--;
            jValue = list.get(j);
        }
        list.set(j, pivot);
        list.set(pivotIndex, jValue);

        int leftLength = j - pivotIndex;
        int rightLength = length - (leftLength) - 1;
        int rightPivotIndex = j + 1;
        quickSortRecursion(list, pivotIndex, leftLength);
        quickSortRecursion(list, rightPivotIndex, rightLength);
    }

    private void processPivot(List<Integer> list, int l, int length) {
        int r = l + length - 1;
        int lValue = list.get(l);
        int rValue = list.get(r);
        if (length == 2) {
            list.set(l, Math.min(lValue, rValue));
            list.set(r, Math.max(lValue, rValue));
            return;
        }

        int mid = l + (length >> 1);
        int mValue = list.get(mid);

        int max = Math.max(Math.max(lValue, rValue), mValue);
        int min = Math.min(Math.min(lValue, rValue), mValue);

        list.set(l, min);
        list.set(r, max);
        if (lValue != max && lValue != min) {
            list.set(mid, lValue);
        } else if (rValue != max && rValue != min) {
            list.set(mid, rValue);
        }
    }


    /**
     * 归并排序,并归排序(分治法) 使用递归
     * 稳定性：
     * 适应性：
     * 时间复杂度:O(n*logn)
     * 空间复杂度:O(n)
     * 使用范围: 使用较多
     */
    public List<Integer> mergeSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int mid = list.size() / 2;
        List<Integer> left = list.subList(0, mid);
        List<Integer> right = list.subList(mid, list.size());
        return merge(mergeSort(left), mergeSort(right));
    }

    public List<Integer> merge(List<Integer> left, List<Integer> right) {
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
     * 稳定性：
     * 适应性：
     * 时间复杂度:O(n)
     * 空间复杂度:复杂
     * 使用范围:
     */
    public List<Integer> countingSort(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        int length = max - min + 1;
        int[] intArr = new int[length];

        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);

            int index = value - min;
            int intArrValue = intArr[index];
            intArr[index] = ++intArrValue;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int count = intArr[i];
            int value = i + min;
            for (int j = 0; j < count; j++) {
                result.add(value);
            }
        }

        return result;
    }

    /**
     * 插入排序
     * 稳定性：√
     * 适应性：
     * 时间复杂度:O(n²)
     * 空间复杂度:O(1)
     * 使用范围:
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

    /**
     * 选择排序
     * 稳定性：×
     * 适应性：×
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
     * 冒泡排序（可优化）
     * 稳定性：√
     * 适应性：√
     */
    public void popSort(ArrayList<Integer> list) {
        int size = 0;
        while (size < list.size() - 1) {
            for (int i = 0; i < list.size() - size - 1; i++) {
                int iInt = list.get(i);
                int jInt = list.get(i + 1);
                if (iInt > jInt) {
                    list.set(i + 1, iInt);
                    list.set(i, jInt);
                }
            }
            size++;
        }
    }


    


}
