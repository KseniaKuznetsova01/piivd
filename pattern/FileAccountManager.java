package pattern;

import java.io.IOException;
import java.util.*;

public class FileAccountManager extends Throwable implements AccountManager {

    private Map<String, Account> allAccounts;
    private final FileService fileService = new FileService();

    public FileAccountManager() {
        allAccounts = new HashMap<>();
    }

    public void setAllAccounts(HashMap<String, Account> allAccounts) {
        this.allAccounts = allAccounts;
    }

    @Override
    public void register(Account account) throws IOException {
        if (allAccounts.containsKey(account.getEmail())) {
            throw new AccountAlreadyExistsException("Аккаунт " + account.getEmail()+ " уже существует");
        }
        account.setBlocked(true);
        allAccounts.put(account.getEmail(), account);
        fileService.writeDataOfUsers((HashMap<String, Account>) allAccounts);
        System.out.println("Аккаунт " + account.getEmail()+" создан");
    }

    @Override
    public Account login(String email, String password) throws WrongCredentialsException,
            AccountBlockedException, IOException {

        if (email.endsWith("@mail.ru") || email.endsWith("@gmail.ru")) {

            ArrayList<Account> arrayListAccounts = fileService.readDataOfUsers();


            Map<String, Account> newAccounts = new HashMap<>();

            for (Account account: arrayListAccounts) {
                newAccounts.put(account.getEmail(), account);}



            if (newAccounts.containsKey(email)) {

                Account user = newAccounts.get(email);
                if (Objects.equals(user.getPassword(), password) & user.getBlock()) {
                    user.getInfo();
                    return user;
                }

                else if (Objects.equals(user.getPassword(), password) & !user.getBlock()) {
                    throw new AccountBlockedException("Account "+user.getEmail()+" is blocked!");
                } else if (!Objects.equals(user.getPassword(), password) & user.getBlock()) {
                    throw new WrongCredentialsException("Неправильный пароль (0)");
                }
            } else {
                throw new WrongCredentialsException("Неправильный пароль (1)!");
            }
        } else {
            throw new WrongCredentialsException("Неправильный пароль(2)!");
        }
        return null;
    }

    @Override
    public void removeAccount(String email, String password) throws WrongCredentialsException, IOException {
        ArrayList<Account> arrayListAccounts = fileService.readDataOfUsers();
        HashMap<String, Account> newAccounts = new HashMap<>();

        for (Account account: arrayListAccounts) {
            newAccounts.put(account.getEmail(), account);
        }
        Account user = newAccounts.get(email);

        if ((Objects.equals(user.getEmail(), email) & Objects.equals(user.getPassword(), password))
                & newAccounts.containsKey(email)) {
            newAccounts.remove(email, user);
            System.out.println("Account " +user.getEmail()+ " is invalid!");

            if (!newAccounts.isEmpty()) {
                fileService.writeDataOfUsers(newAccounts);
            } else {
                fileService.cleanFile();
            }
        } else
        {throw new WrongCredentialsException("Wrong login or password! Try again!");}
    }

    public Map<String, Account> getAllAccounts() {
        return allAccounts;
    }
}
