package org.example;

import java.util.ArrayList;
import java.util.List;

public class MergeSortInteger {
    public static List<Integer> mergeSortInteger(List<Integer> list) {
        if (list.size() <= 1) {
            return list; // Базовый случай рекурсии
        }

        // Разделение списка на две половины
        int mid = list.size() / 2;
        List<Integer> left = new ArrayList<>(list.subList(0, mid));
        List<Integer> right = new ArrayList<>(list.subList(mid, list.size()));

        // Рекурсивная сортировка каждой половины
        left = mergeSortInteger(left);
        right = mergeSortInteger(right);

        // Слияние отсортированных половин
        return merge(left, right);
    }

    // Метод для слияния двух отсортированных списков
    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Сравниваем элементы и добавляем меньший в результат
        while (i < left.size() && j < right.size()) {
            if (sravnenie(right.get(i), left.get(i)) < 0) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        // Добавляем оставшиеся элементы из левого списка
        while (i < left.size()) {
            merged.add(left.get(i++));
        }
        // Добавляем оставшиеся элементы из правого списка
        while (j < right.size()) {
            merged.add(right.get(j++));
        }
        return merged;
    }
    public static int sravnenie(Integer integer1, Integer integer2){
        return integer2 - integer1;
    }
}
