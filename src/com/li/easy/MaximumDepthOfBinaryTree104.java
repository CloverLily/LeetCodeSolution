package com.li.easy;

import com.li.common.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 *
 * @author system
 */
public class MaximumDepthOfBinaryTree104 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t1left = new TreeNode(9);
        TreeNode t1right = new TreeNode(20);
        TreeNode t12left = new TreeNode(15);
        TreeNode t12right = new TreeNode(7);
        t1.left = t1left;
        t1.right = t1right;
        t1.right.left = t12left;
        t1.right.right = t12right;

        System.out.println(maxDepth(t1));

    }

    /**
     * 1.递归法
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int count = 1;
        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left != null || right != null) {
            count += Math.max(maxDepth(left), maxDepth(right));
        }
        return count;
    }
    /**
     * 时间复杂度：我们每个结点只访问一次，因此时间复杂度为O(N)，其中N是结点的数量。
     * 空间复杂度：在最糟糕的情况下，树是完全不平衡的，例如每个结点只剩下左子结点，递归将会被调用N次（树的高度），因此保持调用栈的存储将是O(N)。
     * 但在最好的情况下（树是完全平衡的），树的高度将是log(N)。因此，在这种情况下的空间复杂度将是O(log(N))。
     */

    /**
     * 2.迭代法
     * 我们还可以在栈的帮助下将上面的递归转换为迭代：
     * 使用DFS策略访问每个结点，同时在每次访问时更新最大深度。
     * 所以我们从包含根结点且相应深度为 1 的栈开始。
     * 然后我们继续迭代：
     * 将当前结点弹出栈并推入子结点。每一步都会更新深度。
     */
    public static int maxDepth2(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(new Pair(root.left, current_depth + 1));
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return depth;
    }
    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */

}
