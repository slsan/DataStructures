package heap;

import array.Array;

import static com.sun.tools.doclint.Entity.pi;

/**
 * Created by slsan on 2018/9/18.
 */
public class MaxHeap <E extends Comparable<E>>{

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length -1 ); i >= 0;i--)
            siftDown(i);
    }

    public int getSize(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 返回二叉树所表示的数组中,下标所对应的元素父亲节点的下标
    public int parent(int index){
        if (index == 0)
            throw new IllegalArgumentException("index == 0 is no parent");

        return (index -1)/2;
    }

    // 返回左孩子所对应的下标
    public int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回右孩子所对应下标
    public int rightChild(int index){
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() -1);
    }

    private void siftUp(int index) {
        while(index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0){
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    public E findMax(){
        if (data.getSize() == 0)
            throw new IllegalArgumentException("the heap no  max element");

        return data.get(0);
    }

    public E extractMax(){
        E temp = findMax();

        data.swap(0,getSize()-1);
        data.removeLast();
        siftDown(0);

        return temp;
    }

    private void siftDown(int index) {
        //获取左右子孩子最大值,作交换

        while ( leftChild(index)  <  data.getSize() ){
            int temp = leftChild(index);

            if (rightChild(index) < data.getSize() &&
                    data.get(rightChild(index)).compareTo(data.get(leftChild(index))) > 0){
                temp = rightChild(index);
                // data[temp] 始终存储子孩子的最大值
            }

            if (data.get(index).compareTo(data.get(temp)) >= 0)
                break;

            data.swap(index,temp);
          index = temp;
        }
    }

    // 替换堆顶的元素, 操作时间复杂度是 logn
    public E replace(E e){
        E temp = findMax();
        data.set(0,e);
        siftDown(0);
        return temp;
    }

    // 将任意的数组整理成堆的形状

}
