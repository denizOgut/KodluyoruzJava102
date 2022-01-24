package Model;

import Helper.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Hotel {
    private String name, address, email, konum, roomType;
    private int star, price, id, roomStorage;
    private String establishing;
    private String pensionType;
    private Room room;
    private HashMap<String, Integer> roomMap;

    public Hotel() {
    }

    public Hotel(String name, String address, String email, int star, String establishing, String pensionType, String konum, int id, String roomType, int roomStorage) throws SQLException {
        this.name = name;
        this.address = address;
        this.email = email;
        this.star = star;
        this.establishing = establishing;
        this.pensionType = pensionType;
        this.room = Room.getFetch(id);
        this.konum = konum;
        this.roomMap = new HashMap<String, Integer>();
        this.price = 1000;
        this.id = id;
        this.roomType = roomType;
        this.roomStorage = roomStorage;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getEstablishing() {
        return establishing;
    }

    public void setEstablishing(String establishing) {
        this.establishing = establishing;
    }

    public String getPensionType() {
        return pensionType;
    }

    public void setPensionType(String pensionType) {
        this.pensionType = pensionType;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public HashMap<String, Integer> getroomMap() {
        return roomMap;
    }

    public void setroomMap(HashMap<String, Integer> roomMap) {
        this.roomMap = roomMap;
    }

    public String getKonum() {
        return konum;
    }

    public void setKonum(String konum) {
        this.konum = konum;
    }

    public HashMap<String, Integer> getRoomMap() {
        return roomMap;
    }

    public void setRoomMap(HashMap<String, Integer> roomMap) {
        this.roomMap = roomMap;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomStorage() {
        return roomStorage;
    }

    public void setRoomStorage(int roomStorage) {
        this.roomStorage = roomStorage;
    }

    public static int insertHotel(Hotel hotel) throws SQLException {
        String columnNames[] = new String[]{"id"};
        int result;
        String query = "INSERT INTO [dbo].[hotel](name,address,email,konum,yıldız,roomid,roomtype,roomstorage,establishing,pensiontype)VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = DBHelper.getInstance().prepareStatement(query);
        preparedStatement.setString(1, hotel.getName());
        preparedStatement.setString(2, hotel.getAddress());
        preparedStatement.setString(3, hotel.getEmail());
        preparedStatement.setString(4, hotel.getKonum());
        preparedStatement.setInt(5, hotel.getStar());
        preparedStatement.setInt(6, hotel.getRoom().getId());
        preparedStatement.setString(7, hotel.getRoomType());
        preparedStatement.setInt(8, hotel.getRoomStorage());
        preparedStatement.setString(9, hotel.getEstablishing());
        preparedStatement.setString(10, hotel.getPensionType());
        result = preparedStatement.executeUpdate();
        if (result == 1){
            java.sql.ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                hotel.setId(generatedKeys.getInt(1));
            }
        }
        return result;
    }
}
