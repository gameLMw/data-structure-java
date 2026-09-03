package io.github.gamelmw.video.tree.binarytree;

import io.github.gamelmw.video.tree.TreeNode;

public class RecursiveTraversal {
    public static void main(String[] args) {
        /*
         *           1
         *          / \
         *         2   3
         *        /   / \
         *       4   5   6
         *
         *      前序遍历：根->左->右    1,2,4,3,5,6
         *      中序遍历：左->根->右    4,2,1,5,3,6
         *      后序遍历：左->右->根    4,2,5,6,3,1
         * */
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(4), 2, null), 1, new TreeNode(new TreeNode(5), 3, new TreeNode(6)));
        preOrder(root);
        System.out.println("\t");

        inOrder(root);
        System.out.println("\t");

        postOrder(root);
        System.out.println("\t");


    }

    //递归写法
    /*
     * 前序遍历
     * */
    static void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /*
     * 中序遍历
     * */
    static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    /*
     * 后序遍历
     * */
    static void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }
}
