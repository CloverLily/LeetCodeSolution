package com.li.Medium;

public class _2AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sumVal = l1.val + l2.val;
        int carry = 0;
        if (sumVal >= 10) {
            carry = sumVal / 10;
            sumVal -= 10;

        }
        ListNode sum = new ListNode(sumVal);
        while(l1.next != null && l2.next != null){
            sum.next.val=l1.val+l2.val+carry;
        }

        return sum;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}