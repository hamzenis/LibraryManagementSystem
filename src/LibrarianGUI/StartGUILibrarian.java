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
   }

 /*   private void createUIComponents() {
        // TODO: place custom component creation code here
    }
*/
    public JPanel getLibrarians(){
        return librarians;
    }

}
