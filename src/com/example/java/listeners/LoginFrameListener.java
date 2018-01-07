package com.example.java.listeners;

import com.example.java.frames.LoginFrame;
import com.example.java.player.Player;
import com.example.java.frames.PlayerFrame;
import com.example.java.panels.PlayerPanel;
import com.example.java.utils.XMLWriteAndRead;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LoginFrameListener implements ActionListener {

    private LoginFrame loginFrame;
    private String playerName;
    private String playerPassword;

    public LoginFrameListener(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getLoginFrameDetails();
        if (e.getSource() == loginFrame.getCreateUser()) {
            if (isEmptyField()) {
                JOptionPane.showMessageDialog(loginFrame, "Please fill in username and password", "ERROR", JOptionPane.ERROR_MESSAGE );
            } else {
                String userHomeDir = System.getProperty("user.home");
                File userFile = new File(userHomeDir + "/FightGamePlayers/player" + playerName + ".xml");
                if (userFile.exists()) {
                    JOptionPane.showMessageDialog(loginFrame, "User with this name already exists!", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    createPlayer();
                    loginFrame.setVisible(false);
                }
            }
        }

        if (e.getSource() == loginFrame.getLogin()) {
            if (isEmptyField()) {
                JOptionPane.showMessageDialog(loginFrame, "Please fill in username and password", "ERROR", JOptionPane.ERROR_MESSAGE );
            } else {
                Player player = new Player(playerName, playerPassword);
                String userHomeDir = System.getProperty("user.home");
                File userFile = new File(userHomeDir + "/FightGamePlayers/player" + player.getName() + ".xml");
                if (userFile.exists()) {
                    loginUser(player);
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "User with name " + playerName + " not found!", "WARNING", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    public void getLoginFrameDetails() {
        loginFrame.setPlayerName(loginFrame.getUserName().getText());
        playerName = loginFrame.getPlayerName();
        loginFrame.setPlayerPassword(loginFrame.getUserPassword().getText());
        playerPassword = loginFrame.getPlayerPassword();
    }

    public void loginUser(Player player) {

        try {

            player = XMLWriteAndRead.readXML(player);

            if (player.getName().equals(playerName) && player.getPassword().equals(playerPassword)) {

                PlayerFrame playerFrame = new PlayerFrame(player);
                PlayerPanel playerPanel = new PlayerPanel(player);
                loginFrame.showFrame(false);

            } else {
                JOptionPane.showMessageDialog(loginFrame, "Username or Password don't match!", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.out.println("Wrong login!");
            }

        }
        catch(Exception ex) {
            ex.getStackTrace();
        }

    }

    public void createPlayer() {
        Player player = new Player(playerName, playerPassword);
        XMLWriteAndRead.writeXML(player);
        System.out.println("Player " + playerName + " Created!");
        PlayerFrame playerFrame = new PlayerFrame(player);
        PlayerPanel playerPanel = new PlayerPanel(player);
        loginFrame.showFrame(false);
    }

    public boolean isEmptyField() {
        if (playerName.isEmpty() || playerPassword.isEmpty()) {
            return true;
        }
        return false;
    }

}