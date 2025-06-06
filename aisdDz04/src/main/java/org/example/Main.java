package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.MergeSortInteger.mergeSortInteger;
import static org.example.MergeSortString.mergeSort;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 7,6, 5,1000,72,73};
        System.out.println(ex01(arr));
        String str = "this is ib";
        System.out.println(ex02(str));
        int[] arr1 = new int[]{3, 30, 34, 5, 9};
        System.out.println(ex03(arr1));
        List<Integer> arr2 = new ArrayList<>(List.of(15, 5, 11, 10, 12)) ;
        System.out.println(ex04(arr2));
    }
    /**
     * Задача 1.
     * Дана последовательность различных чисел,
     * в которой все числа до определенного индекса j отсортированы по убыванию,
     * а после j по возрастанию. Найдите этот индекс j.  (Сложность O(log n).)
     *
     * бинарный поиск
     *
     */
    public static int ex01(int[] arr){

        int mid = (arr.length) / 2;
        System.out.println(arr[mid]);
        int l = 0 ;
        int r = arr.length - 1;
        while(l < r){
            mid = (l + r) / 2;
            if(arr[mid] > arr[mid + 1] ){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return mid;
    }
    /**
     * Задача 2.
     * Есть строка. Нужно развернуть строку так,
     * чтобы каждое из слов осталось в естественном порядке.
     * Например. Input 1: A = "the sky is blue" Output 1: "blue is sky the" Input 2: A = "this is ib"
     * Output 2: "ib is this". Сложность линейная, с О(1) дополнительной памяти.
     */
    public static String ex02(String str){
        String res = "";
        String stepL = "";
        for(int l = 0; l < str.length(); l++){
            if(str.charAt(l) != ' '){
                stepL += str.charAt(l);
            }

            if(str.charAt(l) == ' ' || l == str.length() - 1){
                stepL += " ";
                res = stepL + res;
                stepL = "";
            }
        }
        return res;
    }
    /**
     * Задача 3
     * Дан список неотрицательных чисел.
     * Измените их порядок так, чтобы если их после этого выписать в строку,
     * то получилось максимальное из возможных чисел. Пример: дан массив [3, 30, 34, 5, 9].
     * Максимальное возможное число можно получить 9 5 34 3 30. Сложность O(n log n)
     */
    public static String ex03(int[] arr){
        List<String> list = new ArrayList<>();
        String line = "";
        for(int i = 0; i < arr.length; i++){
            list.add(String.valueOf(arr[i]));

        }
        list = mergeSort(list);//сортировка слиянием n log(n)
        for (int i = 0; i < list.size(); i++){
            line += list.get(i);
        }
        return line;
    }
    /**
     * Задача 4
     * Дан список неотрицательных чисел и некоторое число s.
     * Необходимо вывести мксимальное количество числе из списка, сумма которых не превышает s.
     * Пример: [15, 5, 11, 10, 12], s = 30, тогда ответ будет 3 (например, 5 + 10 + 11 < 30)
     */
    public static int ex04(List<Integer> arr){
        int s = 30;
        mergeSortInteger(arr);
        int i = 0;
        int sum = 0;
        while(i != arr.size() && sum <= s){
            sum += arr.get(i++);
        }
        return i;
    }
}