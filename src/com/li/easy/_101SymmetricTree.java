package com.li.easy;

import com.li.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
 *   1
 *  / \
 *  2   2
 *   \   \
 *    3    3
 * 说明:
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
        return isMirror(root, root);
    }

    /**
     * 1.递归法
     */
    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
    /**
     * 时间复杂度：O(n)。因为我们遍历整个输入树一次，所以总的运行时间为O(n)，其中n是树中结点的总数。
     * 空间复杂度：递归调用的次数受树的高度限制。在最糟糕的情况下，树是线性的，其高度为O(n)。因此，在最糟糕的情况下，由栈上的递归调用造成的空间复杂度为O(n)。
     */


    /**
     * 2.迭代法
     * 除了递归的方法外，我们也可以利用队列进行迭代。
     * 队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像。
     * 最初，队列中包含的是 root 以及 root。该算法的工作原理类似于 BFS，但存在一些关键差异。
     * 每次提取两个结点并比较它们的值。然后，将两个结点的左右子结点按相反的顺序插入队列中。当
     * 队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
     */
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
    /**
     * 时间复杂度：O(n)。因为我们遍历整个输入树一次，所以总的运行时间为O(n)，其中n是树中结点的总数。
     * 空间复杂度：搜索队列需要额外的空间。在最糟糕的情况下，我们不得不向队列中插入O(n)个结点。因此，空间复杂度为O(n)。
     */

}
