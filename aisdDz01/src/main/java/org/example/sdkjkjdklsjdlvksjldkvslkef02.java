package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class sdkjkjdklsjdlvksjldkvslkef02 {
    public static void main(String[] args) {
        //int[] arr = {5, 4, 9, 7, 2};
        //int[] arr = {1,2,3,4,5};
        int[] arr = {2,3,4,5,1};
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && (arr[stack.peek()] >= arr[i])) {
                //System.out.println(stack);
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek();//с нуля индексация
                //System.out.println(res[i]);
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = arr.length - 1; i >= 0; i--){
            while (!stack.isEmpty() &&  (arr[stack.peek()] >=  arr[i])) {
                //System.out.println(stack);
                stack.pop();
            }
            if (!stack.isEmpty()) {
                if(res[i] == 0 | (Math.abs(arr[i] - arr[res[i]]) > Math.abs(arr[stack.peek()] - arr[i]))
                        | (i - res[i] < stack.peek() - i)){
                    res[i] = stack.peek();//с нуля индексация
                    //System.out.println(res[i]);
                }
            }
            stack.push(i);
        }
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }

    }

}
