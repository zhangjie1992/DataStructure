package lanchong.iloveu.datastructure.util.tree;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * 红黑树
 * 未完成比较难、、
 * https://time.geekbang.org/column/article/68976#previewimg
 * https://www.cnblogs.com/zhuwbox/p/3634895.html
 */
public class RBTree implements BinaryTree<Integer> {

    private static final int RED = 0;
    private static final int BLACK = 1;


    private int size;
    private Node root;
    /**
     * sentinel
     */
    private Node nil;

    public RBTree() {
        nil = new Node(null, null, null, null, 1);
    }

    /**
     * TODO 添加操作未完成
     */
    @Override
    public void add(Integer element) {
        Node z = new Node(element);
        if (root == null) {
            root = z;
            z.color = BLACK;
        } else {
            add(element, z);
            if (z.p.color == BLACK) {
                size++;
                return;
            }

            while (z.p.color == RED) {
                if (z.p == z.p.p.left) {//如果z的父亲是z祖父的左孩子
                    Node y = z.p.p.right;//令y为z祖父的右孩子,也就是说y是z的叔叔
                    //如果y的颜色是红色
                    if (y.color == RED) {
                        //case 1    既然z是红色，为了不破坏性质4，将z的父节点涂成黑色
                        z.p.color = BLACK;
                        //case 1    同时也要讲z的叔叔结点涂成黑色
                        y.color = BLACK;
                        //case 1    同时将z的祖父结点(y的父节点)涂成红色
                        z.p.p.color = RED;
                        //case 1    令z 等于 z的祖父，循环继续
                        z = z.p.p;
                    } else if (z == z.p.right) {
                        //如果z是父结点的右孩子
                        //case 2    z等于z的父结点
                        z = z.p;
                        //case 2    右旋
                        rotateLeft(z);
//                        LEFT - ROTATE(T, Z);
//case 3    将z的父结点颜色涂成黑色
                        z.p.color = BLACK;
                        //case 3    将z的祖父结点涂成红色
                        z.p.p.color = RED;
                        //case 3    右旋
//                        RIGHT - ROTATE(T, Z.P.P);
                    }
                }
//                else if (same as then clause with 'right' and 'left' exchanged)


//                Node p = z.p;
//                Node ss = getSS(p);
//                if (ss.color == Node.RED) {
//                    p.color = Node.BLACK;
//                    ss.color = Node.BLACK;
//                    p.p.color = Node.RED;
//                    z = p.p;
//                }

            }


        }
        size++;
    }

    @NonNull
    private void add(Integer element, Node curr) {
        Node p = root;
        while (true) {
            if (p.element > element) {
                if (p.left == nil) {
                    p.left = curr;
                    curr.p = p;
                    break;
                }
                p = p.left;
            } else {
                if (p.right == nil) {
                    p.right = curr;
                    curr.p = p;
                    break;
                }
                p = p.right;
            }
        }
    }


    @Override
    public Integer remove(Integer element) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void prevOrder() {

    }

    @Override
    public void inOrder() {

    }

    @Override
    public void postOrder() {

    }

    @Override
    public void levelOrder() {

    }

    /**
     * 查找子树中的最大节点
     */
    @Nullable
    private Node findMax(Node curr) {
        if (curr == null || curr == nil) {
            throw new IllegalArgumentException("findMax curr:" + curr);
        }
        while (curr.right != nil) {
            curr = curr.right;
        }
        return curr;
    }

    /**
     * 查找子树中的最小节点
     */
    @Nullable
    private Node findMin(Node curr) {
        if (curr == null || curr == nil) {
            throw new IllegalArgumentException("findMin curr:" + curr);
        }
        while (curr.left != nil) {
            curr = curr.left;
        }
        return curr;
    }

    /**
     * 快速获取前驱节点
     */
    @Nullable
    private Node findPrev(Node curr) {
        if (curr == null || curr == nil) {
            throw new IllegalArgumentException("findPrev curr:" + curr);
        }
        Node result = null;
        if (curr.left != nil) {
            result = findMax(curr.left);
        } else if (curr != root && curr == curr.p.right) {
            result = curr.p;
        }
        return result;
    }

    /**
     * 快速获取后继节点
     */
    @Nullable
    private Node findNext(Node curr) {
        if (curr == null || curr == nil) {
            throw new IllegalArgumentException("findNext curr:" + curr);
        }
        Node result = null;
        if (curr.left != nil) {
            result = findMin(curr.right);
        } else if (curr != root && curr == curr.p.left) {
            result = curr.p;
        }
        return result;
    }

    private void rotateLeft(Node curr) {
        if (curr == null || curr == nil || curr.right == nil) {
            throw new IllegalArgumentException("rotateLeft curr:" + curr);
        }
        if (curr != root) {
            if (curr.p.left == curr) {
                curr.p.left = curr.right;
                curr.right.p = curr.p;
            } else {
                curr.p.right = curr.right;
                curr.right.p = curr.p;
            }
        } else {
            root = curr.right;
            curr.right.p = null;
        }
        curr.p = curr.right;
        Node tmp = curr.right.left;
        curr.right.left = curr;
        curr.right = tmp;
    }

    private void rotateRight(Node curr) {
        if (curr == null || curr == nil || curr.left == nil) {
            throw new IllegalArgumentException("rotateRight curr:" + curr);
        }
        if (curr != root) {
            if (curr.p.left == curr) {
                curr.p.left = curr.left;
                curr.left.p = curr.p;
            } else {
                curr.p.right = curr.left;
                curr.left.p = curr.p;
            }
        } else {
            root = curr.left;
            curr.left.p = null;
        }
        curr.p = curr.left;
        Node tmp = curr.left.right;
        curr.left.right = curr;
        curr.left = tmp;
    }


    private class Node {


        private Integer element;
        /**
         * 颜色
         */
        private int color;
        /**
         * 父节点
         */
        private Node p;
        private Node left;
        private Node right;

        public Node(Integer element) {
            this.element = element;
            this.color = RED;
            left = nil;
            right = nil;
        }

        public Node(Integer element, Node p, Node l, Node r, int color) {
            this.element = element;
            this.p = p;
            this.left = left;
            this.right = r;
            this.color = color;
        }
    }

}
