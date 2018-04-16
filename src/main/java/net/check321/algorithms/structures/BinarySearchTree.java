package net.check321.algorithms.structures;


import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

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

    /**
     * 以当前Node节点为根前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }


    /**
     * 中序遍历
     */
    public void midOrder() {
        midOrder(root);
    }

    /**
     * 后续遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        // 队列
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            log.info("node: {}", node.key);

            if (null != node.left) {
                queue.add(node.left);
            }

            if (null != node.right) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 删除最小元素
     */
    public void removeMin() {
        if (root != null) {
           root = removeMin(root);
        }
    }

    /**
     * 删除最大元素
     */
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }

    /**
     * 递归到最左子节点
     *
     * @param node
     * @return 删除元素后的根节点
     */
    private Node removeMin(Node node) {

        // 最左子节点
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;

            count--;
            return rightNode;
        }

        // 继续递归到底
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 递归到最右子节点
     *
     * @param node
     * @return 删除元素后的根节点
     */
    private Node removeMax(Node node) {
        if (null == node.right) {
            Node leftNode = node.left;
            node.left = null;
            count--;

            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }


    private void preOrder(Node node) {
        if (null != node) {
            log.info("node: {}", node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void midOrder(Node node) {
        if (null != node) {
            midOrder(node.left);
            log.info("node: {}", node.key);
            midOrder(node.right);
        }
    }

    private void postOrder(Node node) {
        if (null != node) {
            postOrder(node.left);
            postOrder(node.right);
            log.info("node: {}", node.key);
        }
    }


    public static void main(String[] args) {

        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(1, "one");
        bst.put(2, "two");
        bst.put(3, "three");
        bst.put(4, "four");
        bst.put(5, "five");
        bst.put(6, "six");

        log.info("bst result:{}", bst.get(5));

//        bst.preOrder();
//        bst.midOrder();

//
//        bst.removeMax();
        bst.removeMin();
//        bst.levelOrder();
        bst.postOrder();
    }
}
