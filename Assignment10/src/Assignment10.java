import java.util.Arrays;
import java.util.Scanner;

public class Assignment10 {

    public static int[] readArrayFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }
    // Merge Sort implementation
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1)
            return;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Implement Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
         } 
         }
        }
    }

    // Compares the performance of MergeSort and BubbleSort
    public static void compareSorts(int[] arr) {
        long startTime, mergeSortTime, bubbleSortTime;

        int[] arrCopy1 = Arrays.copyOf(arr, arr.length);
        startTime = System.nanoTime();
        mergeSort(arrCopy1);
        mergeSortTime = System.nanoTime() - startTime;

        int[] arrCopy2 = Arrays.copyOf(arr, arr.length);
        startTime = System.nanoTime();
        bubbleSort(arrCopy2);
        bubbleSortTime = System.nanoTime() - startTime;

        System.out.println("MergeSort Time: " + mergeSortTime + " ns");
        System.out.println("BubbleSort Time: " + bubbleSortTime + " ns");
    }

    public static void main(String[] args) {
        //Prompt user to input array
        int[] arr = readArrayFromUser();

        System.out.println("Original Array: " + Arrays.toString(arr));

        System.out.println("\nSorting with MergeSort:");
        int[] arrCopy1 = Arrays.copyOf(arr, arr.length);
        mergeSort(arrCopy1);
        System.out.println("Sorted Array: " + Arrays.toString(arrCopy1));

        System.out.println("\nSorting with BubbleSort:");
        int[] arrCopy2 = Arrays.copyOf(arr, arr.length);
        bubbleSort(arrCopy2);
        System.out.println("Sorted Array: " + Arrays.toString(arrCopy2));

        System.out.println("\nComparing performance:");
        compareSorts(arr);
    }
}

