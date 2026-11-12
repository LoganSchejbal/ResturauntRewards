package rewards.lschej.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import rewards.lschej.data.DataController;
import rewards.lschej.data.RewardItem;
import rewards.lschej.data.InsufficientBalanceError;

public class RewardItemPanel extends JPanel {

    public RewardItemPanel(RewardItem reward, DataController dataController, Runnable onRedeemed) {
        setLayout(new GridBagLayout());
        GridBagConstraints gridBag = new GridBagConstraints();
        gridBag.insets = new Insets(0, 20, 0, 20);
        setBackground(Color.gray);
        setPreferredSize(new Dimension(975, 160));

        JLabel image = new JLabel(reward.getImage());

        JLabel rewardName = new JLabel(reward.getName());
        rewardName.setFont(dataController.settings.boldedFont.deriveFont(24f));
        rewardName.setForeground(Color.WHITE);

        JLabel rewardPrice = new JLabel("\t" + reward.getPrice() + "pts");
        rewardPrice.setFont(dataController.settings.largeRegularFont);
        rewardPrice.setForeground(Color.CYAN);

        JButton redeemButton = new JButton("Redeem");
        redeemButton.setBackground(Color.blue);
        redeemButton.setFont(dataController.settings.boldedFont.deriveFont(24f));
        redeemButton.setForeground(Color.white);
        redeemButton.setPreferredSize(new Dimension(150, 60));

        redeemButton.addActionListener(e -> {
            try {
                dataController.getMember(dataController.getTarget()).redeemPoints(reward.getPrice());
                onRedeemed.run();
                JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
                new RewardRedeemedSuccessful(dataController, reward, parent).setVisible(true);
            } catch (InsufficientBalanceError error) {
                onRedeemed.run();
                JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
                new RewardRedeemedFail(dataController, reward, parent).setVisible(true);
            }
        }
        );

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
