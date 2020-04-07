package studentmgr.tests;

import org.junit.Before;
import org.junit.jupiter.api.Order;
import studentmgr.exception.StudentNotFoundException;
import studentmgr.pojo.Student;
import studentmgr.service.StudentManagerService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Soumen Karmakar
 * 07/04/2020
 */
class StudentManagerServiceTest {

    static StudentManagerService studentManagerService;
    static Student student;

    @org.junit.jupiter.api.BeforeAll
    static void getInstance() {
        studentManagerService = StudentManagerService.getInstance();
        student = new Student(1, "Computer Science", "Jake Turner", new Date());
    }

    @org.junit.jupiter.api.Test
    @Order(1)
    void addStudent() {
        studentManagerService.addStudent(student);
        assertTrue(!studentManagerService.getStudentList().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void removeStudent() throws StudentNotFoundException {
        studentManagerService.removeStudent(student);
    }

    @org.junit.jupiter.api.Test
    void updateStudent() {
    }

    @org.junit.jupiter.api.Test
    void exportStudents() {
    }

    @org.junit.jupiter.api.Test
    void assignModule() {
    }

    @org.junit.jupiter.api.Test
    void removeModuleAssignment() {
    }
}