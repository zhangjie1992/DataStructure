package lanchong.iloveu.datastructure.util;

import java.util.Collection;

public interface List<E> extends Iterable {

    boolean isEmpty();

    int size();

    void clear();

    E get(int idx);

    void add(E e);

    void add(int idx, E e);

    void addAll(E[] e);

    void addAll(int idx, Collection<? extends E> c);

    E set(int idx, E e);

    E remove(int idx);

    boolean removeAll(Collection<?> c);

    boolean contains(E e);
    boolean containsAll(Collection<?> c);

    int indexOf(E e);

    Object[] toArray();


}
