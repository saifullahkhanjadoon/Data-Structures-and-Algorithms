package Tree;
import java.util.Scanner;

class Node1 {
    int data;
    Node1 left, right;

    Node1(int data) {
        this.data = data;
        left = right = null;
    }
}

// -------- CUSTOM QUEUE IMPLEMENTATION --------
class MyQueue {
    Node1[] arr;
    int front, rear, size;

    MyQueue(int size) {
        arr = new Node1[size];
        front = 0;
        rear = -1;
        this.size = size;
    }

    void enq(Node1 value) {
        if (rear == size - 1) {
            System.out.println("Queue Full");
            return;
        }
        arr[++rear] = value;
    }

    Node1 deq() {
        if (isEmpty()) {
            return null;
        }
        return arr[front++];
    }

    boolean isEmpty() {
        return front > rear;
    }
}

// -------- BST CLASS --------
class BST {
    Node1 temp;

    // Only one insert method
    void insert(Node1 ptr, int values) {

        Node1 newnode = new Node1(values);

        while (ptr != null) {
            if (values < ptr.data) {
                temp = ptr;
                ptr = ptr.left;
            } else {
                temp = ptr;
                ptr = ptr.right;
            }
        }

        if (values < temp.data)
            temp.left = newnode;
        else
            temp.right = newnode;
    }

    // BFS
    void bfs(Node1 root) {
        if (root == null) return;

        MyQueue ob = new MyQueue(100);
        ob.enq(root);

        while (!ob.isEmpty()) {
            Node1 temp = ob.deq();

            if (temp != null) {
                System.out.print(temp.data + " ");

                if (temp.left != null)
                    ob.enq(temp.left);

                if (temp.right != null)
                    ob.enq(temp.right);
            }
        }
    }

    // DFS Preorder
    void dfs(Node1 root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        dfs(root.left);
        dfs(root.right);
    }

    // Height of tree
    int height(Node1 ptr) {
        if (ptr == null)
            return 0;

        int l = height(ptr.left);
        int r = height(ptr.right);
        int height;

        if (l > r)
            height = 1 + l;
        else
            height = 1 + r;

        return height;
    }

    // -------- SEARCH METHOD --------
    void search(Node1 ptr, int key) {
        if (ptr == null)
            System.out.println("false search");

        if (ptr.data == key)
            System.out.println("found ");
        else if (key < ptr.data)
           search(ptr.left, key);
        else
             search(ptr.right, key);
    }
}

// -------- MAIN CLASS --------
public class Mainbfsdfs {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BST tree = new BST();

        Node1 root = new Node1(50);

        tree.insert(root, 30);
        tree.insert(root, 70);
        tree.insert(root, 20);
        tree.insert(root, 40);
        tree.insert(root, 60);
        tree.insert(root, 80);

        System.out.println("Choose option:");
        System.out.println("1. BFS Traversal");
        System.out.println("2. DFS Preorder Traversal");
        System.out.println("3. Height of Tree");
        System.out.println("4. Search a Node");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("BFS Traversal: ");
                tree.bfs(root);
                break;

            case 2:
                System.out.print("DFS Preorder: ");
                tree.dfs(root);
                break;

            case 3:
                System.out.println("Height of Tree: " + tree.height(root));
                break;

            case 4:
                System.out.print("Enter value to search: ");
                int target = sc.nextInt();
                tree.search(root, target);

                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
}
