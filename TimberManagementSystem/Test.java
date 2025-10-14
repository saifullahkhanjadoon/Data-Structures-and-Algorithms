package TimberManagementSystem;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

class node implements Serializable
{
    String zone;
    int timberID;
    String kind;
    double weight;
    String status;
    double height;
    int quantity;
    int price;
    Date cutDate;
    node next;

    public node(String zone, int timberID, String kind, double weight, String status,
                  double height, int quantity, int price, Date cutDate)
    {
        this.zone = zone;
        this.timberID = timberID;
        this.kind = kind;
        this.weight = weight;
        this.status = status;
        this.height = height;
        this.quantity = quantity;
        this.price = price;
        this.cutDate = cutDate;
        this.next = null;
    }
    public void displayNode()
    {
        System.out.println("║ ══════════════════════════════════════════════════════════════════════ ║ ");
        System.out.println("║ Zone: " + zone + "            | Timber ID: " + timberID+"                ");
        System.out.println("║ Kind: " + kind + "            | Weight: " + weight + " kg               ");
        System.out.println("║ Status: " + status + "        | Height: " + height + " meters           ");
        System.out.println("║ Quantity: " + quantity + "    | Price: Rs " + price+"                   ");
        System.out.println("║ Cut Date: " + cutDate+"                                                 ");
        System.out.println("║ ══════════════════════════════════════════════════════════════════════ ║ ");

    }
}


class LinkedList implements Serializable
{
    node first;


    public void addTimber(node x)
    {

        if(findByID(x.timberID)!=null)
        {
            System.out.println("Timber with ID " + x.timberID + " already exists!\n  Please use a different Timber ID");
            return;
        }


        if(first==null)
        {
            first=x;
            System.out.println(" First timber record added successfully!");
            System.out.println(" Timber ID: " + x.timberID + ", Kind: " + x.kind);
        }
        else {

            node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = x;
            System.out.println("New timber record added successfully!");
        }
    }


    public node findByID(int id) {
        node temp = first;

        while (temp != null) {

            if (temp.timberID == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    public void displayByZone(String zone) {
        node temp = first;
        boolean found = false;
        int count = 0;

        System.out.println("\n Searching For Timber in Zone: " + zone);
        System.out.println("==================================================================");


        while (temp != null) {

            if (temp.zone.equalsIgnoreCase(zone)) {
                temp.displayNode();
                found = true;
                count++;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println(" No timber records found for Zone: " + zone);
            System.out.println("   Available zones: A, B, C, D");
        } else {
            System.out.println(" Total records found in Zone " + zone + ": " + count);
        }
    }


    public void displayByKind(String kind) {
        node temp = first;
        boolean found = false;
        int count = 0;

        System.out.println("\n SEARCHING FOR TIMBER OF KIND: " + kind);
        System.out.println("==================================================================");

        while (temp != null) {
            if (temp.kind.equalsIgnoreCase(kind)) {
                temp.displayNode();
                found = true;
                count++;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println(" No timber found with Kind: " + kind);

        } else {
            System.out.println(" Total " + kind + " timber records: " + count);
        }
    }


    public void analysis() {
        node temp = first;
        boolean found = false;
        int count = 0;

        System.out.println("Timbers with quantity less than 100:");
        System.out.println("==================================================================");

        while (temp != null) {
            if (temp.quantity < 100) {
                System.out.println(" LOW STOCK ALERT:");
                temp.displayNode();
                found = true;
                count++;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("All timbers have  quantity (100 or more).");

        } else {
            System.out.println("Total low stock items: " + count);
        }
    }


    public void salesUpdate(int id, int soldQty) {
        node temp = findByID(id);

        if (temp == null) {
            System.out.println(" Timber with ID " + id + " not found in our records!");
            return;
        }


        if (soldQty > temp.quantity) {
            System.out.println(" Not enough quantity in stock!");
            System.out.println("   Available: " + temp.quantity + ", Requested: " + soldQty);
            return;
        }


        temp.quantity -= soldQty;
        if (temp.quantity == 0) {
            temp.status = "Sold";
        }

        System.out.println(" Sales Update Sucessful!");
        System.out.println("   Sold: " + soldQty + " units of Timber ID: " + id);
        System.out.println("   Remaining quantity: " + temp.quantity);
        System.out.println("   New Status: " + temp.status);
    }


    public void deleteRecord(int id) {
        if (first == null) {
            System.out.println("The timber list is empty!\nThere are no records to delete.");
            return;
        }


        if (first.timberID == id) {
            System.out.println("Deleted: Timber ID " + id + " - " + first.kind);
            first = first.next;
            return;
        }

        node temp = first;

        while (temp.next != null && temp.next.timberID != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println(" Timber with ID " + id + " not found!");
        } else {
            System.out.println(" DELETED: Timber ID " + id + " - " + temp.next.kind);
            temp.next = temp.next.next;  
        }
    }


    public void updateRecord(int id) {
        Scanner sc = new Scanner(System.in);
        node temp = findByID(id);

        if (temp == null) {
            System.out.println("Timber with ID " + id + " not found!");
            return;
        }

        System.out.println("\n Updating Timber Record:");
        temp.displayNode();
        System.out.println("\nPlease enter the new details (press Enter to keep current value):");

        System.out.print("Current Zone [" + temp.zone + "]: ");
        String newZone = sc.nextLine();
        if (!newZone.isEmpty())
            temp.zone = newZone;

        System.out.print("Current Kind [" + temp.kind + "]: ");
        String newKind = sc.nextLine();
        if (!newKind.isEmpty())
            temp.kind = newKind;

        System.out.print("Current Weight [" + temp.weight + "]: ");
        String newWeightStr = sc.nextLine();
        if (!newWeightStr.isEmpty())
            temp.weight = Double.parseDouble(newWeightStr);

        System.out.print("Current Status [" + temp.status + "]: ");
        String newStatus = sc.nextLine();
        if (!newStatus.isEmpty())
            temp.status = newStatus;

        System.out.print("Current Height [" + temp.height + "]: ");
        String heightStr = sc.nextLine();
        if (!heightStr.isEmpty())
            temp.height = Double.parseDouble(heightStr);

        System.out.print("Current Quantity [" + temp.quantity + "]: ");
        String newQty = sc.nextLine();
        if (!newQty.isEmpty())
            temp.quantity = Integer.parseInt(newQty);

        System.out.print("Current Price [" + temp.price + "]: ");
        String newPrice = sc.nextLine();
        if (!newPrice.isEmpty())
            temp.price = Integer.parseInt(newPrice);

        System.out.print("Current Cut Date [" + temp.cutDate + "]: ");
        String newDate = sc.nextLine();
        if (!newDate.isEmpty()) {
            temp.cutDate = new Date();
        }

        System.out.println(" Update Sucessful: Timber ID " + id + " has been updated!");
    }


    public void generateReport() {
        node temp = first;
        int totalRec = 0;
        int totalQty = 0;
        double totalVal = 0;
        double totalWeight = 0;
        double totalHeight = 0;

        System.out.println("\n Complete Inventory Report");
        System.out.println("==================================================================");
        System.out.println("DETAILED LISTING OF ALL TIMBER RECORDS:");
        System.out.println("==================================================================");

        if (first == null) {
            System.out.println("No timber records available.");
            return;
        }


        while (temp != null) {
            temp.displayNode();
            totalRec++;
            totalQty += temp.quantity;
            totalVal += (temp.quantity * temp.price);
            totalWeight += temp.weight;
            totalHeight += temp.height;
            temp = temp.next;
        }


        System.out.println("\n INVENTORY SUMMARY :");
        System.out.println("===============================================================");
        System.out.println("Total Number of Timber Records: " + totalRec);
        System.out.println("Total Quantity of All Timber: " + totalQty + " units");
        System.out.println("Total Inventory Value: Rs " + totalVal);

        if (totalRec > 0) {
            System.out.println("Average Price per Unit: Rs " + (totalVal / totalQty));
            System.out.println("Average Weight: " + (totalWeight / totalRec) + " kg");
            System.out.println("Average Height: " + (totalHeight / totalRec) + " meters");
        }

        System.out.println("===================================================================");
        System.out.println("Report generated successfully! ");
    }
}


class FileHandler {
    private static final String FILE_NAME = "timberData.txt";

    public static void saveData(LinkedList list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
            System.out.println(" Data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public static LinkedList loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (LinkedList) ois.readObject();
        } catch (Exception e) {
            System.out.println("No previous data found. Starting new file.");
            return new LinkedList();
        }
    }
}



public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = FileHandler.loadData();
        int choice;

        System.out.println("|--------------------------------------------------------------|");
        System.out.println("|      WELCOME TO SAIFULLAH KHAN JADOON TIMBER STORE           |");
        System.out.println("|              INVENTORY MANAGEMENT SYSTEM                     |");
        System.out.println("|--------------------------------------------------------------|");

        do {

            System.out.println("====================================================================");
            System.out.println("║                        MAIN MENU                                 ║");
            System.out.println("====================================================================");
            System.out.println("║ [1]   Add New Timber Record                                      ║");
            System.out.println("║ [2]   Display Timber by Zone                                     ║");
            System.out.println("║ [3]   Display Timber by Kind                                     ║");
            System.out.println("║ [4]   Analysis (Low Stock Items)                                 ║");
            System.out.println("║ [5]   Sales Update                                               ║");
            System.out.println("║ [6]  ️  Delete Timber Record                                       ║");
            System.out.println("║ [7]  ️  Update Timber Record                                       ║");
            System.out.println("║ [8]   Generate Inventory Report                                  ║");
            System.out.println("║ [9]   Backup & Restore Data                                      ║");
            System.out.println("║ [10]  Exit Program                                               ║");
            System.out.println("====================================================================");
            System.out.print("\nPlease enter your choice (1-10): ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:

                    System.out.println("\n➕ ADDING NEW TIMBER RECORD");
                    System.out.println("Please enter the following details:");

                    System.out.print("Timber ID (Unique Number): ");
                    int id = sc.nextInt();


                    if (list.findByID(id) != null) {
                        System.out.println(" Timber with ID " + id + " already exists! Please use a unique ID.");
                        break;
                    }

                    System.out.print("Zone (A/B/C/D): ");
                    String zone = sc.next();
                    System.out.print("Kind (e.g., Pine, Teak): ");
                    String kind = sc.next();
                    System.out.print("Weight (in kg): ");
                    double weight = sc.nextDouble();
                    System.out.print("Status (In Stock/Sold/Reserved): ");
                    String status = sc.next();
                    System.out.print("Height (in meters): ");
                    double height = sc.nextDouble();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Price (in Rs): ");
                    int price = sc.nextInt();


                    Date cutDate = new Date();
                    System.out.println("Cut Date set to current date: " + cutDate);

                    node t = new node(zone, id, kind, weight, status, height, qty, price, cutDate);
                    list.addTimber(t);
                    FileHandler.saveData(list);
                    break;

                case 2:

                    System.out.print("Enter Zone to search (A/B/C/D): ");
                    String searchZone = sc.next();
                    list.displayByZone(searchZone);
                    break;

                case 3:

                    System.out.print("Enter Timber Kind to search: ");
                    String searchKind = sc.next();
                    list.displayByKind(searchKind);
                    break;

                case 4:

                    list.analysis();
                    break;

                case 5:

                    System.out.print("Enter Timber ID to sell: ");
                    int sellId = sc.nextInt();
                    System.out.print("Enter quantity to sell: ");
                    int sellQty = sc.nextInt();
                    list.salesUpdate(sellId, sellQty);
                    FileHandler.saveData(list);
                    break;

                case 6:

                    System.out.print("Enter Timber ID to delete: ");
                    int deleteId = sc.nextInt();
                    list.deleteRecord(deleteId);
                    FileHandler.saveData(list);
                    break;

                case 7:

                    System.out.print("Enter Timber ID to update: ");
                    int updateId = sc.nextInt();
                    list.updateRecord(updateId);
                    FileHandler.saveData(list);
                    break;

                case 8:

                    list.generateReport();
                    break;

                case 9:

                    System.out.println("\n BACKUP & RESTORE MENU");
                    System.out.println("Currently using automatic save/load system.");
                    System.out.println("Data is automatically saved after every operation.");
                    list = FileHandler.loadData();
                    System.out.println(" Data restoration completed!");
                    break;

                case 10:

                    FileHandler.saveData(list);
                    System.out.println("\n|================================================|");
                    System.out.println("|   THANK YOU FOR USING TIMBER MANAGEMENT SYSTEM   |");
                    System.out.println("|              Data saved successfully!            |");
                    System.out.println("|               See you next time!               |");
                    System.out.println("|==================================================|");
                    break;

                default:
                    System.out.println(" INVALID CHOICE: Please enter a number between 1 and 10!");
                    System.out.println("   Try again with a valid option.");
            }


            if (choice != 10) {
                System.out.println("\nPress Enter to continue...");
                sc.nextLine();
                sc.nextLine();
            }

        } while (choice != 10);

        sc.close();
    }
}
