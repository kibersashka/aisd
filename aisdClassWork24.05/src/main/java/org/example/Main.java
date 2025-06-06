package org.example;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 40000, 2, 1, 600, 3};
        System.out.println(ex03(0,arr.length - 1, arr));
        String str = "100001000";
        System.out.println(ex02(str, 0, str.length()- 1));
        String res1 = "10101000";
        String res2 = "11111000";
        ex04(res1, res2);

    }
    public static int ex03(int l, int r, int[] arr){
        if (l + 1 == r ){
            return arr[l];
        }
        int m = (l + r) /2;
        return Math.max(ex03(l, m, arr), ex03(m, r, arr));
    }
    public static int ex02(String str, int l, int r){
        //System.out.println(str.charAt(r));
        if (l > r){
            return 0;
        }
        if (l == r){
            return (str.charAt(l) == '0' ? 1 : 0);
        }
        int mid = (r + l) / 2;
        int zero = ex02(str, mid + 1, r);
        if (zero == r - mid){
            return zero + ex02(str, l, mid);
        }
        return zero;
    }
    public static int ex04(String str1, String str2){
        if (str1.length() == 1 && str2.length() == 1) {
            int n1 = str1.charAt(0) - '0';
            int n2 = str2.charAt(0) - '0';
            return Integer.valueOf(n1 * n2);
        }
        String a = str1.substring(0, str1.length() / 2);
        String b = str1.substring(str1.length() / 2 );
        String c = str2.substring(0, str2.length() / 2);
        String d = str2.substring(str2.length() / 2 );
        double x = Math.pow(2, str1.length() / 2);




        int ac = ex04(a, c);
        int bd = ex04(b, d);
        String aPlusb = a + b;
        String bPlusd = b + d;
        int aPlusbBplusD = ex04(aPlusb, bPlusd);

        return (int) (ac*x*x + (aPlusbBplusD - ac - bd)*x + bd);






    }
}