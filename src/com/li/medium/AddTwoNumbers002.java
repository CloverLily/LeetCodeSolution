package com.li.medium;

import com.li.common.ListNode;
/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 *
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * @author system
 */
public class AddTwoNumbers002 {

    public static void main(String[] args) {
        //l1 = [2,4,3], l2 = [5,6,4]
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        //l1 = [0], l2 = [0]
        ListNode c1 = new ListNode(0);
        ListNode d1 = new ListNode(0);

        //l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        ListNode e1 = new ListNode(9);
        ListNode e2 = new ListNode(9);
        ListNode e3 = new ListNode(9);
        ListNode e4 = new ListNode(9);
        ListNode e5 = new ListNode(9);
        ListNode e6 = new ListNode(9);
        ListNode e7 = new ListNode(9);
        e1.next = e2;
        e2.next = e3;
        e3.next = e4;
        e4.next = e5;
        e5.next = e6;
        e6.next = e7;
        ListNode f1 = new ListNode(9);
        ListNode f2 = new ListNode(9);
        ListNode f3 = new ListNode(9);
        ListNode f4 = new ListNode(9);
        f1.next = f2;
        f2.next = f3;
        f3.next = f4;

        ListNode[] numArr1 = {
                a1,//[7,0,8]
                c1,//[0]
                e1//[8,9,9,9,0,0,0,1]
        };
        ListNode[] numArr2 = {b1, d1, f1};
        for (int i = 0; i < numArr1.length; i++) {
            ListNode res = addTwoNumbers(numArr1[i], numArr2[i]);
            System.out.print('[');
            while (res != null) {
                System.out.print(res.val + " ");
                res = res.next;
            }
            System.out.println(']');
        }
    }

    /**
     * 自解：直接相加，注意进位
     * time:O(max(m,n)),space:O(1)
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1;
        int num2;

        int carry = 0;
        int res;
        ListNode resNode = new ListNode(0);
        ListNode head = resNode;
        while (l1 != null || l2 != null) {
            num1 = 0;
            num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }

            res = num1 + num2 + carry;
            carry = res / 10;
            res = res % 10;
            resNode.next = new ListNode(res);
            resNode = resNode.next;
        }
        if (carry > 0) {
            resNode.next = new ListNode(carry);
        }
        return head.next;
    }

    public static ListNode addTwoNumbersOld(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int carry = 0, sum;
        ListNode listSum = new ListNode(0);
        ListNode n1 = l1, n2 = l2, curl = listSum;
        int val1, val2;
        while (n1 != null || n2 != null) {
            val1 = (n1 == null) ? 0 : n1.val;
            val2 = (n2 == null) ? 0 : n2.val;
            sum = val1 + val2 + carry;
            curl.next = new ListNode(sum % 10);
            curl = curl.next;
            carry = sum / 10;
            n1 = (n1 == null) ? null : n1.next;
            n2 = (n2 == null) ? null : n2.next;

        }
        if (carry == 1) {
            curl.next = new ListNode(1);
        }
        return listSum.next;
    }
}
