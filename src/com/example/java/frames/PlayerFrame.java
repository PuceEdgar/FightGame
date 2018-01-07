package com.example.java.frames;

import com.example.java.listeners.PlayerFrameListener;
import com.example.java.listeners.WindowEventListener;
import com.example.java.player.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.Timer;
import java.util.TimerTask;

public class PlayerFrame{

    private Player player;
    private JFrame playerFrame;
    private JFrame fightFrame;
    private JPanel mainPanel;
    private JLabel playerExperience;
    private JLabel playerHealth;
    private JButton fightButton, exitButton;
   final private Timer timer = new Timer();
    private TimerTask timerTask;
    private PlayerFrameListener playerFrameListener;
    private WindowEventListener windowEventListener;

    public PlayerFrame(Player player) {
        this.player = player;
        playerFrame = new JFrame();
        playerFrame.setSize(500,500);
        playerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playerFrame.setLocationRelativeTo(null);
        mainPanel = new JPanel();
        playerExperience = new JLabel("Experience: " + String.valueOf(player.getExperience()));
        playerHealth = new JLabel("Health: " + String.valueOf(player.getCurrentHealth() + "/" + String.valueOf(player.getHealth())));

        recoverHealth();

        Border playerBorder = BorderFactory.createTitledBorder(player.getName());
        mainPanel.setBorder(playerBorder);

        fightButton = new JButton("Fight");
        playerFrameListener = new PlayerFrameListener(this);
        fightButton.addActionListener(playerFrameListener);
        exitButton = new JButton("Save and Exit");
        exitButton.addActionListener(playerFrameListener);

        Box playerBox = Box.createVerticalBox();
        playerBox.add(playerHealth);
        playerBox.add(playerExperience);
        playerBox.add(fightButton);
        playerBox.add(exitButton);

        windowEventListener = new WindowEventListener(this.player);
        playerFrame.addWindowListener(windowEventListener);

        mainPanel.add(playerBox);
        playerFrame.add(mainPanel);
        playerFrame.setVisible(true);

    }

    public void recoverHealth() {

            timerTask = new TimerTask() {
                @Override
                public void run() {
                    if (player.getCurrentHealth() < 100) {
                        int h = getPlayer().getCurrentHealth();
                        getPlayer().setCurrentHealth(h+1);
                        playerHealth.setText("Health: " + String.valueOf(getPlayer().getCurrentHealth() + "/" + String.valueOf(getPlayer().getHealth())));
                        if ((getPlayer().getCurrentHealth() == 100)) {
                            timerTask.cancel();
                            timer.cancel();
                            timer.purge();
                        }
                    }

                }
            };
            timer.scheduleAtFixedRate(timerTask, 1000, 1000);

    }

    public Timer getTimer() {
        return timer;
    }

    public TimerTask getTimerTask() {
        return timerTask;
    }

    public void setTimerTask(TimerTask timerTask) {
        this.timerTask = timerTask;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public  JLabel setPlayerExperience() {
        playerExperience.setText("Experience: " + String.valueOf(player.getExperience()));
        return playerExperience;
    }

    public  JLabel setPlayerHealth() {
        playerHealth.setText("Health: " + String.valueOf(player.getCurrentHealth() + "/" + String.valueOf(player.getHealth())));
        return playerHealth;
    }

    public  JFrame getPlayerFrame() {
        playerFrame.setVisible(true);
        return playerFrame;
    }

    public void showFrame(boolean b) {
        playerFrame.setVisible(b);
    }

    public JButton getFightButton() {
        return fightButton;
    }

    public void setFightButton(JButton fightButton) {
        this.fightButton = fightButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }
}
