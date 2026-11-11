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

public class RewardRedeemedFail extends JDialog {

    public RewardRedeemedFail(DataController dataController, RewardItem reward, JFrame parent) {
        super(parent, true);
        setSize((int) (parent.getWidth() * 0.25), (int) (parent.getHeight() * 0.25));
        setLocationRelativeTo(null);
        setTitle("Rewards Configurator");
        setLayout(new GridBagLayout());
        GridBagConstraints gridBag = new GridBagConstraints();

        JLabel failMessage = new JLabel("Insufficient Balance");
        failMessage.setFont(new Font("Calibri", Font.BOLD, 30));
        failMessage.setForeground(Color.RED);

        JLabel rewardPrice = new JLabel("Cost: " + reward.getPrice() + "pts");
        rewardPrice.setFont(new Font("Calibri", Font.ITALIC, 14));

        JLabel accountBalance = new JLabel("Balance: " + dataController.getMember(dataController.getTarget()).getPoints() + "pts");
        accountBalance.setFont(new Font("Calibri", Font.BOLD, 14));

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
        add(failMessage, gridBag);
        gridBag.gridy = 1;
        add(rewardPrice, gridBag);
        gridBag.gridy = 2;
        add(accountBalance, gridBag);
        gridBag.gridy = 3;
        add(close, gridBag);
    }
}
