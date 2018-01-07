package com.example.java.player;

import java.util.concurrent.atomic.AtomicBoolean;

public class Player {

    private String name;
    private String password;
    private int health;
    private int experience;
    private int currentHealth;

    public Player () {

    }

    public Player(String name, String password) {
        this.name = name;
        this.password = password;
        this.health = 100;
        this.experience = 1;
        this.currentHealth = this.getHealth();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
       this.experience = this.experience + experience;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;

    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", health=" + health +
                ", experience=" + experience +
                ", currentHealth=" + currentHealth +
                '}';
    }
}
