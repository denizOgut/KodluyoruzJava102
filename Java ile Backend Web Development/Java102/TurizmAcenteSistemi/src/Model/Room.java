package Model;

import Helper.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Room {
    private int yatakSayısı, metreKare, id;
    private String tv, miniBar, oyunKonsolu, kasa, projeksiyon;
    private Date enterDate, exitDate;


    public Room() {
    }

    public Room(int yatakSayısı, int metreKare, String tv, String miniBar, String oyunKonsolu, String kasa, String projeksiyon, Date enterDate, Date exitDate, int id) {
        this.yatakSayısı = yatakSayısı;
        this.metreKare = metreKare;
        this.tv = tv;
        this.miniBar = miniBar;
        this.oyunKonsolu = oyunKonsolu;
        this.kasa = kasa;
        this.projeksiyon = projeksiyon;
        this.enterDate = enterDate;
        this.exitDate = exitDate;
        this.id = id;

    }

    public int getYatakSayısı() {
        return yatakSayısı;
    }

    public void setYatakSayısı(int yatakSayısı) {
        this.yatakSayısı = yatakSayısı;
    }

    public int getMetreKare() {
        return metreKare;
    }

    public void setMetreKare(int metreKare) {
        this.metreKare = metreKare;
    }

    public String isTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String isMiniBar() {
        return miniBar;
    }

    public void setMiniBar(String miniBar) {
        this.miniBar = miniBar;
    }

    public String isOyunKonsolu() {
        return oyunKonsolu;
    }

    public void setOyunKonsolu(String oyunKonsolu) {
        this.oyunKonsolu = oyunKonsolu;
    }

    public String isKasa() {
        return kasa;
    }

    public void setKasa(String kasa) {
        this.kasa = kasa;
    }

    public String isProjeksiyon() {
        return projeksiyon;
    }

    public void setProjeksiyon(String projeksiyon) {
        this.projeksiyon = projeksiyon;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Room getFetch(int id) throws SQLException {
        Room obj = null;
        String query = "SELECT * FROM [TurizmAcenteSistemi].[dbo].[room] WHERE id = ?";
        PreparedStatement preparedStatement = DBHelper.getInstance().prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            obj = new Room();
            obj.setId(resultSet.getInt("id"));
            obj.setYatakSayısı(resultSet.getInt("yataksayısı"));
            obj.setMetreKare(resultSet.getInt("metrekare"));
            obj.setTv(resultSet.getString("tv"));
            obj.setProjeksiyon(resultSet.getString("projeksiyon"));
            obj.setMiniBar(resultSet.getString("minibar"));
            obj.setOyunKonsolu(resultSet.getString("oyunkonsolu"));
            obj.setKasa(resultSet.getString("kasa"));
            obj.setEnterDate(resultSet.getDate("enterDate"));
            obj.setExitDate(resultSet.getDate("exitDate"));

        }
        return obj;
    }

    public static int insertRoom(Room room) throws SQLException {
        String columnNames[] = new String[]{"id"};
        int result;
        String query = "INSERT INTO [dbo].[room](yataksayısı,metrekare,tv,minibar,oyunkonsolu,kasa,projeksiyon,enterDate,exitDate)VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = DBHelper.getInstance().prepareStatement(query);
        preparedStatement.setInt(1, room.getYatakSayısı());
        preparedStatement.setInt(2, room.getMetreKare());
        preparedStatement.setString(3, room.isTv());
        preparedStatement.setString(4, room.isMiniBar());
        preparedStatement.setString(5, room.isOyunKonsolu());
        preparedStatement.setString(6, room.isKasa());
        preparedStatement.setString(7, room.isProjeksiyon());
        preparedStatement.setDate(8, (java.sql.Date) room.getEnterDate());
        preparedStatement.setDate(9, (java.sql.Date) room.getExitDate());

        result = preparedStatement.executeUpdate();
        if (result == 1) {
            java.sql.ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                room.setId(generatedKeys.getInt(1));
            }
        }
        return result;
    }

    public static ArrayList<String> showRoomIds() throws SQLException {
        ArrayList<String> roomIdList = new ArrayList<>();;
        String query = "SELECT id FROM [TurizmAcenteSistemi].[dbo].[room]";
        PreparedStatement preparedStatement = DBHelper.getInstance().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
       while(resultSet.next()) {
            String id = String.valueOf(resultSet.getInt("id"));
            roomIdList.add(id);
        }
        return roomIdList;
    }
}
