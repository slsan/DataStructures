package set;

/**
 * Created by slsan on 2018/9/12.
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    int getSize();
    boolean contains(E e);
    boolean isEmpty();

}
