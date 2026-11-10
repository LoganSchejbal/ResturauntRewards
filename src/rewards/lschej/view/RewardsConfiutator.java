package rewards.lschej.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import rewards.lschej.data.DataController;
import rewards.lschej.data.RewardItem;

public class RewardsConfiutator extends JDialog {

    public RewardsConfiutator(DataController dataController, JFrame parent) {
        super(parent, true);
        setSize((int) (parent.getWidth() * 0.6), (int) (parent.getHeight() * 0.6));
        setLocationRelativeTo(null);
        setTitle("Rewards Configurator");
        setLayout(new GridBagLayout());
        GridBagConstraints gridBag = new GridBagConstraints();
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weighty = 1.0;

        gridBag.gridx = 0;
        gridBag.gridy = 0;
        gridBag.weightx = 0.35;
        add(new RewardsItemSelectionPanel(dataController.getRewards()), gridBag);
        gridBag.gridx = 1;
        gridBag.weightx = 0.65;
        add(new RewardsItemConfigPanel(dataController, new RewardItem()), gridBag);

        setVisible(true);
    }
}
