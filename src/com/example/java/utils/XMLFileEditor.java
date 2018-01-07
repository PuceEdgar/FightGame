package com.example.java.utils;

import com.example.java.player.Player;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLFileEditor {

    static DocumentBuilderFactory factory;
    static DocumentBuilder builder;
    static Document doc;
    static String fileName;

    public static void editXML(Player player, String tagName) {
        String userHomeDir = System.getProperty("user.home");

        try {

            fileName = userHomeDir + "/FightGamePlayers/player" + player.getName() + ".xml";
             factory = DocumentBuilderFactory.newInstance();
             builder = factory.newDocumentBuilder();
             doc = builder.parse(fileName);

            if (tagName.equals("experience")) {
                setExperience();
            } else if (tagName.equals("currenthealth")) {
                setCurrentHealth(player.getCurrentHealth());
            }


            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            //initialize StreamResult with File object to save to file
            StreamResult result = new StreamResult(new File(fileName));
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void setExperience() {

        Node experience = doc.getElementsByTagName("experience").item(0);
        int currentExp = Integer.parseInt(experience.getTextContent());
        String newExp = String.valueOf(currentExp+5);
        experience.setTextContent(newExp);
    }

    public static void setCurrentHealth(int health) {
        Node currentHealth = doc.getElementsByTagName("currenthealth").item(0);
        //int health = Integer.parseInt(currentHealth.getTextContent());
        String newHealth = String.valueOf(health);
        currentHealth.setTextContent(newHealth);
    }
}
