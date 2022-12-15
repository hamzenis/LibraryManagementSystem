package src.main;

import src.logingui.Login;

public class Initialize {

    //  Start of Program
    public void startLoginUI(){
        Login loginUIObj = new Login();
        loginUIObj.setContentPane(loginUIObj.getLoginWindowPanel());
        loginUIObj.setTitle("Welcome to LMS");
        loginUIObj.setSize(250,200);
        loginUIObj.setVisible(true);
    }


}
