package com.example.java.listeners;

import com.example.java.player.Player;
import com.example.java.utils.XMLFileEditor;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventListener implements WindowListener{

    private Player player;

    public WindowEventListener(Player player) {
        this.player = player;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("window is closing");
        XMLFileEditor.editXML(player, "currenthealth");
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
