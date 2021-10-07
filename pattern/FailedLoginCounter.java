package pattern;

public class FailedLoginCounter {
    private static FailedLoginCounter instance;

    public static synchronized FailedLoginCounter getInstance(Account account) {
        if (instance == null) {
            instance = new FailedLoginCounter();
        }
        return instance;
    }
}
