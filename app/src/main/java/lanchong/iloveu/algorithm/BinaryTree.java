package lanchong.iloveu.algorithm;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {



    //144. 二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                result.add(curr.val);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                curr = pop.right;
            }
        }
        return result;
    }

    //94. 二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                curr = pop.right;
            }
        }
        return result;
    }

    //145. 二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root==null) return result;
        Stack<TreeNode> roots = new Stack<>();
        Stack<TreeNode> pops = new Stack<>();
        TreeNode curr = root;
        while (curr!=null||!roots.isEmpty()){
            if (curr!=null){
                roots.push(curr);
                curr = curr.left;
            }else {
                TreeNode pop = roots.pop();
                curr = pop.right;
                if (curr!=null){
                    pops.push(pop);
                }else {
                    result.add(pop.val);
                    while (!pops.isEmpty()&&notRootsChild(pop,roots)){
                        pop = pops.pop();
                        result.add(pop.val);
                    }
                }
            }
        }
        return result;
    }

    private boolean notRootsChild(TreeNode pop,Stack<TreeNode> roots){
        if (roots.isEmpty())return true;
        return roots.peek().left != pop && roots.peek().right != pop;
    }


    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode node, int depth) {
        if (node == null) return depth;

        ++depth;
        int l = maxDepth(node.left, depth);
        int r = maxDepth(node.right, depth);
        return Math.max(l, r);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        ArrayList<Integer> levelVals;
        Queue<TreeNode> levelNode = new LinkedList<>();
        Queue<TreeNode> nextLevelNode = new LinkedList<>();
        levelNode.offer(root);
        while (levelNode.size() != 0) {
            levelVals = new ArrayList<>();
            while (levelNode.size() != 0) {
                TreeNode poll = levelNode.poll();
                levelVals.add(poll.val);

                if (poll.left != null) {
                    nextLevelNode.offer(poll.left);
                }
                if (poll.right != null) {
                    nextLevelNode.offer(poll.right);
                }
            }
            levelNode.addAll(nextLevelNode);
            nextLevelNode.clear();
            result.add(levelVals);
        }
        return result;
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        ArrayList<Integer> levelVals;
        Deque<TreeNode> levelNode = new LinkedList<>();
        Deque<TreeNode> nextLevelNode = new LinkedList<>();
        levelNode.offer(root);
        while (levelNode.size() != 0) {
            levelVals = new ArrayList<>();
            while (levelNode.size() != 0) {
                TreeNode poll = levelNode.poll();
                levelVals.add(poll.val);

                if (poll.left != null) {
                    nextLevelNode.offer(poll.left);
                }
                if (poll.right != null) {
                    nextLevelNode.offer(poll.right);
                }
            }
            levelNode.addAll(nextLevelNode);
            nextLevelNode.clear();
            result.offerFirst(levelVals);
        }
        return result;
    }


    //[3,9,20,null,null,15,7]
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBST(root, 0) != -1;
    }

    private int isBST(TreeNode curr, int cLength) {
        if (curr == null) {
            return cLength;
        }

        int p = isBST(curr.left, cLength + 1);
        if (p == -1) {
            return -1;
        }
        int q = isBST(curr.right, cLength + 1);
        if (q == -1) {
            return -1;
        }
        if (Math.abs(p - q) > 1) {
            return -1;
        }
        return Math.max(p, q);
    }

    /**
     * 1
     * 2  3
     * 4 n  n 5
     * <p>
     * [0,2,4,1,null,3,-1,5,1,null,6,null,8]
     * 0
     * 2          4
     * 1    n       3 -1
     * 5 1         n 6  n 8
     * <p>
     * <p>
     * 111. 二叉树的最小深度
     * 这里有个坑，必须是根结点到叶子结点才行
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int lLength = minDepth(root.left, 2);
        int rLength = minDepth(root.right, 2);
        return Math.min(lLength, rLength);
    }

    private int minDepth(TreeNode node, int length) {
        if (node == null) {
            return Integer.MAX_VALUE;
        } else if (node.left == null && node.right == null) {
            return length;
        }
        int l = minDepth(node.left, length + 1);
        int r = minDepth(node.right, length + 1);
        return Math.min(l, r);
    }


    /**
     * 112. 路径总和
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return pathTarget(root, sum);
    }

    private boolean pathTarget(TreeNode node, int target) {
        if (node.left == null && node.right == null) {
            return node.val == target;
        }
        target = target - node.val;
        boolean result = false;
        if (node.left != null) {
            result = pathTarget(node.left, target);
        }
        if (!result && node.right != null) {
            result = pathTarget(node.right, target);
        }
        return result;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 687. 最长同值路径
     */
    public int longestUnivaluePath(TreeNode root) {
        preOrder(root);
        return max;
    }
    int max = 0;

    private void preOrder(TreeNode root){
        if (root==null){
            return;
        }
        //当前节点
        int currPath = univalue(root.left,root.val, 0) + univalue(root.right,root.val, 0);
        max = Math.max(currPath,max);

        preOrder(root.left);
        preOrder(root.right);
    }

    private int univalue(TreeNode node,int val,int size){
        if (node==null){
            return size;
        }
        if (node.val==val){
            size++;
            return Math.max(univalue(node.left,val,size),univalue(node.right,val,size));
        }
        return size;
    }







    public void preorderTraversal1(TreeNode root) {
        preOrder2(root);
    }

    private void preOrder2(TreeNode root){
        if (root==null){
            return;
        }
        System.out.println("root:"+root.val);
        preOrder2(root.left);
        preOrder2(root.right);
    }


    public void inorderTraversal1(TreeNode root) {
        inOrder2(root);
    }


    private void inOrder2(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder2(root.left);
        System.out.println("root:" + root.val);
        inOrder2(root.right);
    }



    public void postorderTraversal1(TreeNode root) {
        postOrder2(root);
    }


    private void postOrder2(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder2(root.left);
        postOrder2(root.right);
        System.out.println("root:" + root.val);
    }



}
