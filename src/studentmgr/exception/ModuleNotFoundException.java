package studentmgr.exception;

public class ModuleNotFoundException extends RuntimeException {
    public ModuleNotFoundException(String messgae){
        super(messgae);
    }
}
