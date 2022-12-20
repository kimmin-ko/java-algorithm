package algorithm.example;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] arr = {3, 5, 4, 8, 1, 6, 0, 9, 7, 2};
        m.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int s, int e) {
        if (s >= e) {
            return;
        }
        int m = (s + e) / 2;
        mergeSort(arr, temp, s, m);
        mergeSort(arr, temp, m + 1, e);
        merge(arr, temp, s, m, e);
    }

    private void merge(int[] arr, int[] temp, int s, int m, int e) {
        for (int i = s; i <= e; i++) {
            temp[i] = arr[i];
        }

        int l = s;
        int r = m + 1;
        int current = s;
        while (l <= m && r <= e) {
            if (temp[l] < temp[r]) {
                arr[current++] = temp[l++];
            } else {
                arr[current++] = temp[r++];
            }
        }

        for (int i = l; i < m + 1; i++) {
            arr[current++] = temp[i];
        }
    }
}
