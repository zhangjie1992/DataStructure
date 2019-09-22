package lanchong.iloveu.algorithm;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeUnitTest {

    /**
     * 0
     * 2          4
     * 1  n      3 -1
     * 5 3      n 6  n 8
     */
    BinaryTree.TreeNode root;
    BinaryTree binaryTree = new BinaryTree();

    @Test
    public void maxDepth() {
        System.out.println("result:"+binaryTree.maxDepth(root));
    }

    @Test
    public void prevTraversal() {
        System.out.println("result:"+binaryTree.preorderTraversal(root));
    }

    @Test
    public void inorderTraversal() {
        System.out.println("result:"+binaryTree.inorderTraversal(root));
    }
    @Test
    public void postorderTraversal() {
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(1);
        root.right =  new BinaryTree.TreeNode(2);
        root.right.left =  new BinaryTree.TreeNode(3);
        System.out.println("result:"+binaryTree.postorderTraversal(root));
    }

    @Test
    public void longestUnivaluePath() {
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(1);
        root.left =  new BinaryTree.TreeNode(4);
        root.left.left =  new BinaryTree.TreeNode(4);
        root.left.right =  new BinaryTree.TreeNode(4);

        root.right =  new BinaryTree.TreeNode(5);
        root.right.right =  new BinaryTree.TreeNode(5);

        System.out.println("result:"+binaryTree.longestUnivaluePath(root));
    }


    @Test
    public void preorderTraversal1() {
        binaryTree.preorderTraversal1(root);
    }

    @Test
    public void inorderTraversal1() {
        binaryTree.inorderTraversal1(root);
    }


    @Test
    public void postorderTraversal1() {
        binaryTree.postorderTraversal1(root);
    }




    @Before
    public void init(){
        root = new BinaryTree.TreeNode(0);
        root.left =  new BinaryTree.TreeNode(2);
        root.left.left =  new BinaryTree.TreeNode(1);
        root.left.left.left =  new BinaryTree.TreeNode(5);
        root.left.left.right = new BinaryTree.TreeNode(3);

        root.right =  new BinaryTree.TreeNode(4);

        root.right.left = new BinaryTree.TreeNode(3);
        root.right.left.right = new BinaryTree.TreeNode(6);
        root.right.right = new BinaryTree.TreeNode(-1);
        root.right.right.right = new BinaryTree.TreeNode(8);
    }






}
