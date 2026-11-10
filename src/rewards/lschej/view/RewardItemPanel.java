package rewards.lschej.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import rewards.lschej.data.RewardItem;

public class RewardItemPanel extends JPanel {

    public RewardItemPanel(RewardItem reward) {
        setLayout(new GridBagLayout());
        GridBagConstraints gridBag = new GridBagConstraints();
        gridBag.insets = new Insets(0, 20, 0, 20);
        setBackground(Color.gray);
        setPreferredSize(new Dimension(975, 160));

        JLabel image = new JLabel(reward.getImage());

        JLabel rewardName = new JLabel(reward.getName());
        rewardName.setFont(new Font("Calibri", Font.BOLD, 24));
        rewardName.setForeground(Color.WHITE);

        JLabel rewardPrice = new JLabel("\t" + reward.getPrice() + "pts");
        rewardPrice.setFont(new Font("Calibri", Font.PLAIN, 24));
        rewardPrice.setForeground(Color.CYAN);

        JButton redeemButton = new JButton("Redeem");
        redeemButton.setBackground(Color.blue);
        redeemButton.setFont(new Font("Calibri", Font.BOLD, 24));
        redeemButton.setForeground(Color.white);
        redeemButton.setPreferredSize(new Dimension(150, 60));

        gridBag.gridx = 0;
        gridBag.gridy = 0;
        add(image, gridBag);

        gridBag.gridx = 1;
        add(rewardName, gridBag);

        gridBag.gridx = 2;
        add(rewardPrice, gridBag);

        gridBag.gridx = 3;
        gridBag.gridy = 0;
        add(redeemButton, gridBag);
    }
}
