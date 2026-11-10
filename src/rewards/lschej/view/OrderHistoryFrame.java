package rewards.lschej.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Collections;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import rewards.lschej.data.Member;
import rewards.lschej.data.Order;
import rewards.lschej.data.OrderTableModel;

public class OrderHistoryFrame extends JPanel {

    private final JTable orderTable;

    public OrderHistoryFrame(Member member) {
        setLayout(new BorderLayout());
        orderTable = new JTable();
        orderTable.setRowHeight(32);
        orderTable.getTableHeader().setFont(new Font("Calibri", Font.PLAIN, 24));
        orderTable.setFont(new Font("Claibri", Font.PLAIN, 24));
        add(new JScrollPane(orderTable), BorderLayout.CENTER);
        updateTableModel(member);
    }

    public void setMember(Member member) {
        updateTableModel(member);
    }

    private void updateTableModel(Member member) {
        List<Order> orderList = member == null
                ? Collections.emptyList()
                : member.getOrderHistory().getAllOrders();

        AbstractTableModel orderTableModel = new OrderTableModel(orderList);
        orderTable.setModel(orderTableModel);
    }
}
