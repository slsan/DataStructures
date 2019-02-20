package map;

import binarysearch.BST;
import set.FileOPerate;

import java.util.ArrayList;

/**
 * Created by slsan on 2018/9/13.
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }


    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {

        // 当前二分搜索树为空 则直接创建
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);

        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        }
        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        }
        // 左节点为空
        if (node.left == null) {

            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        // 删除右节点为空
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        // 左右子树都不为空
        Node successor = minNum(node.right);
        successor.right = removeMin(node.right);
        successor.left = node.left;
        node.right = node.left = null;

        return successor;


    }

    // 返回二分搜索树所在的最小节点
    private Node minNum(Node node) {
        if (node.left == null)
            return node;

        return minNum(node.left);
    }

    // 删除以 以 node 为根的二分搜索树的最小节点,返回删除节点后的新的根
    private Node removeMin(Node node) {
        if (node == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + " not exist");

        node.value = value;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    private Node getNode(Node node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) == 0)
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }

    public static void main(String[] args){
        System.out.println("---------------统计字数-------------");

        ArrayList<String> words = new ArrayList<>();
        if (FileOPerate.readFile("a.txt",words)){

            System.out.println("total size =" + words.size());

            BSTMap<String,Integer> map = new BSTMap<>();
            for (String word : words){
                if (map.contains(word)){
                    map.set(word,map.get(word) + 1);
                }else {
                    map.add(word,1);
                }
            }

            System.out.println("Total diffent word =" + map.size);
            System.out.println("Total word is have = " + map.get("is"));
            System.out.println("Total word pride have = " + map.get("pride"));
        }
    }
}
