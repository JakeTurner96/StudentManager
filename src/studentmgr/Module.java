package studentmgr;

public class Module {

    private int moduleID;
    private String moduleTitle;
    private String courseworkWeight;
    private String examWeight;

    public Module(int moduleID, String moduleTitle, String examWeight, String courseworkWeight) {
        this.moduleID = moduleID;
        this.moduleTitle = moduleTitle;
        this.examWeight = examWeight;
        this.courseworkWeight = courseworkWeight;
    }

    public int getModuleID() {
        return moduleID;
    }

    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String newTitle) {
        moduleTitle = newTitle;
    }

    public String getCourseworkWeight() {
        return courseworkWeight;
    }

    public void setCourseworkWeight(String newCourseworkWeight) {
        courseworkWeight = newCourseworkWeight;
    }

    public String getExamWeight() {
        return examWeight;
    }

    public void setExamWeight(String newExamWeight) {
        examWeight = newExamWeight;
    }
}
