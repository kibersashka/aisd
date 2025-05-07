package org.example;

import java.io.*;
import java.util.List;

public class ToolsWithFile {

    public static void generateFile(String nameOfFile, int lenOfOutDate, int randeOfCoor) {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(nameOfFile))){
            for (int i = 0; i < lenOfOutDate; i++){
                fw.write((int) ((Math.random() * randeOfCoor * 2) - randeOfCoor) + " " + (int) ((Math.random() * randeOfCoor * 2) - randeOfCoor) + "\n" );
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
}
