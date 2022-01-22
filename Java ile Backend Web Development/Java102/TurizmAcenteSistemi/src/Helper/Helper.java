package Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static void setLayOut() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }


    }

    public static void showMessage(String str) {
        String msg;
        String title;
        switch (str) {
            case "fill":
                msg = "Lütfen Tüm Alanları Doldurunuz";
                title = "Hata";
                break;
            case "success":
                msg = "Islem Basarılı";
                title = "Basarılı";
                break;
            case "error":
                msg = "Bır hata olustu!";
                title = "Hata";
                break;
            default:
                msg = str;
                title = "Mesaj";
                break;
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
