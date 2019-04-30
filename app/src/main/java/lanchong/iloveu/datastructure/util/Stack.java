package lanchong.iloveu.datastructure.util;

/**
 * pop：Stack(栈)的方法，移除堆栈顶部的对象，并作为此函数的值返回该对象
 * add
 */
public interface Stack<E> {

    E peek();
    void push(E e);
    E pop();
    int size();
    boolean isEmpty();
    boolean isFull();





}
