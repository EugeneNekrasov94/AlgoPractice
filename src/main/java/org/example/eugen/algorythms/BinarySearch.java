package org.example.eugen.algorythms;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(find(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 7));
    }

    public static int find(int[] source, int x) {
        int low = 0;
        int high = source.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (x > source[mid]) {
                low = mid + 1;
            } else if (x < source[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
