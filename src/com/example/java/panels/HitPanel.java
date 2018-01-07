package com.example.java.panels;

import javax.swing.*;

public class HitPanel{

    private JPanel hitPanel;
    private JRadioButton hitHead, hitStomach, hitLegs;
    private ButtonGroup hitGroup;
    private Box hitBox;

    public HitPanel(){
        hitPanel = new JPanel();

        hitHead = new JRadioButton("head");
        hitStomach = new JRadioButton("stomach");
        hitLegs = new JRadioButton("legs");

        hitGroup = new ButtonGroup();
        hitGroup.add(hitHead);
        hitGroup.add(hitStomach);
        hitGroup.add(hitLegs);

        hitPanel.add(hitHead);
        hitPanel.add(hitStomach);
        hitPanel.add(hitLegs);

        hitHead.setSelected(true);

        hitBox = Box.createVerticalBox();

        hitBox.add(hitHead);
        hitBox.add(hitStomach);
        hitBox.add(hitLegs);
        hitPanel.add(hitBox);

    }

    public JPanel getHitPanel(){
        return hitPanel;
    }

    public JRadioButton getHitHead() {
        return hitHead;
    }

    public void setHitHead(JRadioButton hitHead) {
        this.hitHead = hitHead;
    }

    public JRadioButton getHitStomach() {
        return hitStomach;
    }

    public void setHitStomach(JRadioButton hitStomach) {
        this.hitStomach = hitStomach;
    }

    public JRadioButton getHitLegs() {
        return hitLegs;
    }

    public void setHitLegs(JRadioButton hitLegs) {
        this.hitLegs = hitLegs;
    }

    public ButtonGroup getHitGroup() {
        return hitGroup;
    }

    public void setHitGroup(ButtonGroup hitGroup) {
        this.hitGroup = hitGroup;
    }

    public Box getHitBox() {
        return hitBox;
    }

    public void setHitBox(Box hitBox) {
        this.hitBox = hitBox;
    }
}
