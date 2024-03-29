package com.li.easy;

import com.li.common.ListNode;

/**
 * 21. 合并两个有序链表
 * 
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @author system
 */
public class MergeTwoSortedLists021 {

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

//        ListNode result = mergeTwoLists(a1, a2);
        ListNode result = mergeTwoLists0428(a1, a2);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }

    }

    /**
     * 普通遍历
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的有序链表
     */
    public static ListNode mergeTwoLists0428(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode resList = new ListNode(0);
        ListNode resBody = resList;

        while (list1 != null && list2 != null) {

            if (list1.val > list2.val) {
                resBody.next = list2;
                list2 = list2.next;

            } else {
                resBody.next = list1;
                list1 = list1.next;
            }

            resBody = resBody.next;
        }

        if (list1 != null) {
            resBody.next = list1;
        }

        if (list2 != null) {
            resBody.next = list2;
        }

        return resList.next;
    }

    /**
     * 合并两个链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 按从小到大顺序合并的链表
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}




