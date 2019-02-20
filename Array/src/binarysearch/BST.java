package binarysearch;

import java.util.*;

/**
 * Created by slsan on 2018/9/11.
 * 二分搜索树 递归实现 和 非递归实现
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        private E e;
        private Node left, right; // 左孩子,右孩子

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root; // 父节点
    private int size; // 二叉树大小

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树中添加元素 e
    public void add(E e) {
        // 根节点是不是存在,不存在直接添加到根节点
//        if (root == null) {
//            root = new Node(e);
//            size++;// 维护 size
//        } else {
//            // 给子节点添加该子元素
//            add(root, e);
//        }

        // 改进递归后的调用方式
        root = add(root, e);
    }

    // 递归给固定 node添加元素 e
  /*
    private void add(Node node , E e){

        // 递归终止条件
        if (node.e.equals(e)){ // 当前节点已存在
            return;
        }else if (e.compareTo(node.e) < 0 && node.left == null){ // 小于父节点,左子树不存在
            node.left = new Node(e);
            size++;
            return;
        }else if (e.compareTo(node.e)  > 0 && node.right == null){// 小于父节点,右子树不存在
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0) // 小于父节点
            add(node.left,e);
        else                         // 肯定大于父节点,终止条件比考虑相等
            add(node.right,e);
    }*/

    // 改进后 的递归算法 返回插入新节点后二叉树的根
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        // 对于相等情况不做任何处理
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }


    // 二分搜索树中是否包含元素 e
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 以 node 为根的节点是否包含元素 e , 递归算法
    private boolean contains(Node node, E e) {
        // 当前 node 不存在
        if (node == null)
            return false;

        if (node.e.compareTo(e) == 0)
            return true;
        else if (node.e.compareTo(e) > 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    // 二分搜索树遍历 (前序遍历,先遍历父节点在遍历左右子树)
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {

        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 后续遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {

        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }

    // 非递归前序遍历
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);

            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    // 非递归中序遍历
    public void inOrderNR() {

    }

    // 非递归后序遍历
    public void postOrderNR() {

    }

    // 二叉树的层序遍历 也叫广度遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);


            if (cur.left != null)
                queue.add(cur.left);

            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    // 获取二分搜索树中的最小值
    public E minNum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is Empty");

        return minNum(root).e;
    }

    // 递归获取最小值
    private Node minNum(Node node) {
        if (node.left == null)
            return node;
        return minNum(node.left);
    }

    // 获取二分搜索树的最大值
    public E maxNum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maxNum(root).e;
    }

    // 递归二分搜索树的最大值
    private Node maxNum(Node node) {
        if (node.right == null)
            return node;

        return maxNum(node.right);
    }

    // 删除最小元素
    public E removeMin() {
        E min = minNum();
        root = removeMin(root);
        return min;
    }

    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E max = maxNum();
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {

            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null)
            return null;

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }else { // e == node.e
            // 左子树 == null
            if (node.left == null){
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }

            if (node.right == null){
                Node left = node.left;
                node.left = null;
                size--;
                return node;
            }

            Node successor = minNum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * @param root 从哪开始遍历
     * @param i    遍历深度
     * @param res  字符串拼接
     */
    private void generateBSTString(Node root, int i, StringBuilder res) {
        if (root == null) {
            res.append(generateDepthString(i) + "null\n");
            return;
        }

        res.append(generateDepthString(i) + root.e + "\n");
        generateBSTString(root.left, i + 1, res);
        generateBSTString(root.right, i + 1, res);
    }

    /**
     * @param depth 遍历深度
     * @return
     */
    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
//        int[] arr = {5, 2, 4, 6, 3, 8, 9};
//        for (int arrs : arr)
//            bst.add(arrs);
//
//        bst.preOrder();
//
//        System.out.println();
//
//        bst.inOrder();
//
//        System.out.println();
//
//        bst.postOrder();
//
//        System.out.println("------------非递归实现----------");
//
//
//        bst.preOrderNR();
//
//        System.out.println("------------层序遍历----------");
//
//        bst.levelOrder();
//        System.out.println(bst);


        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!bst.isEmpty()) {
            list.add(bst.removeMin());
        }

        System.out.println(list.size());
        System.out.println(list);
    }


}
