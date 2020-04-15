package studentmgr.service;

import studentmgr.pojo.Module;
import studentmgr.pojo.Student;
import studentmgr.exception.StudentAlreadyExistException;
import studentmgr.exception.StudentNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentManagerService {

    private List<Student> studentList;
    private static final StudentManagerService studentRecordInstance = new StudentManagerService();

    private StudentManagerService() {
        studentList = new ArrayList<>();
    }

    public static StudentManagerService getInstance() {
        return studentRecordInstance;
    }

    public void addStudent(Student student) throws StudentAlreadyExistException {
        if (!studentExists(student)) {
            studentList.add(student);
        } else {
            throw new StudentAlreadyExistException("Student already exists!");
        }
    }

    private boolean studentExists(Student student) {
        return studentList.contains(student);
    }

    public void removeStudent(Student student) throws StudentNotFoundException {
        if (!studentExists(student)) {
            throw new StudentNotFoundException("Student not found");
        } else {
            studentList.remove(student);
        }
    }

    public void updateStudent(Student old, Student newS) throws StudentNotFoundException {
        if (!studentExists(old)) {
            throw new StudentNotFoundException("Student not found");
        } else {
            removeStudent(old);
            addStudent(newS);
        }
    }

    public Student getStudent(Student student ){
        if(studentExists(student)){
            return studentList.stream().filter(s -> s.equals(student)).findAny().orElse(null);
        }else{
            throw new StudentNotFoundException("Student not found!");
        }
    }

    public void exportStudents(){

        try {
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

            studentList.stream().forEach(sb::append);
            printWriter.write(sb.toString());
            printWriter.close();

        } catch (IOException e) {
            System.out.println("Unable to export to .CSV");
        }
    }

    public void assignModule(Student student, Module module) throws StudentNotFoundException {
        if (!studentExists(student)) {
            throw new StudentNotFoundException("Student not found");
        } else {
            student.addModule(module);
        }
    }

    public void removeModuleAssignment(Student student, Module module) throws StudentNotFoundException {
        if (!studentExists(student)) {
            throw new StudentNotFoundException("Student not found");
        } else {
            student.removeModule(module);
        }
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
