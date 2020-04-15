package studentmgr.tests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import studentmgr.pojo.Module;
import studentmgr.pojo.Student;
import studentmgr.service.StudentManagerService;
import java.io.FileNotFoundException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Soumen Karmakar
 * 07/04/2020
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentManagerServiceTest {

    static StudentManagerService studentManagerService;
    static Student student;
    static Module module;
    static Student updatedStudent;

    @org.junit.jupiter.api.BeforeAll
    static void getInstance() {
        studentManagerService = StudentManagerService.getInstance();
        student = new Student(1, "Computer Science", "Jake Turner",  LocalDate.of(2000, 8, 16));
        updatedStudent = new Student(1, "Business", "Jake William Turner",  LocalDate.of(1996, 8, 16));
        module = new Module(1, "Algorithms and data structures", "80%", "20%");
    }

    @org.junit.jupiter.api.Test
    @Order(1)
    void addStudent() {
        studentManagerService.addStudent(student);
        assertTrue(!studentManagerService.getStudentList().isEmpty());
    }

    @org.junit.jupiter.api.Test
    @Order(2)
    void exportStudents() throws FileNotFoundException {
        studentManagerService.exportStudents();
    }

    @org.junit.jupiter.api.Test
    @Order(3)
    void getStudent(){
        assertEquals(student, (studentManagerService.getStudent(student)));
    }

    @org.junit.jupiter.api.Test
    @Order(4)
    void assignModule() {
        studentManagerService.assignModule(student, module);
        assertEquals(1, studentManagerService.getStudent(student).getModuleSize());
    }

    @org.junit.jupiter.api.Test
    @Order(5)
    void removeModuleAssignment() {
        studentManagerService.removeModuleAssignment(student, module);
        assertEquals(0, studentManagerService.getStudent(student).getModuleSize());
    }

    @org.junit.jupiter.api.Test
    @Order(6)
    void updateStudent() {
        studentManagerService.updateStudent(student, updatedStudent);
        assertEquals(updatedStudent, studentManagerService.getStudent(updatedStudent));
    }

    @org.junit.jupiter.api.Test
    @Order(7)
    void removeStudent() {
        studentManagerService.removeStudent(updatedStudent);
        assertTrue(studentManagerService.getStudentList().isEmpty());
    }
}