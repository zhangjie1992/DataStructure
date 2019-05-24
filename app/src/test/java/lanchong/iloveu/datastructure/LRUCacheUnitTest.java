package lanchong.iloveu.datastructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import lanchong.iloveu.algorithm.LRUCache;
import lanchong.iloveu.datastructure.util.tree.ArrayBinaryTree;

public class LRUCacheUnitTest {

    private LRUCache<Integer,Integer> cache;

    @Test
    public void test() {

        cache.print();
    }


    @Before
    public void init() {
        cache = new LRUCache(5);
        cache.put(0,0);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);

        Assert.assertTrue(cache.get(0)==0);

        cache.put(5,5);
        cache.put(6,6);
    }
}
