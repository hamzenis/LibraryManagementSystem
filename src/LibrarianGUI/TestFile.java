package src.LibrarianGUI;

import com.toedter.calendar.JDateChooser;
import src.jcal.calendar.JCalendar;
import src.main.Initial;

import javax.swing.*;
import src.jcal.*;

public class TestFile extends JFrame{
    private JPanel windowPanel;
    private JTextField textField1;
    private JButton backButton;
    Initial in = new Initial();

    JDateChooser dateshow = new JDateChooser();

    public TestFile() {
        backButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            in.startLibrarianGUI();

            JPCald.add(dateshow);
        });

        public TestFile(){
            setContentPane(JCalendar);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setSize(400,250);
            new TestFile().setVisible(true);


        }
    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }
}
