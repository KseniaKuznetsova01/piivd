package githab;

import java.util.ArrayList;

public class Record {
    public long id;
    private String phoneNumber;
    public String name;


    public Record(long id, String phoneNumber, String name) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}