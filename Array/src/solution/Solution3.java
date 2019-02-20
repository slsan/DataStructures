package solution;

import others.ListNode;

/**
 * Created by slsan on 2018/9/10.
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;

//        ListNode node = removeElements(head.next,val);
//
//        if (head.val == val){
//            return node;
//        }else {
//            head.next = node;
//            return head;
//        }

        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,6,5,6,4,6,8};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);


       ListNode node = (new Solution3()).removeElements(listNode,6);
        System.out.println(node);
    }
}
