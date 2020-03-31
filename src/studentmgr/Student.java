
public class Student {

    private String name;
    private int age;
    private String course;

    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    //Return the name of the student
    public String getName() {
        return name;
    }

    //Return the age of the student
    public int getAge() {
        return age;
    }

    //Return the course of the student
    public String getCourse() {
        return course;
    }

    public void updateName(String newName) {
        name = newName;
    }

    public void updateAge(int newAge) {
        age = newAge;
    }

    public void updateCourse(String newCourse) {
        course = newCourse;
    }
}
