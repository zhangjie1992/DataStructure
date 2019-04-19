package lanchong.iloveu.datastructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import lanchong.iloveu.datastructure.util.MyArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class MyArrayListUnitTest {

    private MyArrayList<Integer> mList;
    @Test
    public void iterator() {
        Iterator<Integer> iterator = mList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println("next:" + next);
        }

    }
    @Before
    public void initMyArrayList(){
        mList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            mList.add(i);
            Assert.assertTrue(mList.get(i)==i);
        }
        Assert.assertTrue(mList.size()==10);

        mList.add(10);
        Assert.assertTrue(mList.size()==11);
        Assert.assertTrue(mList.get(10)==10);

        mList.set(5, 99);
        Assert.assertTrue(mList.size()==11);
        Assert.assertTrue(mList.get(5)==99);

        Integer remove = mList.remove(0);
        Assert.assertTrue(mList.size()==10);
        Assert.assertTrue(remove==0);

        mList.add(1, 95);
        Assert.assertTrue(mList.size()==11);
        Assert.assertTrue(mList.get(1)==95);

        Integer[] intArray = {100, 101, 102};
        mList.addAll(intArray);
        Assert.assertTrue(mList.size()==14);
        Assert.assertTrue(mList.get(11)==100);
        Assert.assertTrue(mList.get(12)==101);
        Assert.assertTrue(mList.get(13)==102);
    }
}