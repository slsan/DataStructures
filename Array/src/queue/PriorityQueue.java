package queue;

import heap.MaxHeap;

/**
 * Created by slsan on 2018/9/18.
 */
public class PriorityQueue <E extends Comparable<E>> implements Queue<E>{

    private MaxHeap<E> heap;

    public PriorityQueue(){
        heap = new MaxHeap<>();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int getSize() {
        return heap.getSize();
    }

    @Override
    public void enQueue(E e) {
        heap.add(e);
    }

    @Override
    public E deQueue() {
        return heap.extractMax();
    }

    @Override
    public E getFront() {
        return heap.findMax();
    }
}
