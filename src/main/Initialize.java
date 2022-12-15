package src.main;

import src.logingui.Login;
import src.userGUI.UserGUI;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Initialize {

    //  Start of Program
    public void startLoginUI(){
        Login loginUIObj = new Login();
        loginUIObj.setContentPane(loginUIObj.getLoginWindowPanel());
        loginUIObj.setTitle("Welcome to LMS");
        loginUIObj.setSize(250,200);
        loginUIObj.setVisible(true);
    }

    public void startUserGUI(){
        UserGUI ug = new UserGUI();
        ug.setContentPane(ug.getPanel1());
        ug.setTitle("LMS - Library Management System");
        ug.setVisible(true);
        ug.setExtendedState(MAXIMIZED_BOTH);
    }

    public void startAvailableBooksGUI(){

    }



}
