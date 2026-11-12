package rewards.lschej.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import rewards.lschej.data.DataController;
import rewards.lschej.data.Order;

public class AddOrder extends JDialog {

    public AddOrder(DataController dataController, ProfileScreen profileScreen, JFrame parent) {
        super(parent, "Add Order", true);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(parent);
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel addOrder = new JLabel("Add Order");
        addOrder.setFont(dataController.settings.largeHeaderFont);
        JLabel orderNumberPrompt = new JLabel("Order Number:");
        orderNumberPrompt.setFont(dataController.settings.boldedFont.deriveFont(24f));
        JLabel dayPrompt = new JLabel("Day:");
        dayPrompt.setFont(dataController.settings.boldedFont.deriveFont(24f));
        JLabel monthPrompt = new JLabel("Month:");
        monthPrompt.setFont(dataController.settings.boldedFont.deriveFont(24f));
        JLabel yearPrompt = new JLabel("Year");
        yearPrompt.setFont(dataController.settings.boldedFont.deriveFont(24f));
        JLabel totalPrompt = new JLabel("Total Amount: $");
        totalPrompt.setFont(dataController.settings.boldedFont.deriveFont(24f));
        JTextField orderNumberField = new JTextField("");
        orderNumberField.setPreferredSize(new Dimension(50, 50));
        orderNumberField.setMinimumSize(new Dimension(25, 25));
        orderNumberField.setFont(dataController.settings.boldedFont.deriveFont(24f));
        Integer[] daysList = new Integer[31];
        for (int i = 1; i <= 31; ++i) {
            daysList[i - 1] = i;
        }
        JComboBox<Integer> dayBox = new JComboBox<>(daysList);
        dayBox.setPreferredSize(new Dimension(50, 50));
        dayBox.setMinimumSize(new Dimension(25, 25));
        dayBox.setFont(dataController.settings.largerRegularFont);
        Integer[] monthsList = new Integer[12];
        for (int i = 1; i <= 12; ++i) {
            monthsList[i - 1] = i;
        }
        JComboBox<Integer> monthsBox = new JComboBox<>(monthsList);
        monthsBox.setPreferredSize(new Dimension(50, 50));
        monthsBox.setMinimumSize(new Dimension(25, 25));
        monthsBox.setFont(dataController.settings.largerRegularFont);
        int year = 2020;
        int quantOfYears = LocalDate.now().getYear() - year;
        Integer[] yearsList = new Integer[quantOfYears + 1];
        for (int i = 0; i < yearsList.length; ++i) {
            yearsList[i] = year;
            ++year;
        }
        JComboBox<Integer> yearBox = new JComboBox<>(yearsList);
        yearBox.setPreferredSize(new Dimension(100, 50));
        yearBox.setMinimumSize(new Dimension(50, 25));
        yearBox.setFont(dataController.settings.largerRegularFont);
        JTextField totaField = new JTextField("");
        totaField.setPreferredSize(new Dimension(100, 50));
        totaField.setMinimumSize(new Dimension(50, 25));
        totaField.setFont(dataController.settings.largerRegularFont);
        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(150, 75));
        submitButton.setFont(dataController.settings.largerRegularFont);
        submitButton.setBackground(Color.BLUE);
        submitButton.setForeground(Color.white);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(150, 75));
        cancelButton.setFont(dataController.settings.largerRegularFont);

        cancelButton.addActionListener(e -> this.dispose());
        submitButton.addActionListener(e -> {
            int day = (int) daysList[dayBox.getSelectedIndex()];
            int month = (int) monthsList[monthsBox.getSelectedIndex()];
            int orderYear = (int) yearsList[yearBox.getSelectedIndex()];
            LocalDate orderDate = LocalDate.of(orderYear, month, day);
            int orderNumber = Integer.parseInt(orderNumberField.getText());
            if (dataController.getMember(dataController.getTarget()).getOrderHistory().findOrder(orderDate, orderNumber) == null) {
                double totalAmount = Double.parseDouble(totaField.getText());
                dataController.getMember(dataController.getTarget()).addOrder(new Order(orderNumber, orderDate, totalAmount, dataController));
                profileScreen.refresh();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(parent, "This order number already exists for the selected date.", "Order Creation", JOptionPane.WARNING_MESSAGE);
            }

        }
        );

        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 0;
        add(addOrder, gridBagConstraints);

        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 0;
        add(orderNumberPrompt, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(orderNumberField, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridx = 0;
        add(monthPrompt, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(monthsBox, gridBagConstraints);

        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridx = 0;
        add(dayPrompt, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(dayBox, gridBagConstraints);

        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridx = 0;
        add(yearPrompt, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(yearBox, gridBagConstraints);

        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridx = 0;
        add(totalPrompt, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(totaField, gridBagConstraints);

        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridx = 0;
        add(cancelButton, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(submitButton, gridBagConstraints);

    }
}
