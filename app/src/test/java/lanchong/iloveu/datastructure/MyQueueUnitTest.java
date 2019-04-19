package lanchong.iloveu.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import lanchong.iloveu.datastructure.util.MyQueue;

import static org.junit.Assert.assertTrue;

public class MyQueueUnitTest {

    private MyQueue<Integer> mList;

    @Test
    public void iterator() {
        Iterator<Integer> iterator = mList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println("next:" + next);
        }

    }
    @Before
    public void init(){
        mList = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            mList.add(i);
        }
        assertTrue(mList.size()==10);

        Integer peek = mList.peek();
        assertTrue(peek==0);
        assertTrue(mList.size()==10);

        Integer pop = mList.poll();
        assertTrue(pop==0);
        assertTrue(mList.size()==9);

        Integer peek2 = mList.peek();
        assertTrue(peek2==1);

    }
}
