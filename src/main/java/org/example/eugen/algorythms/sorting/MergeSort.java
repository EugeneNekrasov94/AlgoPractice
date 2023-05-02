package org.example.eugen.algorythms.sorting;

import java.util.Arrays;
import java.util.Collections;

public class MergeSort {

    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        mergeSortIterative(getArray(50000000));
        long res = System.currentTimeMillis() - before;
        System.out.println("Итеративная = " + res);
        before = System.currentTimeMillis();
        sortByRecursion(getArray(50000000));
        res = System.currentTimeMillis() - before;
        System.out.println("Рекурсивная = " + res);
        before = System.currentTimeMillis();
        QuickSortSelfCheck.quickSort(getArray(50000000),0,50000000-1);
        res = System.currentTimeMillis() - before;
        System.out.println("Быстрая = " + res);
    }

    static int[] getArray(int x) {
        int[] load = new int[x];
        for (int i = 0; i < x;i++) {
            load[i] = (int) (Math.random()*50000);
        }
        return load;
    }

    static int[] sortByRecursion(int[] source) {
        int[] buffer1 = Arrays.copyOf(source, source.length);
        int[] buffer2 = new int[source.length];
        return mergeInner(buffer1, buffer2, 0, source.length);
    }

    private static int[] mergeInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        //base case of recursion
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeInner(buffer1, buffer2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2] ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

    public static int[] mergeSortIterative(int[] array) {
        int[] temp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int size = 1;

        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                mergeIterative(currentSrc, currentSrc, i, i + size, currentDest, i, size);
            }
            temp = currentSrc;
            currentSrc = currentDest;
            currentDest = temp;

            size = size * 2;

            //System.out.println(Arrays.toString(currentSrc));
        }
        return currentSrc;
    }

    public static void mergeIterative(int[] src1, int[] src2, int src1Start, int scr2Start, int[] dest,
                                      int destStart, int size) {
        int index1 = src1Start;
        int index2 = scr2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(scr2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - scr2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
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
