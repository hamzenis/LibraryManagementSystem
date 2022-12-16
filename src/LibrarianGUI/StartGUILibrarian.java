package src.LibrarianGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGUILibrarian extends JFrame{
    private JPanel librarians;
    private JLabel text1;
    private JButton issueBooks_UserButton;
    private JButton viewIssuedBooksButton;
    private JButton addBookButton;
    private JButton viewUserButton;
    private JButton viewBookButton;
    private JButton addUserButton;
    private JButton viewReturnedBooksButton;
    private JButton entriesButton;

   public StartGUILibrarian() {
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               setVisible(false);
               AddBookGUI newAddBook = new AddBookGUI();
               newAddBook.setContentPane(newAddBook.getPanel1());
               newAddBook.setVisible(true);
               newAddBook.setExtendedState(MAXIMIZED_BOTH);

            }
        });
       addUserButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               setVisible(false);
               AddUserGUI newAddUser = new AddUserGUI();
               newAddUser.setContentPane(newAddUser.getJPanelU());
               newAddUser.setVisible(true);
               newAddUser.setExtendedState(MAXIMIZED_BOTH);
           }
       });

       viewBookButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               setVisible(false);
               ViewBookGUI newVieBook = new ViewBookGUI();
               newVieBook.setContentPane(newVieBook.getPanel2());
               newVieBook.setVisible(true);
               newVieBook.setExtendedState(MAXIMIZED_BOTH);
           }
       });

       viewUserButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               setVisible(false);
               ViewUserGUI newViewBook = new ViewUserGUI();
               newViewBook.setContentPane(newViewBook.getPanel3());
               newViewBook.setVisible(true);
               newViewBook.setExtendedState(MAXIMIZED_BOTH);

           }
       });

       viewIssuedBooksButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               setVisible(false);
               ViewUssuedBookGUI newUssedBook = new ViewUssuedBookGUI();
               newUssedBook.setContentPane(newUssedBook.getPanel4());
               newUssedBook.setVisible(true);
               newUssedBook.setExtendedState(MAXIMIZED_BOTH);
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

       viewReturnedBooksButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               setVisible(false);
               ViewReturnedBookGUI newViewBRetuned = new ViewReturnedBookGUI();
               newViewBRetuned.setContentPane(newViewBRetuned.getPanel6());
               newViewBRetuned.setVisible(true);
               newViewBRetuned.setExtendedState(MAXIMIZED_BOTH);
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


   }

 /*   private void createUIComponents() {
        // TODO: place custom component creation code here
    }
*/
    public JPanel getLibrarians(){
        return librarians;
    }

}
