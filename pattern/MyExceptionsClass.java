package pattern;

public class MyExceptionsClass {

}

class AccountAlreadyExistsException extends Error {
    public AccountAlreadyExistsException(String message) {
        super(message);

    }
}

class WrongCredentialsException extends Exception {
    public WrongCredentialsException(String message) {
        super(message);
    }
}

class AccountBlockedException extends Exception {
    public AccountBlockedException(String message) {
        super(message);
    }
}
