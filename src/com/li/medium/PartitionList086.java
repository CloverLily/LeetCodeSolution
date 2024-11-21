package com.li.medium;

import com.li.common.ListNode;

/**
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class PartitionList086 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(2);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(2);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;

        ListNode b1 = new ListNode(2);
        b1.next = new ListNode(1);

        ListNode[] nodes = {
                a1,//head = [1,4,3,2,5,2], x = 3  ->  [1,2,2,4,3,5]
                b1//head = [2,1], x = 2           ->  [1,2]
        };
        int[] x = {3, 2};
        for (int i = 0; i < x.length; i++) {
            ListNode res = partition(nodes[i], x[i]);
            System.out.print("[");
            while (res != null) {
                System.out.print(res.val + " ");
                res = res.next;
            }
            System.out.println("]");
        }
    }

    /**
     * 官方：一次遍历分割拼接 + 无额外空间
     * time:O(N), space: O(1)
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode lessNode = new ListNode(-1);
        ListNode greatNode = new ListNode(-1);
        ListNode resLess = lessNode;
        ListNode resGreat = greatNode;
        while (head != null) {
            if (head.val < x) {
                lessNode.next = head;
                lessNode = lessNode.next;
            } else {
                greatNode.next = head;
                greatNode = greatNode.next;
            }
            head = head.next;
        }
        greatNode.next = null;
        lessNode.next = resGreat.next;
        return resLess.next;
    }
}
