import java.util.Scanner;

public class OperationCostCounter {

    static int comparisons = 0;
    static int swaps = 0;

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        comparisons = 0;
        swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;
        comparisons = 0;
        swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
            }
        }
    }

    static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    static void displayArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] original = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            original[i] = sc.nextInt();
        }

        int[] bubbleArray = copyArray(original);
        bubbleSort(bubbleArray);
        System.out.println("\nBubble Sort Result:");
        displayArray(bubbleArray);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);

        int[] selectionArray = copyArray(original);
        selectionSort(selectionArray);
        System.out.println("\nSelection Sort Result:");
        displayArray(selectionArray);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);

        sc.close();
    }
}
