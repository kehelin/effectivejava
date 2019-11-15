package leetcode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class Solution21 {
    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        node11.next = node12;
        ListNode node13 = new ListNode(4);
        node12.next = node13;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;

        ListNode result = new Solution21().mergeTwoLists2(node11, node21);
        while (result != null) {
            System.out.println(result.val + "->");
            result = result.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode root;
        ListNode other, current;
        if (l1.val <= l2.val) {
            root = l1;
            other = l2;
        } else {
            root = l2;
            other = l1;
        }
        current = root;
        while (current.next != null && other != null) {
            if (current.next.val > other.val) {
                ListNode temp = current.next;
                current.next = other;
                other = temp;
            }
            current = current.next;
        }
        if (other != null) {
            current.next = other;
        }
        return root;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode root, current;
        if (l1.val <= l2.val) {
            root = l1;
            l1 = l1.next;
        } else {
            root = l2;
            l2 = l2.next;
        }
        current = root;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 == null) {
            current.next = l2;
        }
        if (l2 == null) {
            current.next = l1;
        }
        return root;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
