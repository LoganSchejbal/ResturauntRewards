package rewards.lschej.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import rewards.lschej.data.DataController;
import rewards.lschej.data.RewardItem;

public class RewardsItemConfigPanel extends JPanel {

    Font regular = new Font("Calibri", Font.PLAIN, 32);

    public RewardsItemConfigPanel(DataController dataController, RewardItem rewardItem) {
        setLayout(new GridBagLayout());

        JLabel itemNamePrompt = new JLabel("Item Name: ");
        itemNamePrompt.setFont(regular);
        JTextField itemNameField = new JTextField(rewardItem.getName());
        itemNameField.setFont(regular);
        itemNameField.setPreferredSize(new Dimension(450, 50));

        JLabel itemPricePrompt = new JLabel("Item Price: ");
        itemPricePrompt.setFont(regular);
        JTextField itemPriceField = new JTextField(rewardItem.getPrice());
        itemPriceField.setFont(regular);
        itemPriceField.setPreferredSize(new Dimension(150, 50));

        JLabel itemImagePrompt = new JLabel("Item Image");
        itemImagePrompt.setFont(regular);
        JLabel itemImage = new JLabel(rewardItem.getImage());
        itemImage.setPreferredSize(new Dimension(145, 130));
        FileDialog fileChooser = new FileDialog((Frame) null, "Select an Image");
        fileChooser.setMode(FileDialog.LOAD);
        JButton itemImageSelection = new JButton("Select Image");
        itemImageSelection.setPreferredSize(new Dimension(200, 50));
        itemImageSelection.setFont(regular);
        itemImageSelection.addActionListener(e -> {
            fileChooser.setVisible(true);
            if (fileChooser.getFile() != null) {
                itemImage.setIcon(new ImageIcon(fileChooser.getFile()));
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
            rewardItem.setImage(fileChooser.getFile());
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
