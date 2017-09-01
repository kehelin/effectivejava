package leetcode;

/**
 * Created by wangminghui on 2017/6/2.
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1,l2,false);
    }
    public ListNode add(ListNode l1, ListNode l2, boolean plus) {
        if(l1 == null) {
            if(l2 == null) {
                if(plus) {
                    return new ListNode(1);
                }else {
                    return null;
                }
            }else {
                if(plus) {
                    return add( new ListNode(1),l2,false);
                } else {
                    return l2;
                }
            }
        }else {
            if(l2 == null){
                if(plus) {
                    return add(l1,new ListNode(1),false);
                } else {
                    return l1;
                }
            }else {
                int val = l1.val +l2.val;
                if(plus) {
                    val +=1;
                }
                boolean nextPlus = val>=10?true:false;
                ListNode result;
                if(nextPlus) {
                    result = new ListNode(val-10);
                } else {
                    result = new ListNode(val);
                }

                result.next = add(l1.next,l2.next,nextPlus);
                return result;
            }

        }

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
