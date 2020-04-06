package studentmgr.test;

import studentmgr.Module;
import static org.junit.Assert.*;

public class ModuleTest {

    private final Module moduleTest = new Module(1, "test title", "50%","50%");

    @org.junit.Test
    public void getModuleID() {
        assertEquals(1, moduleTest.getModuleID());
    }

    @org.junit.Test
    public void getModuleTitle() {
        assertEquals("test title", moduleTest.getModuleTitle());
    }

    @org.junit.Test
    public void setModuleTitle() {
        moduleTest.setModuleTitle("new title");
        assertEquals("new title", moduleTest.getModuleTitle());
    }

    @org.junit.Test
    public void getCourseworkWeight() {
        assertEquals("50%", moduleTest.getCourseworkWeight());
    }

    @org.junit.Test
    public void setCourseworkWeight() {
        moduleTest.setCourseworkWeight("25%");
        assertEquals("25%", moduleTest.getCourseworkWeight());
    }

    @org.junit.Test
    public void getExamWeight() {
        assertEquals("50%", moduleTest.getExamWeight());
    }

    @org.junit.Test
    public void setExamWeight() {
        moduleTest.setExamWeight("25%");
        assertEquals("25%", moduleTest.getExamWeight());
    }

}