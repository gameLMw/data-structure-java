package io.github.gamelmw.video.tree.binarysearchtree;

/*
 * 二叉搜索树，其中每个节点的左子树所有节点值都小于该节点值，右子树所有节点值都大于该节点值。
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    //查找最小key对应的值
    //return : 最小key对应的值
    public Object min() {
        // 非递归查找最小key
/*        if (root == null) {
            return null;
        }
        BSTNode node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.value;*/

        return doMin(root);
    }

    private Object doMin(BSTNode node) {
        if (node == null) {
            return null;
        }

        // 递归查找最小key
        if (node.left == null) {
            return node.value;
        }
        return doMin(node.left);
    }

    //查找最大key对应的值
    //return : 最大key对应的值
    public Object max() {
/*        if (root == null) {
            return null;
        }
        BSTNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.value;*/

        return doMax(root);
    }

    private Object doMax(BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node.value;
        }
        return doMax(node.right);
    }

    //储存key和value
    //key : 关键字
    //value : 值
    public void put(int key, Object value) {
        // key 有 value更新
        // key 无 value新增
        BSTNode node = root;
        BSTNode parent = null;

        while (node != null) {
            parent = node;
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                // key 有 value更新
                System.out.println("key已存在，旧value：" + node.value + "，value已更新为" + value);
                node.value = value;
                return;
            }
        }
        if (parent == null) {
            root = new BSTNode(key, value);
            return;
        }

        // key 无 value新增
        if (key < parent.key) {
            parent.left = new BSTNode(key, value);
        } else {
            parent.right = new BSTNode(key, value);
        }
    }

    //查找key的前驱值
    //key : 关键字
    //return : 关键字的前驱值
    /*
     * 方法1： 中序遍历
     * 方法2： 1.如果节点有左子树，则节点的前驱值为左子树的最大值
     *        2.如果节点无左子树，若离他最近的祖先自从左而来，则该祖先为前驱值
     * */
    public Object predecessor(int key) {
        BSTNode p = root;
        BSTNode predecessor = null;

        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (key > p.key) {
                predecessor = p;
                p = p.right;
            } else {
                break;
            }
        }

        // 没找到节点
        if (p == null) {
            return null;
        }

        // 节点有左子树
        if (p.left != null) {
            return doMax(p.left);
        }

        // 节点无左子树
/*        if (predecessor != null) {
            return predecessor.value;
        }

        return null;*/
        //二合一
        return predecessor != null ? predecessor.value : null;
    }

    //查找key的后继值
    //key : 关键字
    //return : 关键字的后继值
    /*
     * 方法1： 中序遍历
     * 方法2： 1.如果节点有右子树，则节点的后继值为右子树的最小值
     *        2.如果节点无右子树，若离他最近的祖先自从右而来，则该祖先为后继值
     * */
    public Object successor(int key) {
        BSTNode p = root;
        BSTNode successor = null;

        while (p != null) {
            if (key < p.key) {
                successor = p;
                p = p.left;
            } else if (key > p.key) {
                p = p.right;
            } else {
                break;
            }
        }

        if (p == null) {
            return null;
        }

        if (p.right != null) {
            return doMin(p.right);
        }

        return successor != null ? successor.value : null;
    }

    //根据key删除节点
    //key : 关键字
    //return : 被删除节点的值
    /*
     * 情况1：删除节点没有左孩子，将右孩子托孤给 删除节点的父节点(parent)
     * 情况2：删除节点没有右孩子，将左孩子托孤给parent
     * 情况3：删除节点既没有左孩子又没有右孩子，将null托孤给parent
     * 情况4：删除节点既有左孩子又有右孩子，找到删除节点的后继节点(称为S)，S的父亲为SP，又分为
     *       1.SP是删除节点，此时删除节点与S相邻，用S替代删除节点的位置，将S托孤给parent
     *       2.SP不是删除节点，此时删除节点与S不相邻，需将S的右孩子托孤给SP，再用S替代删除节点的位置
     * */
    public Object delete(int key) {
        BSTNode p = root;
        BSTNode parent = null;

        while (p != null) {
            if (key < p.key) {
                parent = p;
                p = p.left;
            } else if (key > p.key) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }

        // 没找到节点
        if (p == null) {
            return null;
        }

        if (p.left == null) {
            // 情况1：删除节点没有左孩子，将右孩子托孤给父节点
            shift(parent, p, p.right);
        } else if (p.right == null) {
            // 情况2：删除节点没有右孩子，将左孩子托孤给父节点
            shift(parent, p, p.left);
        } else {
            // 情况4：删除节点既有左孩子又有右孩子

            // 4.1：找删除节点的后继节点
            BSTNode s = p.right;// 后继节点
            BSTNode sp = p;// 后继节点的父亲

            while (s.left != null) {
                sp = s;
                s = s.left;
            }
            // 4.2：处理后继节点的孩子
            if (sp != p) {// SP不是删除节点
                shift(sp, s, s.right);// 不可能有左孩子
                s.right = p.right;
            }
            // 4.3：用后继节点替代删除节点
            shift(parent, p, s);
            s.left = p.left;
        }

        return p.value;
    }

    //"托孤"
    //parent : 被删除节点的父节点
    //deleted : 被删除节点
    //child : 被顶上去的节点
    private void shift(BSTNode parent, BSTNode deleted, BSTNode child) {
        if (parent == null) {
            root = child;
        } else if (deleted == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    // 递归删除
    // node : 递归删除的起点
    // key : 要删除的节点的key
    // return : 删剩下的孩子
    // TODO:递归删除
    private BSTNode doDelete(BSTNode node, int key) {
        return null;
    }

    //中序遍历
    public void inOrder() {
        StringBuilder sb = new StringBuilder();
        doInOrder(root, sb);
        System.out.println(sb);
    }

    private void doInOrder(BSTNode node, StringBuilder sb) {
        if (node != null) {
            doInOrder(node.left, sb);
            if (!sb.isEmpty()) {
                sb.append(", ");
            }
            sb.append(node.key).append(" ").append(node.value);
            doInOrder(node.right, sb);
        }
    }

    /*
     * 范围查找
     * */

    // 找 < key 的所有 value
    public List<Object> less(int key) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (p.key < key) {
                result.add(p.value);
            }
            p = p.right;
        }
        return result;
    }

    //TODO :范围查找
}
