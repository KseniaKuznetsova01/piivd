package githab;

public class Main {

    public static void main(String[] args) {

        Record record1 = new Record(12, "89223123132", "kate");

        MyBook book = new MyBook();


        try {
            book.createRecord(record1);
        } catch (PhoneNumberAlreadyExists message) {
            System.out.println(message);
        }


    }
}
