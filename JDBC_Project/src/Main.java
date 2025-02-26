import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== CRUD MENU =====");
            System.out.println("1. Create DB");
            System.out.println("2. Show DB");
            System.out.println("3. Use DB");
            System.out.println("4. Create Table");
            System.out.println("5. Insert Data");
            System.out.println("6. Display Data");
            System.out.println("7. Update Data");
            System.out.println("8. Delete Data");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            
            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    CrudOperations.createDB();
                    break;
                case 2:
                    CrudOperations.showDB();
                    break;
                case 3:
                    CrudOperations.useDB();
                    break;
                case 4:
                    CrudOperations.createTable();
                    break;
                case 5:
                    CrudOperations.insertData();
                    break;
                case 6:
                    CrudOperations.displayData();
                    break;
                case 7:
                    CrudOperations.updateData();
                    break;
                case 8:
                    CrudOperations.deleteData();
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
