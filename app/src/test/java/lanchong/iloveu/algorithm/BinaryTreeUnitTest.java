package lanchong.iloveu.algorithm;

import org.junit.Test;

public class BinaryTreeUnitTest {

    @Test
    public void maxDepth() {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(1);
        System.out.println("result:"+binaryTree.maxDepth(root));
    }


}
