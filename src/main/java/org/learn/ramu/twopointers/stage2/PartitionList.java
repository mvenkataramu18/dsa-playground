package org.learn.ramu.twopointers.stage2;

import org.learn.ramu.twopointers.stage1.ListNode;

public class PartitionList {

    public static ListNode partition(ListNode head, int x) {

        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode lessTail = lessDummy;
        ListNode greaterTail = greaterDummy;
        ListNode curr = head;
        while (curr != null) {
            if(curr.val < x) {
                lessTail.next = curr;
                lessTail = lessTail.next;
            }
            else {
                greaterTail.next = curr;
                greaterTail = greaterTail.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }

        lessTail.next = greaterDummy.next;
        greaterTail.next = null;

        return lessDummy.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        head = partition(head, 3);

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}

