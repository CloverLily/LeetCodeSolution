package com.li.Easy;

import com.li.Common.ListNode;

import java.util.List;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class _083RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        //1->1->2->3->3
        ListNode l1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(3);
        l1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        l1 = deleteDuplicates(l1);
        while (l1 != null) {
            //1->2->3
            System.out.print(l1.val);
            l1 = l1.next;
        }
        System.out.println();

        //1->1->1
        ListNode l2 = new ListNode(1);
        ListNode b2 = new ListNode(1);
        ListNode b3 = new ListNode(1);
        l2.next = b2;
        b2.next = b3;
        l2 = deleteDuplicates(l2);
        while (l2 != null) {
            System.out.print(l2.val);
            l2 = l2.next;
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head;
        while (temp.next != null) {
            //如果值和下一个节点相等则删除下一个节点
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                //如果值不想等则指针继续往后走
                // 指针所在的位置是处理后的节点（即该节点与前节点值不同），所以只需要比较指针所在位置和下一个节点的值
                temp = temp.next;
            }
        }
        return head;
    }
}
