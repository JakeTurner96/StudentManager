package studentmgr;

import studentmgr.test.StudentNotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
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

    public void removeStudent(int ID) throws StudentNotFoundException {
        if(!studentExists(ID)){
            throw new StudentNotFoundException("Student not found");
        }else{
            studentHashMap.remove(ID);
        }
    }

    public void updateStudent(Student student, String newCourse, String newName, String newDateOfBirth) throws StudentNotFoundException {
        if(!studentExists(student.getStudentID())){
            throw new StudentNotFoundException("Student not found");
        }else{
            student.setCourseTitle(newCourse);
            student.setStudentName(newName);
            student.setDateOfBirth(newDateOfBirth);
        }
    }

    public void exportStudents() throws FileNotFoundException {

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

    public void assignModule(Student student, Module module) throws StudentNotFoundException {
        if(!studentExists(student.getStudentID())){
            throw new StudentNotFoundException("Student not found");
        }else{
            student.addModule(module);
        }
    }

    public void removeModuleAssignment(Student student, Module module) throws StudentNotFoundException {
        if(!studentExists(student.getStudentID())){
            throw new StudentNotFoundException("Student not found");
        }else{
            student.removeModule(module);
        }
    }

    public Student getStudent(int ID)  {
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
}
