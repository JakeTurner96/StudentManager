package studentmgr.exception;

/**
 * @author Soumen Karmakar
 * 07/04/2020
 */
public class StudentAlreadyExistException extends RuntimeException {
    public StudentAlreadyExistException(String s) {
        super(s);
    }
}
