package lanchong.iloveu.algorithm;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

    /**
     * 94. 二叉树的中序遍历
     * 好题
     * 使用迭代来中序遍历二叉树
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr!=null||!stack.isEmpty()){
            if (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                curr = pop.right;
            }
        }
        return result;
    }
    private void inOrder(TreeNode root,List<Integer> list){
        if (root==null) return;

        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }

    public int maxDepth(TreeNode root) {
        return maxDepth(root,0);
    }

    private int maxDepth(TreeNode node,int depth) {
        if (node==null) return depth;

        ++depth;
        int l = maxDepth(node.left, depth);
        int r = maxDepth(node.right, depth);
        return Math.max(l,r);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root==null) return result;

        ArrayList<Integer> levelVals ;
        LinkedList<TreeNode> levelNode = new LinkedList<>();
        LinkedList<TreeNode> nextLevelNode = new LinkedList<>();
        levelNode.offer(root);
        while (levelNode.size()!=0){
            levelVals = new ArrayList<>();
            while (levelNode.size()!=0){
                TreeNode poll = levelNode.poll();
                levelVals.add(poll.val);

                if (poll.left!=null){
                    nextLevelNode.offer(poll.left);
                }
                if (poll.right!=null){
                    nextLevelNode.offer(poll.right);
                }
            }
            levelNode.addAll(nextLevelNode);
            nextLevelNode.clear();
            result.add(levelVals);
        }
        return result;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
