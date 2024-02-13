import java.util.*;

public class Sorter<T extends Comparable<T>> {

    // Bubble Sort implementation
    public void bubbleSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Merge Sort implementation
    public void mergeSort(T[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        T[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        T[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private void merge(T[] arr, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) < 0)
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        while (i < left.length)
            arr[k++] = left[i++];

        while (j < right.length)
            arr[k++] = right[j++];
    }

    // Method to print array
    public void printArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Test
    public static void main(String[] args) {
        Sorter<Integer> sorter = new Sorter<>();

        Integer[] arr1 = {87, 71, 58, 29, 9, 66, 5};
        System.out.println("Array:");
        sorter.printArray(arr1);

        sorter.bubbleSort(arr1);
        System.out.println("Array using Bubble Sort:");
        sorter.printArray(arr1);

        Integer[] arr2 = {87, 71, 58, 29, 9, 66, 5};
        System.out.println("Array:");
        sorter.printArray(arr2);

        sorter.mergeSort(arr2);
        System.out.println("Array using Merge Sort:");
        sorter.printArray(arr2);
    }
}
