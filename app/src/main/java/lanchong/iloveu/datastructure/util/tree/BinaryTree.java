package lanchong.iloveu.datastructure.util.tree;

public interface BinaryTree<E> {



    void add(E element);
    E remove(E element);
    int size();
//    int indexOf(E element);
    boolean isEmpty();

    /**
     * 前序遍历
     */
    void prevOrder();
    /**
     * 中序遍历
     */
    void inOrder();
    /**
     * 后序遍历
     */
    void postOrder();
    /**
     * 层序遍历
     */
    void levelOrder();









}
