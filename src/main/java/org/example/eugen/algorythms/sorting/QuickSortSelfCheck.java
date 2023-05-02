package org.example.eugen.algorythms.sorting;

import java.util.Arrays;

public class QuickSortSelfCheck {
    public static void main(String[] args) {
        int[] source = MergeSort.getArray(500);

        quickSort(source, 0, source.length - 1);
        System.out.println(Arrays.toString(source));
    }

    public static void quickSort(int[] source, int from, int to) {
        if (from < to) {
            int division = partition(source, from, to);

            quickSort(source, from, division - 1);
            quickSort(source, division, to);
        }
    }

    private static int partition(int[] source, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = source[from + ((to - from) / 2)];

        while (leftIndex <= rightIndex) {
            while (source[leftIndex] < pivot) {
                leftIndex++;
            }
            while (source[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                int temp = source[leftIndex];
                source[leftIndex] = source[rightIndex];
                source[rightIndex] = temp;
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;

    }


}
