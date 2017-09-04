package leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Solution2 {

    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "999999991";
        ListNode result = new Solution2().addTwoNumbers(getListNode(num1), getListNode(num2));
        ListNode temp = result;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        boolean addon = false;
        ListNode first= null;
        ListNode pre = null;
        while (temp1 != null || temp2 != null || addon) {
            int sum;
            if (addon) {
                sum = 1;
            } else {
                sum = 0;
            }
            int num1;
            int num2;
            if (temp1 != null) {
                num1 = temp1.val;
                temp1 = temp1.next;
            }else {
                num1 = 0;
            }
            if (temp2 != null) {
                num2 = temp2.val;
                temp2 = temp2.next;
            }else {
                num2=0;
            }

            sum += num1 + num2;
            addon = sum >= 10;

            if(first == null) {
                first = new ListNode(sum%10);
                pre = first;
            } else {
                pre.next = new ListNode(sum%10);
                pre = pre.next;
            }

        }
        return first;

    }

    public static ListNode getListNode(String num) {
        ListNode first = null;
        ListNode pre = null;
        for (int i = num.length() - 1; i >= 0; i--) {
            ListNode node = new ListNode((char) num.charAt(i) - 48);
            if (i == num.length() - 1) {
                first = node;
            } else {
                pre.next = node;
            }
            pre = node;

        }
        return first;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode add(ListNode l1, ListNode l2, boolean plus) {
        if (l1 == null) {
            if (l2 == null) {
                if (plus) {
                    return new ListNode(1);
                } else {
                    return null;
                }
            } else {
                if (plus) {
                    return add(new ListNode(1), l2, false);
                } else {
                    return l2;
                }
            }
        } else {
            if (l2 == null) {
                if (plus) {
                    return add(l1, new ListNode(1), false);
                } else {
                    return l1;
                }
            } else {
                int val = l1.val + l2.val;
                if (plus) {
                    val += 1;
                }
                boolean nextPlus = val >= 10 ? true : false;
                ListNode result;
                if (nextPlus) {
                    result = new ListNode(val - 10);
                } else {
                    result = new ListNode(val);
                }

                result.next = add(l1.next, l2.next, nextPlus);
                return result;
            }

        }

    }


}