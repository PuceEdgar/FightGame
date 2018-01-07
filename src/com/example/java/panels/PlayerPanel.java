package com.example.java.panels;

import com.example.java.player.Player;

import javax.swing.*;

public class PlayerPanel {

    private Player player;

    private JPanel playerPanel;

    private JLabel playerName, playerHealth2;

    public PlayerPanel(Player player) {
        this.player = player;
        playerPanel = new JPanel();
        playerName = new JLabel("Name: " + player.getName());
        playerHealth2 = new JLabel(String.valueOf(player.getCurrentHealth()));
        Box playerBox = Box.createVerticalBox();
        playerBox.add(playerName);
        playerBox.add(playerHealth2);
        playerPanel.add(playerBox);
    }

    public  JPanel getPlayerPanel() {
        return playerPanel;
    }

    public  JLabel getPlayerHealth() {
        return playerHealth2;
    }
}
