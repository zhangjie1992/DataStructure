package lanchong.iloveu.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SortUnitTest {

    @Test
    public void quickSort() {
        Sort sort = new Sort();

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(15);
        list.add(30);
        list.add(2);
        list.add(100);
        list.add(1);
        list.add(30);

        sort.quickSort(list);
        System.out.println(list);
    }

    @Test
    public void main() {
    }


}
