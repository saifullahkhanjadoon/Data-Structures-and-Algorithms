import java.util.*;

class node{
    int data;
    node next, first, cur,pre;

    node(){
        first=pre=null;
    }

    void entry(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Do you want to addnode(Y/n)");
        char choice='y';
        choice=sc.next().charAt(0);

        while(choice=='y'||choice=='Y'){
            node temp=new node();
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
    public void show(){
        int count=0;
        System.out.println("Elements in Linked List are: ");
        cur=first;
        while(cur!=null){
            System.out.println(cur.data+ " ");
            cur=cur.next;
            count++;
        }

        System.out.println("Total number of nodes are : "+count);
    }


    public void showOdd(){
        System.out.println("Odd numbers are : ");
        cur=first;
        while(cur!=null){
            if (cur.data%2!=0){
                System.out.println(cur.data+" ");
            }
            cur=cur.next;
        }
        System.out.println();


    }

    void iterate(int pos){

        cur=first;
        int index=1;
        System.out.println("Elements from position "+pos+": ");
        while(cur!=null){
            if(index>=pos){
                System.out.println(cur.data+" ");
            }
            cur=cur.next;
            index++;
        }
        System.out.println();
    }


    void showReverse(node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next != null) {
            showReverse(head.next);
        }

        System.out.print(head.data + " ");

    }


    public	void larOrSamll(){
        int max=first.data;
        int min=first.data;
        cur=first;
        while(cur!=null){
            if (cur.data>max){
                max=cur.data;}
            if(cur.data<min){
                min=cur.data;}

            cur=cur.next;
        }
        System.out.println("Largest Number: "+max+" \nSmallest Number: "+min);
    }


    ArrayList<Integer> toArrayList(){
        ArrayList<Integer> arr=new  ArrayList<>();
        cur=first;
        while(cur!=null){
            arr.add(cur.data);
            cur=cur.next;}
        return arr;
    }

    void swap(int x,int y){
        if (x==y)
            return;
        int temp=0;
        node nodex=null;
        node nodey=null;
        cur=first;

        while(cur!=null){
            if(cur.data==x)
                nodex=cur;
            if(cur.data==y)
                nodey=cur;

            cur=cur.next;}
        if(nodex!=null && nodey!=null)

            temp=nodex.data;
        nodex.data=nodey.data;
        nodey.data=temp;

        System.out.println("Swapped numbers are  :"+ x +" and " +y);
    }
}

public class Linkedlist1{
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        node obj=new node();

        int choice;

        do{
            System.out.println();
            System.out.println("       \n\t\tMenu      ");
            System.out.println("------------------------------------------------");
            System.out.println("[1]. Data Entry. ");
            System.out.println("[2]. Data Display. ");
            System.out.println("[3]. Display odd elemenets. ");
            System.out.println("[4]. Iterate from Position. ");
            System.out.println("[5]. Iterate in Reverse order. ");
            System.out.println("[6]. Largest and Smallest Element in List. ");
            System.out.println("[7]. Swap two elements");
            System.out.println("[8]. Convert LinkedList to ArrrayList. ");
            System.out.println("[9]. Exit ");
            System.out.println("------------------------------------------------");



            System.out.println("Enter your choice (1-9)");

            choice=sc.nextInt();
            switch(choice){
                case 1:{
                    obj.entry();
                    break;}
                case 2:{
                    obj.show();
                    break;}
                case 3:{
                    obj.showOdd();
                    break;}
                case 4:{
                    System.out.println("Enter Position: ");
                    int position=sc.nextInt();
                    obj.iterate(position);
                    break;}
                case 5:{
                    obj.showReverse(obj.first);
                    break;}
                case 6:{
                    obj.larOrSamll();
                    break;}
                case 7:{
                    System.out.println("Enter first value");
                    int x=sc.nextInt();
                    System.out.println("Enter second value");
                    int y=sc.nextInt();
                    obj.swap(x,y);
                    break;}
                case 8:{
                    ArrayList<Integer> arr=obj.toArrayList();
                    System.out.println("ArrayList: "+arr);
                    break;}
                case 9:
                    System.out.println("Exiting program....");
                    break;
                default:{
                    System.out.println("Invalid choice");
                    break;}
            }
        }while(choice!=9);
    }
}







