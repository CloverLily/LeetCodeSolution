package com.li.medium;

import com.li.common.ListNode;

/**
 * 寻找交叉链表的交叉节点
 * @author system
 */
public class FindIntersectionNode {
        public static void main(String[] args) {
            ListNode nodeA=new ListNode(1);
            ListNode nodeB=new ListNode(2);
            ListNode nodeC=new ListNode(3);
            nodeA.next=nodeB;
            nodeC.next=nodeB;
            ListNode intersectionNode=getIntersectionNode(nodeA,nodeC);
            System.out.println(intersectionNode.val);
        }

        /**
         *依次遍历两个链表，得到两链表长度，
         * 较短链表从头开始走，较长的链表减去长度差之后开始走，
         * 当两个链表的下的节点相同时，该节点即为交叉点。
         * @param headA: the first list
         * @param headB: the second list
         * @return: a ListNode
         */
        private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA==null||headB==null){
                return null;
            }
            ListNode A=headA;
            ListNode B=headB;
            int A_length=1;
            while(A.next!=null){
                A=A.next;
                A_length++;
            }
            int B_length=1;
            while(B.next!=null){
                B=B.next;
                B_length++;
            }
            if(A!=B){
                return null;
            }
            ListNode short_list=headA;
            ListNode long_list=headB;
            if(A_length>B_length){
                long_list=headA;
                short_list=headB;
            }
            for(int i=0;i<Math.abs(A_length-B_length);i++){
                long_list=long_list.next;
            }
            while(long_list!=null){
                if(long_list==short_list){
                    return long_list;
                }else{
                    long_list=long_list.next;
                    short_list=short_list.next;
                }
            }
            return null;
        }
    }

    /**
     *单向链表定义
     */
//    class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) {
//            val = x;
//            next = null;
//        }
//    }

