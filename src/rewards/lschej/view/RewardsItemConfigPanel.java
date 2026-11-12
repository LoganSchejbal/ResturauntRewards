package rewards.lschej.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import rewards.lschej.data.DataController;
import rewards.lschej.data.RewardItem;

public class RewardsItemConfigPanel extends JPanel {

    Font regular = new Font("Calibri", Font.PLAIN, 24);

    public RewardsItemConfigPanel(DataController dataController, RewardItem rewardItem, RewardsConfiutator parent) {
        setLayout(new GridBagLayout());

        JLabel itemNamePrompt = new JLabel("Item Name: ");
        itemNamePrompt.setFont(regular);
        JTextField itemNameField = new JTextField(rewardItem.getName());
        itemNameField.setFont(regular);
        itemNameField.setPreferredSize(new Dimension(350, 50));

        JLabel itemPricePrompt = new JLabel("Item Price: ");
        itemPricePrompt.setFont(regular);
        JTextField itemPriceField = new JTextField(Integer.toString(rewardItem.getPrice()));
        itemPriceField.setFont(regular);
        itemPriceField.setPreferredSize(new Dimension(150, 50));

        JLabel itemImagePrompt = new JLabel("Item Image");
        itemImagePrompt.setFont(regular);
        JLabel itemImage = new JLabel(new ImageIcon(rewardItem.getImage().getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        FileDialog fileChooser = new FileDialog((Frame) null, "Select an Image");
        fileChooser.setMode(FileDialog.LOAD);
        JButton itemImageSelection = new JButton("Select Image");
        itemImageSelection.setPreferredSize(new Dimension(200, 50));
        itemImageSelection.setFont(regular);
        itemImageSelection.addActionListener(e -> {
            fileChooser.setVisible(true);
            if (fileChooser.getFile() != null) {
                File selectedImage = new File(fileChooser.getDirectory(), fileChooser.getFile());
                Image rewardImage = new ImageIcon(selectedImage.getAbsolutePath()).getImage();
                itemImage.setIcon(new ImageIcon(rewardImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            }
        }
        );

        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(150, 75));
        submitButton.setFont(new Font("Calibri", Font.BOLD, 24));
        submitButton.setBackground(Color.blue);
        submitButton.setForeground(Color.white);
        submitButton.addActionListener(e -> {
            rewardItem.setName(itemNameField.getText().trim());
            rewardItem.setPrice(Integer.parseInt(itemPriceField.getText().trim()));
            if (fileChooser.getFile() != null) {
                File selectedImage = new File(fileChooser.getDirectory(), fileChooser.getFile());
                rewardItem.setImage(new ImageIcon(selectedImage.getAbsolutePath()));
            }
            parent.refreshList();
        }
        );

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(itemNamePrompt, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(itemNameField, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(itemPricePrompt, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(itemPriceField, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(itemImagePrompt, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(itemImageSelection, gridBagConstraints);
        gridBagConstraints.gridx = 2;
        add(itemImage, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        add(submitButton, gridBagConstraints);
    }
}
