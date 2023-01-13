package src.LibrarianGUI;

import src.db.DBCon;
import src.main.Initial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserGUI extends JFrame{
    private JTextField inputUsername;
    private JTextField inputLastname;
    private JComboBox inputTypeUser;
    private JPanel windowPanel;
    private JButton backButton;
    private JButton saveButton;
    Initial in = new Initial();


    public AddUserGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLibrarianGUI();
        });
        saveButton.addActionListener(e -> {
            DBCon dbaction = new DBCon();
            String inputSQL = "insert into Author (First_name, Last_name) VALUES ('"
                    + inputUsername.getText() + "', '"
                    + inputLastname.getText() + "');";
            dbaction.sqlExecute(inputSQL);
        });
    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }
}
