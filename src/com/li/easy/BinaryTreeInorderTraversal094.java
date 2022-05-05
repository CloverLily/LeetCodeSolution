package com.li.easy;

import com.li.common.TreeNode;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 *
 * 提示：
 *     树中节点数目在范围 [0, 100] 内
 *     -100 <= Node.val <= 100
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author kang
 */
public class BinaryTreeInorderTraversal094 {

    public static void main(String[] args) {

    }

    /**
     * 递归
     * @param root 根节点
     * @return 前序遍历结果
     */
    public List<Integer> inorderTraversalByRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversalByRecursion(root, res);
        return res;
    }

    /**
     * 递归-子方法
     * @param root 根节点
     * @param res 前序遍历结果
     */
    private void traversalByRecursion(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }

        traversalByRecursion(root.left, res);
        res.add(root.val);
        traversalByRecursion(root.right, res);
    }

    /**
     * 迭代
     * @param root 根节点
     * @return 迭代法中序遍历
     */
    public List<Integer> inorderTraversalByIterate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(Objects.isNull(root)){
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode localNode = root;
        while(localNode != null || !stack.isEmpty()){
            while(localNode != null){
                stack.push(localNode);
                localNode = localNode.left;
            }
            localNode = stack.pop();
            res.add(localNode.val);
            localNode = localNode.right;
        }

        return res;
    }

}
