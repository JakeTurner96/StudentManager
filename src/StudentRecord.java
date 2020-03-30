import java.util.Hashtable;

public class StudentRecord {

    private static Hashtable<String, Student> studentHashMap;
    private static final StudentRecord studentRecordInstance = new StudentRecord();

    private StudentRecord() {
        studentHashMap = new Hashtable<>();

        Student s1 = new Student("Jake Turner", 19, "Computer Science");
        studentHashMap.put(s1.getName(), s1);

        Student s2 = new Student("Hannah Tilbury", 20, "Veterinary medicine ");
        studentHashMap.put(s2.getName(), s2);

        Student s3 = new Student("Sam Short", 20, "Ancient history");
        studentHashMap.put(s3.getName(), s3);

        Student s4 = new Student("Mia Hardcastle", 19, "Business management");
        studentHashMap.put(s4.getName(), s4);

        Student s5 = new Student("Sam Stephens", 23, "Electronic engineering");
        studentHashMap.put(s5.getName(), s5);
    }

    public static StudentRecord getInstance() {
        return studentRecordInstance;
    }

    public void addStudent(String name, Student student) {
        studentHashMap.put(name, student);
    }

    public void deleteStudent(String name) {
        studentHashMap.remove(name);
    }

    public Student getStudent(String name) {
        return studentHashMap.get(name);
    }

    public boolean studentExists(String name) {
        return studentHashMap.containsKey(name);
    }
}
