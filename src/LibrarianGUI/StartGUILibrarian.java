package src.LibrarianGUI;

import src.logingui.Login;
import src.userGUI.IssuedBooks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGUILibrarian extends JFrame {
    private JPanel librarians;
    private JButton issueBooks_UserButton;
    private JButton addBookButton;
    private JButton viewUserButton;
    private JButton viewBookButton;
    private JButton addUserButton;
    private JButton entriesButton;
    private JButton LogOutButton;
    private JButton issuedBooksButton;
    private JButton returnedBooksButton;

    public StartGUILibrarian() {

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddUserGUI newAddUser = new AddUserGUI();
                newAddUser.setContentPane(newAddUser.getAddUserPanel());
                newAddUser.setVisible(true);
                newAddUser.setExtendedState(MAXIMIZED_BOTH);
            }
        });

        issueBooks_UserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                IssuebookUsersGUI newIssueBUser = new IssuebookUsersGUI();
                newIssueBUser.setContentPane(newIssueBUser.getPanel5());
                newIssueBUser.setVisible(true);
                newIssueBUser.setExtendedState(MAXIMIZED_BOTH);
            }
        });


        entriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                EntriesGUI newEntries = new EntriesGUI();
                newEntries.setContentPane(newEntries.getPanel7());
                newEntries.setVisible(true);
                newEntries.setExtendedState(MAXIMIZED_BOTH);
            }
        });

        LogOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Login newLogIn = new Login();
                newLogIn.setVisible(true);
                newLogIn.setContentPane(newLogIn.getLoginWindowPanel());
                newLogIn.setSize(250,200);
            }
        });
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddBookGUI newBook = new AddBookGUI();
                newBook.setVisible(true);
                newBook.setContentPane(newBook.getAddBookPanel());
                newBook.setExtendedState(MAXIMIZED_BOTH);
            }
        });
        viewBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ViewBookGUI vb = new ViewBookGUI();
                vb.setVisible(true);
                vb.setContentPane(vb.getViewBookPanel());
                vb.setExtendedState(MAXIMIZED_BOTH);
            }
        });
        issuedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ViewUssuedBookGUI ib = new ViewUssuedBookGUI();
                ib.setVisible(true);
                ib.setContentPane(ib.getIssuedBooksPanel());
                ib.setExtendedState(MAXIMIZED_BOTH);
            }
        });
        returnedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ViewReturnedBookGUI rb = new ViewReturnedBookGUI();
                rb.setVisible(true);
                rb.setContentPane(rb.getReturnedBooks());
                rb.setExtendedState(MAXIMIZED_BOTH);
            }
        });
        viewUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ViewUserGUI vu = new ViewUserGUI();
                vu.setVisible(true);
                vu.setContentPane(vu.getViewUserPanel());
                vu.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }
 /*   private void createUIComponents() {
        // TODO: place custom component creation code here
    }
*/
        public JPanel getLibrarians() {
            return librarians;
        }
}
