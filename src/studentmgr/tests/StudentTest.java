package studentmgr.test;

import org.junit.Test;
import studentmgr.Module;
import studentmgr.Student;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class StudentTest {

    private final Student testStudent = new Student(1, "course title", "test name", "dd/mm/yyyy");
    private final Module testModule = new Module(1, "test title", "50%", "50%");

    @Test
    public void getStudentID() {
        assertEquals(1, testStudent.getStudentID());
    }

    @Test
    public void getCourseTitle() {
        assertEquals("course title", testStudent.getCourseTitle());
    }

    @Test
    public void setCourseTitle(){
        String newCourseTitle =  "new course title";
        testStudent.setCourseTitle(newCourseTitle);
        assertEquals(newCourseTitle, testStudent.getCourseTitle());
    }

    @Test
    public void getStudentName() {
        assertEquals("test name", testStudent.getStudentName());
    }

    @Test
    public void setStudentName() {
        String newName = "new name";
        testStudent.setStudentName(newName);
        assertEquals(newName, testStudent.getStudentName());
    }

    @Test
    public void getDateOfBirth() {
        assertEquals( "dd/mm/yyyy", testStudent.getDateOfBirth());
    }

    @Test
    public void setDateOfBirth() {
        String newDateOfBirth = "new dd/mm/yyyy";
        testStudent.setDateOfBirth(newDateOfBirth);
        assertEquals(newDateOfBirth, testStudent.getDateOfBirth());
    }

    @Test
    public void addModule(){
        testStudent.addModule(testModule);
        assertEquals(1, testStudent.getModuleSize());
    }

    @Test
    public void removeModule(){
        testStudent.addModule(testModule);
        testStudent.removeModule(testModule);
        assertEquals(0, testStudent.getModuleSize());
    }

    @Test
    public void getModuleSize(){
        testStudent.addModule(testModule);
        assertEquals(1, testStudent.getModuleSize());
    }

}