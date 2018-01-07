package com.example.java.frames;

import com.example.java.listeners.LoginFrameListener;

import javax.swing.*;

public class LoginFrame extends JFrame {

   private JFrame loginFrame;
   private JPanel mainPanel;
   private JLabel name, password;
   private JTextField userName, userPassword;
   private JButton login, createUser;

   private String playerName = "";
   private String playerPassword = "";


    public LoginFrame() {
        loginFrame = new JFrame();
        loginFrame.setSize(400,200);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setTitle("LOGIN");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mainPanel = new JPanel();
        name = new JLabel("User name");
        password = new JLabel("User Password");
        userName = new JTextField();
        userPassword = new JTextField();
        login = new JButton("Login");
        createUser = new JButton("Create user");

        LoginFrameListener listenForButton = new LoginFrameListener(this);
        login.addActionListener(listenForButton);
        createUser.addActionListener(listenForButton);

        Box nameBox = Box.createHorizontalBox();
        nameBox.add(name);
        nameBox.add(userName);

        Box passwordBox = Box.createHorizontalBox();
        passwordBox.add(password);
        passwordBox.add(userPassword);

        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(login);
        buttonBox.add(createUser);

        Box loginBox = Box.createVerticalBox();
        loginBox.add(nameBox);
        loginBox.add(passwordBox);
        loginBox.add(buttonBox);
        mainPanel.add(loginBox);


        loginFrame.add(mainPanel);
        loginFrame.setVisible(true);
    }

    public void showFrame(boolean b) {
        loginFrame.setVisible(b);
    }

    public JFrame getLoginFrame() {
        return loginFrame;
    }

    public void setLoginFrame(JFrame loginFrame) {
        this.loginFrame = loginFrame;
    }

    public JTextField getUserName() {
        return userName;
    }

    public void setUserName(JTextField userName) {
        this.userName = userName;
    }

    public JTextField getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(JTextField userPassword) {
        this.userPassword = userPassword;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerPassword() {
        return playerPassword;
    }

    public void setPlayerPassword(String playerPassword) {
        this.playerPassword = playerPassword;
    }

    public JButton getLogin() {
        return login;
    }

    public JButton getCreateUser() {
        return createUser;
    }
}
