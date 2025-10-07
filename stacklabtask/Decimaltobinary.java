package stacklabtask;

import java.util.Scanner;
public class Decimaltobinary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        int[] stack=new int[100];
        int top=-1;
        while(number>0) {
            int remainder=number % 2;
            top++;
            stack[top]=remainder;
            number= number / 2;
        }

        System.out.print("Binary representation: ");

        while (top>=0) {
            System.out.print(stack[top]);
            top--;
        }


    }
}
