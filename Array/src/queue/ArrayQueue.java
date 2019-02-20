package queue;

import array.Array;

/**
 * Created by slsan on 2018/9/5.
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> arr;
    public ArrayQueue(){
        arr = new Array<>();
    }

    public ArrayQueue(int capacity){
        arr = new Array<>(capacity);
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public int getSize() {
        return arr.getSize();
    }

    @Override
    public void enQueue(E e) {
        arr.addLast(e);
    }

    // 时间复杂度 O(n),去对首,其余元素需要前移一位导致移动为 n
    @Override
    public E deQueue() {
        return arr.removeFirst();
    }

    @Override
    public E getFront() {
        return arr.get(0);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Queue: front [");
        for (int i = 0; i < arr.getSize(); i++){
            builder.append(arr.get(i));

            if (i < arr.getSize() - 1)
                builder.append(",");
        }
        builder.append("] tail");
        return builder.toString();
    }

    public static void main(String[] args){
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        for (int i = 0; i < 10 ; i++){
            arrayQueue.enQueue(i);
            System.out.println(arrayQueue);
        }

        arrayQueue.deQueue();
        System.out.println(arrayQueue);

        System.out.println(arrayQueue.getFront());
    }
}
