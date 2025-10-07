package stacklabtask;

import java.util.Scanner;

public class CheckPalendrom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        input = input.toLowerCase();

        int length = input.length();
        char[] stack = new char[length];
        int top = -1;

        for (int i=0;i<length;i++) {
            top++;
            stack[top] = input.charAt(i);
        }
        int isPalindrome = 1;
        for (int i=0;i<length;i++) {
            if (input.charAt(i)!=stack[top]) {
                isPalindrome=0;
                break;
            }
            top--;
        }

        if (isPalindrome==1) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

    }
}
