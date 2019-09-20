package lanchong.iloveu.datastructure.util.tree;

import java.util.ArrayList;

/**
 * 用数组实现的二叉树
 *
 * TODO {@link #remove}
 * 其他就不用实现了，一般不使用数组来实现
 *
 */
public class ArrayBinaryTree implements BinaryTree<Integer> {

    private ArrayList<Integer> datas;
    private int size;

    public ArrayBinaryTree() {
        this.datas = new ArrayList<>();
        size = 0;
    }

    @Override
    public void add(Integer element) {
        datas.add(element);
        size++;
    }

    @Override
    public Integer remove(Integer element) {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

//    @Override
    public int indexOf(Integer element) {
        for (int i = 0; i < size; i++) {
            if (datas.get(i) == element) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void prevOrder() {
        prevOrder(0);
    }

    private void prevOrder(int idx) {
        if (idx >= size || idx < 0) {
            return;
        }
        //自己
        Integer integer = datas.get(idx);
        if (integer != null) {
            //打印自己
            System.out.println("prevOrder:" + integer);
            //打印左孩子
            prevOrder(leftChildIndex(idx));
            //打印右孩子
            prevOrder(rightChildIndex(idx));
        }
    }

    @Override
    public void inOrder() {
        inOrder(0);
    }

    private void inOrder(int idx) {
        if (idx >= size || idx < 0) {
            return;
        }
        Integer integer = datas.get(idx);
        if (integer != null) {
            //打印左孩子
            inOrder(leftChildIndex(idx));
            //打印自己
            System.out.println("midOrder:" + integer);
            //打印右孩子
            inOrder(rightChildIndex(idx));
        }
    }

    @Override
    public void postOrder() {
        postOrder(0);
    }

    @Override
    public void levelOrder() {
        for (Integer value : datas) {
            System.out.println("levelOrder:" + value);
        }

    }

    private void postOrder(int idx) {
        if (idx >= size || idx < 0) {
            return;
        }
        Integer integer = datas.get(idx);
        if (integer != null) {
            //打印左孩子
            postOrder(leftChildIndex(idx));
            //打印右孩子
            postOrder(rightChildIndex(idx));
            //打印自己
            System.out.println("afterOrder:" + integer);
        }
    }

    /**
     * 根据当前结点下标获取父结点下标
     *
     * @param idx 当前节点下标
     * @return 当前结点为root时返回-1，否则为父节点下标
     */
    private int parentIndex(int idx) {
        return (idx - 1) / 2;
    }

    private int leftChildIndex(int idx) {
        return idx * 2 + 1;
    }

    private int rightChildIndex(int idx) {
        return idx * 2 + 2;
    }


}
