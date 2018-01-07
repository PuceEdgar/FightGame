package com.example.java.utils;

import java.io.File;

public class MakeDirectory {


    public static void make() {

        String userHomeDir = System.getProperty("user.home");
        File playerDir = new File(userHomeDir + "/FightGamePlayers");
        if (!playerDir.exists()) {
            new File(userHomeDir + "/FightGamePlayers").mkdir();
            System.out.println("new dir created");
        } else {
            System.out.println("dir exists");
        }
    }
}
