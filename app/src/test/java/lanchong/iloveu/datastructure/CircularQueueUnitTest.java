package lanchong.iloveu.datastructure;

import org.junit.Test;

import lanchong.iloveu.datastructure.util.CircularQueue;

import static org.junit.Assert.assertTrue;


public class CircularQueueUnitTest {

    /**
     * 顺序队列，不可扩容
     */
    private CircularQueue<Integer> mQueue;

    @Test
    public void init() {
        mQueue = new CircularQueue<>(11);
        for (int i = 0; i < 10; i++) {
            mQueue.add(i);
        }
        assertTrue(mQueue.size() == 10);

        assertTrue(mQueue.peek() == 0);
        assertTrue(mQueue.size() == 10);

        assertTrue(mQueue.poll() == 0);
        assertTrue(mQueue.size() == 9);

        assertTrue(mQueue.peek() == 1);

        mQueue.add(99);
        assertTrue(mQueue.size() == 10);


        assertTrue(mQueue.poll() == 1);
        assertTrue(mQueue.poll() == 2);
        assertTrue(mQueue.poll() == 3);
        assertTrue(mQueue.poll() == 4);
        assertTrue(mQueue.poll() == 5);
        assertTrue(mQueue.poll() == 6);
        assertTrue(mQueue.poll() == 7);
        assertTrue(mQueue.poll() == 8);
        assertTrue(mQueue.poll() == 9);
        assertTrue(mQueue.poll() == 99);


    }
}
