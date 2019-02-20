package map;

/**
 * Created by slsan on 2018/9/12.
 */
public interface Map<K,V>{
    void add(K key,V value);
    V remove(K key);
    boolean contains(K key);
    void set(K key , V value);
    V get(K key);
    boolean isEmpty();
    int getSize();
}
