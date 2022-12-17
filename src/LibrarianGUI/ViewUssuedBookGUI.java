package src.LibrarianGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewUssuedBookGUI extends JFrame{
    private JPanel ViewIssued;
    private JButton button1;

    public ViewUssuedBookGUI() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                StartGUILibrarian nl4 = new StartGUILibrarian();
                nl4.setVisible(true);
                nl4.setContentPane(nl4.getLibrarians());
                nl4.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }

    public JPanel getIssuedBooksPanel(){
        return ViewIssued;
    }
}
