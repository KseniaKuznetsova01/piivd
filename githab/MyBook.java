package githab;

import java.util.ArrayList;

public class MyBook {
    ArrayList<Record> records;

    public MyBook() {
        records = new ArrayList<Record>();
    }

    public ArrayList<Record> getAllRecords() {
        // получение номера группы
        return records;
    }

    public void updateRecord(Record record) throws RecordNotFound, RecordNotValid{
        for (Record i : records) {
            if (i.id == record.id) {
                System.out.println();
                throw new RecordNotFound("error");
            }
        }
        if ((record.name == null) || (record.getPhoneNumber() == null) || (record.name.length() == 0) || (record.getPhoneNumber().length()==0) ){
            throw new RecordNotValid("error");
        }
    }

    public void createRecord(Record record) throws PhoneNumberAlreadyExists {
            for (Record i : records) {
                if (i.getPhoneNumber()== record.getPhoneNumber()){
                    throw new PhoneNumberAlreadyExists("error");
                }
            }
        records.add(record);
        System.out.println("Номер телефона " + record.getPhoneNumber() + " сохранен под именем:" + record.name);

        }

    public void deleteRecord(long id) throws RecordNotFound{
        try {
        int count = 0;
            if (records.size() > 0) {
                for (Record record : records) {
                    if (record.id == id) {
                        records.remove(count);
                        System.out.println("Номер " + record.getPhoneNumber() + " удален из записной книжки");
                    } else {
                        System.out.println("Такого номера нет");
                        throw new RecordNotFound("error");
                    }
                    count++;
                }
            } else {
                System.out.println("Список номеров пуст!");
            }
        } catch (Exception e) {
            System.out.println("Ошибка с удалением!");
        }
    }

}

