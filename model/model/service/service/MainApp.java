import java.util.*;
import model.Student;
import service.StudentManager;

public class MainApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int r = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    manager.addStudent(new Student(r, name, email, course, marks));
                    break;

                case 2:
                    System.out.print("Enter Roll No to Delete: ");
                    manager.deleteStudent(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Roll No to Update: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Course: ");
                    manager.updateStudent(roll, sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter Roll No to Search: ");
                    Student s = manager.searchStudent(sc.nextInt());
                    if (s != null) s.displayInfo();
                    else System.out.println("Student Not Found!");
                    break;

                case 5:
                    manager.viewAllStudents();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
