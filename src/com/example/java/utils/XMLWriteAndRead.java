package com.example.java.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.java.player.Player;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XMLWriteAndRead {


    public static void writeXML(Player player) {

        try {
            Document doc = new Document();
            Element theRoot = new Element("root");
            doc.setRootElement(theRoot);

            Element user = new Element("player");
            user.setAttribute("id", "1");



            //---- start ---
            Element name = new Element("name");
            name.setAttribute("property", "name");
            name.addContent(new Text(player.getName()));

            Element password = new Element("password");
            password.setAttribute("property", "password");
            password.addContent(new Text(player.getPassword()));

            Element experience = new Element("experience");
            experience.setAttribute("property", "experience");
            experience.addContent(new Text(String.valueOf(player.getExperience())));

            Element health = new Element("health");
            health.setAttribute("property", "health");
            health.addContent(new Text(String.valueOf(player.getHealth())));

            Element currentHealth = new Element("currenthealth");
            currentHealth.setAttribute("property", "currenthealth");
            currentHealth.addContent(new Text(String.valueOf(player.getCurrentHealth())));


            user.addContent(name);
            user.addContent(password);
            user.addContent(experience);
            user.addContent(health);
            user.addContent(currentHealth);
            theRoot.addContent(user);
            //--- end ---

            XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
            String userHomeDir = System.getProperty("user.home");

            xmlOutput.output(doc, new FileOutputStream(new File(userHomeDir + "/FightGamePlayers/player" + player.getName() + ".xml")));

            System.out.println("wrote to file!");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    public static Player readXML(Player player) {
        SAXBuilder builder = new SAXBuilder();
        String userHomeDir = System.getProperty("user.home");

        try{
            Document readDoc = builder.build(new File(userHomeDir +"/FightGamePlayers/player" + player.getName() + ".xml"));
            Element plElement = readDoc.getRootElement().getChild("player");

            player = new Player();

            player.setName(plElement.getChildText("name"));
            player.setPassword(plElement.getChildText("password"));
            player.setHealth(Integer.parseInt(plElement.getChildText("health")));
            player.setExperience(Integer.parseInt(plElement.getChildText("experience")));
            player.setCurrentHealth(Integer.parseInt(plElement.getChildText("currenthealth")));

            System.out.println(player);
            return player;

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch (JDOMException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

}
