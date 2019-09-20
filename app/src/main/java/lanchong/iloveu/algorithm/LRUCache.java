package lanchong.iloveu.algorithm;

import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * 双向链表+HashMap实现的高效LRUCache
 *
 * 注意这里的添加和移除都要考虑同时操作 链表+HashMap
 *
 * Java LinkedHashMap
 * Note that insertion order is not affected if a key is <i>re-inserted</i> into the map
 */
public class LRUCache<K, V> {

    private final int mCapicity;
    private int size = 0;
    /**
     * sentiel
     */
    private final Entry HEAD;
    /**
     * sentiel
     */
    private final Entry TAIL;

    private HashMap<K, Entry> map = new HashMap<>();

    public LRUCache(int capicity) {
        mCapicity = capicity;
        HEAD = new Entry(null,null);
        TAIL = new Entry(null,null);

        HEAD.next = TAIL;
        TAIL.prev = HEAD;
    }

    /**
     * 加入缓存
     */
    public void put(K k, V v) {
        Entry entry = map.get(k);
        if (entry != null) {
            remove(entry);
        } else {
            entry = new Entry(k, v);
            size++;
            if (size > mCapicity) {
                Entry ret = removeFrist();
                map.remove(ret.key);

                size = mCapicity;
            }
            map.put(k,entry);
        }
        addLast(entry);
    }

    /**
     * 从缓存中获取
     */
    public V get(K k) {
        Entry entry = map.get(k);
        if (entry == null) {
            return null;
        }
        remove(entry);
        addLast(entry);
        return entry.value;
    }

    /**
     * 从缓存中移除
     */
    public V remove(K k) {
        Entry entry = map.remove(k);
        if (entry == null) {
            return null;
        }
        remove(entry);
        size--;
        return entry.value;
    }


    public void print() {
        Entry curr = HEAD.next;
        while (curr.value!=null){
            System.out.println("key:"+curr.key+" value:"+curr.value);
            curr = curr.next;
        }
    }

    /**
     * 将Entry添加到缓存末尾
     */
    private void addLast(Entry entry) {
        entry.prev = TAIL.prev;
        entry.next = TAIL;

        TAIL.prev.next = entry;
        TAIL.prev = entry;
    }

    /**
     * 将Entry从缓存中移除
     */
    private void remove(Entry entry) {
        if (entry == null) {
            throw new NoSuchElementException();
        }
        entry.prev.next = entry.next;
        entry.next.prev = entry.prev;
    }

    /**
     * 移除缓存中的第一个元素
     */
    private Entry removeFrist() {
        if (HEAD.next == TAIL) {
            throw new NoSuchElementException();
        }
        Entry ret = HEAD.next;
        HEAD.next = ret.next;
        ret.next.prev = HEAD;
        size--;
        return ret;
    }


    private class Entry {
        public Entry prev;
        public Entry next;
        public K key;
        public V value;
//        public Entry hNext;


        public Entry(K key, V v) {
            this.key = key;
            this.value = v;
        }
    }


}
