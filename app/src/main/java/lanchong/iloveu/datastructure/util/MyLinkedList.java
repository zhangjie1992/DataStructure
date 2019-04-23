package lanchong.iloveu.datastructure.util;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 双端队列实现
 */
public class MyLinkedList<E> implements Deque<E>, Iterable {

    private Node<E> beginMarker;
    private Node<E> endMarker;
    private int mTheSize;
    private int modCount;

    public MyLinkedList() {
        init();
    }

    private void init() {
        beginMarker = new Node<>(null, null, null);
        endMarker = new Node<>(beginMarker, null, null);
        beginMarker.next = endMarker;
        modCount++;
        mTheSize = 0;
    }

    @Override
    public E peekFrist() {
        return beginMarker.next.data;
    }

    @Override
    public E peekLast() {
        return endMarker.prev.data;
    }

    @Override
    public void addFrist(E e) {
        addBefore(e, 0);
        mTheSize++;
        modCount++;
    }

    @Override
    public void addLast(E e) {
        addBefore(e, size());
        mTheSize++;
        modCount++;
    }

    private void addBefore(E e, int idx) {
        Node<E> r = getNode(idx);
        r.prev.next = r.prev = new Node<>(r.prev, e, r);
    }

    private Node<E> getNode(int idx) {
        if (idx < -1 || idx > size()) {
            throw new IndexOutOfBoundsException();
        }
        int curr;
        Node<E> node;
        if (idx >= size() >> 1) {
            curr = size();
            node = endMarker;
            while (curr != idx) {
                node = node.prev;
                curr--;
            }
        } else {
            curr = -1;
            node = beginMarker;
            while (curr == idx) {
                node = node.next;
                curr++;
            }
        }
        return node;
    }

    @Override
    public E pollFrist() {
        if (beginMarker.next == endMarker) {
            throw new NoSuchElementException();
        }

        Node<E> temp = beginMarker.next;
        temp.next.prev = beginMarker;
        beginMarker.next = temp.next;
        mTheSize--;
        modCount--;
        return temp.data;
    }

    @Override
    public E pollLast() {
        if (endMarker.prev == beginMarker) {
            throw new NoSuchElementException();
        }

        Node<E> temp = endMarker.prev;
        temp.prev.next = endMarker;
        endMarker.prev = temp.prev;
        mTheSize--;
        modCount--;
        return temp.data;
    }


    @Override
    public Iterator iterator() {
        return new Itr();
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
        init();
    }

    @Override
    public void add(E e) {
        addLast(e);
    }

    @Override
    public void add(E e, int idx) {
        if (idx < 0 || idx >= size()) {
            throw new IndexOutOfBoundsException();
        }
        addBefore(e, idx);
        mTheSize++;
        modCount++;
    }


    @Override
    public E set(E e, int idx) {
        if (idx < 0 || idx >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = getNode(idx);
        node.prev.next = node.next.prev = new Node<>(node.prev, e, node.next);
        modCount++;
        return null;
    }

    @Override
    public boolean contains(E e) {
        if (e == null) {
            return false;
        }
        Node<E> curr = beginMarker.next;
        while (curr != endMarker) {
            if (curr.data == e) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public int indexOf(E e) {
        if (e == null) {
            return -1;
        }
        Node<E> curr = beginMarker.next;
        int index = 0;
        while (curr != endMarker) {
            if (curr.data == e) {
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }

    @Override
    public E poll() {
        return pollFrist();
    }

    private static class Node<E> {
        public Node<E> prev;
        public E data;
        public Node<E> next;

        public Node(Node prev, E curr, Node next) {
            this.prev = prev;
            this.data = curr;
            this.next = next;
        }
    }

    private class Itr implements Iterator<E> {
        private Node<E> curr = beginMarker.next;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return curr != endMarker;
        }

        @Override
        public E next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            E tmp = curr.data;
            curr = curr.next;
            return tmp;
        }

//        @Override
//        public void remove() {
//            if (expectedModCount != modCount) {
//                throw new ConcurrentModificationException();
//            }
//            MyLinkedList.this.remove(curr.prev);
//        }
    }

}
