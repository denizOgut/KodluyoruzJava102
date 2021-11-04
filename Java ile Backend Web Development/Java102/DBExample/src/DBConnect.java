import java.sql.*;

public class DBConnect {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/dvdrental";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "4753208Asd";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            System.out.println("Connection to the postgreSql SUCCESS");
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM actor");
            while (resultSet.next()) {
                System.out.println("ID : " + resultSet.getInt("actor_id"));
                System.out.println("Name : " + resultSet.getString("first_name"));
                System.out.println("Surname : " + resultSet.getString("last_name"));
                System.out.println("#################");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
