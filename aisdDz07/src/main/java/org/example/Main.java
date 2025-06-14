package org.example;

import javax.naming.PartialResultException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String len = "12013456789";
        boolean[] arr = new boolean[len.length()];
        int l = 0;
        int r = len.length();
        for(int i = 0; i < r; i++){
            arr[i] = res(String.valueOf(i + 1), len);
            if(!arr[i]){
                System.out.println(i + 1);
                break;
            }
        }




    }
    public static boolean res(String count, String len){
        int l = 0;
        int r = len.length() - 1;
        String res = "";
        int y = 0;
        if(len.contains(String.valueOf(count))){
            return true;
        }
        while(l != r && y < count.length()){
            if(len.charAt(l) == count.charAt(y)){
                y++;

                res += len.charAt(l);
                if(res.equals(count)){
                    return true;
                }
            }
            l++;

        }
        return false;
    }
}

