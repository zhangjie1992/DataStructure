package lanchong.iloveu.datastructure;

import org.junit.Before;
import org.junit.Test;

import lanchong.iloveu.datastructure.util.tree.ArrayBinaryTree;

public class ArrayBinaryTreeUnitTest {

    private ArrayBinaryTree tree;

    /**
     *                0
     *        1              2
     *     3     4        5      6
     *   7   8  9  10
     *
     * 0 1 3 7 8 4 9 10 2 5  6
     *
     */
    @Test
    public void prevOrder() {
        tree.prevOrder();
    }

    /***
     *
     *                0
     *        1              2
     *     3     4        5      6
     *   7   8  9  10
     *
     *
     *   7 3 8 1  9  4   10   0   5  2   6
     *
     *
     *
     */
    @Test
    public void inOrder() {
        tree.inOrder();
    }

    /***
     *
     *                0
     *        1              2
     *     3     4        5      6
     *   7   8  9  10
     *
     *   7 8 3 9  10 4  1  5  6  2  0
     */
    @Test
    public void postOrder() {
        tree.postOrder();
    }

    @Test
    public void levelOrder() {
        tree.levelOrder();
    }

    /**
     *
     */
    @Before
    public void init() {
        tree = new ArrayBinaryTree();
        tree.add(0);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
    }
}
