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

        for (int i = 1; i <= 50; i++) {

            ToolsWithFile.generateFile("coord" + i + ".txt", i * 100, i * 100);
            ToolsWithFile.readFile("coord" + i + ".txt", points);


            long start = System.nanoTime();

            List<Point> list = Algoritm.algoritmDgarvisa(points);


            long end = System.nanoTime();

            for (Point point : list) {
                System.out.println(point);
            }


            //System.out.println("Нашли выпуклую оболочку за : " + (end - start));
        }

    }
}