package com.li.easy;

import com.li.common.TreeNode;

import java.util.*;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 *
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * 提示：
 *     树中节点数目在范围 [0, 100] 内
 *     -100 <= Node.val <= 100
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author kang
 */
public class BinaryTreePreorderTraversal144 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode left1left = new TreeNode(4);
        TreeNode left1right = new TreeNode(5);
        TreeNode right1left = new TreeNode(6);
        TreeNode right1right = new TreeNode(7);
        TreeNode right1rightleft = new TreeNode(8);
        TreeNode right1rightright = new TreeNode(9);
        root1.left = left1;
        root1.right = right1;
        left1.left = left1left;
        left1.right = left1right;
        right1.left = right1left;
        right1.right = right1right;
        right1right.left = right1rightleft;
        right1right.right = right1rightright;

//        List<Integer> res1 = preorderTraversalRecursion(root1);
        List<Integer> res1 = preorderTraversalIterate(root1);
        for (Integer node : res1) {
            System.out.print(node + ",");
        }

        preorderTraversalRecursion(null);
    }

    /**
     * 递归
     * @param root 根节点
     * @return 前序遍历结果
     */
    public static List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversalRecursion(root, res);
        return res;
    }

    /**
     * 前序遍历子方法-递归
     * @param root 根节点
     * @param res 前序遍历结果
     */
    private static void traversalRecursion(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }

        res.add(root.val);
        traversalRecursion(root.left, res);
        traversalRecursion(root.right, res);
    }

    /**
     * 迭代
     * @param root 根节点
     * @return 前序遍历结果
     */
    public static List<Integer> preorderTraversalIterate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        if (root == null) {
            return res;
        }

        TreeNode localNode = root;
        while (localNode != null || !stack.isEmpty()) {
            while(localNode != null){
                res.add(localNode.val);
                stack.push(localNode);
                localNode = localNode.left;
            }

            localNode = stack.pop();
            localNode = localNode.right;
        }

        return res;
    }

}
