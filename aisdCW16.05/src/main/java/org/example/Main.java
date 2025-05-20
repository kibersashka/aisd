package org.example;

/**
 * aaaabaabaa
 * aabaaaabaa
 * не конец
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,4,5,6};
        int x = 6;
        //binSearch(arr, 3);
        System.out.println( st("aaaab", "aabaa") > 0 ? "есть сдвиг : " + st("aaaab", "aabaa") : "неt" );


    }
    public static int st(String t, String s){
        String res = s + s;
        int k = 0;
        for(int i = 0; i < res.length(); i++){
            if (k == s.length() & k != res.length()){
                return i - k - 1;
            }
            if(k < t.length() && res.charAt(i) == t.charAt(k)){
                k = k + 1;
            }else{
                k = 0;
            }
        }
        return -10;
    }
    public static void binSearch(int[] arr, int x) {
        int r = arr.length - 1;
        int l = 0;
        int m = (r + l) / 2;
        int resL = 0;
        int resR = 0;

        while (l <= r ) {
            m = (l + r) / 2;
            if (arr[m] < x) {

                l = m + 1;
            }
            else{
                r = m - 1;
            }
        }
        resL = l;
        r = arr.length - 1;
        l = 0;
        m = (r + l) / 2;

        System.out.println(resL + " " + resR);

    }

}