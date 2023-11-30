package CharacterClasses;

import GUI.ChoosePanel;

import javax.swing.*;

public class Warrior extends Character {



    private ImageIcon warriorPic;

    private String name ;


    //Constructors

    public Warrior(String name, int baseAttack, int defense, int agility, int hitPoints) {
        super(name, baseAttack, defense, agility,  hitPoints);
        warriorPic = new ImageIcon(this.getClass().getResource("/Images/fighter.png"));
    }
    public String getName() {

        return name;
    }
    //
    public void setName(String name) {
        this.name = name;
    }


    public ImageIcon getWarriorPic() {
        return warriorPic;
    }

    public void setWarriorPic(ImageIcon monsterPic) {
        this.warriorPic = warriorPic;
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

        return "Fighters are often human.Have higher HP and defence but low agility.";
    }
}
