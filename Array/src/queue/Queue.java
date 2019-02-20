package queue;

/**
 * Created by slsan on 2018/9/5.
 */
public interface Queue<E> {
    boolean isEmpty();
    int getSize();
    void enQueue(E e);
    E deQueue();
    E getFront();
}
