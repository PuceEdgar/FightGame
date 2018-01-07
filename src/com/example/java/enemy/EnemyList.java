package com.example.java.enemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyList {

    private Enemy enemy;
    private List<Enemy> enemies = new ArrayList<>();

    public EnemyList() {
        enemies.add(new Enemy("Evil", 100));
        enemies.add(new Enemy("Anger", 100));
        enemies.add(new Enemy("Tom", 100));
        enemies.add(new Enemy("John", 100));
        enemies.add(new Enemy("Elvis", 100));
        enemies.add(new Enemy("Drake", 100));
    }


    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public Enemy getRandomEnemy() {
        int listSize = enemies.size();
        Random random = new Random();
        enemy = enemies.get(random.nextInt(listSize));
        return enemy;
    }
}
