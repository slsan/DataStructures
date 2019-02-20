package array;

/**
 * Created by slsan on 2018/9/4.
 */
public class Array<E> {
    private E[] datas;
    private int size;

    // 默认构造,默认容量为10

    public Array(){
        this(10);
    }

    // 构造,capacity 数组容量
    public Array(int capacity){
        this.datas = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(E[] arr){
        datas = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
            datas[i] = arr[i];
        size = arr.length;
    }

    // 获取数组大小
    public int getSize(){
        return size;
    }

    // 获取数组容量
    public int getCapacity(){
        return datas.length;
    }

    // 判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 向数组末尾添加一个元素
    public void addLast(E e){
        add(size,e);
    }

    // 向数组开头添加一个元素
    public void addFirst(E e){
        add(0,e);
    }

    // 向数组中任意位置添加一个元素
    public void add(int index , E e){

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Required index >= 0 and index < size");
        }

        // 时间复杂度震荡, 当数组内容超过数组长度就扩容为原数组容量的2倍
        if (size == datas.length)
            resize(2 * datas.length);

        for (int i = size -1; i >= index; i--)
            datas[i + 1] = datas[i];

        datas[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];

        for (int i = 0; i < size; i++){
            newData[i] = datas[i];
        }
        datas = newData;
        newData = null;
    }

    public void swap(int i , int j){
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("index is Illegal");

        E temp = datas[i];
        datas[i] = datas[j];
        datas[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("array.Array : size = %d , capacity = %d\n", size, datas.length));
        builder.append("[");
        for (int i = 0; i < size ;i++){
            builder.append(datas[i]);
            if (i < size - 1){
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed , Required index > 0 and index < size");

        return datas[index];
    }

    public E getLast(){
        return get(size -1);
    }

    public E getFirst(){
        return get(0);
    }

    public void set(int index , E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed, Required index > 0 and index < size");

        datas[index] = e;
    }

    // 是否包含当前元素,包含当期元素返回 true,否则返回 false
    public boolean contains(E e){
        for (int i = 0; i < size ;i++){
            if (datas[i].equals(e))
                return true;
        }
        return false;
    }

    // 查找元素找到返回当前位置,找不到返回-1
    public int find(E e){
        for (int i = 0; i < size ;i ++){
            if (datas[i].equals(e))
                return i;
        }
        return -1;
    }

    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed, Required index > 0 and index < size");

        E temp = datas[index];

        for (int i = index + 1; i < size; i++){
            datas[i - 1] = datas[i];
        }
        datas[size - 1] = null;
        size--;
        // 时间复杂度震荡, 当缩减大小时,数组长度为容量的1/4,才去缩减数组容量的1/2
        if (datas.length != 0 && size == datas.length / 4)
            resize(datas.length / 2);
        return temp;
    }

    public E  removeLast(){
       return remove(size - 1);
    }

    public E removeFirst(){
       return remove(0);
    }

    public void removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

}
