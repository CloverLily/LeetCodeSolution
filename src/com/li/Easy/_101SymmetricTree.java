package com.li.Easy;

import com.li.Common.TreeNode;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class _101SymmetricTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t1left = new TreeNode(2);
        TreeNode t21left = new TreeNode(3);
        TreeNode t21right = new TreeNode(4);
        TreeNode t1right = new TreeNode(2);
        TreeNode t22left = new TreeNode(4);
        TreeNode t22right = new TreeNode(3);
        t1.left = t1left;
        t1.left.left = t21left;
        t1.left.right = t21right;
        t1.right = t1right;
        t1.right.left = t22left;
        t1.right.right = t22right;

        System.out.println(isSymmetric(t1));
    }
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    /**
     * 1.递归法
     * @param t1
     * @param t2
     * @return
     */
    public static boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        return (t1.val == t2.val) && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
    /**
     * 时间复杂度：O(n)。因为我们遍历整个输入树一次，所以总的运行时间为O(n)，其中n是树中结点的总数。
     * 空间复杂度：递归调用的次数受树的高度限制。在最糟糕的情况下，树是线性的，其高度为O(n)。因此，在最糟糕的情况下，由栈上的递归调用造成的空间复杂度为O(n)。
     */

    /**
     * 2.迭代法
     */

}
