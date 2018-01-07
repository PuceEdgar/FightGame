package com.example.java.listeners;

import com.example.java.enemy.Enemy;
import com.example.java.frames.FightFrame;
import com.example.java.player.Player;
import com.example.java.frames.PlayerFrame;
import com.example.java.utils.Attack;
import com.example.java.utils.GroupButtonsUtils;
import com.example.java.utils.XMLFileEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FightFrameListener implements ActionListener {

    private FightFrame fightFrame;
    private Player player;
    private Enemy enemy;
    private PlayerFrame playerFrame;
    private String playerHitOption;
    private String playerBlockOption;
    private String enemyHitOption;
    private String enemyBlockOption;
    private int playerHit;
    private int playerHealth;
    private int enemyHit;
    private int enemyHealth;

    public FightFrameListener(FightFrame fightFrame) {
        this.fightFrame = fightFrame;
        this.player = fightFrame.getPlayer();
        this.enemy = fightFrame.getEnemy();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fightFrame.getButton()) {
            setValues();

            if (!playerHitOption.equals(enemyBlockOption)) {
                playerHitsEnemy();
            } else {
                enemyBlocksPlayersHit();
            }

            if (!enemyHitOption.equals(playerBlockOption)) {
                enemyHitsPlayer();
            } else {
                playerBlocksEnemyHit();
            }

            if (enemyHealth <= 0) {
                playerWin();
            }

            if (playerHealth <= 0) {
                playerLost();
            }

        }

    }

    public void setValues() {
        playerHitOption = GroupButtonsUtils.getSelectedButtonText(fightFrame.getHitGroup());
        playerBlockOption = GroupButtonsUtils.getSelectedButtonText(fightFrame.getBlockGroup());
        enemyHitOption = enemyMove();
        enemyBlockOption = enemyMove();
        playerHealth = player.getCurrentHealth();
        enemyHealth = enemy.getCurrentHealth();
    }

    public void playerHitsEnemy() {
        playerHit = Attack.attack();
        enemyHealth = enemyHealth - playerHit;
        enemy.setCurrentHealth(enemyHealth);
        fightFrame.getEnemyPanel().getEnemyHealth().setText(String.valueOf(enemy.getCurrentHealth()));
        fightFrame.getGameResult().append(player.getName() + " hit " + enemy.getName() + "'s " + playerHitOption + " and did " + playerHit + " damage\n");
        fightFrame.setGameResult(fightFrame.getGameResult());
    }

    public void enemyBlocksPlayersHit() {
        fightFrame.getGameResult().append(player.getName() + " hit " + enemy.getName() + "'s " + playerHitOption + " but " + enemy.getName() + " blocked it\n");
        fightFrame.setGameResult(fightFrame.getGameResult());
    }

    public void enemyHitsPlayer() {
        enemyHit = Attack.attack();
        playerHealth = playerHealth-enemyHit;
        player.setCurrentHealth(playerHealth);
        fightFrame.getPlayerPanel().getPlayerHealth().setText(String.valueOf(player.getCurrentHealth()));
        fightFrame.getGameResult().append(enemy.getName() + " hit " + player.getName() + "'s " + enemyHitOption + " and did " + enemyHit + " damage\n");
        fightFrame.setGameResult(fightFrame.getGameResult());
    }

    public void playerBlocksEnemyHit() {
        fightFrame.getGameResult().append(enemy.getName() + " hit " + player.getName() + "'s " + enemyHitOption + " but " + player.getName() + " blocked it\n");
        fightFrame.setGameResult(fightFrame.getGameResult());
    }

    public void playerWin() {
        JOptionPane.showMessageDialog(fightFrame, "you win!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
        player.setExperience(+5);
        XMLFileEditor.editXML(player, "experience");
        player.setCurrentHealth(playerHealth);


        fightFrame.getFightFrame().setVisible(false);
        playerFrame = new PlayerFrame(this.player);
        enemy.setCurrentHealth(enemy.geteHealth());
    }

    public void playerLost() {
        JOptionPane.showMessageDialog(fightFrame, "you lose!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
        if (player.getCurrentHealth() < 0) {
            player.setCurrentHealth(0);
        }
        fightFrame.getFightFrame().setVisible(false);
        playerFrame = new PlayerFrame(player);
        enemy.setCurrentHealth(enemy.geteHealth());
    }

    public String enemyMove(){
        String enemyMove;
        String[] movesList = {"head", "stomach", "legs"};
        Random random = new Random();
        enemyMove = movesList[random.nextInt(movesList.length)];
        return enemyMove;
    }
}
