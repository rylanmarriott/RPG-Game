package CharacterClasses;

import GUI.ChoosePanel;
import WeaponClasses.Weapon;

public abstract class Character {

    //Declare properties of ANY shape
    private String name;
    private Weapon weapon;
    private int baseAttack;
    private int defense;
    private int agility;
    private int hitPoints;


    public Character(String name, int attack, int weight, int agility, int hitPoints) {
        this.name = name;
        int[] stats = ChoosePanel.getTextFieldsData();
        this.baseAttack = stats[0];
        this.defense = stats[1];
        this.agility = stats[2];
        this.hitPoints = stats[3];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    //Define a getArea() method, to be inherited by subclasses
    //public abstract double getArea();
    public abstract String getCharactorInformString();


    public String toString() {
        return "My name is " + name + ". My weapon is " + (weapon != null ? weapon.getWeaponInformString() : "none") + ".";
    }

    public abstract String getWeaponInformString();
}