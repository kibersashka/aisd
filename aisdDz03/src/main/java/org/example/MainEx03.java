package org.example;

/**
 * ## Задача 3
 * **Сериализация N-арного дерева**
 * Решите задачу 2 при условии, что дерево может быть не бинарным.
 * Формат: `(значение, список детей через запятую)`.
 * Пустой список детей заменяется на `NULL`.
 **          1
 *  *    /  \   \
 *  *   2    4  3
 *  *  / \       \
 *  * 4   5        6
 * **Требования:**
 * - Линейная сложность O(n)
 * - Универсальное решение для любого количества потомков
 */
public class MainEx03 {
    public static void main(String[] args) {
        NodeNTree root = new NodeNTree(1);
        NodeNTree node1 = new NodeNTree(2);
        NodeNTree node2 = new NodeNTree(4);
        NodeNTree node3 = new NodeNTree(3);

        root.addChild(node1);
        root.addChild(node2);
        root.addChild(node3);
        node1.addChild(new NodeNTree(4));
        node1.addChild(new NodeNTree(5));
        node3.addChild(new NodeNTree(6));
        System.out.println(ex02(root));
    }
    public static String ex02(NodeNTree node){
        if(node == null){
            return "null";
        }
        String result = "(" + node;
        if(node.children.isEmpty()){
            result = result + ", NULL";
        }
        for(NodeNTree nodeNTree : node.children){
            result = result + ", " + ex02(nodeNTree);


        }
        return result + ") ";
    }
}
