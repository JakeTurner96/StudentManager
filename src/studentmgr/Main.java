package studentmgr;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentManagerService studentManager = (StudentManagerService) StudentManagerService.getInstance();
    private static Service moduleManager = ModuleManagerService.getInstance();
    private static boolean exit = false;
    private static Thread recordThread = new Thread(studentManager);

    public static void main(String[] args) {

        recordThread.start();
        System.out.println("\nPlease select a number from the menu:");

        while (!exit) {
            System.out.println("\n1. Add new student\n2. Edit existing student\n3. Search student\n4. Delete student\n5. Exit");
            int menuDecision = scanner.nextInt();
            scanner.nextLine();
            switch (menuDecision) {
                //Add new student case
                case 1:
                    System.out.println("Please enter the students full name");
                    String newName = scanner.nextLine();

                    System.out.println("Please enter the students course title");
                    String newCourse = scanner.nextLine();

                    System.out.println("Please enter the students date of birth dd/mm/yyyy");
                    String dateOfBirth = scanner.nextLine();

                    Student student = new Student(studentManager.generateID(), newCourse, newName, dateOfBirth);
                    studentManager.addRecord(student.getID(), student);

                    break;
                //Edit existing student case
//                case 2:
//                    System.out.println("Please enter the ID of the student you want to edit");
//                    int editID = scanner.nextInt();
//                    scanner.nextLine();
//                    if (studentManager.studentExists(editID)) {
//                        System.out.println("\nPlease select a number from the menu:\n\n1. Edit age\n2. Edit course\n3. Exit");
//                        int editMenuDecision = scanner.nextInt();
//                        scanner.nextLine();
//                        switch (editMenuDecision) {
//                            //Edit age sub case
//                            case 1:
//                                System.out.println("Please enter the new age");
//                                int updatedAge = scanner.nextInt();
//                                scanner.nextLine();
//                                studentManager.getStudent(editName).updateAge(updatedAge);
//                                System.out.println("Student age updated");
//                                break;
//                            //Edit course sub case
//                            case 2:
//                                System.out.println("Please enter the new course");
//                                String updatedCourse = scanner.nextLine();
//                                studentManager.getStudent(editName).updateCourse(updatedCourse);
//                                System.out.println("Student course updated");
//                                break;
//                            //Exit sub case
//                            case 3:
//                                break;
//                            default:
//                                System.out.println("Invalid input");
//                        }
//                        break;
//                    } else {
//                        System.out.println("A student with the name '" + editName + "' does not exist");
//                    }
//                    break;
                case 3:
                    System.out.println("Please enter the ID of the student you want to search for");
                    int searchID = scanner.nextInt();
                    scanner.nextLine();
//                    if (studentManager.studentExists(searchID)) {
                        Student searchStudent = (Student) studentManager.getRecord(searchID);
                        System.out.println("Name: " + searchStudent.getStudentName() + "\nAge: " + searchStudent.getDateOfBirth() + "\nCourse: " + searchStudent.getTitle());
//                    } else {
//                        System.out.println("A student with the ID '" + searchID + "' does not exist");
//                    }
                    break;
                //Delete existing student record case
                case 4:
                    System.out.println("Please enter the ID of the student you want to delete");
                    int deleteStudentID = scanner.nextInt();
                    scanner.nextLine();

                    if (studentManager.studentExists(deleteStudentID)) {
                        studentManager.removeRecord(deleteStudentID);
                        System.out.println("Student record was successfully deleted");
                    } else {
                        System.out.println("A student with the name '" + deleteStudentID + "' does not exist");
                    }
                    break;
                //Exit case
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}

