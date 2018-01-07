package com.example.java.enemy;

import com.example.java.player.Player;

import javax.swing.*;

public class Enemy {


    private int currentHealth;
    private int eHealth;
    private String name;
    private JLabel enemyName, enemyHealth;

    public Enemy(String name, int health) {
        this.name = name;
        this.eHealth = health;
        this.currentHealth = this.geteHealth();

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

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    public int geteHealth() {
        return eHealth;
    }

    public void seteHealth(int eHealth) {
        this.eHealth = eHealth;
    }

    public int setCurrentHealth(int currentHealth) {
       return this.currentHealth = currentHealth;
    }


}
