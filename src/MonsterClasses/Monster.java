package MonsterClasses;

import WeaponClasses.Weapon;

import javax.swing.*;

public class Monster {
    private ImageIcon monsterPic;
    private String name;
    private Weapon weapon;
    public void setMonsterPic(ImageIcon monsterPic) {
        this.monsterPic = monsterPic;
    }
    public ImageIcon getMonsterPic() {
        return monsterPic;
    }
    public Monster(String name) {
        this.name = name;

    }

}