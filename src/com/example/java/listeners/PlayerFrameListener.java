package com.example.java.listeners;

import com.example.java.frames.FightFrame;
import com.example.java.frames.PlayerFrame;
import com.example.java.utils.XMLFileEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerFrameListener implements ActionListener {

    private PlayerFrame playerFrame;

    public PlayerFrameListener(PlayerFrame playerFrame) {
        this.playerFrame = playerFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playerFrame.getFightButton()) {
            playerFrame.getTimerTask().cancel();
            playerFrame.showFrame(false);
            FightFrame fightFrame = new FightFrame(playerFrame.getPlayer());

        }
        if (e.getSource() == playerFrame.getExitButton()) {
            XMLFileEditor.editXML(playerFrame.getPlayer(), "currenthealth");
            System.exit(0);
        }

    }
}
