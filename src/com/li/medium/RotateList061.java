package com.li.medium;

import com.li.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
 */
public class RotateList061 {
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

        ListNode b1 = new ListNode(0);
        ListNode b2 = new ListNode(1);
        ListNode b3 = new ListNode(2);
        b1.next = b2;
        b2.next = b3;

        ListNode c1 = new ListNode(1);

        ListNode[] nodes = {
                a1,//[1,2,3,4,5] -> [4,5,1,2,3]
                b1,//[0,1,2] -> [2,0,1]
                c1//[1] -> [1]
        };
        int[] k = {2, 4, 1};
        for (int i = 0; i < k.length; i++) {
            ListNode res = rotateRight(nodes[i], k[i]);
            System.out.print("[");
            while (res != null) {
                System.out.print(res.val + " ");
                res = res.next;
            }
            System.out.println("]");
        }
    }

    /**
     * 自解：一次遍历 + 拼接
     * time: O(N), space:O(N)
     */
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode res = head;
        if (head == null) {
            return null;
        }

        List<ListNode> nodeList = new ArrayList<>();
        int n = 0;
        while (head != null) {
            n++;
            nodeList.add(head);
            head = head.next;
        }

        k = k % n;
        if (k == 0) {
            return res;
        }

        nodeList.get(n - 1).next = nodeList.get(0);
        nodeList.get(n - k - 1).next = null;
        return nodeList.get(n - k);
    }
}
