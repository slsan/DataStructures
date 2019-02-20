package queue;

/**
 * Created by slsan on 2018/9/5.
 *
 * 循环队列 当 队首 == 队尾 的时候我们认为队列为空 当 (队首 + 1)% 容量 == 队尾时 我们认为队列是满的 因此,总会有一个空间是被浪费的
 * 用户想达到自己想要的空间大小,就要在创建 数组时多创建一个空间
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] arr;
    private int front,tail,size;

    public LoopQueue(){
        this(10);
    }

    public LoopQueue(int capacity){
        arr = (E[]) new Object[capacity + 1]; // 多创建一个空间
        front = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return  front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return arr.length -1; //默认浪费一个空间
    }

    @Override
    public void enQueue(E e) {
        // 检查数组是否已满
        if ((tail + 1) % arr.length == front)
            resize(getCapacity() * 2);

        arr[tail] = e;
        tail = (tail + 1) % arr.length;
        size++;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size ;i++){
            newData[i] = arr[(i + front) % arr.length];
        }
        arr = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E deQueue() {

        if (isEmpty())
            throw new IllegalArgumentException("Cannot deQueue from an empty queue");

        E data = arr[front];
        arr[front] = null;
        front = (front + 1) % arr.length;
        size--;

        // 出队缩容
        if (getCapacity() != 0 && size == getCapacity()/4)
            resize(getCapacity()/2);
        return data;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty");

        return arr[front];
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue :size = %d , capacity = %d \n", size , getCapacity()));
        builder.append("front [");
        for (int i = front; i != tail; i = (i + 1) % arr.length ){
            builder.append(arr[i]);
            if ((i+1)%arr.length != tail)
                builder.append(",");
        }
        builder.append("] tail");
        return builder.toString();
    }

    public static void main(String[] args){
        LoopQueue<Integer> arrayQueue = new LoopQueue<>();

        for (int i = 0; i < 10 ; i++){
            arrayQueue.enQueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 0) {
                arrayQueue.deQueue();
                System.out.println(arrayQueue);
            }
        }

        System.out.println(arrayQueue.getFront());
    }
}
