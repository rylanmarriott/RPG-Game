package GUI;

import CharacterClasses.Cleric;
import CharacterClasses.Warrior;
import CharacterClasses.Wizard;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    private Warrior warrior;
    private Wizard wizard;
    private Cleric cleric;
    private JLabel characterImageLabel;
    private JLabel monsterImageLabel;
    private JTextArea displayText;
    private ImageIcon monsterPic;
    private SecondFrame secondFrame;

    private Boolean initial = true;
    public DisplayPanel(SecondFrame secondFrame) {
        this.secondFrame = secondFrame;
        // Create and set font for the text
        Font myFont = new Font("Calibri", Font.BOLD, 20);

        // Set panel layout and properties
        setLayout(null);

        // Create and set the title label
        JLabel choiceLabel = new JLabel("Battle To The Death!");
        choiceLabel.setFont(new Font("Calibri", Font.BOLD, 50));
        choiceLabel.setBounds(150, 10, 480, 50);

        // Create and set the text area
        displayText = new JTextArea();
        displayText.setBounds(50, 350, 650, 270);
        displayText.setFont(myFont);
        displayText.setLineWrap(true);
        displayText.setEnabled(false);
        displayText.setWrapStyleWord(true);

        // Create and set the character and monster image labels
        characterImageLabel = new JLabel();
        characterImageLabel.setBounds(200, 150, 150, 150);
        monsterImageLabel = new JLabel();
        monsterImageLabel.setBounds(400, 150, 150, 150);

        // Create a back button and add an action listener
        JButton backButton = new JButton("Back to Character Selection");
        backButton.setBounds(280, 650, 200, 50);
        backButton.addActionListener(e -> {
//

            initial = false;
            SwingUtilities.invokeLater(MainFrame::new);
            secondFrame.dispose(); // Close the current SecondFrame
        });

        // Add components to the panel
        add(choiceLabel);
        add(displayText);
        add(characterImageLabel);
        add(monsterImageLabel);
        add(backButton);
    }

    public void displayChoice() {
        // Get character instances from SecondFrame
        warrior = SecondFrame.getTheWarrior();
        wizard = SecondFrame.getTheWizard();
        cleric = SecondFrame.getTheCleric();

        // Initialize variables
        String monster = "";
        String text = "";

        // Display character image and information based on the selected character
        if (warrior.getName() != null && !warrior.getName().isEmpty()) {
            swapImages(warrior.getWarriorPic());
            text = warrior.toString();
        } else if (wizard.getName() != null && !wizard.getName().isEmpty()) {
            swapImages(wizard.getWizardPic());
            text = wizard.toString();
        } else if (cleric.getName() != null && !cleric.getName().isEmpty()) {
            swapImages(cleric.getClericPic());
            text = cleric.toString();
        }
        // Update display text with character information
        displayText.setText(text);

        // Display the selected monster image and name
        if (ChoosePanel.getMonsterName().equals("Gazer")) {
            monsterPic = new ImageIcon(this.getClass().getResource("/Images/monster.jpg"));
            monster = "Gazer";
        } else if (ChoosePanel.getMonsterName().equals("Drakan")) {
            monsterPic = new ImageIcon(this.getClass().getResource("/Images/monster2.jpg"));
            monster = "Drakan";
        } else {
            monsterPic = new ImageIcon(this.getClass().getResource("/Images/monster3.jpg"));
            monster = "Anuharte";
        }

        // Create and set player and monster labels
        JLabel playerLabel = new JLabel("Player :" + ChoosePanel.getCharacterType());
        playerLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        playerLabel.setBounds(170, 100, 400, 50);

        JLabel monsterLabel = new JLabel("Monster : " + monster);
        monsterLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        monsterLabel.setBounds(400, 100, 400, 50);

        // Add player and monster labels to the panel
        add(playerLabel);
        add(monsterLabel);

        // Set the monster image
        monsterImageLabel.setIcon(monsterPic);
    }

    // Swap character images based on the selected character
    public void swapImages(ImageIcon image) {
        characterImageLabel.setIcon(image);
    }

    // Swap monster images (This method is not currently used)
    public void swapImagesMonster(ImageIcon image) {
        monsterImageLabel.setIcon(image);
    }
}

