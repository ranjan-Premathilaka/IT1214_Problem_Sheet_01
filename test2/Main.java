import java.util.Scanner;

class Student {
    private int studentId;
    private String name;
    private int daysAttended;

    // Constructor
    Student(int studentId, String name, int daysAttended) {
        this.studentId = studentId;
        this.name = name;
        this.daysAttended = daysAttended;
    }

    // Getters and setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysAttended() {
        return daysAttended;
    }

    public void setDaysAttended(int daysAttended) {
        this.daysAttended = daysAttended;
    }
}

// Classroom class
class Classroom {
    private Student[] students = new Student[10];
    private int count = 0; // number of students added
    private static Scanner sc = new Scanner(System.in);

    // Add a new student
    public void add() {
        if (count >= 10) {
            System.out.println("Cannot add, classroom is full.");
            return;
        }

        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of days attended: ");
        int days = sc.nextInt();

        students[count] = new Student(id, name, days);
        count++;

        System.out.println("Student added successfully!");
    }

    // Update attendance
    public void attend() {
        System.out.print("Enter student ID to update attendance: ");
        int id = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() == id) {
                System.out.print("Enter new number of attended days: ");
                int days = sc.nextInt();
                students[i].setDaysAttended(days);
                System.out.println("Attendance updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student ID not found.");
        }
    }

    // Display students
    public void display() {
        System.out.println("\n--- Student Info ---");
        for (int i = 0; i < count; i++) {
            Student s = students[i];
            System.out.println("Student ID: " + s.getStudentId() +
                               ", Name: " + s.getName() +
                               ", Days Attended: " + s.getDaysAttended());
        }
        System.out.println("--------------------\n");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1: Add new student");
            System.out.println("2: Change attendance");
            System.out.println("3: Display students");
            System.out.println("4: Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        classroom.add();
                        break;
                    case 2:
                        classroom.attend();
                        break;
                    case 3:
                        classroom.display();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        throw new IllegalArgumentException("Invalid input! Please enter 1, 2, 3, or 4.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
