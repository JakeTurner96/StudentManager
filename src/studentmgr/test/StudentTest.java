package studentmgr.test;

import org.junit.Test;
import studentmgr.Student;

import static org.junit.Assert.*;

public class StudentTest {

    private final Student testStudent = new Student(1, "course title", "name", "dd/mm/yyyy");

    @Test
    public void getID() {
        assertEquals(testStudent.getID(), 1);
    }

    @Test
    public void getTitle() {
        assertEquals(testStudent.getTitle(), "course title");
    }

    @Test
    public void setTitle() {
        testStudent.setTitle("new title");
        assertEquals(testStudent.getTitle(), "new title");
    }

    @Test
    public void getStudentName() {
        assertEquals(testStudent.getStudentName(), "name");
    }

    @Test
    public void getDateOfBirth() {
        assertEquals(testStudent.getDateOfBirth(), "dd/mm/yyyy");
    }

    @Test
    public void updateName() {
        testStudent.updateName("new name");
        assertEquals(testStudent.getStudentName(), "new name");
    }

    @Test
    public void updateDateOfBirth() {
        testStudent.updateDateOfBirth("new dd/mm/yyyy");
        assertEquals(testStudent.getDateOfBirth(), "new dd/mm/yyyy");
    }
}