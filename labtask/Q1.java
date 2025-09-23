import java.util.Scanner;
public class Q1 {
    public void delete(int[] arr){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter element you want to delete:   ");
        int element=sc.nextInt();


            for(int i=0;i<arr.length-1 ;i++){
                if(arr[i]==element){
                    for(int j=i;j<arr.length-1;j++){
                        arr[j]=arr[j+1];
                    }
                    arr[arr.length-1]=0;
                    break;
                }
            }

            System.out.println("The Deletion");

                for(int j=0;j<arr.length-1;j++)
                    if(arr[j]!=0)
                        System.out.print(arr[j]+" ");
            }

    public void insert(int[] arr){
        Scanner sc=new Scanner(System.in);

        System.out.print("\nEnter location:   ");
        int location=sc.nextInt();
        location-=1;
        System.out.print("The element to be inserted is: ");
        int ele=sc.nextInt();

        for(int i=arr.length-1;i>location;i--){
            arr[i]=arr[i-1];
        }
        arr[location]=ele;
        System.out.print("Output: ");
        for(int j:arr)
            System.out.print(j+" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10, 20, 30, 40, 50, 0};
        System.out.print("Numbers in Array: ");
        for (int i : arr) {
            if (i != 0)
                System.out.print(i + "\t");
        }
        Q1 obj = new Q1();
        System.out.println("\n[1]. Insert at particular location");
        System.out.println("[2]. Delete the specific element");
        System.out.println();
        System.out.println("Enter what you want to do: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                obj.insert(arr);
                break;
            case 2:

                System.out.println();
                obj.delete(arr);
                break;
        }
    }}
