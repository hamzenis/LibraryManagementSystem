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
            String inputSQL;
            if (inputTypeUser.getSelectedItem() == "Administrator") {
                inputSQL = "insert into User (firstname, lastname, isLibrarian) VALUES ('"
                        + inputUsername.getText() + "', '"
                        + inputLastname.getText() + "', '"
                        + "1" + "');";
            } else {
                inputSQL = "insert into User (firstname, lastname, isLibrarian) VALUES ('"
                        + inputUsername.getText() + "', '"
                        + inputLastname.getText() + "', '"
                        + "0" + "');";
            }
            dbaction.sqlExecute(inputSQL);
            JOptionPane.showMessageDialog(null, "User Added Successfully!");

            //  Clear last input
            inputUsername.setText("");
            inputLastname.setText("");
            inputTypeUser.setSelectedItem("");
        });
    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }
}
