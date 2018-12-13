package com.li.Easy;

import com.li.Common.ListNode;

/**
 * 21. 合并两个有序链表
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class _021MergeTwoSortedLists {

    public static void main(String[] args) {
        //1->2->4
        ListNode a1 = new ListNode(1);
        ListNode b1 = new ListNode(2);
        ListNode c1 = new ListNode(4);
        a1.next = b1;
        b1.next = c1;
        //1->3->4
        ListNode a2 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode c2 = new ListNode(4);
        a2.next = b2;
        b2.next = c2;

        ListNode result = mergeTwoLists(a1, a2);
        ListNode temp = result;
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }

    }

    /**
     * 合并两个链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 按从小到大顺序合并的链表
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}




