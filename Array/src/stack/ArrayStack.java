package stack;

import array.Array;

/**
 * Created by slsan on 2018/9/5.
 */
public class ArrayStack<E> implements Stack<E> {

    public static void main(String[] args){
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0 ; i < 10 ; i++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());
    }

    Array<E> arr;

    public ArrayStack(){
        arr = new Array<>();
    }

    public ArrayStack(int capacity){
        arr = new Array<>(capacity);
    }


    public int getCapacity(){
        return arr.getCapacity();
    }

    // 时间复杂度 O(1) 触发动态数组 则为 O(n) 均摊时间复杂度为 O(1)
    @Override
    public int getSize() {
        return arr.getSize();
    }

    // 时间复杂度 O(1) 触发动态数组 则为 O(n) 均摊时间复杂度为 O(1)
    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    // 时间复杂度 为 O(1)
    @Override
    public void push(E e) {
        arr.addLast(e);
    }

    @Override
    public E pop() {
        return arr.removeLast();
    }

    @Override
    public E peek() {
        return arr.getLast();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("stack.Stack [");
        for (int i = 0; i < arr.getSize(); i++ ){
            builder.append(arr.get(i));
            if (i < arr.getSize() - 1)
                builder.append(",");
        }

        builder.append("] top");
        return builder.toString();
    }
}
