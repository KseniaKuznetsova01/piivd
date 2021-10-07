package pattern;

import java.io.IOException;

public interface AccountManager {
    void register(Account account) throws IOException;

    Account login(String email, String password) throws WrongCredentialsException, AccountBlockedException, IOException;

    void removeAccount(String email, String password) throws WrongCredentialsException, IOException;
}
