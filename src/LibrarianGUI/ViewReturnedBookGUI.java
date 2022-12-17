package src.LibrarianGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewReturnedBookGUI extends JFrame {

    private JPanel ReturnedBooks;
    private JButton backButton;

    public ViewReturnedBookGUI() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                StartGUILibrarian nl2 = new StartGUILibrarian();
                nl2.setVisible(true);
                nl2.setContentPane(nl2.getLibrarians());
                nl2.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }

    public JPanel getReturnedBooks(){
        return ReturnedBooks;
    }
}
