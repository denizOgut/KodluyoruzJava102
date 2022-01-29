package Wiev;

import Helper.Helper;
import Helper.Config;
import Model.Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HotelSearchGUI extends JFrame {
    private JPanel panel1;
    private JPanel wrapper;
    private JTabbedPane tabbedPane1;
    private JComboBox cmb_hotel_konum;
    private JTextField txt_enter_date;
    private JTextField txt_exit_date;
    private JTextField txt_guest_info;
    private JButton btn_search;

    public HotelSearchGUI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        add(wrapper);
        setSize(new Dimension(400, 400));
        this.setLocation(Helper.screenSize.width / 2 - this.getSize().width / 2, Helper.screenSize.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        Helper.setLayOut();
        setVisible(true);
        loadKonumCombo();


        btn_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] guestInfo = txt_guest_info.getText().split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    java.util.Date dateExit = formatter.parse(txt_enter_date.getText());
                    java.util.Date dateEnter = formatter.parse(txt_exit_date.getText());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                    //Bu kısıma query giricek ve
            }
        });
    }

    public void loadKonumCombo() throws SQLException {
        for (String s: Hotel.showHotelKonum()) {
            cmb_hotel_konum.addItem(s);
        }
    }
}