package Tree;
class Node11 {

    int data;
    Node11 left, right;

    Node11(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST1 {
    Node11 temp;

    // Iterative insert
    void insert(Node11 ptr, int value) {
        Node11 newnode = new Node11(value);

        while (ptr != null) {
            if (value < ptr.data) {
                temp = ptr;
                ptr = ptr.left;
            } else {
                temp = ptr;
                ptr = ptr.right;
            }
        }

        if (value < temp.data)
            temp.left = newnode;
        else
            temp.right = newnode;
    }

    // Iterative delete (without ternary operator)
    Node11 delete(Node11 root, int key) {
        Node11 parent = null;
        Node11 ptr = root;

        // Find the node to delete
        while (ptr != null && ptr.data != key) {
            parent = ptr;
            if (key < ptr.data)
                ptr = ptr.left;
            else
                ptr = ptr.right;
        }

        if (ptr == null) {
            System.out.println("Key not found");
            return root;
        }

        // Case 1 & 2: Node has at most one child
        Node11 child = null;
        if (ptr.left != null) {
            child = ptr.left;
        } else if (ptr.right != null) {
            child = ptr.right;
        }

        if (ptr.left == null || ptr.right == null) {
            if (parent == null) {
                // Deleting root
                return child;
            }

            if (parent.left == ptr)
                parent.left = child;
            else
                parent.right = child;
        }
        // Case 3: Node has two children
        else {
            Node11 successorParent = ptr;
            Node11 successor = ptr.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            ptr.data = successor.data;

            if (successorParent.left == successor)
                successorParent.left = successor.right;
            else
                successorParent.right = successor.right;
        }

        return root;
    }



    // Preorder traversal
    void preorder(Node11 root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}

// -------- MAIN CLASS --------
public class Deletetreeele {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        BST1 tree = new BST1();

        Node11 root = new Node11(50);
        tree.insert(root, 30);
        tree.insert(root, 70);
        tree.insert(root, 20);
        tree.insert(root, 40);
        tree.insert(root, 60);
        tree.insert(root, 80);

//        System.out.println("Inorder before deletion:");
//        tree.inorder(root);
//        System.out.println();

        System.out.println("Preorder before deletion:");
        tree.preorder(root);
        System.out.println();

        System.out.print("Enter value to delete: ");
        int key = sc.nextInt();
        root = tree.delete(root, key);
//
//        System.out.println("Inorder after deletion:");
//        tree.inorder(root);
//        System.out.println();

        System.out.println("Preorder after deletion:");
        tree.preorder(root);
    }
}
