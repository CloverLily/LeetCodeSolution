package com.li.medium;

import com.li.common.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。
 * 返回 已排序的链表 。
 *
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class RemoveDuplicatesFromSortedListIi082 {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(4);
        ListNode a7 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(1);
        ListNode b3 = new ListNode(1);
        ListNode b4 = new ListNode(2);
        ListNode b5 = new ListNode(3);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;

        ListNode c1 = new ListNode(1);

        ListNode[] nodes = {
                a1,//[1,2,3,3,4,4,5] -> [1,2,5]
                b1,//[1,1,1,2,3] -> [2,3]
                c1//[1] -> [1]
        };
        for (ListNode node : nodes) {
            ListNode res = deleteDuplicates(node);
            System.out.print("[");
            while (res != null) {
                System.out.print(res.val + " ");
                res = res.next;
            }
            System.out.println("]");
        }
    }

    /**
     * 自解：一次遍历比较
     * time: O(N), space: O(1)
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                return res.next;
            }

            if (cur.val != next.val) {
                pre.next = cur;
                pre = pre.next;
            } else {
                while (next != null && cur.val == next.val) {
                    cur = next;
                    next = next.next;
                }
                pre.next = next;
            }
            cur = next;
        }
        return res.next;
    }
}
