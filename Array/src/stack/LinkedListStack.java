package stack;


import linkedlist.LinkedList;

/**
 * Created by slsan on 2018/9/6.
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Stack : top \n");
        builder.append(list);
        return builder.toString();
    }

    public static void main(String[] args){
        LinkedListStack<Integer> link = new LinkedListStack<>();

        for (int i = 0; i < 5; i++){
            link.push(i);
            System.out.println(link);
        }

        link.pop();
        System.out.println(link);

        System.out.println(link.peek());

    }
}
