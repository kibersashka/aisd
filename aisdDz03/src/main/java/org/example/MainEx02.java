package org.example;

/**
 * ## Задача 2
 * **Сериализация бинарного дерева**
 * Дано бинарное дерево чисел. Преобразовать его в строку в формате:
 * `(значение вершины, описание левого поддерева, описание правого поддерева)`.
 * Пустое поддерево заменяется строкой `NULL`.
 *
 * **Требования:**
 * - Линейная сложность O(n)
 * - Рекурсивная реализация
 *
 * **Пример:**
 * Для дерева:
 * Пример дерева:
 *      1
 *    /   \
 *   2     3
 *  / \     \
 * 4   5     6
 *
 * Результат:
 * `(1, (2, (4, NULL, NULL), (5, NULL, NULL)), (3, NULL, (6, NULL, NULL)))`
 */
public class MainEx02 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);
        System.out.println(ex02(root));
    }
    public static String ex02(Node node){
        if(node == null){
            return "null";
        }

        String left = ex02(node.left);
        String right = ex02(node.right);

        return node + " " + left + " " + right;
    }
}

