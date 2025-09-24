import java.util.Scanner;
public class Q1{
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

	public static void main(String[] args)
	{
		int[] numbers={10,20,30,40,50,0};
		System.out.print("Numbers in array: ");
	for(int i=0;i<numbers.length-1;i++){
	System.out.print("\t"+numbers[i]);
	}
	System.out.println();

		        Q1 obj = new Q1();
                obj.insert(numbers);


}}
