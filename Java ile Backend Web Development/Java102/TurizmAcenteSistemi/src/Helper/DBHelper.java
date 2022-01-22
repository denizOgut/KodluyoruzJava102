package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private Connection connection = null;

    public Connection connectDB() throws SQLException {
        connection = DriverManager.getConnection(Config.DB_URL);
        return this.connection;
    }

    public static Connection getInstance() throws SQLException {
        DBHelper dbConnecter = new DBHelper();
        return dbConnecter.connectDB();
    }

}
