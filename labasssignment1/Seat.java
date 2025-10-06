package labtask;

import java.util.Scanner;

public class Seat {
    int[][] seats = new int[5][5];
    int row, column;
    int ticketType;
    Scanner in = new Scanner(System.in);
    void reserveTicket() {
        System.out.print("Select Seat (1 TO 5)");
        column = in.nextInt();
        column = column - 1;
        if (column >= 0 && column <= 4) {
            if (seats[row][column] == 1) {
                System.out.println("Seat Already reserved");
            } else {
                seats[row][column] = 1;
                System.out.println("Thanks for choosing us\nYour Seat is Reserved");
                show();
            }
        } else {
            System.out.println("Invalid Choice");
        }
    }
    void bookSeat() {
        System.out.println("1. First Class\n2. Economy");
        System.out.print("Select Ticket Type: ");
        int choice = in.nextInt();
        switch (choice) {
            case 1: {
                ticketType = 1;
                break;
            }
            case 2: {
                ticketType = 2;
                break;
            }
            default:
                System.out.println("Invalid Choice!!!");
                return;

        }
        if (ticketType == 1) {
            System.out.println("Welcome to Our First Class: ");
            System.out.println("First Class has two Rows Row 1 and Row 2");
            System.out.print("Enter Row: ");
            row = in.nextInt();
            row = row - 1;
            if (row >= 0 && row <= 1) {
                reserveTicket();
            } else {
                System.out.println("Invalid Choice");
            }
        } else {
            System.out.println("Welcome to Our Economy Class");
            System.out.println("E1conomy  Class has three Rows Row 3, Row 4 and Row 5");
            System.out.print("Enter Row: ");
            row = in.nextInt();
            row = row - 1;
            if (row >= 2 && row <= 4) {
                reserveTicket();
            } else {
                System.out.println("Invalid Choice");
            }
        }    }
    void show() {
        System.out.println("\tA\tB\tC\tD\tE");
        for(int i = 0; i < 5; i++) {
            System.out.println("Row" + (i+1));
            for(int j =0; j < 5; j++) {
                System.out.print("\t" + seats[i][j]);
            }
            System.out.println(" ");
        }
    }
    void menu() {
        int choice;
        boolean isCont = true;
        do {
            System.out.println("Welcome to our Air Lines");
            System.out.println("1. Book Seat\n2. See Bookings\n3. Exit");
            System.out.print("Select from Option Above: ");
            choice = in.nextInt();
            switch (choice) {
                case 1: {
                    bookSeat();
                    break;
                }
                case 2: {
                    show();
                    break;
                }
                case 3: {
                    isCont = false;
                    break;                }
                default:
                    System.out.print("Invalid Choice");}
        } while(isCont);
    }
    public static void main(String[] argc) {
        Seat ob = new Seat();
        ob.menu();
    }
}
