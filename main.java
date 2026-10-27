
import java.util.Scanner;

class Student {
    int id;
    String name;
    String department;
    int roomNumber;

    Student(int id, String name, String department, int roomNumber) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.roomNumber = roomNumber;
    }

    void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("--------------------------");
    }
}

class Hostel {
    Student[] students;
    int totalRooms;

    Hostel(int totalRooms) {
        this.totalRooms = totalRooms;
        students = new Student[totalRooms];
    }

    void allocateRoom(int id, String name, String department) {
        for (int i = 0; i < totalRooms; i++) {
            if (students[i] != null && students[i].id == id) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        for (int i = 0; i < totalRooms; i++) {
            if (students[i] == null) {
                students[i] = new Student(id, name, department, i + 1);
                System.out.println("Room allocated successfully!");
                System.out.println("Allocated Room Number: " + (i + 1));
                return;
            }
        }

        System.out.println("Hostel is full! No rooms available.");
    }

    void vacateRoom(int id) {
        for (int i = 0; i < totalRooms; i++) {
            if (students[i] != null && students[i].id == id) {
                students[i] = null;
                System.out.println("Room vacated successfully!");
                return;
            }
        }

        System.out.println("Student ID not found!");
    }

    void viewStudents() {
        boolean found = false;

        for (int i = 0; i < totalRooms; i++) {
            if (students[i] != null) {
                students[i].display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students are staying in the hostel.");
        }
    }

    void viewAvailableRooms() {
        int available = 0;

        for (int i = 0; i < totalRooms; i++) {
            if (students[i] == null) {
                available++;
            }
        }

        System.out.println("Total Rooms: " + totalRooms);
        System.out.println("Occupied Rooms: " + (totalRooms - available));
        System.out.println("Available Rooms: " + available);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Hostel hostel = new Hostel(5);
        int choice;

        do {
            System.out.println("\n===== HOSTEL MANAGEMENT SYSTEM =====");
            System.out.println("1. Allocate Room");
            System.out.println("2. Vacate Room");
            System.out.println("3. View Students");
            System.out.println("4. View Available Rooms");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    hostel.allocateRoom(id, name, department);
                    break;

                case 2:
                    System.out.print("Enter Student ID to vacate room: ");
                    int sid = sc.nextInt();
                    hostel.vacateRoom(sid);
                    break;

                case 3:
                    hostel.viewStudents();
                    break;

                case 4:
                    hostel.viewAvailableRooms();
                    break;

                case 5:
                    System.out.println("Thank you for using Hostel Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
