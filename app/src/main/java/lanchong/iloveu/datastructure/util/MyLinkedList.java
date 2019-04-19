package lanchong.iloveu.datastructure.util;

import java.util.Collection;
import java.util.Iterator;

/**
 * 双端队列实现
 * TODO 未完全实现
 */
public class MyLinkedList<E> implements List<E>, Deque<E>, Iterable {

    private Node<E> mFrist;
    private Node<E> mLast;
    private int mTheSize;

    public MyLinkedList() {
    }

    @Override
    public E peekFrist() {
        return mFrist == null ? null : mFrist.data;
    }

    @Override
    public E peekLast() {
        return mLast == null ? null : mLast.data;
    }

    @Override
    public void addFrist(E e) {
        mFrist = new Node<>(null, e, mFrist);
        if (mLast==null){
            mLast = mFrist;
            mFrist.next = mLast;
            mLast.prev = mFrist;
        }
        mTheSize++;
    }

    @Override
    public void addLast(E e) {
        mLast = new Node<>(mLast, e, null);
        if (mFrist==null){
            mFrist = mLast;
            mLast.prev = mFrist;
            mFrist.next = mLast;
        }
        mTheSize++;
    }

    @Override
    public E pollFrist() {
        if (mFrist == null) {
            return null;
        }
        E temp = mFrist.data;
        mFrist.data = null;
        mFrist.prev = null;
        //双端列表不太对
        mFrist = mFrist.next;
        mFrist.prev = null;
        mTheSize--;
        return temp;
    }

    @Override
    public E pollLast() {
        if (mLast == null) {
            return null;
        }
        E temp = mFrist.data;
        mFrist.data = null;
        mFrist.prev = null;
        //双端列表不太对
        mFrist = mFrist.next;
        mFrist.prev = null;
        mTheSize--;
        return temp;
    }


    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public E peek() {
        return peekFrist();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return mTheSize;
    }

    @Override
    public void clear() {
        mFrist = new Node<>(mFrist, null, mLast);
        mLast = mFrist;
        mTheSize = 0;
    }

    @Override
    public E get(int idx) {
        return null;
    }

    @Override
    public void add(E e) {
        addLast(e);
    }

    @Override
    public void add(int idx, E e) {

    }

    @Override
    public void addAll(E[] e) {

    }

    @Override
    public void addAll(int idx, Collection<? extends E> c) {

    }

    @Override
    public E set(int idx, E e) {
        return null;
    }

    @Override
    public E remove(int idx) {
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public E[] toArray() {
        return null;
    }

    @Override
    public E poll() {
        return pollFrist();
    }

    private class Node<E> {
        public Node<E> prev;
        public E data;
        public Node<E> next;

        public Node(Node prev, E curr, Node next) {
            this.prev = prev;
            this.data = curr;
            this.next = next;
        }
    }
}
