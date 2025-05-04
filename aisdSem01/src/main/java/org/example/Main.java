package org.example;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        generateFile("coord.txt", 100, 10);
        readFile("coord.txt", points);
        algoritmDgarvisa(points);




    }
    public static void generateFile(String nameOfFile, int lenOfOutDate, int randeOfCoor) {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(nameOfFile))){
            for (int i = 0; i < lenOfOutDate; i++){
                fw.write((int) (Math.random() * randeOfCoor) + " " + (int) (Math.random() * randeOfCoor) + "\n" );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readFile(String nameOfFile, List<Point> points){
        //Generate generate = new Generate();
        //generate.generateFile(1000, nameOfFile);
        try (BufferedReader fr = new BufferedReader(new FileReader(nameOfFile))){
            String r;
            while ((r = fr.readLine()) != null){
                String[] str = r.split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                points.add(new Point(x, y));

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void algoritmDgarvisa(List<Point> points){
        //List<Point> points = new ArrayList<>();
        List<Point> algoritm = new ArrayList<>();
        Point start = points.get(0);
        //находим самую левую точку по ОХ и ОУ
        for(Point point : points){
            if (start.getX() == point.getX() && start.getY() > point.getY()){
                start = point;
            }
            if (start.getX() > point.getX()){
                start = point;
            }
        }

        //System.out.println(start.getX() + " " + start.getY());

        Point current = start;//выбираем текущую изначально равна начальной самой правой
        do{//ищем самую правую от текущей
            algoritm.add(current);//заполняем множество для оболочки
            Point next = points.get(0);// берем первую так как она 99% существует

            for(Point maybeCurrent : points) {//идем по множеству точек
                if (getPlace(current, next, maybeCurrent) < 0 | next == current) {//самая правая или избегаем цикла
                    next = maybeCurrent;
                }
                if (getPlace(current, next, maybeCurrent) == 0) {//коллинеарные
                    if (lenOfVector(current, next) < lenOfVector(current, maybeCurrent)) {//берем самую дальнюю точку
                        next = maybeCurrent;
                    }
                }
            }

            current = next;
        } while (!current.equals(start));//алгоритм завершается когда дойдем до стартовой

        for(Point point : algoritm){
            System.out.println(point.getX() + " " + point.getY());
        }
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