package WeaponClasses;
import javax.swing.*;
public class Sword extends Weapon{
    private ImageIcon swordPic;

    //Constructors
    public Sword(int attack, int weight) {
        super(attack, weight);

        swordPic = new ImageIcon(this.getClass().getResource("/Images/sword.png"));
    }
    public ImageIcon getSwordPic() {return swordPic;}
    public void setSwordPic(ImageIcon swordPic) {this.swordPic = swordPic;}
    @Override
    public String getCharacterInformString(){return null;}

    @Override
    public String toString() {return "I'm a circle name " + "." + super.toString();}

    @Override
    public String getWeaponInformString(){
        return"A sword is a good all-round weapon. " +
                "It is not too heavy and inflicts a lot of damage.";
    }
}
