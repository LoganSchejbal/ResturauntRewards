package rewards.lschej.data;

import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class RewardsTableModel extends AbstractTableModel {

    private final List<RewardItem> rewards;
    private static final String[] columnNames = {
        "Reward Image", "Reward Name", "Reward Price", "Redeem"
    };

    public RewardsTableModel(List<RewardItem> rewards) {
        this.rewards = rewards;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return rewards.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rewards.get(rowIndex).getImage();
            case 1:
                return rewards.get(rowIndex).getName();
            case 2:
                return rewards.get(rowIndex).getPrice();
            default:
                return "ERROR";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return ImageIcon.class;
            case 1:
                return String.class;
            case 2:
                return int.class;
            default:
                return String.class;
        }
    }

}
