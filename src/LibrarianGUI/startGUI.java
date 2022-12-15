package src.LibrarianGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startGUI extends JFrame{
    private JPanel Librarians;
    private JLabel text1;
    private JButton issueBooks_UserButton;
    private JButton viewIssuedBooksButton;
    private JButton addBookButton;
    private JButton viewUserButton;
    private JButton viewBookButton;
    private JButton addUserButton;
    private JButton viewReturnedBooksButton;
    private JButton entriesButton;

    public startGUI() {
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
