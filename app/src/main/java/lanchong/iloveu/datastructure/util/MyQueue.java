package lanchong.iloveu.datastructure.util;

import java.util.Iterator;

/**
 * 队列
 */
public class MyQueue<E> implements Queue<E>, Iterable {

    private Node mTheHead;
    private int mTheSize;

    @Override
    public E peek() {
        return mTheHead == null ? null : mTheHead.data;
    }

    @Override
    public void add(E e) {
        mTheSize++;
        if (isEmpty()) {
            mTheHead = new Node(null, e, null);
            return;
        }

        Node curr = mTheHead;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(curr, e, null);
    }

    @Override
    public void add(E e, int idx) {

    }

    @Override
    public E set(E e, int idx) {
        return null;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        Node pollNode = mTheHead;
        mTheHead = pollNode.next;

        mTheSize--;
        return pollNode.data;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }


    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return mTheSize;
    }

    public void clear() {
        mTheHead = null;
        mTheSize = 0;
    }


    @Override
    public Iterator iterator() {
        return new Itr();
    }

    private class Node {
        public Node prev;
        public E data;
        public Node next;

        public Node(Node prev, E curr, Node next) {
            this.prev = prev;
            this.data = curr;
            this.next = next;
        }
    }

    private class Itr implements Iterator<E> {

        private int idx;
        private Node curr = MyQueue.this.mTheHead;

        @Override
        public boolean hasNext() {
            return idx < MyQueue.this.mTheSize;
        }

        @Override
        public E next() {
            idx++;
            Node currNode = curr;
            curr = curr.next;
            return currNode.data;
        }

        @Override
        public void remove() {
            if (hasNext()) {
                curr.prev.next = curr.next;
                if (curr.next != null) {
                    curr.next.prev = curr.prev;
                }
                curr = curr.prev;
            } else {
                curr.prev.next = null;
                curr = null;
            }
            MyQueue.this.mTheSize--;
        }
    }
}
