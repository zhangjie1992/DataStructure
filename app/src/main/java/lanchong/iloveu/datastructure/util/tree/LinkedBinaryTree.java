package lanchong.iloveu.datastructure.util.tree;


import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 用链表实现的二叉树
 * 支持重复数据的二叉查找树
 */
public class LinkedBinaryTree implements BinaryTree<Integer> {

    private BinaryTreeNode root;
    private int size;

    @Override
    public void add(Integer element) {
        if (root == null) {
            root = new BinaryTreeNode(element, null, null);
            return;
        }

        BinaryTreeNode mid = root;
        while (true) {
            if (mid.element > element) {
                if (mid.l == null) {
                    mid.l = new BinaryTreeNode(element, null, null);
                    break;
                }
                mid = mid.l;
            } else {
                if (mid.r == null) {
                    mid.r = new BinaryTreeNode(element, null, null);
                    break;
                }
                mid = mid.r;
            }
        }
        size++;
    }



    /**
     * remove是比较复杂的
     * 未考虑重复数据
     */
    @Override
    public Integer remove(Integer element) {
        BinaryTreeNode curr = root;
        //父节点
        BinaryTreeNode pp = null;
        while (curr != null) {
            if (curr.element == element) {
                break;
            } else if (curr.element > element) {
                pp = curr;
                curr = curr.l;
            } else {
                pp = curr;
                curr = curr.r;
            }
        }
        if (curr == null) {
            throw new NoSuchElementException();
        }

        //三种情况
        if (isLeaf(curr)) {
            //叶子结点时
            if (pp == null) {
                root = null;
            } else if (pp.l == curr) {
                pp.l = null;
            } else {
                pp.r = null;
            }
        } else if (curr.l == null || curr.r == null) {
            //有一个子节点时
            if (pp == null) {
                root = curr.l != null ? curr.l : curr.r;
            } else {
                if (pp.l == curr) {
                    pp.l = curr.l != null ? curr.l : curr.r;
                } else {
                    pp.r = curr.l != null ? curr.l : curr.r;
                }
            }
        } else {
            //有两个子节点时
            //右子树的最小节点上位
            BinaryTreeNode rMin = curr.r;
            BinaryTreeNode rMinp = curr;
            while (rMin.l != null) {
                rMinp = rMin;
                rMin = rMin.l;
            }
            if (rMinp == curr) {
                rMin.l = rMinp.l;
            } else {
                if (rMin.r != null) {
                    rMinp.l = rMin.r;
                }
                rMin.r = curr.r;
                rMin.l = curr.l;
            }
            if (pp == null) {
                root = rMin;
            } else {
                pp.r = rMin;
            }
        }

        size--;
        return element;
    }

    /**
     * 查找
     */
    private BinaryTreeNode find(Integer element) {
        BinaryTreeNode mid = root;
        while (mid != null) {
            if (mid.element == element) {
                return mid;
            } else if (mid.element > element) {
                mid = mid.l;
            } else {
                mid = mid.r;
            }
        }
        return null;
    }

    private boolean isLeaf(BinaryTreeNode node) {
        if (node == null) {
            return false;
        } else {
            if (node.l == null && node.r == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }


    /**
     * 查找最大节点
     */
    private BinaryTreeNode findMax() {
        return findMax(root);
    }

    private BinaryTreeNode findMax(BinaryTreeNode max) {
        while (max != null && max.r != null) {
            max = max.r;
        }
        return max;
    }

    private BinaryTreeNode findMin() {
        return findMin(root);
    }

    private BinaryTreeNode findMin(BinaryTreeNode min) {
        while (min != null && min.l != null) {
            min = min.l;
        }
        return min;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void prevOrder() {
        prevOrder(root);
    }

    private void prevOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println("prevOrder:" + node.element);
        prevOrder(node.l);
        prevOrder(node.r);
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.l);
        System.out.println("prevOrder:" + node.element);
        inOrder(node.r);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.l);
        postOrder(node.r);

        System.out.println("prevOrder:" + node.element);
    }

    /**
     * 广度优先遍历
     */
    @Override
    public void levelOrder() {
        if (root == null) {
            return;
        }
        LinkedList<BinaryTreeNode> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            BinaryTreeNode poll = list.poll();
            System.out.println("prevOrder:" + poll.element);
            if (poll.l != null) {
                list.offer(poll.l);
            }

            if (poll.r != null) {
                list.offer(poll.r);
            }

        }
    }

    private class BinaryTreeNode {
        private int element;
        private BinaryTreeNode l;
        private BinaryTreeNode r;

        public BinaryTreeNode(int element, BinaryTreeNode l, BinaryTreeNode r) {
            this.element = element;
            this.l = l;
            this.r = r;
        }
    }


}
