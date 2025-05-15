package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println( ex01(3628800));
        List<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(4);
        list.add(10);
        System.out.println(ex02(list.get()).toString());
        System.out.println(list.toString());
    }
    /**
     * ## Задача 1
     * **Вычисление log(N!)**
     * Реализовать рекурсивную процедуру вычисления логарифма факториала.
     *
     * **Немного математики:
     * log(N!) = log(1 × 2 × 3 × ... × N) = log(1) + log(2) + log(3) + ... + log(N)
     */
    public static double ex01(double n){
        if (n <= 1){
            return 0;
        }
        return Math.log(n) + ex01(Math.log(n - 1));
    }
    /**
     * ## Задача 2
     * **Разворот односвязного списка**
     * Рекурсивно изменить порядок следования элементов в линейном односвязном списке на обратный.
     * <p>
     * **Требования:**
     * - Не использовать дополнительную память для нового списка
     * - Сложность O(n)
     *
     * @return
     */
    public static Node<Integer> ex02(Node<Integer> head){
        if(head == null || head.next == null) {
            return head;
        }
        Node<Integer> newHead = ex02(head.next);
        head.next.next = head.next;
        head.next = null;
        return newHead;
    }
}