package rewards.lschej.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import rewards.lschej.data.DataController;
import rewards.lschej.data.RewardItem;

public class FullRewardsItemPanel extends JPanel {

    public FullRewardsItemPanel(List<RewardItem> rewards, DataController dataController) {
        setLayout(new BorderLayout());

        JPanel rewardsPanel = new JPanel();
        rewardsPanel.setLayout(new GridBagLayout());
        GridBagConstraints rewardsPanelGB = new GridBagConstraints();
        rewardsPanelGB.gridx = 0;
        rewardsPanelGB.gridy = 0;
        for (RewardItem reward : rewards) {
            JPanel newReward = new RewardItemPanel(reward, dataController);
            rewardsPanel.add(newReward, rewardsPanelGB);
            rewardsPanelGB.gridy += 1;
        }

        JScrollPane rewardsScroll = new JScrollPane();
        rewardsScroll.setViewportView(rewardsPanel);
        add(rewardsScroll, BorderLayout.CENTER);

    }
}
