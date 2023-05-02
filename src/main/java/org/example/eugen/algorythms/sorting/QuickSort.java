package org.example.eugen.algorythms.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{3,5,2,9,0,8,6,4,1,7};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }//[3, 5, 2, 9, 0, 8, 6, 4, 1, 7]
    //[0, 5, 2, 9, 3, 8, 6, 4, 1, 7]

    //рекурсивная реализация
    private static void quickSort(int[] array, int from, int to) {
        if (from < to) {
            int divideIndex = partition(array, from, to);
            quickSort(array, from, divideIndex - 1);
            quickSort(array, divideIndex, to);
        }
    }

    private static int partition(int[] array, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = array[from + ((to - from) / 2)];

        while (leftIndex <= rightIndex) {

            while (array[leftIndex] < pivot) {
                leftIndex++;
            }

            while (array[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                int temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    //чуть иная реализация
    private static void quickSortAnother(int[] array,int from,int to) {
        if (array.length == 0) {
            System.out.println("Массив пуст");
            return;
        }
        if (from > to) {
            return; //
        }

        int pivot = array[from + ((to-from)/2)];

        int fromIndex = from;
        int toIndex = to;

        while (fromIndex <= toIndex) {
            while (array[fromIndex] < pivot) {
                fromIndex++;
            }

            while (array[toIndex] > pivot) {
                toIndex--;
            }

            if (fromIndex <= toIndex) {
                int temp = array[fromIndex];
                array[fromIndex] = array[toIndex];
                array[toIndex] = temp;
                fromIndex++;
                toIndex--;
            }
        }

        if (from < toIndex) {
            quickSortAnother(array,from,toIndex);
        }
        if (to > toIndex) {
            quickSortAnother(array,fromIndex,to);
        }
    }

}
