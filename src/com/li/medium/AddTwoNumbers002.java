package com.li.medium;

import com.li.common.ListNode;
/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * ps:
 *  Definition for singly-linked list.
 *  public class ListNode {
 *    int val;
 *    ListNode next;
 *    ListNode(int x) { val = x; }
 *    }
 *
 * @author system
 */
public class AddTwoNumbers002 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode b1 = new ListNode(4);
        ListNode c1 = new ListNode(3);
        l1.next = b1;
        b1.next = c1;
        ListNode l2 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode c2 = new ListNode(4);
        l2.next = b2;
        b2.next = c2;

        ListNode result;
        result = addTwoNumbers(l1, l2);

        ListNode l3 = new ListNode(1);
        ListNode b3 = new ListNode(8);
        l3.next = b3;
        ListNode l4 = new ListNode(0);
        l2.next = b2;
        //result = addTwoNumbers(l3, l4);

        //result = addTwoNumbers(new ListNode(5), new ListNode(5));

        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int carry = 0, sum;
        ListNode listSum = new ListNode(0);
        ListNode n1 = l1, n2 = l2, curl = listSum;
        int val1, val2;
        while (n1 != null || n2 != null) {
            val1 = (n1 == null) ? 0 : n1.val;
            val2 = (n2 == null) ? 0 : n2.val;
            sum = val1 + val2 + carry;
            curl.next = new ListNode(sum % 10);
            curl = curl.next;
            carry = sum / 10;
            n1 = (n1 == null) ? null : n1.next;
            n2 = (n2 == null) ? null : n2.next;

        }
        if (carry == 1) {
            curl.next = new ListNode(1);
        }
        return listSum.next;
    }
}
