package pattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, AccountBlockedException, WrongCredentialsException {

        Account user1 = new Account("Вихарева Ксения Алексеевна", "20.05.2001",
                "ksyna@mail.ru", "1223344", true);
        Account user2 = new Account("Инитов Анатолий Владиславович", "06.09.1991",
                "init@mail.ru", "1213456", true);

        FileAccountManager listOfUsers = new FileAccountManager();
        listOfUsers.register(user1);
        listOfUsers.register(user2);


        listOfUsers.login("ksyna@mail.ru", "1223344");

        listOfUsers.removeAccount("ksyna@mail.ru", "1223344");

    }
}
