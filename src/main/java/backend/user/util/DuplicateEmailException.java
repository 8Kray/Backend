package backend.user.util;

public class DuplicateEmailException extends Throwable {
    public DuplicateEmailException(String message) {
        super(message);
    }
}