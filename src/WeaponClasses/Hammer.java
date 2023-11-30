package WeaponClasses;
import javax.swing.*;
public class Hammer extends Weapon{
    private ImageIcon hammerPic;

    //Constructors
    public Hammer(int attack, int weight) {
        super(attack, weight);

        hammerPic = new ImageIcon(this.getClass().getResource("/Images/hammer.png"));
    }
    public ImageIcon getHammerPic() {return hammerPic;}
    public void setHammerPic(ImageIcon hammerPic) {this.hammerPic = hammerPic;}
    @Override
    public String getCharacterInformString(){return null;}

    @Override
    public String toString() {return "I'm a circle name " + "." + super.toString();}

    @Override
    public String getWeaponInformString(){
        return"The hammer is a weapon with powerful attack power. " +
                "A single attack can create a high hit point. " +
                "However, it is a hevay weapon and has a slow attack speed. ";
    }
}
