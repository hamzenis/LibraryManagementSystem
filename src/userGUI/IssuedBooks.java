package src.userGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IssuedBooks extends JFrame{
    private JPanel panel3;
    private JButton backButton;

    public IssuedBooks() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                UserGUI ug = new UserGUI();
                ug.setContentPane(ug.getPanel1());
                ug.setVisible(true);
                ug.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }

    public JPanel getPanel3(){
        return panel3;
    }
}
