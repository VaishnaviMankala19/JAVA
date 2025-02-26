import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== CRUD MENU =====");
            System.out.println("1. Insert User");
            System.out.println("2. Display Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CrudOperations.insertUser();
                    break;
                case 2:
                    CrudOperations.fetchUsers();
                    break;
                case 3:
                    CrudOperations.updateUser();
                    break;
                case 4:
                    CrudOperations.deleteUser();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
