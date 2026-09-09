package io.github.gamelmw.video.tree.binarysearchtree;

/*
 * 二叉搜索树，其中每个节点的左子树所有节点值都小于该节点值，右子树所有节点值都大于该节点值。
 * */

public class BSTTree1 {

    BSTNode root;// 根节点

    static class BSTNode {
        int key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //查找关键字对应的值
    //key : 关键字
    //return : 关键字对应的值
/*
    public Object get(int key) {

    }

    //递归查找
    //node : 当前节点
    //key : 关键字
    //return : 关键字对应的值
    private Object doGet(BSTNode node, int key) {
        if (node == null){
            return null;//未找到
        }
        if (key < node.key){
            return doGet(node.left, key);//向左子树查找
        }else if (key > node.key){
            return doGet(node.right, key);//向右子树查找
        }else {
            return node.value;//找到
        }
    }
*/

    //非递归查找
    //key : 关键字
    //return : 关键字对应的值
    public Object get(int key) {
        BSTNode node = root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    //查找最小关键字对应的值
    //return : 最小关键字对应的值
    public Object min() {
        return null;
    }

    //查找最大关键字对应的值
    //return : 最大关键字对应的值
    public Object max() {
        return null;
    }

    //储存关键字和值
    //key : 关键字
    //value : 值
    public void put(int key, Object value) {
        return;
    }

    //查找关键字的前驱值
    //key : 关键字
    //return : 关键字的前驱值
    public Object successor(int key) {
        return null;
    }

    //查找关键字的后继值
    //key : 关键字
    //return : 关键字的后继值
    public Object predecessor(int key) {
        return null;
    }

    //根据关键字删除节点
    //key : 关键字
    public void delete(int key) {
        return;
    }
}
