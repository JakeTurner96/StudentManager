package studentmgr;

import java.util.HashMap;

public class Student implements Record {

    private int studentID;
    private String courseTitle;
    private String name;
    private String dateOfBirth;
    private HashMap<Integer, Module> modules;

    public Student(int studentID, String courseTitle, String name, String dateOfBirth) {
        this.studentID = studentID;
        this.courseTitle = courseTitle;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        modules = new HashMap<>();
    }

    @Override
    public int getID() {
        return studentID;
    }

    @Override
    public String getTitle() {
        return courseTitle;
    }

    @Override
    public void setTitle(String newTitle) {
        courseTitle = newTitle;
    }

    public String getStudentName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void updateName(String newName) {
        name = newName;
    }

    public void updateDateOfBirth(String newDateOfBirth) {
        dateOfBirth = newDateOfBirth;
    }
}