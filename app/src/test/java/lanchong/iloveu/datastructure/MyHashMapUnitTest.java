package lanchong.iloveu.datastructure;

import org.junit.Before;
import org.junit.Test;

import lanchong.iloveu.datastructure.util.MyHashMap;

public class MyHashMapUnitTest {

    private MyHashMap myHashMap;

    @Test
    public void test() {



    }

    @Before
    public void init() {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println("get 1:"+hashMap.get(1));// 返回 1
        System.out.println("get -1:"+hashMap.get(3));            // 返回 -1 (未找到)
        hashMap.put(2, 1);         // 更新已有的值
        System.out.println("get 1:"+hashMap.get(2));            // 返回 1
        hashMap.remove(2);         // 删除键为2的数据
        System.out.println("get 1:"+hashMap.get(2));            // 返回 -1 (未找到)
    }
}
