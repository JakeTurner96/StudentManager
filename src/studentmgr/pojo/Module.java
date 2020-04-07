package studentmgr.pojo;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Module)) return false;

        Module module = (Module) o;

        if (getModuleID() != module.getModuleID()) return false;
        if (getModuleTitle() != null ? !getModuleTitle().equals(module.getModuleTitle()) : module.getModuleTitle() != null)
            return false;
        if (getCourseworkWeight() != null ? !getCourseworkWeight().equals(module.getCourseworkWeight()) : module.getCourseworkWeight() != null)
            return false;
        return getExamWeight() != null ? getExamWeight().equals(module.getExamWeight()) : module.getExamWeight() == null;
    }

    @Override
    public int hashCode() {
        int result = getModuleID();
        result = 31 * result + (getModuleTitle() != null ? getModuleTitle().hashCode() : 0);
        result = 31 * result + (getCourseworkWeight() != null ? getCourseworkWeight().hashCode() : 0);
        result = 31 * result + (getExamWeight() != null ? getExamWeight().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{\"_class\":\"Module\", " +
                "\"moduleID\":\"" + moduleID + "\"" + ", " +
                "\"moduleTitle\":" + (moduleTitle == null ? "null" : "\"" + moduleTitle + "\"") + ", " +
                "\"courseworkWeight\":" + (courseworkWeight == null ? "null" : "\"" + courseworkWeight + "\"") + ", " +
                "\"examWeight\":" + (examWeight == null ? "null" : "\"" + examWeight + "\"") +
                "}";
    }
}
