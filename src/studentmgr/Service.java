package studentmgr;

public interface Service {

    void addRecord(int ID, Record record);

    void removeRecord(int ID);

    Record getRecord(int ID);

    int getLength();

}
