package com.li.easy;

import com.li.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 提示：
 *     树中节点的数目在范围 [0, 100] 内
 *     -100 <= Node.val <= 100
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 * @author kang
 */
public class BinaryTreePostorderTraversal145 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode left1left = new TreeNode(4);
        TreeNode left1right = new TreeNode(5);
        TreeNode right1left = new TreeNode(6);
        TreeNode right1right = new TreeNode(7);
        TreeNode right1rightleft = new TreeNode(8);
        TreeNode right1rightright = new TreeNode(9);
        root.left = left1;
        root.right = right1;
        left1.left = left1left;
        left1.right = left1right;
        right1.left = right1left;
        right1.right = right1right;
        right1right.left = right1rightleft;
        right1right.right = right1rightright;

        List<Integer> res1 = postorderTraversalByRecursion(root);
//        List<Integer> res1 = postorderTraversalByIterate(root);
        for (Integer node : res1) {
            System.out.print(node + ",");
        }

        postorderTraversalByIterate(null);

    }

    /**
     * 递归
     * @param root 根节点
     * @return 后序遍历结果
     */
    public static List<Integer> postorderTraversalByRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversalByRecursion(root, res);
        return res;
    }

    /**
     * 递归-子方法
     * @param root 根节点
     * @param res 后序遍历结果
     */
    private static void traversalByRecursion(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }

        traversalByRecursion(root.left, res);
        traversalByRecursion(root.right, res);
        res.add(root.val);
    }

    /**
     * 迭代
     * @param root 根节点
     * @return 迭代法后序遍历
     */
    public static List<Integer> postorderTraversalByIterate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        TreeNode prevRoot = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.right == null || root.right == prevRoot) {
                res.add(root.val);
                prevRoot = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }

        return res;
    }

}
