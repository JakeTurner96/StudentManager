package studentmgr.test;

import studentmgr.Module;
import static org.junit.Assert.*;

public class ModuleTest {

    private final Module moduleTest = new Module(1, "Test title");

    @org.junit.Test
    public void getID() {
        assertEquals(moduleTest.getID(), 1);
    }

    @org.junit.Test
    public void getTitle() {
        assertEquals(moduleTest.getTitle(), "Test title");
    }

    @org.junit.Test
    public void setTitle() {
        moduleTest.setTitle("new title");
        assertEquals(moduleTest.getTitle(), "new title");
    }
}