package Wiev;

import Helper.Config;
import Helper.Helper;
import Model.Hotel;
import Model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class HotelManagmentGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tabbedPane1;
    private JTextField txt_hotel_name;
    private JTextField txt_hotel_address;
    private JTextField txt_hotel_mail;
    private JTextField txt_hotel_konum;
    private JComboBox cmb_hotel_room_type;
    private JTextField txt_hotel_room_storage;
    private JList list_hotel_establishing;
    private JList list_hotel_pension_type;
    private JButton btn_add;
    private JSpinner spinner_room_yatak_sayısı;
    private JTextField txt_room_metrekare;
    private JComboBox cmb_room_tv;
    private JComboBox cmb_room_minibar;
    private JComboBox cmb_room_oyunkonsolu;
    private JComboBox cmb_room_kasa;
    private JComboBox cmb_room_projeksiyon;
    private JTextField txt_room_enterdate;
    private JTextField txt_room_exitdate;
    private JButton btn_room_add;
    private JComboBox cmb_hotel_room_id;
    ArrayList<String> hotelEstablishingList;
    ArrayList<String> hotelPensionTypeList;

    public HotelManagmentGUI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        add(wrapper);
        setSize(new Dimension(1000, 1000));
        this.setLocation(Helper.screenSize.width / 2 - this.getSize().width / 2, Helper.screenSize.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        Helper.setLayOut();
        setVisible(true);
        loadComboRoomId();

        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hotel hotel = new Hotel();
                if (txt_hotel_name.getText().isEmpty() || txt_hotel_address.getText().isEmpty() || txt_hotel_mail.getText().isEmpty() || txt_hotel_konum.getText().isEmpty() ||
                        txt_hotel_room_storage.getText().isEmpty() || cmb_hotel_room_type.getSelectedItem() == null ||
                        establishing().isEmpty() || pensionType().isEmpty() || cmb_hotel_room_id.getSelectedItem() == null) {
                    Helper.showMessage("fill");
                } else {
                    hotel.setName(txt_hotel_name.getText());
                    hotel.setAddress(txt_hotel_address.getText());
                    hotel.setEmail(txt_hotel_mail.getText());
                    hotel.setKonum(txt_hotel_konum.getText());
                    hotel.setRoomStorage(Integer.parseInt(txt_hotel_room_storage.getText()));
                    hotel.setRoomType((String) cmb_hotel_room_type.getSelectedItem());
                    hotel.setEstablishing(establishing());
                    hotel.setPensionType(pensionType());
                    try {
                        hotel.setRoom(Room.getFetch((Integer) cmb_hotel_room_id.getSelectedItem()));
                        Hotel.insertHotel(hotel);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });


        btn_room_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Room room = new Room();
                if (txt_room_enterdate.getText().isEmpty() || txt_room_exitdate.getText().isEmpty() || txt_room_metrekare.getText().isEmpty() || spinner_room_yatak_sayısı.getValue() == null ||
                        cmb_room_kasa.getSelectedItem() == null || cmb_room_projeksiyon.getSelectedItem() == null || cmb_room_oyunkonsolu.getSelectedItem() == null ||
                        cmb_room_minibar.getSelectedItem() == null || cmb_room_tv.getSelectedItem() == null){
                        Helper.showMessage("fill");
                }else {
                    Date dateExit = null;
                    Date dateEnter = null;
                    java.sql.Date sqlDateExit = null;
                    java.sql.Date sqlDateEnter = null;
                    try {
                        dateExit = formatter.parse(txt_room_exitdate.getText());
                        dateEnter = formatter.parse(txt_room_enterdate.getText());
                        sqlDateEnter = new java.sql.Date(dateEnter.getTime());
                        sqlDateExit = new java.sql.Date(dateExit.getTime());
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    room.setYatakSayısı((Integer) spinner_room_yatak_sayısı.getValue());
                    room.setExitDate(sqlDateExit);
                    room.setEnterDate(sqlDateEnter);
                    room.setKasa((String) cmb_room_kasa.getSelectedItem());
                    room.setTv((String) cmb_room_tv.getSelectedItem());
                    room.setProjeksiyon((String) cmb_room_projeksiyon.getSelectedItem());
                    room.setOyunKonsolu((String) cmb_room_oyunkonsolu.getSelectedItem());
                    room.setMiniBar((String) cmb_room_minibar.getSelectedItem());
                    room.setMetreKare(Integer.parseInt(txt_room_metrekare.getText()));
                    try {
                        Room.insertRoom(room);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    public String establishing() {
        StringBuilder establishing = new StringBuilder();
        hotelEstablishingList = (ArrayList<String>) list_hotel_establishing.getSelectedValuesList();
        for (String word : hotelEstablishingList) {
            establishing.append(word).append(" ");
        }
        return establishing.toString();
    }

    public String pensionType() {
        StringBuilder pensionType = new StringBuilder();
        hotelPensionTypeList = (ArrayList<String>) list_hotel_pension_type.getSelectedValuesList();
        for (String word : hotelPensionTypeList) {
            pensionType.append(word).append(" ");
        }
        return pensionType.toString();
    }

    public void loadComboRoomId() throws SQLException {
        for (String s : Room.showRoomIds()) {
            cmb_hotel_room_id.addItem(s);
        }
    }
}
