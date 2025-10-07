package stacklabtask;
import java.util.Scanner;

public class FactorialStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] stack = new int[5];
        int top = -1;


        System.out.print("Enter 5 positive integers: ");
        for (int i = 0; i < 5; i++) {
            int value = sc.nextInt();
            top++;
            stack[top] = value;
        }

        System.out.println("\nPopping values and calculating factorials:");


        while (top >= 0) {
            int num = stack[top];  // pop value
            top--;

            int factorial = 1;
            for (int i = 1; i <= num; i++) {
                factorial *= i;
            }

            System.out.println("Value: " + num + " → Factorial: " + factorial);
        }

    }
}

