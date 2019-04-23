package lanchong.iloveu.datastructure.util;

/**
 * 队列
 * FIFO
 * <p>
 * poll：Queue(队列)的一个方法，获取并移除此队列的头，如果此队列为空，则返回null
 */
public interface Queue<E> {

    E peek();

    void add(E e);

    void add(E e, int idx);

    E set(E e, int idx);

    E poll();

    boolean contains(E e);

    int indexOf(E e);

    int size();

    boolean isEmpty();

    void clear();


}
