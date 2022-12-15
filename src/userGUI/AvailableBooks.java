package src.userGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvailableBooks extends JFrame {
    private JPanel panel4;
    private JButton AvailableBooksbackButton;

    public AvailableBooks() {
        AvailableBooksbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                UserGUI ug2 = new UserGUI();
                ug2.setContentPane(ug2.getPanel1());
                ug2.setVisible(true);
                ug2.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }

    public JPanel getPanel4(){
        return panel4;
    }
}
