package studentmgr.test;

import org.junit.Test;
import studentmgr.Module;
import studentmgr.Student;
import studentmgr.StudentManagerService;

import static org.junit.Assert.*;

public class StudentManagerServiceTest {

    private final StudentManagerService serviceTest = StudentManagerService.getInstance();
    private Student student = new Student(1, "test title", "test name", "dd/mm/yyyy");
    private Module module = new Module(1, "test module", "50%", "50%");


    @Test
    public void addStudent() {
        serviceTest.addStudent(1, student);
        assertTrue(serviceTest.studentExists(1));
    }

    @Test
    public void removeStudent() {
        serviceTest.addStudent(1, student);
        serviceTest.removeStudent(1);
        assertFalse(serviceTest.studentExists(1));
    }

    @Test
    public void updateStudent() {
        serviceTest.updateStudent(student, "new course", "new name", "new date of birth");
        assertEquals("new course", student.getCourseTitle());
        assertEquals("new name", student.getStudentName());
        assertEquals("new date of birth", student.getDateOfBirth());
    }

    @Test
    public void assignModule() {
        serviceTest.assignModule(student, module);
        assertEquals(1, student.getModuleSize());
    }

    @Test
    public void removeModuleAssignment() {
        serviceTest.assignModule(student, module);
        serviceTest.removeModuleAssignment(student, module);
        assertEquals(0, student.getModuleSize());
    }

    @Test
    public void getStudent() {
        serviceTest.addStudent(1, student);
        assertEquals(student, serviceTest.getStudent(1));
    }

    @Test
    public void studentExists() {
        serviceTest.addStudent(1, student);
        assertTrue(serviceTest.studentExists(1));
    }

    @Test
    public void generateID() {
        assertEquals(1, serviceTest.generateID());
    }

    @Test
    public void getLength() {
       assertEquals(0, serviceTest.getLength());
    }

}