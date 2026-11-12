package rewards.lschej.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import rewards.lschej.data.DataController;
import rewards.lschej.data.Member;

public class CreateProfile extends JPanel {

    private DataController datatController;

    private JTextField phoneNumField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField birthdayField;

    public CreateProfile(ScreenController controller, DataController dataController) {
        this.datatController = dataController;

        setLayout(new GridBagLayout());
        setBackground(Color.DARK_GRAY);

        JLabel titleLabel = new JLabel("Create New Account");
        titleLabel.setFont(dataController.settings.headerTextFont);
        titleLabel.setForeground(Color.red);
        JLabel phoneNumLabel = new JLabel("Phone Number ");
        phoneNumLabel.setFont(dataController.settings.largerRegularFont);
        phoneNumLabel.setForeground(Color.cyan);
        JLabel emailLabel = new JLabel("Email Address");
        emailLabel.setFont(dataController.settings.largerRegularFont);
        emailLabel.setForeground(Color.cyan);
        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setFont(dataController.settings.largerRegularFont);
        firstNameLabel.setForeground(Color.cyan);
        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setFont(dataController.settings.largerRegularFont);
        lastNameLabel.setForeground(Color.cyan);
        JLabel birthDayLabel = new JLabel("Birthday (MM/DD)");
        birthDayLabel.setFont(dataController.settings.largerRegularFont);
        birthDayLabel.setForeground(Color.cyan);
        phoneNumField = new JTextField(dataController.getTarget());
        phoneNumField.setPreferredSize(new Dimension(350, 50));
        phoneNumField.setMinimumSize(new Dimension(150, 25));
        phoneNumField.setFont(dataController.settings.largerRegularFont);
        emailField = new JTextField("");
        emailField.setMinimumSize(new Dimension(150, 25));
        emailField.setPreferredSize(new Dimension(350, 50));
        emailField.setFont(dataController.settings.largerRegularFont);
        firstNameField = new JTextField("");
        firstNameField.setPreferredSize(new Dimension(350, 50));
        firstNameField.setMinimumSize(new Dimension(150, 25));
        firstNameField.setFont(dataController.settings.largerRegularFont);
        lastNameField = new JTextField("");
        lastNameField.setPreferredSize(new Dimension(350, 50));
        lastNameField.setMinimumSize(new Dimension(150, 25));
        lastNameField.setFont(dataController.settings.largerRegularFont);
        birthdayField = new JTextField("");
        birthdayField.setPreferredSize(new Dimension(350, 50));
        birthdayField.setMinimumSize(new Dimension(150, 25));
        birthdayField.setFont(dataController.settings.largerRegularFont);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(dataController.settings.largerRegularFont);
        JButton createNewButton = new JButton("Create Account");
        createNewButton.setFont(dataController.settings.largerRegularFont);
        createNewButton.setBackground(Color.blue);
        createNewButton.setForeground(Color.RED);

        cancelButton.addActionListener(e -> controller.switchScreen("HOME"));
        createNewButton.addActionListener(e -> {
            Member newMemeber = new Member(phoneNumField.getText().trim(),
                    firstNameField.getText().trim(),
                    lastNameField.getText().trim(),
                    birthdayField.getText().trim(),
                    emailField.getText().trim()
            );

            dataController.addMember(newMemeber);
            memberCreated.accountCreated(this);
            dataController.clearTarget();
            controller.switchScreen("HOME");

        });

        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.insets = new Insets(10, 10, 10, 10);

        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        add(titleLabel, gridConstraints);
        gridConstraints.gridy = 1;
        add(phoneNumLabel, gridConstraints);
        gridConstraints.gridx = 1;
        add(phoneNumField, gridConstraints);
        gridConstraints.gridy = 2;
        gridConstraints.gridx = 0;
        add(emailLabel, gridConstraints);
        gridConstraints.gridx = 1;
        add(emailField, gridConstraints);
        gridConstraints.gridy = 3;
        gridConstraints.gridx = 0;
        add(firstNameLabel, gridConstraints);
        gridConstraints.gridx = 1;
        add(firstNameField, gridConstraints);
        gridConstraints.gridy = 4;
        gridConstraints.gridx = 0;
        add(lastNameLabel, gridConstraints);
        gridConstraints.gridx = 1;
        add(lastNameField, gridConstraints);
        gridConstraints.gridy = 5;
        gridConstraints.gridx = 0;
        add(birthDayLabel, gridConstraints);
        gridConstraints.gridx = 1;
        add(birthdayField, gridConstraints);
        gridConstraints.gridy = 6;
        gridConstraints.gridx = 0;
        add(cancelButton, gridConstraints);
        gridConstraints.gridx = 1;
        add(createNewButton, gridConstraints);

    }

    public void refresh() {
        phoneNumField.setText(datatController.getTarget());
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        birthdayField.setText("");
    }
}
