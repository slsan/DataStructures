package queue;

/**
 * Created by slsan on 2018/9/6.
 */
public class LinkedListQueue<E> implements Queue<E> {

    public class Node{
        private E e;
        private Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enQueue(E e) {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E deQueue() {

        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");

        Node node = head;
        head = head.next;
        node.next = null;

        if (head == null)
            tail = null;

        return node.e;
    }

    @Override
    public E getFront() {

        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");

        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LinkedListQueue : front ");

        Node cur = head;

        while (cur != null){
            builder.append(cur + "->");
            cur = cur.next;
        }

        builder.append("null ");
        return builder.toString();
    }

    public static void main(String[] args){
        LinkedListQueue<Integer> arrayQueue = new LinkedListQueue<>();

        for (int i = 0; i < 10 ; i++){
            arrayQueue.enQueue(i);
            System.out.println(arrayQueue);
        }

        arrayQueue.deQueue();
        System.out.println(arrayQueue);

        System.out.println(arrayQueue.getFront());
    }
}
