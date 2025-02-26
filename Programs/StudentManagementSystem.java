package Programs;
import java.util.*;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void displayDetails() {
        System.out.println("Student ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Marks: ");
            int marks = sc.nextInt();
            students[i] = new Student(id, name, marks);
        }

        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Display all students");
            System.out.println("2. Calculate average marks");
            System.out.println("3. Find student with maximum marks");
            System.out.println("4. Find student with minimum marks");
            System.out.println("5. Search student by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nStudent Details:");
                    for (Student student : students) {
                        student.displayDetails();
                    }
                    break;

                case 2:
                    double avg = calculateAverage(students);
                    System.out.println("Average Marks of All Students: " + avg);
                    break;

                case 3:
                    Student topStudent = findMaxScore(students);
                    System.out.println("Student with Maximum Marks:");
                    topStudent.displayDetails();
                    break;

                case 4:
                    Student lowStudent = findMinScore(students);
                    System.out.println("Student with Minimum Marks:");
                    lowStudent.displayDetails();
                    break;

                case 5:
                    System.out.print("Enter the ID of the student to search: ");
                    int searchId = sc.nextInt();
                    searchStudentById(students, searchId);
                    break;

                case 6:
                    System.out.println("Exiting the program. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        sc.close();
    }

    
    public static double calculateAverage(Student[] students) {
        int total = 0;
        for (Student student : students) {
            total += student.marks;
        }
        return (double) total / students.length;
    }

    public static Student findMaxScore(Student[] students) {
        Student maxStudent = students[0];
        for (Student student : students) {
            if (student.marks > maxStudent.marks) {
                maxStudent = student;
            }
        }
        return maxStudent;
    }

    public static Student findMinScore(Student[] students) {
        Student minStudent = students[0];
        for (Student student : students) {
            if (student.marks < minStudent.marks) {
                minStudent = student;
            }
        }
        return minStudent;
    }

    public static void searchStudentById(Student[] students, int id) {
        for (Student student : students) {
            if (student.id == id) {
                System.out.println("Student Found:");
                student.displayDetails();
                return;
            }
        }
        System.out.println("No student found with ID: " + id);

        
    }
}
