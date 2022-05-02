package com.li.easy;

import com.li.common.ListNode;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * 提示：
 *     列表中的节点数目在范围 [0, 104] 内
 *     1 <= Node.val <= 50
 *     0 <= val <= 50
 */
public class RemoveLinkedListElements203 {

    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(6);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(5);
        ListNode a7 = new ListNode(6);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        ListNode resA = removeElements(a1, 6);

        while(resA != null){
            System.out.print(resA.val);
            System.out.print(",");
            resA = resA.next;
        }

        ListNode b1 = null;
        ListNode resB = removeElements(b1, 1);

        while(resB != null){
            System.out.print(resB.val);
            System.out.print(",");
            resB = resB.next;
        }


        ListNode c1 = new ListNode(7);
        ListNode c2 = new ListNode(7);
        ListNode c3 = new ListNode(7);
        ListNode c4 = new ListNode(7);
        c1.next = c2;
        c2.next = c3;
        c3.next = c4;
        ListNode resC = removeElements(c1, 7);

        while(resC != null){
            System.out.print(resC.val);
            System.out.print(",");
            resC = resC.next;
        }

    }


    public static ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode currentNode = dummyHead;
        while (currentNode.next != null) {
            if (currentNode.next.val == val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }

        return dummyHead.next;
    }

}
