package lanchong.iloveu.datastructure;

import org.junit.Before;
import org.junit.Test;

import lanchong.iloveu.datastructure.util.tree.ArrayBinaryTree;
import lanchong.iloveu.datastructure.util.tree.LinkedBinaryTree;

public class LinkedBinaryTreeUnitTest {

    private LinkedBinaryTree tree;


    /**
     *                5
     *        3              8
     *     2     4        6      9
     *   1                 7
     *
     * 0 1 3 7 8 4 9 10 2 5  6
     *
     */
    @Test
    public void remove() {
        tree.prevOrder();
        tree.remove(5);
        System.out.println("============");
        tree.prevOrder();
    }
    @Test
    public void levelOrder() {
        tree.levelOrder();
    }



    @Before
    public void init() {
        tree = new LinkedBinaryTree();
        tree.add(5);
        tree.add(3);
        tree.add(4);
        tree.add(2);
        tree.add(1);

        tree.add(8);
        tree.add(6);
        tree.add(7);

        tree.add(9);
    }
}
