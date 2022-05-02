package com.li.common;

import java.util.Objects;

/**
 * 单向链表
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * @author system
 */
public class ListNode {

    /**
     * 节点值
     */
    public int val;
    /**
     * 下一个节点
     */
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof ListNode) {
            ListNode listNode = (ListNode) obj;
            return this.next == listNode.next && this.val == listNode.val;
        }
        return false;


    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.val);
    }

}
