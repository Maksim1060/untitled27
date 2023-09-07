package exeptions;

public class WrongLoginException extends Exception {
    public WrongLoginException(String messege) {
        super(messege);
    }

}
