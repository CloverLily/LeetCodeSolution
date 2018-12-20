package com.li.Easy;

import com.li.Common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /     \
 * 15      7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class _107BinaryTreeLevelOrderTraversal_II {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t1Left = new TreeNode(9);
        TreeNode t1Right = new TreeNode(20);
        TreeNode t1LeftLeft = new TreeNode(15);
        TreeNode t1RightRight = new TreeNode(7);
        t1.left = t1Left;
        t1.right = t1Right;
        t1.left.left = t1LeftLeft;
        t1.right.right = t1RightRight;

        List<List<Integer>> lists = levelOrderBottom(t1);

        for (List<Integer> list : lists) {
            System.out.print("[");
            for (Integer i : list) {
                System.out.print(i + ",");
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }


    /**
     * 1.BFS 广度优先遍历
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    /**
     * 层序遍历二叉树
     *
     * @param list  遍历后存放的链表
     * @param root  树的根
     * @param level 树的层数
     */
    private static void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level + 1);
        levelMaker(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }

}
