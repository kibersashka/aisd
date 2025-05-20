package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,0,0,2,1,2,1};
        sort(arr);
    }
    public static void sort(int[] arr){
        int r = arr.length - 1;
        int l = 0;
        int m = 0;
        while (l < r && m < r){

            if(arr[l] > arr[r]){
                int step = arr[l];
                arr[l] = arr[r];
                arr[r] = step;
                l++;
                continue;
            }
            if (arr[m] > arr[r]){
                int step = arr[l];
                arr[l] = arr[r];
                arr[r] = step;
                m++;
                continue;
            }
            if(arr[m] < arr[r]){
                int step = arr[l];
                arr[l] = arr[r];
                arr[r] = step;

                continue;
            }
            if (arr[l] < arr[m]){
                r--;
                continue;
            }
            if (arr[l] == arr[r]){
                m++;
            }

        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}