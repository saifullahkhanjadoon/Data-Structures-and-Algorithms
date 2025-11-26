package Tree;
import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;
    Node temp;


    void create (Node ptr, int values) {

        Node newnode = new Node();
        newnode.data = values;
        newnode.left = null;
        newnode.right = null;

        while(ptr != null){
            if(values < ptr.data){
                temp = ptr;
                ptr = ptr.left;
            }
            else{
                temp = ptr;
                ptr = ptr.right;
            }
        }
        if (values < temp.data) {

            temp.left = newnode;
        }
        else{
            temp.right = newnode;
        }
    }

    void inorder(Node ptr){
        if(ptr != null){
            inorder(ptr.left);
            System.out.println(ptr.data + "  ");
            inorder(ptr.right);
        }
    }

    void preorder(Node ptr){
        if(ptr != null){
            System.out.println(ptr.data + " ");
            preorder(ptr.left);
            preorder(ptr.right);
        }
    }
    void postorder(Node ptr){
        if (ptr != null) {
            postorder(ptr.left);
            postorder(ptr.right);
            System.out.println(ptr.data + " ");
        }
    }

    int min(Node ptr){

        if (ptr == null) {
            return -1;

        }
        while(ptr.left != null ){
            ptr = ptr.left;
        }
        System.out.println("Minimum value node is: "+ ptr.data);
        return ptr.data;
    }

    int max(Node ptr){

        if (ptr == null) {
            return -1;

        }
        while(ptr.right != null ){
            ptr = ptr.right;
        }
        System.out.println("Maximum value node is: "+ ptr.data);
        return ptr.data;
    }


}

public class TreeAssg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = new Node();
        root.data = 90;
        root.left = null;
        root.right = null;
        Node obj = new Node();

        int[] values = {70, 30, 20, 40, 60, 80, 76, 85 };

        for (int v : values){
            obj.create(root, v);
        }
        System.out.println("Inorder traversal :");
        obj.inorder(root);

        System.out.println("Preorder traversal :");
        obj.preorder(root);

        System.out.println("Postorder traversal :");
        obj.postorder(root);


        int totalNodes = 1 + values.length;
        System.out.println("\nTotal Nodes in BST = " + totalNodes);

        obj.min(root);
        obj.max(root);
    }

}

