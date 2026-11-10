package rewards.lschej.data;

import java.time.LocalDate;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class OrderTableModel extends AbstractTableModel {

    private final List<Order> orders;
    private final static String[] columnNames = {"Order Date", "Order Number", "Order Total", "Rewards Points"};

    public OrderTableModel(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return orders.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return orders.get(rowIndex).getOrderDate();
            case 1:
                return orders.get(rowIndex).getOrderNumber();
            case 2:
                return orders.get(rowIndex).getOrderTotal();
            case 3:
                return orders.get(rowIndex).getPoints();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return LocalDate.class;
            case 1:
                return Integer.class;
            case 2:
                return Double.class;
            case 3:
                return Integer.class;
            default:
                return String.class;
        }
    }
}
