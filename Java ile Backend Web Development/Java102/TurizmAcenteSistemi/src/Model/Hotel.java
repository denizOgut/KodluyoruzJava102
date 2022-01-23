package Model;

import Model.Enum.Establishing;
import Model.Enum.PensionType;
import Model.Enum.RoomType;

import java.util.HashMap;

public class Hotel {
    private String name, address, email, konum;
    private int star;
    private String establishing;
    private String pensionType;
    private Room room;
    private HashMap<RoomType, Integer> roomMap;

    public Hotel() {
    }

    public Hotel(String name, String address, String email, int star, String establishing, String pensionType, Room room, String konum, HashMap<RoomType, Integer> roomMap) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.star = star;
        this.establishing = establishing;
        this.pensionType = pensionType;
        this.room = room;
        this.konum = konum;
        this.roomMap = roomMap;

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

    public HashMap<RoomType, Integer> getroomMap() {
        return roomMap;
    }

    public void setroomMap(HashMap<RoomType, Integer> roomMap) {
        this.roomMap = roomMap;
    }

    public String getKonum() {
        return konum;
    }

    public void setKonum(String konum) {
        this.konum = konum;
    }

    public HashMap<RoomType, Integer> getRoomMap() {
        return roomMap;
    }

    public void setRoomMap(HashMap<RoomType, Integer> roomMap) {
        this.roomMap = roomMap;
    }
}
