package com.li.AboutListNode;

import com.li.Common.ListNode;

/**
 * 删除链表的重复节点
 * e.g
 * input:
 * 1->2->2->4->4->5
 * output:
 * 1->5
 * @author system
 */
public class DeleteDuplicateNode {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node = deleteDuplicateNode(head);

        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if(node != null){
                System.out.print("->");
            }
        }
    }

    private static ListNode deleteDuplicateNode(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                int value = head.val;
                head = head.next.next;
                while (head != null && head.val == value) {
                    head = head.next;
                }
                pre.next = head;
            } else {
                pre = head;
                head = head.next;
            }
        }
        return newHead.next;
    }
}

