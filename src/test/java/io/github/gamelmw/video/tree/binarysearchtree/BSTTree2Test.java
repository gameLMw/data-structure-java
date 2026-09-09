package io.github.gamelmw.video.tree.binarysearchtree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BSTTree2Test {

    public BSTTree2<String, String> createTree() {
        /*
         *            4
         *          /   \
         *         2     6
         *       /  \    /  \
         *      1   3    5   7
         * */
        BSTTree2.BSTNode<String, String> n1 = new BSTTree2.BSTNode<>("a", "w");
        BSTTree2.BSTNode<String, String> n2 = new BSTTree2.BSTNode<>("b", "l");
        BSTTree2.BSTNode<String, String> n3 = new BSTTree2.BSTNode<>("c", "j");
        BSTTree2.BSTNode<String, String> n4 = new BSTTree2.BSTNode<>("d", "k");
        BSTTree2.BSTNode<String, String> n5 = new BSTTree2.BSTNode<>("e", "f");
        BSTTree2.BSTNode<String, String> n6 = new BSTTree2.BSTNode<>("f", "g");
        BSTTree2.BSTNode<String, String> root = new BSTTree2.BSTNode<>("g", "h");

        BSTTree2<String, String> tree = new BSTTree2<>();
        tree.root = root;
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;


        return tree;
    }

    @Test
    public void test() {
        BSTTree2<String, String> tree = createTree();
        assertEquals("w", tree.get("a"));
        assertEquals("l", tree.get("b"));
        assertEquals("j", tree.get("c"));
        assertEquals("k", tree.get("d"));
        assertEquals("f", tree.get("e"));
        assertEquals("g", tree.get("f"));
    }
}
