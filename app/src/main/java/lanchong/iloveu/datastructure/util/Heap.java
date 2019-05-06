package lanchong.iloveu.datastructure.util;

/**
 * 二叉堆
 * 小顶堆
 * TODO 改成可以插入任意元素 模仿priorityQueue
 */
public class Heap {

    private Integer[] mDatas;
    private int mSize;
    private int mCapicity;

    /**
     * create an empty heap
     * @param capicity
     */
    public Heap(int capicity) {
        mCapicity = capicity;
        this.mDatas = new Integer[mCapicity];
    }

    public Integer peek() {
        return mDatas[0];
    }

    public Integer poll() {
        Integer e = mDatas[0];
        //和最顶上的交换
        mDatas[0] = mDatas[mSize - 1];
        mDatas[mSize - 1] = null;
        mSize--;
        //下沉
        shiftDown(0);
        return e;
    }

    /**
     * adding a new key to the heap
     */
    public void insert(Integer e) {
        mDatas[mSize] = e;
        mSize++;
        //上浮s
        shiftUp(mSize - 1);
    }

    /**
     * returns true if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * return the number of items in the heap
     */
    public int size() {
        return mSize;
    }

    /**
     * Move a node up in the tree, as long as needed (depending on the heap condition: min-heap or max-heap)
     * TODO 可以优化，使用for减少赋值次数
     */
    private void shiftUp(int idx) {
        int parentNodeIndex = getParentNodeIndex(idx);
        if (parentNodeIndex == -1) {
            return;
        }
        if (mDatas[parentNodeIndex] <= mDatas[idx]) {
            return;
        }
        Integer temp = mDatas[parentNodeIndex];
        mDatas[parentNodeIndex] = mDatas[idx];
        mDatas[idx] = temp;
        shiftUp(parentNodeIndex);
    }


    /**
     * Move a node down in the tree, similar to Shift-up
     * TODO 可以优化
     */
    private void shiftDown(int idx) {
        int lChild = getlChildNodeIndex(idx);
        int rChild = getrChildNodeIndex(idx);
        if (lChild >= mSize && rChild >= mSize) {
            return;
        }
        int tmp = mDatas[idx];
        if (rChild < mSize) {
            //两个都有
            int min = Math.min(mDatas[lChild], mDatas[rChild]);
            if (tmp > min) {
                mDatas[idx] = min;
                if (mDatas[lChild] == min){
                    mDatas[lChild] = tmp;
                    shiftDown(lChild);
                }else {
                    mDatas[rChild] = tmp;
                    shiftDown(rChild);
                }
            }
        }else {
            if (tmp > mDatas[lChild]) {
                mDatas[idx] = mDatas[lChild];
                mDatas[lChild] = tmp;
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



}
