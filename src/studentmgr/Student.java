package studentmgr;

import java.util.ArrayList;

public class Student {

    private int studentID;
    private String courseTitle;
    private String name;
    private String dateOfBirth;
    private ArrayList<Module> modules;

    public Student(int studentID, String courseTitle, String name, String dateOfBirth) {
        this.studentID = studentID;
        this.courseTitle = courseTitle;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        modules = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String newCourseTitle){
        courseTitle = newCourseTitle;
    }

    public String getStudentName() {
        return name;
    }

    public void setStudentName(String newName) {
        name = newName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String newDateOfBirth) {
        dateOfBirth = newDateOfBirth;
    }

    public void addModule(Module module){
        modules.add(module);
    }

    public void removeModule(Module module){
        modules.remove(module);
    }

    public int getModuleSize(){
        return modules.size();
    }

}