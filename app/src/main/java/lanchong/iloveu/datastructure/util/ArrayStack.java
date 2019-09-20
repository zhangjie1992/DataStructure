package lanchong.iloveu.datastructure.util;

import java.util.NoSuchElementException;

/**
 * 用数组实现的stack
 */
public class ArrayStack<E> implements Stack<E> {

    private E[] datas;
    private int size;

    /**
     * 堆顶下标
     */
    private int top;

    private final int DEFAULT_CAPACITY = 10;
    private int capacity = DEFAULT_CAPACITY;

    public ArrayStack() {
        init();
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        init();
    }

    private void init() {
        this.datas = (E[]) new Object[capacity];
        top = 0;
        size = 0;
    }

    @Override
    public E peek() {
        return datas[top];
    }

    @Override
    public void push(E e) {
        if (isFull()) {
            System.out.println("stack is full");
            return;
        }
        datas[++top] = e;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E result = datas[top];
        datas[top] = null;
        size--;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean isFull() {
        return size() == capacity;
    }


}
