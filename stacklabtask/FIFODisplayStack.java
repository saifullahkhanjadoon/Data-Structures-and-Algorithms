package stacklabtask;

import java.util.Scanner;

public class FIFODisplayStack {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] stack=new int[5];
        int top=-1;

        System.out.println("Enter 5 integers to push into the stack:");
        for (int i=0;i<5;i++) {
            int value=sc.nextInt();
            top++;
            stack[top]=value;
        }

        System.out.println("\nElements in FIFO order :");

        for (int i=0;i<=top;i++) {
            System.out.println(stack[i]);
        }

    }
}
