package Account;

import Insurance.Insurance;
import Main.User;

public class Individual extends Account{

    public Individual(User user) {
        super(user);
    }

    @Override
    public boolean addInsurance(Insurance insurance) {
        return false;
    }

    @Override
    public int compareTo(Account o) {
        return 0;
    }
}
