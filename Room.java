package p1;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private String customer;
    private double totalAmount = 0;
    private int roomprice = 1000;
    private int roomprice2 = 2000;
    private int roomprice3 = 4000;

    public void roomdetails() {
        System.out.println("Press Number from 1-3 to continue info of the room:");
        Scanner scanner = new Scanner(System.in);
        int choice1 = scanner.nextInt();
        switch (choice1) {
            case 1:
                System.out.println("Single");
                System.out.println("Price Rs " + roomprice);
                System.out.println("Ac No");
                break;
            case 2:
                System.out.println("Double");
                System.out.println("Price Rs " + roomprice2);
                System.out.println("Ac No");
                break;
            case 3:
                System.out.println("Luxury");
                System.out.println("Price- Rs " + roomprice3);
                System.out.println("Ac Yes");
                System.out.println("Free Breakfast");
                break;
            default:
                System.out.println("Invalid data");
        }
    }

    public void Availability(int roomno) {
        if (roomno < 4 || roomno == 2 || roomno == 3) {
            System.out.println("Available");
        } else if (roomno >= 4) {
            System.out.println("Room doesn't Exist!!");
        } else {
            System.out.println("Room not Available");
        }
    }

    public void roombook(int roomNumber, String customer) {
        this.roomNumber = roomNumber;
        this.customer = customer;
        System.out.println("The room no " + roomNumber + " booked by " + customer);
    }

    public void orderFood(int roomNumber) {
        System.out.println("\n==========\nMenu: ");
        String[] menuItems = {"Sandwich", "Pasta", "Noodles", "Coke"};
        double[] menuPrices = {50, 60, 70, 30};
        System.out.println("Item\tPrice");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(i + 1 + "\t" + menuItems[i] + "\tRs." + menuPrices[i]);
        }
        double totalAmount = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter item number (1-4): ");
            int itemNumber = scanner.nextInt();
            if (itemNumber < 1 || itemNumber > menuItems.length) {
                System.out.println("\nInvalid item number. Try again.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            if (quantity <= 0) {
                System.out.println("\nInvalid quantity. Try again.");
                continue;
            }

            totalAmount += menuPrices[itemNumber - 1] * quantity;

            System.out.print("Do you want to order anything else? (y/n): ");
            char wish = scanner.next().charAt(0);
            if (wish == 'n' || wish == 'N') {
                break;
            }
        }

        System.out.println("Your bill: Rs " + totalAmount);
    }

    public void totalbill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sir, which room?");
        int roomno = scanner.nextInt();
        double totalBil = 0;

        if (roomno == 1) {
            totalBil = roomprice + totalAmount;
        } else if (roomno == 2) {
            totalBil = roomprice2 + totalAmount;
        } else if (roomno == 3) {
            totalBil = roomprice3 + totalAmount;
        }

        System.out.println("Your Total bill: Rs " + totalBil);
        System.out.println("===Thanks for Visit.=== Visit Again===");
    }

    public static void main(String[] args) {
        System.out.println("\n===== Hotel Management System =====");
        System.out.println("\n===Welcome to the Hotel. How may I help you?===\n");
        System.out.println("1. Display Room Details");
        System.out.println("2. Display Room Availability");
        System.out.println("3. Book Room");
        System.out.println("4. Order Food");
        System.out.println("5. Bill\n");

        Room ob = new Room();
        String Naam;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nDisplay room Details");
                    ob.roomdetails();
                    break;
                case 2:
                    System.out.println("\nEnter room from 1-5");
                    int roomno = scanner.nextInt();
                    ob.Availability(roomno);
                    break;
                case 3:
                    System.out.println("\nEnter room No to book");
                    int no = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character left in the input buffer
                    System.out.print("Enter Name: ");
                    Naam = scanner.nextLine();
                    ob.roombook(no, Naam);
                    break;
                case 4:
                    System.out.println("\nEnter room Number");
                    int roomno1 = scanner.nextInt();
                    ob.orderFood(roomno1);
                    System.out.println("Thanks for Order.");
                    break;
                case 5:
                    ob.totalbill();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}