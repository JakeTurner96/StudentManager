import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentRecord studentRecord = StudentRecord.getInstance();
    private static boolean exit = false;
    private static int menuDecision;

    public static void main(String[] args) {

        System.out.println("\nPlease select a number from the menu:");

        while (!exit) {
            System.out.println("\n1. Add new student\n2. Edit existing student\n3. Search student\n4. Delete student\n5. Exit");
            try {
                menuDecision = scanner.nextInt();
                scanner.nextLine();
                switch (menuDecision) {
                    case 1:
                        System.out.println("Please enter the students full name");
                        String newName = scanner.nextLine();

                        System.out.println("Please enter the students age");
                        int newAge = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Please enter the students course");
                        String newCourse = scanner.nextLine();

                        if (!studentRecord.studentExists(newName)) {
                            Student student = new Student(newName, newAge, newCourse);
                            studentRecord.addStudent(newName, student);
                            System.out.println("New student record successfully added");
                        } else {
                            System.out.println("A student record with the name " + newName + " already exists, no record was created");
                        }
                        break;

                    case 2:
                        System.out.println("Please enter the full name of the student you want to edit");
                        String editName = scanner.nextLine();

                        if (studentRecord.studentExists(editName)) {
                            System.out.println("\nPlease select a number from the menu:\n\n1. Edit name\n2. Edit age\n3. Edit course\n4. Exit");
                            int editMenuDecision = scanner.nextInt();
                            scanner.nextLine();
                            switch (editMenuDecision) {
                                case 1:
//                                System.out.println("Please enter the new name");
//                                String updatedName = scanner.nextLine();
                                    break;

                                case 2:
                                    System.out.println("Please enter the new age");
                                    int updatedAge = scanner.nextInt();
                                    scanner.nextLine();
                                    studentRecord.getStudent(editName).updateAge(updatedAge);
                                    System.out.println("Student age updated");
                                    break;

                                case 3:
                                    System.out.println("Please enter the new course");
                                    String updatedCourse = scanner.nextLine();
                                    studentRecord.getStudent(editName).updateCourse(updatedCourse);
                                    System.out.println("Student course updated");
                                    break;

                                case 4:
                                    break;

                                default:
                                    System.out.println("Invalid input");
                            }
                            break;
                        } else {
                            System.out.println("A student with the name '" + editName + "' does not exist");
                        }
                        break;

                    case 3:
                        System.out.println("Please enter the full name of the student you want to search for");
                        String searchName = scanner.nextLine();

                        if (studentRecord.studentExists(searchName)) {
                            Student searchStudent = studentRecord.getStudent(searchName);
                            System.out.println("Name: " + searchStudent.getName() + "\nAge: " + searchStudent.getAge() + "\nCourse: " + searchStudent.getCourse());
                        } else {
                            System.out.println("A student with the name '" + searchName + "' does not exist");
                        }
                        break;

                    case 4:
                        System.out.println("Please enter the name of the student you want to delete");
                        String deleteStudentName = scanner.nextLine();

                        if (studentRecord.studentExists(deleteStudentName)) {
                            studentRecord.deleteStudent(deleteStudentName);
                            System.out.println("Student record was successfully deleted");
                        } else {
                            System.out.println("A student with the name '" + deleteStudentName + "' does not exist");
                        }
                        break;

                    case 5:
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                break;
            }
        }
    }
}
