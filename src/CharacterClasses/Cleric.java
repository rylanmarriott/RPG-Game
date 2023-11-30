package CharacterClasses;

import javax.imageio.ImageIO;
import javax.swing.*;
import GUI.ChoosePanel;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Cleric extends Character {


    private ImageIcon clericPic;

    //Constructor

    public Cleric(String name, int baseAttack, int defense, int agility, int hitPoints) {
        super(name, baseAttack, defense, agility, hitPoints);
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("Images/dwarf.png");
        if (is != null) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(is);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            clericPic = new ImageIcon(img);
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }
    public ImageIcon getClericPic() {
        return clericPic;
    }

    public void setClericPic(ImageIcon clericPic) {
        this.clericPic = clericPic;
    }


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


    public String getCharactorInformString() {

        return "Clerics are usually dwarf. Have higher defense but low agility ";
    }


    public String getWeaponInformString() {
        return null;
    }
}
