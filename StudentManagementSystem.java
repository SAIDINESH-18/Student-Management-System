
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String course;

    Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    void display() {
        System.out.println("ID: " + id
                + " | Name: " + name
                + " | Course: " + course);
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static Student findStudent(int id) {
        for (Student s : students) {
            if (s.id == id) {
                return s;
            }
        }
        return null;
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());

        if (findStudent(id) != null) {
            System.out.println("ID already exists.");
            return;
        }

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter course: ");
        String course = sc.nextLine();

        students.add(new Student(id, name, course));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = Integer.parseInt(sc.nextLine());

        Student s = findStudent(id);

        if (s != null) {
            s.display();
        } else {
            System.out.println("Student not found.");
        }
    }

    static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = Integer.parseInt(sc.nextLine());

        Student s = findStudent(id);

        if (s != null) {
            System.out.print("Enter new name: ");
            s.name = sc.nextLine();

            System.out.print("Enter new course: ");
            s.course = sc.nextLine();

            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        Student s = findStudent(id);

        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    viewStudents();
                    break;
                case "3":
                    searchStudent();
                    break;
                case "4":
                    updateStudent();
                    break;
                case "5":
                    deleteStudent();
                    break;
                case "6":
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
