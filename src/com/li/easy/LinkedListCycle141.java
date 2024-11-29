package com.li.easy;

import com.li.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * 提示：
 * 链表中节点的数目范围是 [0, 10^4]
 * -10^5 <= Node.val <= 10^5
 * pos 为 -1 或者链表中的一个 有效索引 。
 *
 * 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * @author system
 */
public class LinkedListCycle141 {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public static void main(String[] args) {
        //head = [3,2,0,-4], pos = 1
        ListNode headA = new ListNode(3);
        ListNode headA2 = new ListNode(2);
        ListNode headA3 = new ListNode(0);
        ListNode headA4 = new ListNode(-4);
        headA.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;
        headA4.next = headA2;

        //head = [1,2], pos = 0
        ListNode headB = new ListNode(1);
        ListNode headB2 = new ListNode(2);
        headB.next = headB2;
        headB2.next = headB;

        //head = [1], pos = -1
        ListNode headC = new ListNode(1);

        ListNode headD = new ListNode(1);
        ListNode headD2 = new ListNode(2);
        headD.next = headD2;

        ListNode[] heads = {
                headA,//true
                headB,//true
                headC,//false
                headD//false
        };
        for (ListNode ln : heads) {
            System.out.println(hasCycle(ln));
        }
    }

    /**
     * 官方：快慢指针
     * time:O(N), space: O(1)
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * Floyd Algorithm
     * do-while
     * 时间 O(N)
     * 空间 O(1)
     * @param head 链表头
     * @return 是否环形链表
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        do {
            if(fast.next == null){
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;

            if(fast == null){
                return false;
            }

            if(slow != null && fast == slow){
                return true;
            }
        } while (slow != null);

        return false;
    }

    /**
     * 时间 O(N)
     * 空间 O(N)
     * @param head 链表头
     * @return 是否环形链表
     */
    public static boolean hasCycleOfficial(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> indexSet = new HashSet<>();
        ListNode now = head;
        while (now != null) {
            if (!indexSet.add(now)) {
                return true;
            }
            now = now.next;
        }
        return false;
    }

}

