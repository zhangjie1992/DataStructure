package lanchong.iloveu.datastructure.util;

/**
 * 队列
 * FIFO
 * <p>
 * poll：Queue(队列)的一个方法，获取并移除此队列的头，如果此队列为空，则返回null
 */
public interface Queue2<E> {

    E peek();

    void add(E e);

    E poll();

    int size();

    boolean isEmpty();

    void clear();


}
