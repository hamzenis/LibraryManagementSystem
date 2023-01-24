package src.LibrarianGUI;

import src.db.DBCon;
import src.main.Initial;

import javax.swing.*;

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
            DBCon dbCon = new DBCon();
            String values[] = {
                    inputUsername.getText(),
                    inputLastname.getText(),
                    inputTypeUser.getSelectedItem().toString()
            };
            dbCon.insertUser(values);
            JOptionPane.showMessageDialog(null, "User Added Successfully!");
            clearInput();
        });
    }

    //  Clear last input
    private void clearInput() {
        inputUsername.setText("");
        inputLastname.setText("");
        inputTypeUser.setSelectedItem("");
    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }
}
