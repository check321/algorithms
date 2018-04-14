package net.check321.algorithms.structures;


import lombok.extern.slf4j.Slf4j;

/**
 * @author check321
 * @title 二分搜索树
 * @description 结构内由节点组成，并维护子节点的引用
 * @date 2018/4/14 15:25
 */
@Slf4j
public class BinarySearchTree<K extends Comparable<K>, V> {

    // 节点结构
    private class Node {
        // 键值对
        private K key;
        private V value;

        // 子节点引用(左右子节点)
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    // 树根节点
    private Node root;
    // 节点数
    private int count;


    // 默认构造，无节点树
    public BinarySearchTree() {
        root = null;
        count = 0;
    }


    /**
     * 返回节点个数
     *
     * @return
     */
    public int size() {
        return count;
    }


    /**
     * 是否为无节点树
     *
     * @return
     */
    public boolean isEmpty() {
        return 0 == count;
    }


    /**
     * 新增元素
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        root = insert(root, key, value);
    }

    /**
     * BTS是否包含Key
     *
     * @param key
     * @return
     */
    public boolean isContains(K key) {
        return isContains(root, key);
    }

    /**
     * 根据K 获取V
     *
     * @param key
     * @return
     */
    public V get(K key) {
        return search(root, key);
    }

    /**
     * 新增元素
     *
     * @param node  插入元素的根节点
     * @param key
     * @param value
     * @return 插入新元素后的BST根节点
     */
    private Node insert(Node node, K key, V value) {

        // 默认根节点
        if (null == node) {
            count++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) == 0) {
            // 替换节点
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            // 递归加入左子节点
            node.left = insert(node.left, key, value);
        } else {
            // 加入右子节点
            node.right = insert(node.right, key, value);
        }

        return node;
    }

    /**
     * 在以node为根的BST中是否包含key的Node
     *
     * @param node
     * @param key
     * @return
     */
    private boolean isContains(Node node, K key) {

        if (node == null) {
            return false;
        }

        if (node.key.compareTo(key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            // 左子节点
            return isContains(node.left, key);
        } else {
            // 右子节点
            return isContains(node.right, key);
        }
    }


    /**
     * @param node
     * @param key
     * @return
     */
    private V search(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (node.key.compareTo(key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    public static void main(String[] args) {

        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(1,"one");
        bst.put(2,"two");
        bst.put(3,"three");
        bst.put(4,"four");
        bst.put(5,"five");
        bst.put(6,"six");

        log.info("bst result:{}",bst.get(5));
    }
}
