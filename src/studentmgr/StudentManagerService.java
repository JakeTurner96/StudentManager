package studentmgr;

import java.util.HashMap;

public class StudentManagerService extends Thread implements Service{

    private static HashMap<Integer, Record> studentHashMap;
    private static final Service studentRecordInstance = new StudentManagerService();

    private StudentManagerService() {
        studentHashMap = new HashMap<>();
    }

    public static Service getInstance() {
        return studentRecordInstance;
    }

    public void exportStudents() {}

    public int generateID() {
        return studentHashMap.size() + 1;
    }

    public boolean studentExists(int ID) {
        return studentHashMap.containsKey(ID);
    }

    @Override
    public void addRecord(int ID, Record record) {
        studentHashMap.put(ID, record);
    }

    @Override
    public void removeRecord(int ID) {
        studentHashMap.remove(ID);
    }

    @Override
    public Record getRecord(int ID) {
        return studentHashMap.get(ID);
    }

    @Override
    public int getLength() {
        return studentHashMap.size();
    }

    public void run() {
        Record s1 = new Student(1, "Computer Science", "Jake Turner", "16/08/1996");
        studentHashMap.put(s1.getID(), s1);

        Record s2 = new Student(2, "Business Management", "", "");
        studentHashMap.put(s2.getID(), s2);

        Record s3 = new Student(3, "", "", "");
        studentHashMap.put(s3.getID(), s3);

        Record s4 = new Student(4, "", "", "");
        studentHashMap.put(s4.getID(), s4);

        Record s5 = new Student(5, "", "", "");
        studentHashMap.put(s5.getID(), s5);
    }
}
