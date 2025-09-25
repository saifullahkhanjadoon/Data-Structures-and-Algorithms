import java.util.Scanner;

class LinkedList_Deletion {
    Scanner sc = new Scanner(System.in);

    class Node {
        int data;
        Node next;
    }

    Node first = null;
    Node cur,pre;

    void entry(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Do you want to addnode(Y/n)");
        char choice='y';
        choice=sc.next().charAt(0);

        while(choice=='y'||choice=='Y'){
            Node temp=new Node();
            System.out.println("Enter data: ");
            temp.data=sc.nextInt();
            temp.next=null;
            if(first==null){
                first=temp;
            }else{
                cur=first;
                while(cur.next!=null){
                    cur=cur.next;
                }
                cur.next=temp;
            }
            System.out.println("Do you want to add another node(y/n)");
            choice=sc.next().charAt(0);
        }
    }
void deleteTop() {
    if (first == null) {
        System.out.println("List is empty. Nothing to delete.");
    } else {
        System.out.println("Deleted: " + first.data);
        first = first.next;
    }
}

void deleteMid() {
    if (first == null) {
        System.out.println("List is empty.");
        return;
    }

    System.out.print("Enter value to delete: ");
    int target = sc.nextInt();

     cur = first;
     pre = null;
    int flag = 0;

    while (cur != null) {
        if (cur.data == target) {
            flag = 1;
            break;
        }
        pre = cur;
        cur = cur.next;
    }

    if (flag==0) {
        System.out.println("Value not found.");
    } else {
        if (pre == null) {
            // Deleting first node
            first = cur.next;
        } else {
            pre.next = cur.next;
        }
        System.out.println("Deleted node with value: " + target);
    }
}

void deleteEnd() {
    if (first == null) {
        System.out.println("List is empty.");
        return;
    }

    if (first.next == null) {
        System.out.println("Deleted: " + first.data);
        first = null;
    } else {
         cur = first;
         pre = null;
        while (cur.next != null) {
            pre = cur;
            cur = cur.next;
        }
        System.out.println("Deleted: " + cur.data);
        pre.next = null;
    }
}

// Display method
void display() {
    if (first == null) {
        System.out.println("List is empty.");
        return;
    }

    Node temp = first;
    while (temp != null) {
        System.out.print(temp.data + " -> ");
        temp = temp.next;
    }
    System.out.println("null");
}

public static void main(String[] args) {
    LinkedList_Deletion list = new LinkedList_Deletion();
    Scanner sc = new Scanner(System.in);
    int choice;

    do {
        System.out.println("\n--- Linked List Menu ---");
        System.out.println("1.Data entry for creation of list");
        System.out.println("2. Delete from Top");
        System.out.println("3. Delete by Value (Middle)");
        System.out.println("4. Delete from End");
        System.out.println("5. Display");
        System.out.println("56. Exit");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                list.entry();
                break;
            case 2:
                list.deleteTop();
                break;
            case 3:
                list.deleteMid();
                break;
            case 4:
                list.deleteEnd();
                break;
            case 5:
                list.display();
                break;
            case 6:
                System.out.println("Exiting program.");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }

    } while (choice != 6);
}
}