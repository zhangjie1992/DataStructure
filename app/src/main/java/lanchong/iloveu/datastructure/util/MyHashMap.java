package lanchong.iloveu.datastructure.util;

/**
 * 706. 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射
 * <p>
 * 具体地说，你的设计应该包含以下的功能:
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 * <p>
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 * <p>
 * 由于没有哨兵节点。所以不能保持一致
 */
public class MyHashMap {

    private Node[] nodeArray;

    private int size;
    private int initialCapacity;
    private float loadFactor;


    public MyHashMap() {
        init();
    }

    private void init() {
        size = 0;
        initialCapacity = 1006;
        loadFactor = 0.75f;
        nodeArray = new Node[initialCapacity];
    }

    private void examineSize() {
        if (size + 1 >= initialCapacity * loadFactor) {
            initialCapacity = initialCapacity * 2 + 1;

            rehash();
        }
    }

    private void rehash() {
        Node[] newNodeArray = new Node[initialCapacity];
        for (Node aNodeArray : nodeArray) {
            Node node = aNodeArray;
            while (node != null) {
                int hash = hash(node.key);
                Node tmp = newNodeArray[hash];
                newNodeArray[hash] = new Node(node.key, node.element, tmp, null);
                if (tmp != null) {
                    tmp.prev = newNodeArray[hash];
                }
                node = node.next;
            }
        }
        nodeArray = newNodeArray;
    }

    public void put(int key, int value) {
        examineSize();
        int hash = hash(key);

        boolean contains = false;

        Node node = nodeArray[hash];
        while (node != null) {
            if (node.key == key) {
                node.element = value;
                contains = true;
                break;
            }
            node = node.next;
        }
        if (!contains) {
            Node tmp = nodeArray[hash];
            nodeArray[hash] = new Node(key, value, nodeArray[hash], null);
            if (tmp != null) {
                tmp.prev = nodeArray[hash];
            }
            size++;
        }
    }

    public int get(int key) {
        int hash = hash(key);

        Node node = nodeArray[hash];
        while (node != null) {
            if (node.key == key) {
                return node.element;
            }
            node = node.next;
        }
        return -1;
    }


    public void remove(int key) {
        int hash = hash(key);

        Node node = nodeArray[hash];

        if (node != null && node.key == key) {
            Node next = node.next;
            if (next != null) {
                next.prev = null;
            }
            nodeArray[hash] = next;
            size--;
            return;
        }
        while (node != null) {
            if (node.key == key) {
                Node prev = node.prev;
                Node next = node.next;
                if (prev != null) {
                    prev.next = next;
                }
                if (next != null) {
                    next.prev = prev;
                }
                size--;
                break;
            }
            node = node.next;
        }

    }

    private int hash(int key) {
        return key % initialCapacity;
    }


    private class Node {
        private int key;
        private int element;
        private Node next;
        private Node prev;

        public Node(int key, int element, Node next, Node prev) {
            this.key = key;
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

}


