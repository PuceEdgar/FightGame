package com.example.java.frames;


import com.example.java.enemy.EnemyList;
import com.example.java.panels.BlockPanel;
import com.example.java.panels.EnemyPanel;
import com.example.java.panels.HitPanel;
import com.example.java.listeners.FightFrameListener;
import com.example.java.enemy.Enemy;
import com.example.java.panels.PlayerPanel;
import com.example.java.player.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class FightFrame extends JFrame {

   private Player player;
   private Enemy enemy;
   private EnemyList enemyList;
   private JFrame fightFrame;
   private JButton button;
   private ButtonGroup hitGroup, blockGroup;
   private JPanel mainPanel;
   private PlayerPanel playerPanel;
   private EnemyPanel enemyPanel;
   private JPanel hitPanel, blockPanel, gamePanel;
   private JTextArea gameResult;
   private FightFrameListener listenForButton;


    public FightFrame (Player player) {
        fightFrame = new JFrame();
        this.player = player;
        this.enemyList = new EnemyList();
        this.enemy = enemyList.getRandomEnemy();
        fightFrame.setSize(400,500);
        Dimension frameDim = new Dimension();
        frameDim.setSize(500,600);
        fightFrame.setMaximumSize(frameDim);
        fightFrame.setMinimumSize(frameDim);
        fightFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fightFrame.setTitle("Fight Game");
        fightFrame.setLocationRelativeTo(null);

        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        HitPanel hit = new HitPanel();
        BlockPanel block = new BlockPanel();

        playerPanel = new PlayerPanel(player);
        gamePanel = new JPanel();
        hitPanel = hit.getHitPanel();
        blockPanel = block.getBlockPanel();
        enemyPanel = new EnemyPanel(enemy);

        Border playerBorder = BorderFactory.createTitledBorder("Player");
        Border gameBorder = BorderFactory.createTitledBorder("Game");
        Border hitBorder = BorderFactory.createTitledBorder("Hit");
        Border blockBorder = BorderFactory.createTitledBorder("Block");
        Border enemyBorder = BorderFactory.createTitledBorder("Enemy");

        playerPanel.getPlayerPanel().setBorder(playerBorder);
        gamePanel.setBorder(gameBorder);
        hitPanel.setBorder(hitBorder);
        blockPanel.setBorder(blockBorder);
        enemyPanel.getEnemyPanel().setBorder(enemyBorder);

        //ATTACK
        hitGroup = hit.getHitGroup();

        //BLOCK
        blockGroup = block.getBlockGroup();

        button = new JButton("Make your move!");
        listenForButton = new FightFrameListener(this);
        button.addActionListener(listenForButton);


        Box gameBox = Box.createVerticalBox();
        gameBox.add(hitPanel);
        gameBox.add(blockPanel);
        gameBox.add(button, BorderLayout.CENTER);

        gameResult = new JTextArea();
        gameResult.setEditable(false);

        Border gameEvent = BorderFactory.createTitledBorder("Passed moves");

        gameResult.setBorder(gameEvent);

        JScrollPane scrollPane = new JScrollPane(gameResult);
        Dimension dimension = new Dimension();
        dimension.setSize(300,250);
        scrollPane.setPreferredSize(dimension);

        gamePanel.add(gameBox);
        mainPanel.add(playerPanel.getPlayerPanel());
        mainPanel.add(gamePanel);
        mainPanel.add(enemyPanel.getEnemyPanel());
        mainPanel.add(scrollPane);
        fightFrame.add(mainPanel);
        fightFrame.setVisible(true);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public JFrame getFightFrame() {
        return fightFrame;
    }

    public void setFightFrame(JFrame fightFrame) {
        this.fightFrame = fightFrame;
    }


    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public ButtonGroup getHitGroup() {
        return hitGroup;
    }

    public void setHitGroup(ButtonGroup hitGroup) {
        this.hitGroup = hitGroup;
    }

    public ButtonGroup getBlockGroup() {
        return blockGroup;
    }

    public void setBlockGroup(ButtonGroup blockGroup) {
        this.blockGroup = blockGroup;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public PlayerPanel getPlayerPanel() {
        return playerPanel;
    }

    public void setPlayerPanel(PlayerPanel playerPanel) {
        this.playerPanel = playerPanel;
    }

    public JPanel getHitPanel() {
        return hitPanel;
    }

    public void setHitPanel(JPanel hitPanel) {
        this.hitPanel = hitPanel;
    }

    public JPanel getBlockPanel() {
        return blockPanel;
    }

    public void setBlockPanel(JPanel blockPanel) {
        this.blockPanel = blockPanel;
    }

    public EnemyPanel getEnemyPanel() {
        return enemyPanel;
    }

    public void setEnemyPanel(JPanel enemyPanel) {
        this.enemyPanel.setEnemyPanel(enemyPanel);
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(JPanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public JTextArea getGameResult() {
        return gameResult;
    }

    public void setGameResult(JTextArea gameResult) {
        this.gameResult = gameResult;
    }

}
