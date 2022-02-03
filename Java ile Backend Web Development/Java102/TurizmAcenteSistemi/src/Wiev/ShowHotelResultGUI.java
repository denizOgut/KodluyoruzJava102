package Wiev;

import Helper.Helper;
import Helper.Config;
import Model.Hotel;
import Model.Room;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ShowHotelResultGUI extends JFrame {

    private JPanel wrapper;
    private JTable hotel_data_table;
    private JTextField txt_hotel_id;
    private JButton chooseButton;
    private JPanel panel1;
    private DefaultTableModel mdl_hotel_list;
    private Object[] row_hotel_list;
    public static Room room;
    public ShowHotelResultGUI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        add(wrapper);
        setSize(new Dimension(800, 500));
        this.setLocation(Helper.screenSize.width / 2 - this.getSize().width / 2, Helper.screenSize.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        Helper.setLayOut();
        setVisible(true);


        mdl_hotel_list = new DefaultTableModel();
        Object[] col_hotelList = {"Id", "Hotel Ad", "Hotel Adres", "E-mail", "Konum","Yıldız","Tesis","Pansiyon Tipi"};
        row_hotel_list = new Object[col_hotelList.length];
        mdl_hotel_list.setColumnIdentifiers(col_hotelList);
        hotel_data_table.setModel(mdl_hotel_list);
        hotel_data_table.getTableHeader().setReorderingAllowed(false);
        loadHotelModel();
        hotel_data_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (hotel_data_table.getSelectedRow() != -1) {
                    String selectedUserId = hotel_data_table.getValueAt(hotel_data_table.getSelectedRow(), 0).toString();
                    txt_hotel_id.setText(selectedUserId);
                }

            }
        });

        chooseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Hotel hotel = Hotel.getFetch(Integer.parseInt(txt_hotel_id.getText()));
                    room = Room.getFetch(hotel.getRoom().getId());
                    System.out.println(room.getId() + " --- "+room.getYatakSayısı()+ " --- "+room.getMetreKare());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void loadHotelModel() throws SQLException {
        DefaultTableModel clearModel = (DefaultTableModel) hotel_data_table.getModel();
        clearModel.setRowCount(0);
        for (Hotel hotel : Hotel.showAllHotel()) { // Gecıcı kalıcak
            row_hotel_list[0] = hotel.getId();
            row_hotel_list[1] = hotel.getName();
            row_hotel_list[2] = hotel.getAddress();
            row_hotel_list[3] = hotel.getEmail();
            row_hotel_list[4] = hotel.getKonum();
            row_hotel_list[5] = hotel.getStar();
            row_hotel_list[6] = hotel.getEstablishing();
            row_hotel_list[7] = hotel.getPensionType();
            mdl_hotel_list.addRow(row_hotel_list);
        }
    }
}
