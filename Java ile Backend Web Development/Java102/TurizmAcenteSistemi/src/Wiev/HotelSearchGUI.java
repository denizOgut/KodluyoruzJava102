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
                String[] guestInfo = txt_guest_info.getText().split(",");
                Date dateEnter = null;
                Date dateExit = null;
                java.sql.Date sqlDateExit = null;
                java.sql.Date sqlDateEnter = null;
                String konum = cmb_hotel_konum.getSelectedItem().toString();
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    dateEnter = formatter.parse(txt_enter_date.getText());
                    dateExit = formatter.parse(txt_exit_date.getText());
                    sqlDateEnter = new java.sql.Date(dateEnter.getTime());
                    sqlDateExit = new java.sql.Date(dateExit.getTime());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                try {
                    Hotel.showHotelSearchResult(sqlDateEnter, sqlDateExit,konum);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

    public void loadKonumCombo() throws SQLException {
        for (String s: Hotel.showHotelKonum()) {
            cmb_hotel_konum.addItem(s);
        }
    }
}