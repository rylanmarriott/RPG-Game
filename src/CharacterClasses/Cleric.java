package CharacterClasses;

import javax.swing.*;
import GUI.ChoosePanel;

public class Cleric extends Character {


    private ImageIcon clericPic;
    private String name ;
    //Constructor

    public Cleric(String name, int baseAttack, int defense, int agility, int hitPoints) {
        super(name, baseAttack, defense, agility,  hitPoints);

        clericPic = new ImageIcon(this.getClass().getResource("/Images/dwarf.png"));
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
