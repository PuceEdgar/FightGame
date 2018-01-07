package com.example.java.panels;

import com.example.java.enemy.Enemy;

import javax.swing.*;

public class EnemyPanel {

    private Enemy enemy;
    private JPanel enemyPanel;
    private JLabel enemyName, enemyHealth;

    public EnemyPanel(Enemy enemy) {
        this.enemy = enemy;
        this.enemyPanel = new JPanel();
        this.enemyName = new JLabel("Name: " + enemy.getName());
        this.enemyHealth = new JLabel(String.valueOf(enemy.getCurrentHealth()));
        Box enemyBox = Box.createVerticalBox();
        enemyBox.add(enemyName);
        enemyBox.add(enemyHealth);
        this.enemyPanel.add(enemyBox);
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public JPanel getEnemyPanel() {
        return enemyPanel;
    }

    public void setEnemyPanel(JPanel enemyPanel) {
        this.enemyPanel = enemyPanel;
    }

    public JLabel getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(JLabel enemyName) {
        this.enemyName = enemyName;
    }

    public JLabel getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(JLabel enemyHealth) {
        this.enemyHealth = enemyHealth;
    }
}
