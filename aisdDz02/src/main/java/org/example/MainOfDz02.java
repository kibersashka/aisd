package org.example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Напишите функцию, которая принимает на вход текст и вовращает количество
 * вхождений каждого слова (с учетом окончаний. Т.е. "яблоко" и "яблока" -- это два разных слова ).
 * Сложность -- O(n)
 */

/**
 * Дан массив целых чисел и число k. Определить,
 * есть ли в массиве такие два различных индекса i и j, что nums[i] == nums[j] и |i - j| <= k
 * Пример:
 * [1, 2, 3, 1, 5], k = 3
 * Вывод: true (индекс 0 и 3, расстояние 3)
 */
public class MainOfDz02 {
    public static void main(String[] args) {
        String[] strArr = ("Hello my my dear friend").trim().split(" ");
        ex01stream(strArr);
        System.out.println("_---------_");
        ex01withOutStream(strArr);
        System.out.println("_---------_");
        Integer[] arrInt = {2,4,4,1};
        System.out.println(ex02(arrInt, 2));
        Integer[] arrInt2 = {2,2,4,5};
        System.out.println("_---------_");
        for(Integer integer : ex03(arrInt, arrInt2)){
            System.out.print(integer + " ");
        }
    }
    /**
     * Напишите функцию, которая принимает на вход текст и вовращает количество
     * вхождений каждого слова (с учетом окончаний. Т.е. "яблоко" и "яблока" -- это два разных слова ).
     * Сложность -- O(n)
     */

    //первое задание с использованием стримов
    public static void ex01stream(String[] str) {
        Map<String, Integer> mapa = Arrays.stream(str)
                .collect(Collectors.toMap(
                        x -> x,
                        x -> 1,
                        (x, y) -> x + y));
        mapa.entrySet().stream().forEach(System.out::println);
    }
    //первое задание без использованием стримов
    public static void ex01withOutStream(String[] str){
        Map<String, Integer> mapa = new HashMap<>();
        for(String string: str){
            if(mapa.get(string) == null){
                mapa.put(string, 1);
                continue;
            }
            mapa.put(string, mapa.get(string) + 1);
        }
        mapa.entrySet().stream().forEach(System.out::println);
    }
    /**
     * Дан массив целых чисел и число k. Определить,
     * есть ли в массиве такие два различных индекса i и j, что nums[i] == nums[j] и |i - j| <= k
     * Пример:
     * [1, 2, 3, 1, 5], k = 3
     * Вывод: true (индекс 0 и 3, расстояние 3)
     */
    public static boolean ex02(Integer[] arrInt, int k){
        Map<Integer, List<Integer>> mapa = new HashMap<>();
        for(int i = 0; i < arrInt.length; i++){
            mapa.merge(arrInt[i],
                    new ArrayList<>(List.of(i)),
                    (x, y) -> {x.addAll(y); return x;});
        }
        //mapa.entrySet().stream().forEach(System.out::println);
        for(Map.Entry<Integer, List<Integer>> key: mapa.entrySet()){
            if(key.getValue().size() <= 1){
                continue;
            }
            for(int i = 1; i < key.getValue().size(); i++){
                if (key.getValue().get(i) - key.getValue().get(i - 1) <= k){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Даны два массива целых чисел. Вернуть массив их общих элементов,
     * где количесвто вхождений каждого элемента равно минимальному из его встречаемости в обоих массивах
     * Пример:
     * [2, 4, 4, 1], [2, 2, 4, 5]
     * Вывод:
     * [2, 4]
     * 1 - 1
     *      2 - 1
     * 4 - 2
     *
     * 2 - 2
     *       4 - 1
     * 5 -1
     *
     */
    public static Integer[] ex03(Integer[] intArr01, Integer[] intArr02){
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map01 = new HashMap<>();
        int min01 = 1000;
        for(int i = 0; i < intArr01.length; i++){
            map01.merge(intArr01[i], 1, Integer::sum);
        }
        Map<Integer, Integer> map02 = new HashMap<>();

        for(int i = 0; i < intArr02.length; i++){
            map02.merge(intArr02[i], 1, Integer::sum);
        }
        for(Map.Entry<Integer, Integer> entry : map01.entrySet()){
            if(map02.containsKey(entry.getKey())){
                int min = Math.min(entry.getValue(), map02.get(entry.getKey()));
                for(int i = 0; i < min; i++){
                    list.add(entry.getKey());
                }
            }
        }
        Integer[] res = new Integer[list.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }

}
