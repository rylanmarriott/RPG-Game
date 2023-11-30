package CharacterClasses;

import GUI.ChoosePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Wizard extends Character {

    private ImageIcon wizardPic;

    private String name ;


    public Wizard(String name, int baseAttack, int defense, int agility, int hitPoints) {
        super(name, baseAttack, defense, agility, hitPoints);
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("Images/wizard.png");
        if (is != null) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(is);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            wizardPic = new ImageIcon(img);
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public String getName() { return name;
    }
    //
    public void setName(String name) {
        this.name = name;
    }

    public ImageIcon getWizardPic() {
        return wizardPic;
    }

    public void setWizardPic(ImageIcon wizardPic) {
        this.wizardPic = wizardPic;
    }

    //toString method to return a description of the object.
    @Override
    public String toString() {
        int[] stats = ChoosePanel.getTextFieldsData();
        int[] monsStats = ChoosePanel.getSelectMonster();
        String monsterName = ChoosePanel.getMonsterName();
        return String.format("Player : %-10s\n---------------------" +
                        "\nClass  : %-10s" +
                        "\nHP     : %-3d               Attack Point : %-3d          Defense : %-3d          Agility : %-3d" +
                        "\nWeapon : %-13s Weight : %-3d               Attack Mod : %-3d" +
                        "\n\n" +

                        "Monster Name : %-10s\n---------------------" +
                        "\nHP       : %-3d               Defence     : %-3d          Base Attack : %-3d",
                name,
                ChoosePanel.getCharacterType(),
                100,
                stats[0],
                stats[1],
                stats[2],
                ChoosePanel.getWeaponType(),
                stats[5],
                stats[4],
                monsterName,
                50,
                monsStats[0],
                monsStats[1]);
    }

    @Override
    public String getWeaponInformString() {
        return null;
    }

    @Override
    public String getCharactorInformString() {

        return "Wizards are usually elf. Have higher hit points but low defense ";
    }


}
