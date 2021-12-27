package Manager;
import java.util.Scanner;

public class InputReaderManager {

    private String email, password;

    public InputReaderManager() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type Email: ");
        this.email = scanner.next();
        System.out.print("Type Password: ");
        this.password = scanner.next();
        AccountManager.login(this);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}