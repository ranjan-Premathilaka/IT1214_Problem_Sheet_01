import java.util.Scanner;

class Student {
    private String name;
    private int exam1;
    private int exam2;
    private int exam3;

    // Constructor
    Student(String name, int exam1, int exam2, int exam3) {
        this.name = name;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.exam3 = exam3;
    }

    // Empty constructor (you need this in main)
    Student() {}

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExam1() {
        return exam1;
    }

    public void setExam1(int exam1) {
        this.exam1 = exam1;
    }

    public int getExam2() {
        return exam2;
    }

    public void setExam2(int exam2) {
        this.exam2 = exam2;
    }

    public int getExam3() {
        return exam3;
    }

    public void setExam3(int exam3) {
        this.exam3 = exam3;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your Name: ");
        name = sc.nextLine(); // Fix: was 'nextline()'

        System.out.println("Enter marks for exam1: ");
        exam1 = sc.nextInt();
        try {
            if (exam1 < 0 || exam1 > 100) {
                throw new IllegalArgumentException("Invalid input, exam marks must be between 0 to 100.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Enter marks for exam2: ");
        exam2 = sc.nextInt();
        try {
            if (exam2 < 0 || exam2 > 100) {
                throw new IllegalArgumentException("Invalid input, exam marks must be between 0 to 100.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Enter marks for exam3: ");
        exam3 = sc.nextInt();
        try {
            if (exam3 < 0 || exam3 > 100) {
                throw new IllegalArgumentException("Invalid input, exam marks must be between 0 to 100.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public double calculateAverage(int exam1, int exam2, int exam3) {
        return (exam1 + exam2 + exam3) / 3.0; // use 3.0 to get decimal average
    }

    void print(String name, double average) {
        System.out.println("\n--- Student Info ---");
        System.out.println("Name: " + name);
        System.out.println("Average Marks: " + average);
    }
}


public class Main {
    public static void main(String[] args) {
        Student s = new Student(); // call no-arg constructor
        s.input(); // get input

        double avg = s.calculateAverage(s.getExam1(), s.getExam2(), s.getExam3());
        s.print(s.getName(), avg); // print name and average
    }
}
