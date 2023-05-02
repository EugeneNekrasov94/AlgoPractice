package org.example.eugen.algorythms.sorting;

import java.util.Arrays;

public class MergeSortSelfCheck {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(MergeSort.getArray(50))));
    }

    private static int[] sort(int[] array) {
        int[] tmp;
        int[] currSource = array;
        int[] dest = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += size * 2) {
                merge(currSource, currSource, i, i + size, dest, i, size);
            }

            size *= 2;

            tmp = currSource;
            currSource = dest;
            dest = tmp;
        }
        return currSource;
    }

    private static void merge(int[] src1, int[] src2, int src1Start, int src2Start, int[] dest, int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size,src1.length);
        int src2End = Math.min(src2Start + size,src2.length);

        int countOfOperations = src1End - src1Start + src2End - src2Start;

        for (int i = destStart;i < destStart + countOfOperations;i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }


}
