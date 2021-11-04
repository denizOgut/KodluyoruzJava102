# JAVA DATABASE ORNEGI

````java
import java.sql.*;

public class DBConnect {
    public static final String DB_URL = "jdbc:mysql://localhost/school";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            conn.setAutoCommit(false);

            // PreparedStatement ile Insert İşlemi
            PreparedStatement pr = conn.prepareStatement("INSERT INTO student (student_fname,student_lname,student_class) VALUES (?,?,?)");
            pr.setString(1, "Harry");
            pr.setString(2, "Potter");
            pr.setString(3, "2");
            pr.executeUpdate();

            if (1 == 1) {
                throw new SQLException();
            }

            // PreparedStatement ile Insert İşlemi
            pr.setString(1, "Ron");
            pr.setString(2, "Weasley");
            pr.setString(3, "1");
            pr.executeUpdate();

            conn.commit();
            conn.close();
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}


````