package stacklabtask;

import java.util.Scanner;

public class ReverseString{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String you want to reverse: ");
        String input=sc.nextLine();
        char[] stack=new char[input.length()];
        int top=-1;


        for(int i=0;i<input.length();i++) {
            top++;
            stack[top]=input.charAt(i);
        }


//        System.out.println(input);
        System.out.print("Reversed string: ");
        while (top>=0) {
            System.out.print(stack[top--]);
        }
        System.out.println();
    }
}