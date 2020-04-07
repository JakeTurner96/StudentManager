package studentmgr.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Student {

    private int studentID;
    private String courseTitle;
    private String name;
    private Date dateOfBirth;
    private List<Module> modules;

    public Student(int studentID, String courseTitle, String name, Date dateOfBirth) {
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

    public void setCourseTitle(String newCourseTitle) {
        courseTitle = newCourseTitle;
    }

    public String getStudentName() {
        return name;
    }

    public void setStudentName(String newName) {
        name = newName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date newDateOfBirth) {
        dateOfBirth = newDateOfBirth;
    }

    public void addModule(Module module) {
        this.modules.add(module);
    }

    public void removeModule(Module module) {
        modules.remove(module);
    }

    public int getModuleSize() {
        return modules.size();
    }


    @Override
    public String toString() {
        return "{\"_class\":\"Student\", " +
                "\"studentID\":\"" + studentID + "\"" + ", " +
                "\"courseTitle\":" + (courseTitle == null ? "null" : "\"" + courseTitle + "\"") + ", " +
                "\"name\":" + (name == null ? "null" : "\"" + name + "\"") + ", " +
                "\"dateOfBirth\":" + (dateOfBirth == null ? "null" : "\"" + dateOfBirth + "\"") + ", " +
                "\"modules\":" + (modules == null ? "null" : Arrays.toString(modules.toArray())) +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getStudentID() != student.getStudentID()) return false;
        if (getCourseTitle() != null ? !getCourseTitle().equals(student.getCourseTitle()) : student.getCourseTitle() != null)
            return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (getDateOfBirth() != null ? !getDateOfBirth().equals(student.getDateOfBirth()) : student.getDateOfBirth() != null)
            return false;
        return modules != null ? modules.equals(student.modules) : student.modules == null;
    }

    @Override
    public int hashCode() {
        int result = getStudentID();
        result = 31 * result + (getCourseTitle() != null ? getCourseTitle().hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + (modules != null ? modules.hashCode() : 0);
        return result;
    }
}