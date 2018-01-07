package com.example.java.utils;

public class Attack {

    public static int attack() {
        double doubleDamage = Math.random() * 10;
        int damage = (int) Math.ceil(doubleDamage);
        return damage;
    }
}
