package map;


import set.FileOPerate;

import java.util.ArrayList;

/**
 * Created by slsan on 2018/9/12.
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node node) {
            this.key = key;
            this.value = value;
            this.next = node;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);

        if (node == null){
            // 没有当前可以存在,直接添加到头结点
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }else {
            // 否则认为出异常或者更新对应的值
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.key.equals(key))
                break;
            prev = prev.next;
        }

        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node == null)
            throw new IllegalArgumentException(key + " not exist!");

        node.value = value;
    }

    @Override
    public V get(K key) {

        Node node = getNode(key);
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

    private Node getNode(K key) {

        Node cur = dummyHead.next;

        while (cur != null) {
            if (key.equals(cur.key))
                return cur;
            cur = cur.next;
        }
        return null;
    }


    public static void main(String[] args){
        System.out.println("---------------统计字数-------------");

        ArrayList<String> words = new ArrayList<>();
        if (FileOPerate.readFile("a.txt",words)){

            System.out.println("total size =" + words.size());

            LinkedListMap<String,Integer> map = new LinkedListMap<>();
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