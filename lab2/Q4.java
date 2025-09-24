import java.util.Scanner;
public class Q4{

	double inch,gallon,miles,pounds;
	public void centoinc(double c){
	 inch=c/2.54;
	System.out.println(c+" centimeter =  "+inch+" inches");
	}
	public void litogal(double l){
		 gallon=l/3.785;
		System.out.println(l+" Liters =  "+gallon+" galoons");
	}

	public void kmtomil(double m){
		 miles=m/1.609;
		System.out.println(m+" Kilometer =  "+miles+" miles");
	}
	public void kgtopd(double kg){
		 pounds=kg/.4536;
		System.out.println(kg+" kilogram =  "+pounds+" pound");
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);

		Q4 obj=new Q4();

		String choice="y";
		do{
		System.out.println("Main Menu");
		System.out.println("[1]. Convert Centimeter into Inches");
		System.out.println("[2]. Liters into Gallons ");
		System.out.println("[3]. Kilometers into Miles");
		System.out.println("[4]. Kilograms into Pounds");
		System.out.println("[5]. Exit");
		System.out.println("Enter what you want to do");
		int option=sc.nextInt();
		switch(option){
		case 1:
		{
		System.out.println("Enter value: ");
		double centi=sc.nextDouble();
		sc.nextLine();
		 obj.centoinc(centi);
		break;
		}
		case 2:
				{
				System.out.println("Enter value: ");
				double liter=sc.nextDouble();
				sc.nextLine();
				 obj.litogal(liter);
		break;
		}
		case 3:
				{
				System.out.println("Enter value: ");
				double km=sc.nextDouble();
								sc.nextLine();

				 obj.kmtomil(km);
		break;
		}
		case 4:
				{
				System.out.println("Enter value: ");
				double kg=sc.nextDouble();
								sc.nextLine();

				 obj.kgtopd(kg);
		break;
		}
		case 5:
				{System.exit(0);
		break;
		}
		default:
		{

			System.out.println("invalid choice");
			break;
			}
			}
			System.out.println("Enter Y if you want to continue ");

				 choice=sc.nextLine();

		}
		while(choice.equals("y"));
	}
		}
