package lanchong.iloveu.datastructure.util;


import java.util.Iterator;

/**
 * 顺序队列，不可扩容
 */
public class CircularQueue<E> implements Queue2<E>, Iterable {

    private int HEAD;
    private int TAIL;
    private int mTheSize;
    /**
     * 不是实际的容量需要浪费一个数组空间
     */
    private int mCapicity;
    private final int DEFAULT_CAPICITY = 10;
    private final E[] data;

    public CircularQueue() {
        data = (E[]) new Object[DEFAULT_CAPICITY];
        init();
    }

    public CircularQueue(int capicity) {
        if (capicity <= 0) {
            throw new IllegalArgumentException();
        }
        mCapicity = capicity;
        data = (E[]) new Object[capicity];
        init();
    }

    private void init() {
        HEAD = 0;
        TAIL = 0;
        mTheSize = 0;
    }

    @Override
    public E peek() {
        return data[HEAD];
    }

    @Override
    public void add(E e) {
        if ((TAIL + 1) % mCapicity == HEAD) {
            throw new IllegalStateException();
        }
        data[TAIL] = e;
        mTheSize++;
        if (++TAIL == mCapicity) {
            TAIL = 0;
        }
    }

    @Override
    public E poll() {
        if (HEAD == TAIL) {
            return null;
        }
        E poll = data[HEAD];
        mTheSize--;
        if (++HEAD == mCapicity) {
            HEAD = 0;
        }
        return poll;
    }


    @Override
    public int size() {
        return mTheSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }

        HEAD = 0;
        TAIL = 0;
        mTheSize = 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

}
