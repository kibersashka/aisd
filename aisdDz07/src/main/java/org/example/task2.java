
import java.util.Arrays;
import java.util.Scanner;

public class task2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] stalls = new int[N];
        for (int i = 0; i < N; i++) {
            stalls[i] = scanner.nextInt();
        }
        Arrays.sort(stalls);
        System.out.println(findMaxMinDistance(stalls, K));
    }

    public static int findMaxMinDistance(int[] stalls, int K) {
        int left = 0;
        int right = stalls[stalls.length - 1] - stalls[0];
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlaceCows(stalls, K, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static boolean canPlaceCows(int[] stalls, int K, int minDistance) {
        int count = 1;
        int lastPosition = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDistance) {
                count++;
                lastPosition = stalls[i];
                if (count == K) {
                    return true;
                }
            }
        }
        return false;
    }

}
