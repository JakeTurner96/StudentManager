package studentmgr.test;

import org.junit.Test;
import studentmgr.Record;
import studentmgr.Student;
import studentmgr.StudentManagerService;

import static org.junit.Assert.*;

public class StudentManagerServiceTest {

    private final StudentManagerService serviceTest = (StudentManagerService) StudentManagerService.getInstance();
    private final Record r = new Student(1, "test title", "test name", "dd/mm/yyyy");

    @Test
    public void getInstance() {
    }

    @Test
    public void exportStudents() {
    }

    @Test
    public void generateID() {
       assertEquals(serviceTest.generateID(), 1);
    }

    @Test
    public void studentExists() {
        serviceTest.addRecord(1, r);
        assertEquals(serviceTest.studentExists(1), true);
    }

    @Test
    public void addRecord() {
    }

    @Test
    public void removeRecord() {
        serviceTest.addRecord(1 ,r);
        serviceTest.removeRecord(1);
        assertEquals(serviceTest.getLength(), 0);
    }

    @Test
    public void getRecord() {
        serviceTest.addRecord(1, r);
        assertEquals(serviceTest.getRecord(1), r);
    }

    @Test
    public void getLength() {
        assertEquals(serviceTest.getLength(), 0);
    }

}