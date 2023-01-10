package src.LibrarianGUI;

import Project.ConnectionProvider;
import src.main.Initial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import Project.*;

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
                //String id_user = inputUserID.getText();
                String fname_user = inputUsername.getText();
                String lname_user = inputLastname.getText();
                String typeof_user = (String) inputTypeUser.getSelectedItem();
                try
                {
                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement();
                    // st.executeUpdate("insert into user values ('"+id_user+"','"+fname_user+"','"+lname_user+"','"+typeof_user+"')");
                    st.executeUpdate("insert into Library_Management_System.user (First_name,Last_name,Is_Librarian) values ('"+fname_user+"','"+lname_user+"','"+typeof_user+"')");
                    JOptionPane.showMessageDialog(null,"Successfully Updated");
                    setVisible (false);
                    new AddUserGUI().setVisible (true);
                }
                catch(Exception evt)
                {
                    JOptionPane.showMessageDialog(null,"User Id already exists");
                    //setVisible(false);
                    new AddUserGUI().setVisible (true);
                }
            }
        });
    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }
}