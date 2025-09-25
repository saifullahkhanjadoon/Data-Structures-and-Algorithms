import java.util.Scanner;

class LinkedList_Insertion {
    Scanner sc = new Scanner(System.in);

    class Node {
        int data;
        Node next;
    }

    Node first = null;
    Node cur,pre;
    void insertTop() {
        Node temp = new Node();
        System.out.print("Enter data to insert at top: ");
        temp.data = sc.nextInt();
        temp.next = first;
        first = temp;
        System.out.println("Node added successfully at top.");
    }

    void insertAtMid() {
        System.out.print("Enter the number before which you want to insert: ");
        int target = sc.nextInt();
         cur = first;
         pre = null;
        int flag=0;

        while (cur != null) {
            if (cur.data == target) {
                flag = 1;
                break;
            }
            pre = cur;
            cur = cur.next;
        }

        if (flag==1) {
            Node temp = new Node();
            System.out.print("Enter data to insert: ");
            temp.data = sc.nextInt();
//            pre.next = temp;
            temp.next = cur;

            if (pre == null) {
                first = temp;
            } else {
                pre.next = temp;
            }
            System.out.println("Node added successfully in the middle.");
        } else {
            System.out.println("Target not found. Node not added.");
        }
    }

    void insertAtEnd() {
        Node temp = new Node();
        System.out.print("Enter data to insert at end: ");
        temp.data = sc.nextInt();
        temp.next = null;

        if (first == null) {
            first = temp;
        } else {
             cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = temp;
        }

        System.out.println("Node added successfully at end.");
    }

    void display() {
        if (first == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("Elements in Linked List are: ");
        cur=first;
        while(cur!=null){
            System.out.print(cur.data+ "--> ");
            cur=cur.next;

        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList_Insertion list = new LinkedList_Insertion();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Linked List Menu ---");
            System.out.println("1. Insert at Top");
            System.out.println("2. Insert in Middle");
            System.out.println("3. Insert at End");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    list.insertTop();
                    break;
                case 2:
                    list.insertAtMid();
                    break;
                case 3:
                    list.insertAtEnd();
                    break;
                case 4:
                    list.display();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);
    }
}
