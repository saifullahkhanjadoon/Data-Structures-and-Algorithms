package stacklabtask;

import java.util.Scanner;

public class Stacking {
    int[] stack=new int[5];
    int top;

    Stacking(){
        top=-1;
    }

    int push(int x) {
        if(fullStack()) {
            System.out.println("Stack Overflow");
            return 1;
        }else{
            top++;
            stack[top]=x;

            System.out.println("Pushed:"+x);
            return 0;
        }
    }

    boolean fullStack(){
        return top>=4;
    }

    int pop(){
        if(emptyStack()){
            System.out.println("Stack Underflow");
            return -1;
        }else{
            int popped=stack[top--];
            System.out.println("Popped: "+popped);
            return popped;
        }
    }

    boolean emptyStack(){
        return top<0;
    }
    void display(){
        if(emptyStack()){
            System.out.println("Stack is empty");
        }
        else{
            System.out.print("Stack elements: ");
            for(int i=0;i<=top;i++) {
                System.out.print(stack[i]+" ");
            }            System.out.println();        }    }
    public static void main(String[] args) {
        Stacking obj = new Stacking();
        Scanner sc = new Scanner(System.in);
        int choice;
        do{            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter value to push: ");
                    int val=sc.nextInt();
                    obj.push(val);
                    break;
                case 2:
                    obj.pop();
                    break;
                case 3:
                    obj.display();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while(choice!=4);

    }
}
