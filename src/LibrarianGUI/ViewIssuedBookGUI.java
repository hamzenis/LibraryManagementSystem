package src.LibrarianGUI;

import src.main.Initial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewIssuedBookGUI extends JFrame{
    private JPanel windowPanel;
    private JButton backButton;
    Initial in = new Initial();

    public ViewIssuedBookGUI() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                in.startLibrarianGUI();
            }
        });
    }

    public JPanel getIssuedBooksPanel(){
        return windowPanel;
    }
}
