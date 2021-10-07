package pattern;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileService {
    private static FileService instance;

    public static synchronized FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    FileService() {

    }

    public void cleanFile() throws IOException {
        String csvFilename = "C/Users/kseniakuznecova/IdeaProjects/z1/src/pattern/DATA.csv";
        BufferedWriter fileZero = new BufferedWriter(new FileWriter(csvFilename));
        fileZero.write("");
        fileZero.close();
    }

    public void writeDataOfUsers(HashMap<String, Account> accounts) {
        StringBuilder dataOfUsers = new StringBuilder();
        String csvFilename = "/Users/kseniakuznecova/IdeaProjects/z1/src/pattern/DATA.csv";
        try {

            BufferedWriter fileOut = new BufferedWriter(new FileWriter(csvFilename));

            for (Account account: accounts.values()) {
                for (String elem : account.getData()) {
                    dataOfUsers.append(elem);
                    dataOfUsers.append("/");
                }
                dataOfUsers.append("\n");
            }
            //System.out.println(dataOfUsers);
            fileOut.write(String.valueOf(dataOfUsers));
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public ArrayList<Account> readDataOfUsers() throws IOException {
        String csvFilename = "/Users/kseniakuznecova/IdeaProjects/z1/src/pattern/DATA.csv";

        ArrayList<Account> userMap = new ArrayList<>();
        BufferedReader fileIn = new BufferedReader(new FileReader(csvFilename));

        Scanner scanner = null;
        String line = null;
        int index = 0;

        try {
            while ((line = fileIn.readLine()) != null) {
                Account account = new Account();
                scanner = new Scanner(line);
                scanner.useDelimiter("/");

                while (scanner.hasNext()) {
                    String user = scanner.next();
                    if (index == 0)
                        account.setName(user);
                    else if (index == 1)
                        account.setBirthday(user);
                    else if (index == 2)
                        account.setEmail(user);
                    else if (index == 3)
                        account.setPassword(user);
                    else if (index == 4) {
                        if (user == "-1") {
                            account.setBlocked(false);
                        } else {
                            account.setBlocked(true);
                        }
                    }
                    else System.out.println("Uncorrected information!");
                    index ++;
                }
                index = 0;
                userMap.add(account);
            }
            fileIn.close();

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        return userMap;
    }

}
