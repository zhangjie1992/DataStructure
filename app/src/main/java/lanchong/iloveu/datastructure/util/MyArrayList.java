package lanchong.iloveu.datastructure.util;

import android.support.annotation.NonNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyArrayList<E> implements List<E> {

    private final int DEFAULT_CAPACITY = 10;
    private E[] mTheItems = (E[]) new Object[DEFAULT_CAPACITY];
    private int mTheSize;

    @Override
    public void clear() {
        mTheSize = 0;
        ensureCapacityInternal(DEFAULT_CAPACITY);
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
    public E get(int idx) {
        checkRange(idx);

        return mTheItems[idx];
    }

    @Override
    public E set(int idx, E e) {
        checkRange(idx);

        E oldVal = mTheItems[idx];
        mTheItems[idx] = e;
        return oldVal;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > DEFAULT_CAPACITY) {
            ensureCapacityInternal(minCapacity);
        }
    }

    private void ensureCapacityInternal(int newCapacity) {
        if (newCapacity < mTheItems.length) return;

        E[] old = mTheItems;
        mTheItems = (E[]) new Object[Math.max(newCapacity, DEFAULT_CAPACITY)];

        System.arraycopy(old, 0, mTheItems, 0, size());
    }

    @Override
    public void add(E e) {
        if (mTheItems.length == size()) {
            ensureCapacityInternal(mTheItems.length + 1);
        }

        mTheItems[mTheSize++] = e;
    }

    @Override
    public void add(int idx, E e) {
        if (mTheItems.length == size()) {
            ensureCapacityInternal(mTheItems.length + 1);
        }

        System.arraycopy(mTheItems, idx, mTheItems, idx + 1, mTheSize - idx);

        mTheItems[idx] = e;
        mTheSize++;
    }

    @Override
    public void addAll(E[] e) {
        int newCapacity = mTheSize + e.length;
        if (newCapacity > mTheItems.length) {
            //扩容
            ensureCapacityInternal(newCapacity);
        }

        System.arraycopy(e, 0, mTheItems, size(), e.length);

        mTheSize = newCapacity;
    }

    @Override
    public void addAll(int idx, Collection<? extends E> c) {
        //TODO
    }


    public E remove(int idx) {
        checkRange(idx);

        E element = mTheItems[idx];

        //移除元素
        System.arraycopy(mTheItems, idx + 1, mTheItems, idx, mTheSize - (idx + 1));
        mTheSize--;

        return element;
    }

    @Override
    public boolean contains(Object o) {
        //TODO
        return false;
    }

    @Override
    public int indexOf(Object o) {
        //TODO
        return 0;
    }

    @Override
    public Object[] toArray() {
        Object[] objArr = new Object[mTheSize];
        System.arraycopy(mTheItems, 0, objArr, 0, mTheSize);
        return objArr;
    }

    @Override
    public boolean containsAll(Collection c) {
        //TODO
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }


    private void checkRange(int idx) {
        if (idx < 0) throw new IllegalArgumentException();
        if (idx >= mTheSize) throw new ArrayIndexOutOfBoundsException();
    }


    public void trimToSize() {
        if (mTheSize < mTheItems.length) {
            mTheItems = (mTheSize == 0) ? (E[]) new Object[0] : Arrays.copyOf(mTheItems, mTheSize);
        }
    }


    @NonNull
    @Override
    public Iter iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E> {

        int currIdx = 0;

        @Override
        public boolean hasNext() {
            return MyArrayList.this.mTheSize > currIdx;
        }

        @Override
        public E next() {
            return MyArrayList.this.get(currIdx++);
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(currIdx);
        }

    }
}
