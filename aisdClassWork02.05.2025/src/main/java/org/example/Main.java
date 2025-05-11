package org.example;

import javax.naming.PartialResultException;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //getCheck01("(((())))())");
        //System.out.println((char) );
        System.out.println("21 / 2 = " + getCheck02("21 2 *"));
        System.out.println("5 1 2 + 4 * + 3 - == " + getCheck02("5 1 2 + 4 * + 3 -"));


    }
    public static boolean chek01(Character ch1, Character ch2){
        if (ch1 != null && (ch1 - ch2 == '(' - ')')){
            return true;
        }
        return false;
    }
    public static void getCheck01(String str) {
        if(str.length() == 0){
            System.out.println(0);
            return;
        }
        Stack<Character> stack = new Stack<>();
        stack.add(str.charAt(0));
        int step = 0;
        for(int i = 1; i < str.length(); i++){
            if(!stack.isEmpty() && chek01(stack.peek(), str.charAt(i))){
                stack.pop();
                continue;
            }
            stack.add(str.charAt(i));
        }
        System.out.println("нужно удалить:");
        System.out.println(stack.size() + " скобочку");
    }
    public static Double getCheck02(String str) {
        /**
         * 1. проверка на число
         * 2. проверка на символ операции
         */
        Stack<Double> stack = new Stack<>();
        String[] arr = str.trim().split("\\s"); //
        Pattern pattern = Pattern.compile("^-?\\d+");
        for(String string : arr){
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()){
                stack.push((double)Integer.parseInt(string));
            }
            else{
                double x1 = stack.pop();
                double x2 = stack.pop();
                switch (string) {
                    case ("*") -> stack.push(x1 * x2);
                    case ("-") -> stack.push(x1 - x2);
                    case ("+") -> stack.push(x1 + x2);
                    case ("/") -> stack.push(x1 / x2);// так как массив не дабл
                }
            }
        }
        return stack.pop();
    }
}