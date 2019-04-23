package lanchong.iloveu.datastructure.util;

import lanchong.iloveu.datastructure.util.Queue;

/**
 * 双端队列
 * 队列的两端都支持进出
 *
 * poll：Queue(队列)的一个方法，获取并移除此队列的头，如果此队列为空，则返回null
 *
 */
public interface Deque<E> extends Queue<E> {

    E peekFrist();
    E peekLast();

    void addFrist(E e);
    void addLast(E e);

    E pollFrist();
    E pollLast();




}
