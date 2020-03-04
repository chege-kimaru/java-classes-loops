import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        new StudentManagementSystem();
    }

    private Scanner scanner;
    private User currentUser;
    private Student[] students;

    private StudentManagementSystem() {
        scanner = new Scanner(System.in);
        currentUser = new User();
        students = new Student[5];

        signIn();
        addStudents();
        printOrExit();
    }

    private void signIn() {
        do {
            System.out.println("Enter your last name: ");
            String lastName = scanner.nextLine();
            currentUser.setLastName(lastName);
            if (lastName.length() == 0) {
                System.out.println("You did not provide your last name, press enter to re-enter:");
                scanner.nextLine();
            }
        } while (currentUser.getLastName().length() == 0);

        System.out.println("Enter your first name: (optional)");
        String firstName = scanner.nextLine();
        currentUser.setFirstName(firstName);
        System.out.println("Enter your position/title in the school: (optional)");
        String title = scanner.nextLine();
        currentUser.setTitle(title);

        System.out.println();

        System.out.println("You are signed in as " + currentUser.getLastName() + " . Your details are:");
        System.out.println("Last Name: " + currentUser.getLastName());
        System.out.println("First Name: " + currentUser.getFirstName());
        System.out.println("Title: " + currentUser.getTitle());
        System.out.println();
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }

    private void addStudents() {
        System.out.println("Enter details of 5 students: ");
        for (int i = 0; i < 5; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Enter registration number: ");
            String registrationNumber = scanner.nextLine();
            System.out.println("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Enter last name: ");
            String lastName = scanner.nextLine();
            System.out.println("Enter course: ");
            String course = scanner.nextLine();
            Student student = new Student(registrationNumber, firstName, lastName, course);

            students[i] = student;
            System.out.println();
        }
    }

    private void printOrExit() {
        System.out.println("Press any key to show student details or type exit to exit");
        String choice = scanner.nextLine();
        if (choice.equals("exit")) {
            System.exit(0);
        } else {
            printStudents();
        }
    }

    private void printStudents() {
        for (int i = 0; i < 5; i++) {
            System.out.println(students[0].toString(i));
        }
    }
}
