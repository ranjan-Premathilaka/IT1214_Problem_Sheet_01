import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);

        int exam1 = 0, exam2 = 0, exam3 = 0;  // Declare variables outside of try block

        try {
            // Get exam 1 mark and validate
            System.out.println("Enter mark 1: ");
            exam1 = sc1.nextInt();
            if (exam1 < 0 || exam1 > 100) {
                throw new IllegalArgumentException("Invalid mark! Exam marks must be between 0 and 100.");
            }

            // Get exam 2 mark and validate
            System.out.println("Enter mark 2: ");
            exam2 = sc1.nextInt();
            if (exam2 < 0 || exam2 > 100) {
                throw new IllegalArgumentException("Invalid mark! Exam marks must be between 0 and 100.");
				
            }

            // Get exam 3 mark and validate
            System.out.println("Enter mark 3: ");
            exam3 = sc1.nextInt();
            if (exam3 < 0 || exam3 > 100) {
                throw new IllegalArgumentException("Invalid mark! Exam marks must be between 0 and 100.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            
        }

        // Now that the marks are validated, we can create a Student object
        System.out.println("Enter student's name: ");
        sc1.nextLine();  // Consume the newline character left by nextInt()
        String name = sc1.nextLine();

        // Create a Student object using the valid exam marks and name
        Student s1 = new Student(name, exam1, exam2, exam3);

        // Display student's name and average score
        System.out.println("Student's name: " + s1.getName());
        System.out.println("Average score: " + s1.calculateAverage());
    }
}

