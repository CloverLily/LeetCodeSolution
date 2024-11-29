package com.li.medium;

import com.li.common.ListNode;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 *
 * 提示：
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 * 进阶： 你可以使用一趟扫描完成反转吗？
 *
 */
public class ReverseLinkedListIi092 {

    public static void main(String[] args) {
        //head = [1,2,3,4,5], left = 2, right = 4
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode b1 = new ListNode(5);

        //[3,5]
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(5);
        c1.next = c2;

        ListNode[] head = {
                a1,//[1,4,3,2,5]
                b1,//[5]
                c1//[3,5]
        };
        int[] left = {2, 1, 2};
        int[] right = {4, 1, 2};
        for (int i = 0; i < head.length; i++) {
            ListNode res = reverseBetween(head[i], left[i], right[i]);
            System.out.print("[");
            while (res != null) {
                System.out.print(res.val + " ");
                res = res.next;
            }
            System.out.println("]");
        }
    }

    /**
     * 自解：一次遍历 + 额外空间
     * time:O(N), space:O(N)
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(-1);
        int i = 1;
        ListNode reverseNode = null;
        ListNode res = newHead;
        while (head != null) {
            if (i >= left && i <= right) {
                if (reverseNode == null) {
                    reverseNode = new ListNode(head.val);
                } else {
                    ListNode newReverseHead = new ListNode(head.val);
                    newReverseHead.next = reverseNode;
                    reverseNode = newReverseHead;
                }
                if (head.next == null) {
                    newHead.next = reverseNode;
                }
            } else {
                if (i == (right + 1)) {
                    newHead.next = reverseNode;
                    while (newHead.next != null) {
                        newHead = newHead.next;
                    }
                }
                newHead.next = new ListNode(head.val);
                newHead = newHead.next;
            }
            i++;
            head = head.next;
        }
        return res.next == null ? reverseNode : res.next;
    }
}
