package GUI;

import CharacterClasses.Cleric;
import CharacterClasses.Warrior;
import CharacterClasses.Wizard;
import WeaponClasses.Dagger;
import WeaponClasses.Hammer;
import WeaponClasses.Sword;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
public class ChoosePanel extends JPanel {

    //Some controls need to be declared at the class level, if referenced in multiple places
    private JButton battleStartBtn,rerollBtn;
    private JTextArea characterInformation ,weaponInformation;
    private JLabel imageLabel,imageLabelWeapon;
    private static JTextField nameText;
    private JRadioButton rdoWarrior,rdoWizard,rdoCleric;
    private JRadioButton rdoDagger;
    private JRadioButton rdoSword;
    private JRadioButton rdoHammer;

    private Warrior warrior = null;
    private Wizard wizard = null;
    private Cleric cleric = null;

    private Dagger dagger = null;
    private Sword sword = null;
    private Hammer hammer = null;

    private static JTextField textField1;
    private static JTextField textField2;
    private static JTextField textField3;
    private static JTextField textField4;
    private static JTextField textField5;
    private static JTextField textField6;
    private static JTextField textField7;

    private static String CharacterType;
    private static String currentMonsterName;
    private static String weaponType;
    private ImageIcon monsterPic;
    public ChoosePanel() {

        //Set font object
        Font myFont = new Font("Calibri", Font.BOLD, 22);
        Font screenTitle = new Font("Calibri", Font.BOLD, 40);
        Font selectTile = new Font("Calibri", Font.BOLD, 30);
        Font informaion = new Font("Calibri", Font.BOLD, 18);
        //Set Panel Properties
        setLayout(null);
        setVisible(true);
        //Create all GUI objects
        //Radiobutton for each shape
        addCharacterStats(myFont);
        addWeaponSelect(myFont);

        JLabel titleLabel = new JLabel("Character Generator");
        titleLabel.setFont(screenTitle);
        titleLabel.setBounds(50, 20, 500, 50);

        //Label control for name
        JLabel enterNameLabel = new JLabel("Enter Name:");
        enterNameLabel.setFont(selectTile);
        enterNameLabel.setBounds(50, 70, 200, 50);

        JLabel characterTypeLabel = new JLabel("Character Type");
        characterTypeLabel.setFont(selectTile);
        characterTypeLabel.setBounds(50, 120, 300, 50);
        add(characterTypeLabel);

        JLabel characterStatsLabel = new JLabel("Character Stats");
        characterStatsLabel.setFont(selectTile);
        characterStatsLabel.setBounds(500, 120, 300, 50);
        add(characterStatsLabel);

        JLabel chaHit = new JLabel("Hit Points");
        chaHit.setFont(myFont);
        chaHit.setBounds(500, 170, 300, 30);
        add(chaHit);

        JLabel chaDef = new JLabel("Defence");
        chaDef.setFont(myFont);
        chaDef.setBounds(500, 205, 300, 30);
        add(chaDef);

        JLabel chaAgi = new JLabel("Agility");
        chaAgi.setFont(myFont);
        chaAgi.setBounds(500, 240, 300, 30);
        add(chaAgi);

        JLabel chaBaseAtt = new JLabel("Strength");
        chaBaseAtt.setFont(myFont);
        chaBaseAtt.setBounds(500, 275, 300, 30);
        add(chaBaseAtt);

        JLabel weaponLabel = new JLabel("Select your Weapon");
        weaponLabel.setFont(selectTile);
        weaponLabel.setBounds(50, 400, 300, 50);
        add(weaponLabel);

        JLabel weaponStatsLabel = new JLabel("Weapon Stats");
        weaponStatsLabel.setFont(selectTile);
        weaponStatsLabel.setBounds(500, 400, 300, 50);
        add(weaponStatsLabel);

        JLabel weaponAttack = new JLabel("Attack Modifier");
        weaponAttack.setFont(myFont);
        weaponAttack.setBounds(500, 460, 290, 30);
        add(weaponAttack);

        JLabel weaponWeight = new JLabel("Weight");
        weaponWeight.setFont(myFont);
        weaponWeight.setBounds(500, 500, 300, 30);
        add(weaponWeight);

        //Textfield control for name
        nameText = new JTextField();
        nameText.setFont(myFont);
        nameText.setBounds(260, 70, 200, 50);

        //Labels to show dimensions of each shape in a single field
        characterInformation = new JTextArea();
        characterInformation.setLineWrap(true);
        characterInformation.setFont(myFont);
        characterInformation.setBounds(50, 320, 400, 70);

        weaponInformation = new JTextArea();
        weaponInformation.setLineWrap(true);
        weaponInformation.setFont(informaion);
        weaponInformation.setBounds(50, 630, 400, 90);

        //Label for shape image
        imageLabel = new JLabel();
        imageLabel.setBounds(240, 170, 150, 150);

        imageLabelWeapon = new JLabel();
        imageLabelWeapon.setBounds(240, 450, 150, 150);

        //Change screen button
        battleStartBtn = new JButton("Start Battle");
        battleStartBtn.setFont(myFont);
        battleStartBtn.setBounds(500, 700, 200, 50);

        rerollBtn = new JButton("Reroll");
        rerollBtn.setFont(myFont);
        rerollBtn.setBounds(500, 320, 200, 50);

        //Add all controls to Panel
        add(rdoWarrior);
        add(rdoWarrior);
        add(rdoCleric);
        add(rdoDagger);
        add(rdoSword);
        add(rdoHammer);
        add(titleLabel);
        add(enterNameLabel);
        add(nameText);
        add(imageLabel);
        add(imageLabelWeapon);
        add(characterInformation);
        add(weaponInformation);
        add(battleStartBtn);
        add(rerollBtn);

        // Create text fields for displaying random numbers
        textField1 = new JTextField();
        textField1.setBounds(650, 170, 50, 30);
        textField2 = new JTextField();
        textField2.setBounds(650, 205, 50, 30);
        textField3 = new JTextField();
        textField3.setBounds(650, 240, 50, 30);
        textField4 = new JTextField();
        textField4.setBounds(650, 275, 50, 30);
        textField5 = new JTextField();
        textField5.setBounds(650, 460, 50, 30);
        textField6 = new JTextField();
        textField6.setBounds(650, 500, 50, 30);

        textField7 = new JTextField();
        //textField1 = new JTextField();

        add(textField1);
        add(textField2);
        add(textField3);
        add(textField4);
        add(textField5);
        add(textField6);
        getRerollBtn();
    }

    private void addWeaponSelect(Font myFont) {
        Font selectTile = new Font("Calibri", Font.BOLD, 30);
        // Create the Dagger radio button
        rdoDagger = new JRadioButton("Dagger");
        rdoDagger.setFont(myFont);
        rdoDagger.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // When the Dagger radio button is selected, get the Dagger object
                dagger = SecondFrame.getTheDagger();
                // Update the weapon information label with the Dagger's stats
                weaponInformation.setText(dagger.getWeaponInformString());
                // Update the weapon image to show the Dagger
                swapImagesWeapon(dagger.getDaggerPic());
                // Create the weapon stats panel
                createWeaponStats();
            }
        });

        // Create the Sword radio button
        rdoSword = new JRadioButton("Sword");
        rdoSword.setFont(myFont);
        rdoSword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // When the Sword radio button is selected, get the Sword object
                sword = SecondFrame.getTheSword();
                // Update the weapon information label with the Sword's stats
                weaponInformation.setText(sword.getWeaponInformString());
                // Update the weapon image to show the Sword
                swapImagesWeapon(sword.getSwordPic());
                // Create the weapon stats panel
                createWeaponStats();
            }
        });
        // Create the Hammer radio button
        rdoHammer = new JRadioButton("Hammer");
        rdoHammer.setFont(myFont);
        rdoHammer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // When the Hammer radio button is selected, get the Hammer object
                hammer = SecondFrame.getTheHammer();
                // Update the weapon information label with the Hammer's stats
                weaponInformation.setText(hammer.getWeaponInformString());
                // Update the weapon image to show the Hammer
                swapImagesWeapon(hammer.getHammerPic());
                // Create the weapon stats panel
                createWeaponStats();
            }
        });
        // Set the bounds for the Dagger, Sword, and Hammer radio buttons
        rdoDagger.setBounds(50, 460, 150, 50);
        rdoSword.setBounds(50, 520, 150, 50);
        rdoHammer.setBounds(50, 580, 150, 50);
    }

    private void addCharacterStats(Font myFont) {
        rdoWarrior = new JRadioButton("Warrior");
        rdoWarrior.setFont(myFont);
        rdoWarrior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                warrior = SecondFrame.getTheWarrior();
                characterInformation.setText(warrior.getCharactorInformString());
                swapImages(warrior.getWarriorPic());
                createCharacterStats();
            }
        });

        rdoWizard = new JRadioButton("Wizard");
        rdoWizard.setFont(myFont);
        rdoWizard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                wizard = SecondFrame.getTheWizard();
                characterInformation.setText(wizard.getCharactorInformString());
                swapImages(wizard.getWizardPic());
                createCharacterStats();
            }
        });

        rdoCleric = new JRadioButton("Cleric");
        rdoCleric.setFont(myFont);
        rdoCleric.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cleric = SecondFrame.getTheCleric();
                characterInformation.setText(cleric.getCharactorInformString());
                swapImages(cleric.getClericPic());
                createCharacterStats();
            }
        });

        rdoWarrior.setBounds(50, 170, 150, 50);
        rdoWizard.setBounds(50, 220, 150, 50);
        rdoCleric.setBounds(50, 270, 150, 50);

        //ButtonGroup to group the radio buttons
        ButtonGroup grpColorRadios = new ButtonGroup();
        grpColorRadios.add(rdoWarrior);
        grpColorRadios.add(rdoWizard);
        grpColorRadios.add(rdoCleric);
    }

    public void swapImages(ImageIcon image) {
        imageLabel.setIcon(image);
    }

    public void swapImagesWeapon(ImageIcon image) {
        imageLabelWeapon.setIcon(image);
    }

    private void getRerollBtn() {
        // Reroll button action listener
        rerollBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCharacterStats();
            }
        });
    }

    public void createCharacterStats() {
        String name = nameText.getText();
        if (rdoWarrior.isSelected()) {
            warrior = SecondFrame.getTheWarrior();
            warrior.setName(name);
            // Create 4 random numbers and put them in text boxes
            int[] nums = new int[4];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = (int) (Math.random() * 100);
            }
            textField1.setText(String.valueOf(nums[0]));
            textField2.setText(String.valueOf(nums[1]));
            textField3.setText(String.valueOf(nums[2]));
            textField4.setText(String.valueOf(nums[3]));
            textField7.setText("Warrior");
            CharacterType = "Warrior";

        } else if (rdoWizard.isSelected()) {
            // Create 4 random numbers and put them in text boxes
            wizard = SecondFrame.getTheWizard();
            wizard.setName(name);
            int[] nums = new int[4];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = (int) (Math.random() * 100);
            }
            textField1.setText(String.valueOf(nums[0]));
            textField2.setText(String.valueOf(nums[1]));
            textField3.setText(String.valueOf(nums[2]));
            textField4.setText(String.valueOf(nums[3]));
            CharacterType = "Wizard";
        } else if (rdoCleric.isSelected()) {

            cleric = SecondFrame.getTheCleric();
            cleric.setName(name);
            int[] nums = new int[4];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = (int) (Math.random() * 100);
            }
            textField1.setText(String.valueOf(nums[0]));
            textField2.setText(String.valueOf(nums[1]));
            textField3.setText(String.valueOf(nums[2]));
            textField4.setText(String.valueOf(nums[3]));
            CharacterType = "Cleric";
        }

    }

    public void createWeaponStats() {
        if (rdoDagger.isSelected()) {
            // Create 4 random numbers and put them in text boxes
            int[] nums = new int[2];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = (int) (Math.random() * 50);
            }
            textField5.setText(String.valueOf(nums[0]));
            textField6.setText(String.valueOf(nums[1]));
            weaponType = "Dagger";

        } else if (rdoHammer.isSelected()) {
            // Create 4 random numbers and put them in text boxes
            int[] nums = new int[2];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = (int) (Math.random() * 50);
            }
            textField5.setText(String.valueOf(nums[0]));
            textField6.setText(String.valueOf(nums[1]));
            weaponType = "Hammer";

        } else if (rdoSword.isSelected()) {
            // Create 4 random numbers and put them in text boxes
            int[] nums = new int[2];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = (int) (Math.random() * 50);
            }
            textField5.setText(String.valueOf(nums[0]));
            textField6.setText(String.valueOf(nums[1]));
            weaponType = "Sword";

        }
    }

    //     This method retrieves data from six text fields and returns an integer array containing the data.
//     If a text field is empty or contains a non-integer value, the corresponding element in the returned array is set to 0.
//     @return an integer array containing the data from the text fields
    public static int[] getTextFieldsData() {
        int[] data = new int[6];
        String value = textField1.getText().trim();
        if (value.isEmpty()) {
            Arrays.fill(data, 0);

        } else {
            data[0] = Integer.parseInt(textField1.getText());
            data[1] = Integer.parseInt(textField2.getText());
            data[2] = Integer.parseInt(textField3.getText());
            data[3] = Integer.parseInt(textField4.getText());
            data[4] = Integer.parseInt(textField5.getText());
            data[5] = Integer.parseInt(textField6.getText());

        }
        return data;
    }
    //Get the random monster number
    public static int[] getSelectMonster(){

        int[] monsterStats = new int[2];
        for (int i = 0; i < 2; i++) {
            monsterStats[i] = (int) (Math.random() * 100);
        }
        return monsterStats;
    }
    //    This method gets the name of the monster that the player will be facing in the game.
//    If the monster's name has not been set, a random name is chosen from a list of possible names.
//     @return the name of the monster
    public static String getMonsterName() {
        if (currentMonsterName == null) {
            Random rand = new Random();
            String[] monsterName = new String[3];
            int num = rand.nextInt(3);
            monsterName[0] = "Gazer";
            monsterName[1] = "Drakan";
            monsterName[2] = "Anuharte";

            currentMonsterName = monsterName[num];
        }

        return currentMonsterName;
    }
    // Returns the Start Battle button and sets its ActionListener to create a new character based on user input and pass it to the result window
    // If no character is selected, nothing happens
    // Uses getTextFieldsData() to get character stats and nameText to get character name
    // Uses rdoWarrior, rdoWizard, and rdoCleric to determine which character type to create
    public JButton getStartBattleBtn() {
        battleStartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] stats = getTextFieldsData();
                String name = nameText.getText();
                Character character = null;
                getSelectMonster();
                if (rdoWarrior.isSelected()) {
                    character = new Warrior(name, stats[0], stats[1], stats[2], stats[3]);
                } else if (rdoWizard.isSelected()) {
                    character = new Wizard(name, stats[0], stats[1], stats[2], stats[3]);
                } else if (rdoCleric.isSelected()) {
                    character = new Cleric(name, stats[0], stats[1], stats[2], stats[3]);
                }

                if (character != null) {
                    // Update the result window with the chosen character details
                    // or pass the character instance to the result window
                }
            }
        });

        return battleStartBtn;
    }
    public static String getCharacterType() {
        return CharacterType;
    }
    public static String getWeaponType() {
        return weaponType;
    }
}
