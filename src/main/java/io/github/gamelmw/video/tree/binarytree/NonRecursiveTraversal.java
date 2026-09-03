package io.github.gamelmw.video.tree.binarytree;

import io.github.gamelmw.video.tree.TreeNode;

import java.util.LinkedList;

public class NonRecursiveTraversal {
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

        LinkedList<TreeNode> stack = new LinkedList<>();

        /*
         * 非递归写法
         * */

        // 前序遍历和中序遍历
        TreeNode curr = root;// 当前节点
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.print("去" + curr.val + " ");//前序遍历
                stack.push(curr);// 将当前节点压入栈中,记住回来的路
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.print("回" + pop.val + " ");//中序遍历
                curr = pop.right;
            }
        }

        System.out.println("\t");

        // 后序遍历
        TreeNode curr1 = root;
        TreeNode pop1 = null;//最近一次弹栈元素
        while (curr1 != null || !stack.isEmpty()) {
            if (curr1 != null) {
                stack.push(curr1);// 将当前节点压入栈中,记住回来的路
                curr1 = curr1.left;
            } else {
                TreeNode peek = stack.peek();//栈顶元素
                if (peek.right == null || peek.right == pop1) {//右子树处理完
                    pop1 = stack.pop();
                    System.out.print("回" + pop1.val + " ");
                } else {
                    curr1 = peek.right;
                }
            }
        }

        System.out.println("\t");

        //三合一
        TreeNode curr2 = root;//代表当前节点
        TreeNode pop2 = null;//最近一次弹栈元素
        while (curr2 != null || !stack.isEmpty()) {
            if (curr2 != null) {
                stack.push(curr2);// 将当前节点压入栈中,记住回来的路
                System.out.print("前" + curr2.val + " ");
                //待处理的左子树
                curr2 = curr2.left;
            } else {
                TreeNode peek = stack.peek();//栈顶元素
                if (peek.right == null) {//没有右子树
                    System.out.print("中" + peek.val + " ");
                    pop2 = stack.pop();
                    System.out.print("后" + pop2.val + " ");
                } else if (peek.right == pop2) {//右子树处理完
                    pop2 = stack.pop();
                    System.out.print("后" + pop2.val + " ");
                } else {
                    System.out.print("中" + peek.val + " ");
                    //待处理的右子树
                    curr2 = peek.right;
                }
            }
        }
    }
}

