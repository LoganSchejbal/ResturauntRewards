package rewards.lschej.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import rewards.lschej.data.DataController;

public class HomeScreen extends JPanel {

    private DataController dataController;

    private JTextField phoneEntry;

    public HomeScreen(ScreenController controller, DataController dataController) {
        this.dataController = dataController;

        setLayout(new GridBagLayout());
        setBackground(Color.darkGray);

        JLabel title = new JLabel("Resturaunt Rewards");
        title.setFont(new Font("Calibri", Font.BOLD, 50));
        title.setForeground(Color.CYAN);
        JLabel phonePrompt = new JLabel("Phone/Account Number: ");
        phonePrompt.setFont(new Font("Calibri", Font.PLAIN, 24));
        phonePrompt.setForeground(Color.CYAN);
        phoneEntry = new JTextField("");
        phoneEntry.setPreferredSize(new Dimension(350, 50));
        phoneEntry.setMinimumSize(new Dimension(250, 25));
        phoneEntry.setFont(new Font("Calibri", Font.PLAIN, 24));
        JButton enterButton = new JButton("Enter");
        enterButton.setPreferredSize(new Dimension(100, 50));
        enterButton.setMinimumSize(new Dimension(75, 25));

        //Wait for Phone field submission
        //On keyboard "Enter" pressed
        phoneEntry.addActionListener(e -> {
            dataController.addTarget(phoneEntry.getText().trim());
            if (dataController.getMember(phoneEntry.getText().trim()) == null) {
                if (UnknownNumberDialog.createNewAccount(this, dataController.getTarget())) {
                    controller.switchScreen("CREATE");
                }
            } else {
                controller.switchScreen("PROFILE");
            }
        }
        );
        //On Screen "Enter" Pressed
        enterButton.addActionListener(e -> {
            dataController.addTarget(phoneEntry.getText().trim());
            if (dataController.getMember(phoneEntry.getText().trim()) == null) {
                if (UnknownNumberDialog.createNewAccount(this, dataController.getTarget())) {
                    controller.switchScreen("CREATE");
                }
            } else {
                controller.switchScreen("PROFILE");
            }
        }
        );

        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        add(title, gridConstraints);

        gridConstraints.gridy = 1;
        gridConstraints.gridx = 0;
        add(phonePrompt, gridConstraints);
        gridConstraints.gridx = 1;
        add(phoneEntry, gridConstraints);
        gridConstraints.gridx = 2;
        add(enterButton, gridConstraints);
        gridConstraints.gridy = 2;
        gridConstraints.gridx = 1;
    }

    public void refresh() {
        dataController.clearTarget();
        phoneEntry.setText("");
    }
}
