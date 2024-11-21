package com.li.hard;

import com.li.common.ListNode;

/**
 * 25. K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 *
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 *
 */
public class ReverseNodesInKGroup025 {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(4);
        ListNode b5 = new ListNode(5);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;

        ListNode[] heads = {
                a1, //[2,1,4,3,5]
                b1 //[3,2,1,4,5]
        };
        int[] k = {2, 3};
        for (int i = 0; i < k.length; i++) {
            ListNode res = reverseKGroup(heads[i], k[i]);
            System.out.print("[");
            while(res != null){
                System.out.print(res.val + " ");
                res = res.next;
            }
            System.out.println("]");
        }

    }

    /**
     * 官方:一次遍历 + 无额外空间
     * time:O(n), space:O(1)
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(-1);
        res.next = head;

        ListNode pre = res;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return res.next;
                }
            }

            ListNode tailNext = tail.next;
            ListNode[] reverseNodes = reverseNode(head, tail);
            ListNode tempHead = reverseNodes[0];
            ListNode tempTail = reverseNodes[1];
            pre.next = tempHead;
            tempTail.next = tailNext;
            pre = tempTail;
            head = tempTail.next;
        }
        return res.next;
    }

    /**
     * 翻转链表
     * @param head 链表头，非空
     * @param tail 链表尾，非空
     * @return 翻转后的头尾
     */
    private static ListNode[] reverseNode(ListNode head, ListNode tail) {
        ListNode tailNext = tail.next;
        ListNode cur = head;
        while (tail != tailNext) {
            ListNode next = cur.next;
            cur.next = tailNext;
            tailNext = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }

}
