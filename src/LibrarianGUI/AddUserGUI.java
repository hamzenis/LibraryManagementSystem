package src.LibrarianGUI;

import src.db.DBCon;
import src.main.Initial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserGUI extends JFrame{
    private JTextField inputUserID;
    private JTextField inputUsername;
    private JTextField inputLastname;
    private JComboBox inputTypeUser;
    private JPanel windowPanel;
    private JButton backButton;
    private JButton saveButton;
    Initial in = new Initial();

    public AddUserGUI() {
        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLibrarianGUI();
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBCon test = new DBCon();
                test.sqlExecute("insert into Author (First_name, Last_name) VALUES ('Hamzenis', 'Kryeziu');");
            }
        });
    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }
}
