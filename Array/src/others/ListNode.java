package others;

/**
 * Created by slsan on 2018/9/6.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] x) {

        if (x == null || x.length == 0)
            throw new IllegalArgumentException("x cannot be null");

        this.val = x[0];

        ListNode cur = this;
        for (int i = 1; i < x.length; i++) {
            cur.next = new ListNode(x[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while(cur != null){
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }

}
