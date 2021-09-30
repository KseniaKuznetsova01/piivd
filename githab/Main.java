package githab;

public class Main {

    public static void main(String[] args) throws PhoneNumberAlreadyExists, RecordNotValid {

        Record record1 = new Record(12, "89223123132", "kate");
        Record record2 = new Record(13, "89123453678", "masha");
        Record record3 = new Record(1, "89253647856", "Ksysha");
        MyBook book = new MyBook();

        book.createRecord(record1);
        try {
            book.createRecord(record1);
        } catch (PhoneNumberAlreadyExists message) {
            System.out.println(message);
        }

        book.updateRecord(record2);
        try {
            book.updateRecord(record2);
        } catch (RecordNotValid message) {
            System.out.println(message);
        }

        book.deleteRecord(record3.id);



    }
}
