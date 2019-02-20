package stack;

/**
 * Created by slsan on 2018/9/5.
 */
public interface Stack<E> {
    int getSize();  // 获取栈的大小
    boolean isEmpty(); // 栈是否为空
    void push(E e);   // 入栈
    E pop();   // 出栈
    E peek(); // 查看栈顶元素
}
