package solution;

import others.ListNode;
import queue.LinkedListQueue;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

/**
 * Created by slsan on 2018/9/6.
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {

        // 头结点是否相同
        while (head != null && head.val == val){
            ListNode listNode = head;
            head = listNode.next;
            listNode.next = null;
        }

        // 头结点不同,中间节点是否相同
        if (head == null)
            return null;

        ListNode prev = head;
        while (prev.next != null){
            if (prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else {
                prev = prev.next;
            }
        }
        return head;
    }
}
