package rewards.lschej.view;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import rewards.lschej.data.RewardItem;
import rewards.lschej.data.RewardsTableModel;
import rewards.lschej.data.DataController;

public class RewardsItemFrame extends JPanel {

    private final JTable rewardsTable;

    public RewardsItemFrame(List<RewardItem> rewards, DataController dataController) {
        setLayout(new BorderLayout());
        rewardsTable = new JTable();
        rewardsTable.setRowHeight(150);
        rewardsTable.getTableHeader().setFont(dataController.settings.largeRegularFont);
        rewardsTable.setFont(dataController.settings.largeRegularFont);
        add(new JScrollPane(rewardsTable), BorderLayout.CENTER);
        updateTableModel(rewards);
    }

    public void refreshRewards(List<RewardItem> rewards) {
        updateTableModel(rewards);
    }

    private void updateTableModel(List<RewardItem> rewards) {
        AbstractTableModel rewardsTableModel = new RewardsTableModel(rewards);
        rewardsTable.setModel(rewardsTableModel);
    }
}
