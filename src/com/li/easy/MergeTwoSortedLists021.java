package com.li.easy;

import com.li.common.ListNode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * @author system
 */
public class MergeTwoSortedLists021 {

    public static void main(String[] args) {
        //l1 = [1,2,4], l2 = [1,3,4]
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        //l1 = [], l2 = []
        ListNode c1 = null;
        ListNode d1 = null;

        //l1 = [], l2 = [0]
        ListNode e1 = null;
        ListNode f1 = new ListNode(0);

        ListNode[] l1s = {
                a1,//[1,1,2,3,4,4]
                c1,//[]
                e1//[0]
        };
        ListNode[] l2s = {b1, d1, f1};
        for (int i = 0; i < l1s.length; i++) {
            ListNode result = mergeTwoLists(l1s[i], l2s[i]);
            System.out.print("[");
            while (result != null) {
                System.out.print(result.val + " ");
                result = result.next;
            }
            System.out.println("]");
        }
    }

    /**
     * 自解：顺序遍历比较
     * time:O(max(m,n)), space:O(1)
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode head = res;

        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                int num1 = list1.val;
                int num2 = list2.val;
                if (num1 < num2) {
                    res.next = new ListNode(num1);
                    list1 = list1.next;
                } else if (num1 == num2) {
                    res.next = new ListNode(num1);
                    res = res.next;
                    res.next = new ListNode(num2);
                    list1 = list1.next;
                    list2 = list2.next;
                } else {
                    res.next = new ListNode(num2);
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                res.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                res.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            res = res.next;
        }
        return head.next;
    }

    /**
     * 普通遍历
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的有序链表
     */
    public static ListNode mergeTwoLists0428(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode resList = new ListNode(0);
        ListNode resBody = resList;

        while (list1 != null && list2 != null) {

            if (list1.val > list2.val) {
                resBody.next = list2;
                list2 = list2.next;

            } else {
                resBody.next = list1;
                list1 = list1.next;
            }

            resBody = resBody.next;
        }

        if (list1 != null) {
            resBody.next = list1;
        }

        if (list2 != null) {
            resBody.next = list2;
        }

        return resList.next;
    }

    /**
     * 合并两个链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 按从小到大顺序合并的链表
     */
    public static ListNode mergeTwoListsOld(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsOld(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsOld(l1, l2.next);
            return l2;
        }
    }
}




