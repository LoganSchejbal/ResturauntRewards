package rewards.lschej.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import rewards.lschej.data.DataController;
import rewards.lschej.data.RewardItem;

public class RewardRedeemedSuccessful extends JDialog {

    public RewardRedeemedSuccessful(DataController dataController, RewardItem reward, JFrame parent) {
        super(parent, true);
        setSize((int) (parent.getWidth() * 0.5), (int) (parent.getHeight() * 0.5));
        setLocationRelativeTo(null);
        setTitle("Reward Redeemed");
        setLayout(new GridBagLayout());
        GridBagConstraints gridBag = new GridBagConstraints();

        JLabel successMessage = new JLabel("You have redeemed " + reward.getName() + "!");
        successMessage.setFont(new Font("Calibri", Font.BOLD, 30));

        JLabel rewardImage = new JLabel(reward.getImage());

        JLabel rewardPrice = new JLabel("-" + reward.getPrice() + "pts");
        rewardPrice.setFont(new Font("Calibri", Font.ITALIC, 14));

        JLabel accountBalance = new JLabel("Current Balance: " + dataController.getMember(dataController.getTarget()).getPoints() + "pts");
        accountBalance.setFont(new Font("Calibri", Font.BOLD, 24));

        JButton close = new JButton("Close");
        close.setFont(new Font("Calibri", Font.PLAIN, 14));
        close.setBackground(Color.BLUE);
        close.setForeground(Color.WHITE);
        close.setPreferredSize(new Dimension(150, 50));
        close.addActionListener(e -> {
            this.dispose();
        });

        gridBag.gridx = 0;
        gridBag.gridy = 0;
        add(successMessage, gridBag);
        gridBag.gridy = 1;
        add(rewardImage, gridBag);
        gridBag.gridy = 2;
        add(rewardPrice, gridBag);
        gridBag.gridy = 3;
        add(accountBalance, gridBag);
        gridBag.gridy = 4;
        add(close, gridBag);

    }
}
