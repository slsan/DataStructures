import array.Array;
import queue.ArrayQueue;
import queue.LinkedListQueue;
import queue.LoopQueue;
import queue.Queue;
import stack.ArrayStack;
import stack.LinkedListStack;
import stack.Stack;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
//	  Array<Integer> arr = new Array<>();
//
//        for (int i = 0; i < 10 ;i++){
//            arr.addLast(i);
//        }
//
//        System.out.println(arr);
//
//        arr.add(2,20);
//        System.out.println(arr);
//
//        arr.addFirst(100);
//        System.out.println(arr);
//
//        arr.remove(3);
//        System.out.println(arr);
//
//        arr.removeElement(100);
//        System.out.println(arr);
//
//        arr.remove(2);
//        System.out.println(arr);
        int count = 100000;
        ArrayQueue<Integer> arr = new ArrayQueue<>();
        double time1 = testQueue(arr, count);
        System.out.println("ArrayQueue time = " + time1 + " s");


        LoopQueue<Integer> loop = new LoopQueue<>();
        double time2 = testQueue(loop, count);
        System.out.println("LoopQueue time = " + time2 + " s");

        LinkedListQueue<Integer> link = new LinkedListQueue<>();
        double time3 = testQueue(link, count);
        System.out.println("LinkedListQueue time = " + time3 + " s");

//        ArrayStack<Integer> arr = new ArrayStack<>();
//        double time1 = testStack(arr, count);
//        System.out.println("ArrayStack time = " + time1 + " s");
//
//
//        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
//        double time2 = testStack(linkedListStack, count);
//        System.out.println("LoopQueue time = " + time2 + " s");
    }

    private static double testQueue(Queue<Integer> queue, int count) {

        double startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            queue.enQueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < count; i++)
            queue.deQueue();

        double endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }


    private static double testStack(Stack<Integer> stack, int count) {

        double startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < count; i++)
            stack.pop();

        double endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }


}
