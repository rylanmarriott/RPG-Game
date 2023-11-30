package WeaponClasses;
import javax.swing.*;
public class Dagger extends Weapon{
    private ImageIcon daggerPic;

    //Constructors
    public Dagger(int attack, int weight) {
        super(attack, weight);

        daggerPic = new ImageIcon(this.getClass().getResource("/Images/dagger.png"));
    }
    public ImageIcon getDaggerPic() {return daggerPic;}
    public void setDaggerPic(ImageIcon daggerPic) {this.daggerPic = daggerPic;}
    @Override
    public String getCharacterInformString(){return null;}

    @Override
    public String toString() {return "I'm a circle name " + "." + super.toString();}

    @Override
    public String getWeaponInformString(){
        return"A dagger is a light and fast weapon. " +
                "Classes with high agility are very effective when using this weapon. " +
                "It can maintain fast attack speed, but the increase in additional attack power is not high.";
    }
}
