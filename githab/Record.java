package githab;

import java.util.ArrayList;

public class Record {
    public long id;
    public String phoneNumber;
    public String name;
    public ArrayList<Record> Records;



    public Record(long id, String phoneNumber, String name) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        Records = new ArrayList<Record>()

    }

    public String getPhoneNumber() {
        return phoneNumber;

    public ArrayList<Record> getAllRecords() {
        return Records;
    }

    public void createRecord(Record record){
        Records.add(record);
        System.out.println("Номер телефона " + record.phoneNumber + " сохранен под именем:" + record.name);
    }

    public void deleteRecord(long id) {
        try {
            int count = 0;
            if (Records.size() > 0) {
                for (Record record : Records) {
                    if (record.id == id) {
                        Records.remove(count);
                        System.out.println("Номер " + record.getPhoneNumber() + " удален из записной книжки");
                    } else {
                        System.out.println("Такого номера нет");
                    }
                    count++;
                }
            } else {
                System.out.println("Список номеров пуст!");
            }
        } catch (Exception e) {
            System.out.println("ошибка с удалением!");
        }
    }

    }
}
