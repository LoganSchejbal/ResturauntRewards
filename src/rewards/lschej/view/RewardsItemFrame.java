package rewards.lschej.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import rewards.lschej.data.RewardItem;
import rewards.lschej.data.RewardsTableModel;

public class RewardsItemFrame extends JPanel {

    private final JTable rewardsTable;

    public RewardsItemFrame(List<RewardItem> rewards) {
        setLayout(new BorderLayout());
        rewardsTable = new JTable();
        rewardsTable.setRowHeight(150);
        rewardsTable.getTableHeader().setFont(new Font("Calibri", Font.PLAIN, 24));
        rewardsTable.setFont(new Font("Calibri", Font.PLAIN, 24));
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
