package studentmgr;

import java.util.HashMap;

public class ModuleManagerService implements Service {

    private static HashMap<Integer, Record> modulesList;
    private static final Service moduleManagerInstance = new ModuleManagerService();

    private ModuleManagerService() { modulesList = new HashMap<>();}

    public static Service getInstance() {return moduleManagerInstance;}

    @Override
    public void addRecord(int ID, Record record) {
        modulesList.put(ID, record);
    }

    @Override
    public void removeRecord(int ID) {
        modulesList.remove(ID);
    }

    @Override
    public Record getRecord(int ID) {
        return modulesList.get(ID);
    }

    @Override
    public int getLength() {
        return modulesList.size();
    }
}
