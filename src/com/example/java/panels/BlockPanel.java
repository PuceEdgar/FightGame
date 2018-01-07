package com.example.java.panels;

import javax.swing.*;

public class BlockPanel {

    private JPanel blockPanel;
    private JRadioButton blockHead, blockStomach, blockLegs;
    private ButtonGroup blockGroup;
    private Box blockBox;

    public BlockPanel(){
        blockPanel = new JPanel();

        blockHead = new JRadioButton("head");
        blockStomach = new JRadioButton("stomach");
        blockLegs = new JRadioButton("legs");

        blockGroup = new ButtonGroup();
        blockGroup.add(blockHead);
        blockGroup.add(blockStomach);
        blockGroup.add(blockLegs);

        blockPanel.add(blockHead);
        blockPanel.add(blockStomach);
        blockPanel.add(blockLegs);

        blockHead.setSelected(true);


        blockBox = Box.createVerticalBox();
        blockBox.add(blockHead);
        blockBox.add(blockStomach);
        blockBox.add(blockLegs);
        blockPanel.add(blockBox);

    }

    public JPanel getBlockPanel(){
        return blockPanel;
    }


    public ButtonGroup getBlockGroup() {
        return blockGroup;
    }




}
