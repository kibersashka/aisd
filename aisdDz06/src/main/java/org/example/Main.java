package org.example;

/**
 * Черепашка ходит либо вниз либо вправо по двумерному массиву, в котором расположены
 * цены прохождения той или иной клетки, необходимо вывести минимальную сумму, за которую можно пройти
 * 8  8  8  8  8  8  8  8  8
 *
 * 9 = макс(б1, а2) + current
 *
 * 8
 *
 * 8
 *
 * 8
 *
 * 8
 */
public class Main {
    public static void main(String[] args) {
        ex03();
    }
    public static void ex03(){
        int[][] arr = new int[][]{
                {1, 3, 4, 8, 1, 3},
                {2, 1, 4, 6, 7, 4},
                {2, 1, 4, 6, 7, 4},
                {2, 1, 4, 6, 7, 4}};
        int current = arr[0][0];
        //column
        for(int i = 1; i < arr.length; i++) {
            arr[i][0] += current;
            current = arr[i][0];
        }
        //row
        current = arr[0][0];
        for(int i = 1; i < arr[0].length; i++) {
            arr[0][i] += current;
            current = arr[0][i];
        }
        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j < arr[0].length; j++) {
                arr[i][j] += Math.max(arr[i - 1][j], arr[i][j - 1]);
            }
        }
        System.out.println(arr[3][5]);
    }
}