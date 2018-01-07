package com.example.java;


import com.example.java.frames.LoginFrame;
import com.example.java.utils.MakeDirectory;

import java.io.File;

public class Main {


    public static void main(String[] args) {

        LoginFrame loginFrame = new LoginFrame();
        MakeDirectory.make();

    }


}
