package rewards.lschej.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import rewards.lschej.data.DataController;
import rewards.lschej.data.RewardItem;

public class RewardsConfiutator extends JDialog {

    RewardsItemSelectionPanel selectorPanel;
    JPanel configPanel;

    DataController dataController;

    public RewardsConfiutator(DataController dataController, JFrame parent) {
        super(parent, true);
        setSize((int) (parent.getWidth() * 0.6), (int) (parent.getHeight() * 0.6));
        setLocationRelativeTo(null);
        setTitle("Rewards Configurator");
        setLayout(new GridBagLayout());
        GridBagConstraints gridBag = new GridBagConstraints();
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weighty = 1.0;

        this.dataController = dataController;

        if (dataController.getRewards().isEmpty()) {
            dataController.addReward(new RewardItem());
        }

        selectorPanel = new RewardsItemSelectionPanel(dataController, this);
        configPanel = new RewardsItemConfigPanel(dataController, dataController.getRewards().get(0), this);

        gridBag.gridx = 0;
        gridBag.gridy = 0;
        gridBag.weightx = 0.35;
        add(selectorPanel, gridBag);
        gridBag.gridx = 1;
        gridBag.weightx = 0.65;
        add(configPanel, gridBag);

        setVisible(true);
    }

    public void updateRewardSelection(RewardItem reward) {
        if (reward == null) {
            return;
        }

        remove(configPanel);
        configPanel = new RewardsItemConfigPanel(dataController, reward, this);
        GridBagConstraints gridBag = new GridBagConstraints();
        gridBag.gridx = 1;
        gridBag.gridy = 0;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 0.65;
        gridBag.weighty = 1.0;
        add(configPanel, gridBag);
        revalidate();
        repaint();
    }

    public void refreshList() {
        selectorPanel.refreshList();
    }
}
