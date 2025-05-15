package org.example;

/**
 *                4 (2)
 *             /    \
 *     (1)     6     10 (0)
 *            / \
 *  (0)     5   119
 */
public class MainEx01 {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.right = new Node(119);
        root.right = new Node(10);
        heightEx01(root);
        System.out.println(root.value + " " + root.getHeight());
        System.out.println(root.right.value + " " + root.right.getHeight());
        System.out.println(root.left.value + " " + root.left.getHeight());
        System.out.println(root.left.right.value + " " + root.left.right.getHeight());

    }
    /**
     * ## Задача 1
     * **Высота поддерева**
     * Для каждого узла двоичного дерева найти высоту поддерева, с корнем в заданном узле.
     *
     * **Требования:**
     * - Реализовать рекурсивное решение
     * - Сложность: O(n)
     */
    public static int heightEx01(Node node){
        if(node == null){
            return -1;
        }
        int leftH = heightEx01(node.left);
        int rightH = heightEx01(node.right);
        node.setHeight(Math.max(leftH, rightH) + 1);
        return node.getHeight();
    }
}