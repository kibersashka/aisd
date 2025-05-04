package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
//https://datalens.yandex/hugj9nghekim3
public class Algoritm {
    public static List<Point> algoritmDgarvisa(List<Point> points){
        //List<Point> points = new ArrayList<>();
        List<Point> algoritm = new ArrayList<>();
        if (points == null){
            return null;
        }
        Point start = points.get(0);
        //находим самую левую точку по ОХ и ОУ
        long startTime = System.nanoTime();
        long n = 0;
        for(Point point : points){
            if (start.getX() == point.getX() && start.getY() > point.getY()){
                start = point;
            }
            if (start.getX() > point.getX()){
                start = point;
            }
            n++;
        }

        //System.out.println(start.getX() + " " + start.getY());

        Point current = start;//выбираем текущую изначально равна начальной самой правой
        do{//ищем самую правую от текущей
            algoritm.add(current);//заполняем множество для оболочки
            Point next = points.get(0);// берем первую так как она 100% существует

            for(Point maybeCurrent : points) {//идем по множеству точек
                if (getPlace(current, next, maybeCurrent) < 0 | next == current) {//самая правая или избегаем цикла
                    next = maybeCurrent;
                }
                if (getPlace(current, next, maybeCurrent) == 0) {//коллинеарные
                    if (lenOfVector(current, next) < lenOfVector(current, maybeCurrent)) {//берем самую дальнюю точку
                        next = maybeCurrent;
                    }
                }
                n++;
            }
            current = next;
        } while (!current.equals(start));//алгоритм завершается когда дойдем до стартовой
        long endTime = System.nanoTime();
        System.out.println("колличество операций: " + n);
        System.out.println("размер входных данных: " + points.size());
        try (FileWriter os = new FileWriter("res.txt", true)){
            os.write(n + " " + points.size() + " " + (endTime - startTime) + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return algoritm;
    }
    //проверка расположения
    //ab * bc < 0 справа
    //ab * bc > 0 слева
    //ab * bc = 0 лежит

    public static int getPlace(Point a, Point b, Point c) {
        return ((b.getX() - a.getX()) * (c.getY() - b.getY()) - (b.getY() - a.getY()) * (c.getX() - b.getX()));
    }
    public static double lenOfVector(Point a, Point b){ //для случая коллинеарности выбираем самую дальнюю
        return Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2);
    }
}
