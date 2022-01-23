import Helper.DBHelper;
import Wiev.HotelManagmentGUI;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String query = "SELECT * FROM [TurizmAcenteSistemi].[dbo].[hotel]";
        PreparedStatement preparedStatement;
        preparedStatement = DBHelper.getInstance().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            System.out.println("ID : " + resultSet.getInt("id"));
            System.out.println("Name : " + resultSet.getString("name"));
            System.out.println("Address : " + resultSet.getString("address"));
            System.out.println("Email : " + resultSet.getString("email"));
            System.out.println("Konum : " + resultSet.getString("konum"));
            System.out.println("Yıldız : " + resultSet.getInt("yıldız"));
            System.out.println("RoomId : " + resultSet.getInt("roomid"));
            System.out.println("RoomType : " + resultSet.getString("roomtype"));
            System.out.println("RoomNumber: " + resultSet.getInt("roomstorage"));
            System.out.println("Establishing: " + resultSet.getString("establishing"));
            System.out.println("PensionType : " + resultSet.getString("pensiontype"));
            System.out.println("###################################################");
        }
        HotelManagmentGUI hotelManagmentGUI = new HotelManagmentGUI();
        }
    }

