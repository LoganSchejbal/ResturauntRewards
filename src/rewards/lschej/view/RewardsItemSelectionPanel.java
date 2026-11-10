package rewards.lschej.view;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import rewards.lschej.data.RewardItem;

public class RewardsItemSelectionPanel extends JPanel {

    public RewardsItemSelectionPanel(List<RewardItem> rewards) {
        setLayout(new BorderLayout());

        JButton newRewardButton = new JButton("New");
        newRewardButton.setBackground(Color.green);
        newRewardButton.setFont(new Font("Calibri", Font.BOLD, 28));
        newRewardButton.setPreferredSize(new Dimension(350, 100));

        JList<RewardItem> rewardsList = new JList<>(rewards.toArray(new RewardItem[0]));
        rewardsList.setFont(new Font("Calibri", Font.PLAIN, 16));

        JScrollPane rewardsScroll = new JScrollPane();
        rewardsScroll.setPreferredSize(new Dimension(350, 900));

        rewardsScroll.setViewportView(rewardsList);
        add(rewardsScroll, BorderLayout.CENTER);
        add(newRewardButton, BorderLayout.SOUTH);
    }
}
