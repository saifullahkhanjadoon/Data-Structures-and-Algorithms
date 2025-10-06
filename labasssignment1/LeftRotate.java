package labtask;
import java.util.Scanner;

public class LeftRotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i, j, k, n;

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number of positions to rotate (k): ");
        k = sc.nextInt();
        for (i = 0; i < k; i++) {
            int first = arr[0];
            for (j = 0; j < n - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[n - 1] = first;
        }

        System.out.println("Array after left rotation:");
        for (i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
