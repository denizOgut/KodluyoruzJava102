package Wiev;

import Helper.Helper;
import Helper.Config;
import Model.Hotel;
import Model.Room;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.ChronoUnit;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class RoomDetailsGUI extends JFrame {
    private JPanel wrapper;
    private JLabel lbl_room_date;
    private JLabel lbl_pension_type;
    private JLabel lbl_room_type;
    private JLabel lbl_hotel_konum;
    private JLabel lbl_hotel_address;
    private JLabel lbl_hotel_mail;
    private JLabel lbl_hotel_puan;
    private JLabel lbl_hotel_hizmetleri;
    private JLabel lbl_hotel_price;
    private JButton btn_reservation;
    private Room room = ShowHotelResultGUI.selectedRoom;
    private Hotel hotel = ShowHotelResultGUI.selectedHotel;
    private String[] guestinfo = HotelSearchGUI.guestInfo;
    String[] pensionTypes;

    public RoomDetailsGUI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        add(wrapper);
        setSize(new Dimension(800, 500));
        this.setLocation(Helper.screenSize.width / 2 - this.getSize().width / 2, Helper.screenSize.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        Helper.setLayOut();
        setVisible(true);
        lbl_room_date.setText("Rezerve Tarih: " + room.getEnterDate() + " / " + room.getExitDate());
        pensionTypes = hotel.getPensionType().split("");
        String[] establishingArray = hotel.getEstablishing().split("");
        StringBuilder lblPensionType = new StringBuilder();
        for (String s : pensionTypes) {
            lblPensionType.append(s);
        }

        StringBuilder establishing = new StringBuilder();
        for (String s : establishingArray) {
            establishing.append(s);
        }

        lbl_room_type.setText("Oda Tipi: " + hotel.getRoomType());
        lbl_pension_type.setText(String.valueOf(lblPensionType));
        lbl_hotel_konum.setText("Şehir: " + hotel.getKonum());
        lbl_hotel_address.setText("Bölge: " + hotel.getAddress());
        lbl_hotel_mail.setText("Mail: " + hotel.getEmail());
        lbl_hotel_puan.setText("Puan: " + hotel.getStar());
        lbl_hotel_hizmetleri.setText("Hotel Hizmetleri: " + '\n' + establishing);
        int differenceInTime = room.getExitDate().getDay() - room.getEnterDate().getDay();
        hotel.setPrice((hotel.getPrice() + priceCalculateByGuestInfo() + priceCalculateByPensionType())* differenceInTime);
        lbl_hotel_price.setText(differenceInTime+" Gece için fiyat: " + hotel.getPrice());
        btn_reservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hotel.getRoomStorage()==0){
                    Helper.showMessage("Oda Kalmamıştır.");
                }else{
                    try {
                        Hotel.updateHotel(hotel.getId());
                        LoginGUI loginGUI = new LoginGUI();
                    } catch (SQLException | UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                }


            }
        });
    }

    public int priceCalculateByGuestInfo() {
        if (guestinfo[1].equals("YETISKIN")) {
            hotel.setPrice(hotel.getPrice() + (Integer.valueOf(guestinfo[0]) * 500));
        }

        if (guestinfo[1].equals("ÇOCUK")) {
            hotel.setPrice(hotel.getPrice() + (Integer.valueOf(guestinfo[0]) * 250));
        }

        if (guestinfo[3].equals("YETISKIN")) {
            hotel.setPrice(hotel.getPrice() + (Integer.valueOf(guestinfo[2]) * 500));
        }

        if (guestinfo[3].equals("ÇOCUK")) {
            hotel.setPrice(hotel.getPrice() + (Integer.valueOf(guestinfo[2]) * 250));
        }

        return  hotel.getPrice();
    }

    public int priceCalculateByPensionType(){
       hotel.setPrice(hotel.getPrice() + (pensionTypes.length * 700));
        return hotel.getPrice();
    }

}
