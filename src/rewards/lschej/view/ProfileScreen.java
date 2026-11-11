package rewards.lschej.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import rewards.lschej.data.DataController;
import rewards.lschej.data.Member;

public class ProfileScreen extends JPanel {

    private DataController dataController;
    private Member member;

    private JLabel profileName;
    private JLabel pointsTotal;
    private JLabel emailAddress;
    private JLabel phoneNumber;
    private JLabel birthday;
    private OrderHistoryFrame orderHistoryPanel;
    private FullRewardsItemPanel rewardsItemPanel;

    public ProfileScreen(ScreenController controller, DataController dataController) {
        this.dataController = dataController;

        setLayout(new GridBagLayout());
        setBackground(Color.DARK_GRAY);

        ImageIcon profileIcon = new ImageIcon("C:\\Users\\logan\\Documents\\Assignments\\Other\\ResturauntRewards\\lib\\User-Profile-PNG-Download-Image.png");
        Image scaledProfileIcon = profileIcon.getImage();
        scaledProfileIcon = scaledProfileIcon.getScaledInstance(120, 75, Image.SCALE_SMOOTH);
        profileIcon = new ImageIcon(scaledProfileIcon);
        JLabel profileIconObject = new JLabel(profileIcon);
        profileName = new JLabel("FirstName LastName");
        profileName.setFont(new Font("Calibri", Font.PLAIN, 36));
        profileName.setForeground(Color.cyan);
        emailAddress = new JLabel("emailAddress");
        phoneNumber = new JLabel("###-###-####");
        emailAddress.setFont(new Font("Calibri", Font.PLAIN, 24));
        emailAddress.setForeground(Color.white);
        phoneNumber.setFont(new Font("Calibri", Font.PLAIN, 24));
        phoneNumber.setForeground(Color.white);
        birthday = new JLabel("MM/DD/YYYY");
        birthday.setFont(new Font("Calibri", Font.PLAIN, 24));
        birthday.setForeground(Color.white);
        pointsTotal = new JLabel("Rewards Points: 123,456");
        pointsTotal.setFont(new Font("Callibri", Font.BOLD, 36));
        pointsTotal.setForeground(Color.RED);
        JButton homeButton = new JButton("Home");
        homeButton.setPreferredSize(new Dimension(75, 75));
        homeButton.setMinimumSize(new Dimension(50, 50));
        JButton addOrderButton = new JButton("Add Order");
        addOrderButton.setPreferredSize(new Dimension(150, 50));
        addOrderButton.setMinimumSize(new Dimension(75, 30));
        addOrderButton.setFont(new Font("Calibri", Font.PLAIN, 22));

        orderHistoryPanel = new OrderHistoryFrame(null);
        orderHistoryPanel.setPreferredSize(new Dimension(1000, 500));
        // rewardsItemPanel = new RewardsItemFrame(dataController.getRewards());
        // rewardsItemPanel.setBackground(Color.DARK_GRAY);
        rewardsItemPanel = new FullRewardsItemPanel(dataController.getRewards(), dataController);
        rewardsItemPanel.setPreferredSize(new Dimension(1000, 500));

        JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
        tabs.addTab("Rewards", rewardsItemPanel);
        tabs.addTab("Orders", orderHistoryPanel);
        tabs.setPreferredSize(new Dimension(1000, 500));
        tabs.setFont(new Font("Calibri", Font.PLAIN, 32));

        homeButton.addActionListener(e -> controller.switchScreen("HOME"));
        addOrderButton.addActionListener(e -> {
            new AddOrder(dataController, this, (JFrame) SwingUtilities.getWindowAncestor(this)).setVisible(true);
        }
        );

        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.insets = new Insets(20, 20, 20, 20);
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        add(profileIconObject, gridConstraints);
        gridConstraints.gridx = 1;
        add(pointsTotal, gridConstraints);
        gridConstraints.gridy = 1;
        add(tabs, gridConstraints);
        gridConstraints.gridy = 0;
        gridConstraints.gridx = 3;
        add(homeButton, gridConstraints);
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        add(profileName, gridConstraints);
        gridConstraints.gridy = 2;
        add(phoneNumber, gridConstraints);
        gridConstraints.gridy = 3;
        add(emailAddress, gridConstraints);
        gridConstraints.gridy = 4;
        add(birthday, gridConstraints);
        gridConstraints.gridy = 5;
        add(addOrderButton, gridConstraints);

    }

    public void refresh() {
        this.member = dataController.getMember(dataController.getTarget());
        profileName.setText(member.getFullName());
        pointsTotal.setText("Rewards Points: " + Integer.toString(member.getPoints()));
        emailAddress.setText(member.getEmailAddress());
        phoneNumber.setText(member.getPhoneNumber());
        birthday.setText(member.getBirthday().toString());
        orderHistoryPanel.setMember(member);
    }
}
