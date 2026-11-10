package rewards.lschej.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import rewards.lschej.data.DataController;

public class RewardsSettingsMenu extends JDialog {

    public RewardsSettingsMenu(DataController dataController, JFrame parent) {
        super(parent, true);
        setLocationRelativeTo(parent);
        setLayout(new GridBagLayout());
        setSize(new Dimension(800, 750));
        setTitle("Rewards Settings Menu");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel orderLifespanPrompt = new JLabel("Order Expitation: ");
        orderLifespanPrompt.setToolTipText("This Setting determines how long an order's points last before they expire.");
        orderLifespanPrompt.setFont(new Font("Calibri", Font.PLAIN, 24));
        JTextField orderLifespanField = new JTextField(Integer.toString(dataController.settings.getPointsLifespan()));
        orderLifespanField.setFont(new Font("Claibri", Font.PLAIN, 24));
        orderLifespanField.setPreferredSize(new Dimension(100, 75));
        orderLifespanField.setMinimumSize(new Dimension(75, 50));
        JLabel pointsRatioPrompt = new JLabel("Total to Points Ratio: ");
        pointsRatioPrompt.setToolTipText("This setting adjusts the total to points ratio for orders. 10 = 10X the total. 0.1 = 10% of the total");
        pointsRatioPrompt.setFont(new Font("Calibri", Font.PLAIN, 24));
        JTextField pointsRatioField = new JTextField(Double.toString(dataController.settings.getPointsToTotalRatio()));
        pointsRatioField.setFont(new Font("Calibri", Font.PLAIN, 24));
        pointsRatioField.setPreferredSize(new Dimension(100, 75));
        pointsRatioField.setMinimumSize(new Dimension(75, 50));

        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(150, 75));
        submitButton.setFont(new Font("Calibri", Font.BOLD, 24));
        submitButton.setBackground(Color.BLUE);
        submitButton.setForeground(Color.white);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(150, 75));
        cancelButton.setFont(new Font("Calibri", Font.BOLD, 24));

        cancelButton.addActionListener(e -> this.dispose());
        submitButton.addActionListener(e -> {
            dataController.settings.setPointsLifespan(Integer.parseInt(orderLifespanField.getText().trim()));
            dataController.settings.setPointsTotToalRatio(Double.parseDouble(pointsRatioField.getText().trim()));
            this.dispose();
        }
        );

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(orderLifespanPrompt, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(orderLifespanField, gridBagConstraints);
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 0;
        add(pointsRatioPrompt, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(pointsRatioField, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(cancelButton, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(submitButton, gridBagConstraints);

        setVisible(true);
    }
}
