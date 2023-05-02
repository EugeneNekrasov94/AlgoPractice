package org.example.eugen.algorythms.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{5, 4, 6, 2, 45, 23, 53})));
    }

    static int[] sort(int[] source) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int j = 0; j < source.length - 1; j++) {
                if (source[j] > source[j + 1]) {
                    int temp = source[j];
                    source[j]  = source[j + 1];
                    source[j + 1] = temp;
                    sorted = false;
                }
            }
        }
        return source;
    }
}
