package src.LibrarianGUI;

import src.logingui.Login;
import src.main.Initial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGUILibrarian extends JFrame {
    private JPanel windowPanel;
    private JButton issueBookTOUserButton;
    private JButton addBookButton;
    private JButton viewUserButton;
    private JButton viewBookButton;
    private JButton addUserButton;
    private JButton entriesButton;
    private JButton LogOutButton;
    private JButton issuedBooksButton;
    private JButton returnedBooksButton;
    Initial in = new Initial();

    public StartGUILibrarian() {

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startAddUserGUI();

            }
        });

        issueBookTOUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startIssueBookUsersGUI();
            }
        });


        entriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startEntriesGUI();
            }
        });

        LogOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startLoginUI();
            }
        });
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startAddBookGUI();
            }
        });
        viewBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startViewBookGUI();
            }
        });
        issuedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startViewIssuedBook();
            }
        });
        returnedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startViewReturnedBook();
            }
        });
        viewUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startViewUserGUI();
            }
        });
    }

        public JPanel getWindowPanel() {
            return windowPanel;
        }
}
