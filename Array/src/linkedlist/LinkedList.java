package linkedlist;

/**
 * Created by slsan on 2018/9/6.
 */
public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    //    private Node head;
    private Node dummyHead;// 设置个虚拟头结点
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    // 在链表中间插入元素,关键点是找到需要插入位置的前一个节点
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed, index error");

        // 遍历链表, 每一个等于当前的 next
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;

//      prev.next = new Node(e,prev.next);
//      可以使用当前代替上面,new Node,传入数据,把 head 节点当做下一个节点,并把新 node 赋值给 head

        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }


    public void addLast(E e) {
        add(size, e);
    }

    // 找当前节点的元素和找当前节点的下一个节点
    public E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed , illegal index");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    // 修改 index 位置元素
    public void set(int index , E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed , illegal index");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        cur.e = e;
    }

    // 链表是否包含元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed, illegal index");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }

        Node curNode = prev.next;
        prev.next = curNode.next;
        curNode.next = null;

        size--;

        return curNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size -1);
    }

    public void removeElement(E e){
        Node prev = dummyHead;
        while (prev.next != null){
            if (e.equals(prev.next.e))
                break;
            prev = prev.next;
        }

        if (prev.next != null)
        {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            builder.append(cur + "->");
            cur = cur.next;
        }

        // 使用 for 循环代替 while 循环
//        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
//            builder.append(cur + "->");

        builder.append("null");
        return builder.toString();
    }

    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5;i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2,234);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

    }
}
