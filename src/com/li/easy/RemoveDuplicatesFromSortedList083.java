package com.li.easy;

import com.li.common.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 提示：
 *     链表中节点数目在范围 [0, 300] 内
 *     -100 <= Node.val <= 100
 *     题目数据保证链表已经按升序 排列
 *
 * @author system
 */
public class RemoveDuplicatesFromSortedList083 {

    public static void main(String[] args) {
        //1->1->2->3->3
        ListNode l1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(3);
        l1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        ListNode res1 = deleteDuplicates0503(l1);
        while (res1 != null) {
            //1->2->3
            System.out.print(res1.val);
            res1 = res1.next;
        }
        System.out.println();

        //1->1->1
        ListNode l2 = new ListNode(1);
        ListNode b2 = new ListNode(1);
        ListNode b3 = new ListNode(1);
        l2.next = b2;
        b2.next = b3;
        ListNode res2 = deleteDuplicates0503(l2);
        while (res2 != null) {
            System.out.print(res2.val);
            res2 = res2.next;
        }

    }

    public static ListNode deleteDuplicates0503(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = head;
        while (pre.next != null) {
            if (pre.val == pre.next.val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }

}
