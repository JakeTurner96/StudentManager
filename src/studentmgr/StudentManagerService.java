package studentmgr;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class StudentManagerService{

    private HashMap<Integer, Student> studentHashMap;
    private static final StudentManagerService studentRecordInstance = new StudentManagerService();

    private StudentManagerService() {
        studentHashMap = new HashMap<>();
    }

    public static StudentManagerService getInstance() {
        return studentRecordInstance;
    }

    public void addStudent(int ID, Student student) {
        try{
            studentHashMap.put(ID, student);
        }catch (RuntimeException e){
            System.out.println("Unable to add student");
        }
    }

    public void removeStudent(int ID) {
        studentHashMap.remove(ID);
    }

    public void updateStudent(Student student, String newCourse, String newName, String newDateOfBirth) {
        student.setCourseTitle(newCourse);
        student.setStudentName(newName);
        student.setDateOfBirth(newDateOfBirth);
    }

    public void exportStudents(){

        try{
            PrintWriter printWriter = new PrintWriter(new File("test.csv"));
            StringBuilder sb = new StringBuilder();

            sb.append("ID");
            sb.append(", ");
            sb.append("Course");
            sb.append(", ");
            sb.append("Name");
            sb.append(", ");
            sb.append("DoB");
            sb.append(", ");
            sb.append("Modules");
            sb.append("\n");

            for(int ID : studentHashMap.keySet()){
                Student student = getStudent(ID);

                sb.append(student.getStudentID());
                sb.append(", ");
                sb.append(student.getCourseTitle());
                sb.append(", ");
                sb.append(student.getStudentName());
                sb.append(", ");
                sb.append(student.getDateOfBirth());
                sb.append(", ");
                sb.append(student.getModuleSize());
                sb.append("\n");
            }

            printWriter.write(sb.toString());
            printWriter.close();
        }catch (IOException e){
            System.out.println("Unable to export to .CSV");
        }
    }

    public void assignModule(Student student, Module module){
        student.addModule(module);
    }

    public void removeModuleAssignment(Student student, Module module){
        student.removeModule(module);
    }

    public Student getStudent(int ID) {
        return studentHashMap.get(ID);
    }

    public boolean studentExists(int ID) {
        return studentHashMap.containsKey(ID);
    }

    public int generateID() {
        return getLength() + 1;
    }

    public int getLength() {
        return studentHashMap.size();
    }

//    public void test(){
//        Student s1 = new Student(1, "Computer Science", "Jake Turner", "16/08/1996");
//        assignModule(s1, new Module(1, "module 1"));
//        assignModule(s1, new Module(2, "module 2"));
//        studentHashMap.put(s1.getStudentID(), s1);
//
//        Student s2 = new Student(2, "Business Management", "John Smith", "20/03/1998");
//        assignModule(s2, new Module(1, "module 1"));
//        assignModule(s2, new Module(2, "module 2"));
//        studentHashMap.put(s2.getStudentID(), s2);
//
//        Student s3 = new Student(3, "Politics", "William Abercrombie", "31/01/1997");
//        assignModule(s3, new Module(1, "module 1"));
//        studentHashMap.put(s3.getStudentID(), s3);
//
//        Student s4 = new Student(4, "Veterinary Medicine", "Hannah Tilbury", "11/09/1995");
//        assignModule(s4, new Module(1, "module 1"));
//        assignModule(s4, new Module(2, "module 2"));
//        assignModule(s4, new Module(3, "module 3"));
//        assignModule(s4, new Module(4, "module 4"));
//        studentHashMap.put(s4.getStudentID(), s4);
//
//        Student s5 = new Student(5, "Economics", "Mia Hardcastle", "04/05/1997");
//        assignModule(s5, new Module(1, "module 1"));
//        studentHashMap.put(s5.getStudentID(), s5);
//    }
}
