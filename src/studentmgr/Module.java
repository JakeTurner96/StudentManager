package studentmgr;

public class Module implements Record {

    private int moduleID;
    private String moduleTitle;

    public Module(int moduleID, String moduleTitle) {
        this.moduleID = moduleID;
        this.moduleTitle = moduleTitle;
    }

    @Override
    public int getID() {
        return moduleID;
    }

    @Override
    public String getTitle() {
        return moduleTitle;
    }

    @Override
    public void setTitle(String newTitle) {
        moduleTitle = newTitle;
    }
}
