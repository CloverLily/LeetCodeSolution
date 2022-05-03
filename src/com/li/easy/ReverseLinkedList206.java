package com.li.easy;

import com.li.common.ListNode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 *     链表中节点的数目范围是 [0, 5000]
 *     -5000 <= Node.val <= 5000
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 * @author kang
 */
public class ReverseLinkedList206 {

    public static void main(String[] args) {
        ListNode headA1= new ListNode(1);
        ListNode headA2= new ListNode(2);
        ListNode headA3= new ListNode(3);
        ListNode headA4= new ListNode(4);
        ListNode headA5= new ListNode(5);
        headA1.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;
        headA4.next = headA5;

        ListNode resA = reverseList(headA1);

        while(resA != null){
            System.out.print(resA.val);
            System.out.print(",");
            resA = resA.next;
        }
        System.out.println();

        ListNode headB1= new ListNode(1);
        ListNode headB2= new ListNode(2);
        headB1.next = headB2;

        ListNode resB = reverseList(headB1);

        while(resB != null){
            System.out.print(resB.val);
            System.out.print(",");
            resB = resB.next;
        }

        ListNode resC = reverseList(null);

        while(resC != null){
            System.out.print(resC.val);
            System.out.print(",");
            resC = resC.next;
        }

    }

    /**
     * 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     * @param head 链表头
     * @return 反转链表
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode now = head;

        while (now != null) {
            ListNode follow = now.next;
            now.next = pre;

            pre = now;
            now = follow;
        }

        return pre;
    }

    /**
     * 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     * @param head 链表头
     * @return 反转链表
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return res;
    }

}
