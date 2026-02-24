package org.learn.ramu.twopointers.stage2;

import org.learn.ramu.twopointers.stage1.ListNode;

public class DetectCycle {

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        boolean cycleExists = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                cycleExists = true;
                break;
            }
        }
        if(cycleExists) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        else {
            return null;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next;

        ListNode cycleStart = detectCycle(head);
        assert cycleStart != null;
        System.out.println("cycle start " + cycleStart.val);
    }

}
