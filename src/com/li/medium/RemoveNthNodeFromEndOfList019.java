package com.li.medium;

import com.li.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthNodeFromEndOfList019 {

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

        ListNode c1 = new ListNode(1);
        ListNode c2 = new ListNode(2);
        c1.next = c2;

        ListNode[] nodes = {
                a1,//head = [1,2,3,4,5], n = 2 -> [1,2,3,5]
                b1,//head = [1], n = 1 -> []
                c1//head = [1,2], n = 1 -> [1]

        };
        int[] n = {2, 1, 1};
        for (int i = 0; i < nodes.length; i++) {
            ListNode res = removeNthFromEndOfficial(nodes[i], n[i]);
//            ListNode res = removeNthFromEnd(nodes[i], n[i]);
            System.out.print("[");
            while (res != null) {
                System.out.print(res.val + " ");
                res = res.next;
            }
            System.out.println("]");
        }
    }

    /**
     * 官方：一次遍历+双指针
     * time:O(N), space:O(1)
     */
    public static ListNode removeNthFromEndOfficial(ListNode head, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode fast;
        ListNode slow = res;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        fast = head;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next == null ? null : slow.next.next;
        return res.next;
    }

    /**
     * 自解：一次遍历+链表
     * time:O(N), space:O(N)
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();

        ListNode res = head;
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }

        int sz = nodes.size();
        if (sz == n) {
            return res.next;
        }

        if (n == 1) {
            nodes.get(sz - 2).next = null;
            return res;
        }

        nodes.get(sz - n - 1).next = nodes.get(sz - n + 1);
        return res;
    }
}
