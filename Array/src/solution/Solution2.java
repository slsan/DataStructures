package solution;

import others.ListNode;

/**
 * Created by slsan on 2018/9/6.
 */
public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {
        // 使用虚拟头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        while (prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return dummyNode.next;
    }
}
