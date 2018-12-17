package com.li.Easy;

import com.li.Common.TreeNode;

/**
 * 100. 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * <p>
 * 示例 3:
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 */
public class _100SameTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t1left = new TreeNode(2);
        TreeNode t1right = new TreeNode(3);
        t1.left = t1left;
        t1.right = t1right;

        TreeNode t2 = new TreeNode(1);
        TreeNode t2left = new TreeNode(2);
        TreeNode t2right = new TreeNode(3);
        t2.left = t2left;
        t2.right = t2right;

        System.out.println(isSameTree(t1, t2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null || q == null)) return false;

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
