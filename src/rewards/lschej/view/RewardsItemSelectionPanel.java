package rewards.lschej.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import rewards.lschej.data.DataController;
import rewards.lschej.data.RewardItem;

public class RewardsItemSelectionPanel extends JPanel {

    private JList<RewardItem> rewardsList;
    DataController dataController;

    public RewardsItemSelectionPanel(DataController dataController, RewardsConfiutator parent) {
        setLayout(new BorderLayout());

        this.dataController = dataController;

        JButton newRewardButton = new JButton("New");
        newRewardButton.setBackground(Color.green);
        newRewardButton.setForeground(Color.white);
        newRewardButton.setFont(dataController.settings.largeRegularFont);
        newRewardButton.setPreferredSize(new Dimension(175, 50));

        JButton deleteRewardButton = new JButton("Delete");
        deleteRewardButton.setBackground(Color.red);
        deleteRewardButton.setForeground(Color.white);
        deleteRewardButton.setFont(dataController.settings.largeRegularFont);
        deleteRewardButton.setPreferredSize(new Dimension(175, 50));

        JPanel rewardButtonPanel = new JPanel(new GridLayout(1, 2));
        rewardButtonPanel.add(newRewardButton);
        rewardButtonPanel.add(deleteRewardButton);

        rewardsList = new JList<>(dataController.getRewards().toArray(new RewardItem[0]));
        rewardsList.setFont(dataController.settings.mediumRegularFont);
        rewardsList.setSelectedIndex(0);
        rewardsList.setFixedCellHeight(35);
        rewardsList.addListSelectionListener(e -> {
            parent.updateRewardSelection(rewardsList.getSelectedValue());
        });

        newRewardButton.addActionListener(e -> {
            RewardItem newReward = new RewardItem();
            dataController.addReward(newReward);
            rewardsList.setListData(dataController.getRewards().toArray(new RewardItem[0]));
            parent.updateRewardSelection(newReward);
            rewardsList.setSelectedIndex(dataController.getRewards().size() - 1);
        });
        deleteRewardButton.addActionListener(e -> {
            dataController.getRewards().remove(rewardsList.getSelectedIndex());
            rewardsList.setListData(dataController.getRewards().toArray(new RewardItem[0]));
        });

        JScrollPane rewardsScroll = new JScrollPane();
        rewardsScroll.setPreferredSize(new Dimension(350, 900));

        rewardsScroll.setViewportView(rewardsList);
        add(rewardsScroll, BorderLayout.CENTER);
        add(rewardButtonPanel, BorderLayout.SOUTH);
    }

    public void refreshList() {
        rewardsList.setListData(dataController.getRewards().toArray(new RewardItem[0]));
    }
}
