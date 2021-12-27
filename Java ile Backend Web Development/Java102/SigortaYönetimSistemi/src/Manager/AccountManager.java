package Manager;

import Account.Account;
import Main.InvalidAuthenticationException;

import java.util.TreeSet;

public class AccountManager {

    public static TreeSet<Account> accountTreeSet = new TreeSet<>();

    public static boolean login (InputReaderManager reader)
    {
        Account account = accountTreeSet.stream() .filter(account1 -> (
                        account1.getUser().getEmail().equalsIgnoreCase(reader.getEmail())  &&
                                account1.getUser().getPassword().equalsIgnoreCase(reader.getPassword())))
                .findFirst().orElseGet(null);
        if (account == null)
            return false;

        else {
            try {
                account.login(reader.getEmail(), reader.getPassword());
                return true;
            } catch (InvalidAuthenticationException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
    }
}
