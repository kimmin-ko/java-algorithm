package algorithm.example;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] arr = {7, 3, 0, 8, 9, 1, 4, 5, 2};
        q.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int s, int e) {
        int part2 = partition(arr, s, e);
        if (s < part2 - 1) {
            quickSort(arr, s, part2 - 1);
        }
        if (part2 < e) {
            quickSort(arr, part2, e);
        }
    }

    private int partition(int[] arr, int s, int e) {
        int pivot = arr[(s + e) / 2];
        while (s <= e) {
            while (arr[s] < pivot) s++;
            while (arr[e] > pivot) e--;
            if (s <= e) {
                swap(arr, s, e);
                s++;
                e--;
            }
        }
        return s;
    }

    private void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }

}
