package githab;


class PhoneNumberAlreadyExists extends Exception{
    public PhoneNumberAlreadyExists(String message) {
        super(message);
    }
}

class RecordNotFound extends RuntimeException{
    public RecordNotFound(String message) {
        super(message);
    }
}

class RecordNotValid extends Exception{
    public RecordNotValid(String message) {
        super(message);
    }
}

