package src.LibrarianGUI;

import src.main.Initial;

import javax.swing.*;

public class StartGUILibrarian extends JFrame {
    private JPanel windowPanel;
    private JButton issueBookTOUserButton;
    private JButton addBookButton;
    private JButton viewUserButton;
    private JButton viewBookButton;
    private JButton addUserButton;
    private JButton logOutButton;
    private JButton issuedBooksButton;
    private JButton returnedBooksButton;
    Initial in = new Initial();

    public StartGUILibrarian() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addUserButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startAddUserGUI();
        });

        issueBookTOUserButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startIssueBookUsersGUI();
        });

        logOutButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLoginUI();
        });

        addBookButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startAddBookGUI();
        });

        viewBookButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startViewBookGUI();
        });

        issuedBooksButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startViewIssuedBook();
        });

        returnedBooksButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startViewReturnedBook();
        });

        viewUserButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startViewUserGUI();
        });
    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }
}
