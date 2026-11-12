package rewards.lschej.view;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import rewards.lschej.data.DataController;
import rewards.lschej.data.DataHandler;
import rewards.lschej.data.Member;
import rewards.lschej.data.RewardItem;

public class MainFrame extends JFrame implements ScreenController {

    private JPanel cardPanel;
    private CardLayout cardLayout;

    private HomeScreen home;
    private ProfileScreen profile;
    private CreateProfile create;

    public MainFrame() {
        //Window Setup
        setTitle("Resturaunt Rewards");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2560, 1440);
        setLocationRelativeTo(null);

        //Cards Setup
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        //DataController Instance
        DataController dataController = new DataHandler();

        /**
         * Temp test instances
         */
        dataController.addMember(new Member("1234567890", "John", "Doe", "01012000", "JohnDoe@email.com"));
        dataController.addReward(new RewardItem("", "Reward Ex. 1", 300));
        dataController.addReward(new RewardItem("", "Reward Ex. 2", 400));
        dataController.addReward(new RewardItem("", "Reward Ex. 3", 500));
        dataController.addReward(new RewardItem("", "Reward Ex. 4", 600));
        dataController.addReward(new RewardItem("", "Reward Ex. 5 But with a long name", 700));

        //Instances of screens
        //Passes this as controller
        //Passes Data Handler
        home = new HomeScreen(this, dataController);
        profile = new ProfileScreen(this, dataController);
        create = new CreateProfile(this, dataController);

        //Add to card manager
        cardPanel.add(home, "HOME");
        cardPanel.add(profile, "PROFILE");
        cardPanel.add(create, "CREATE");

        //Menu Bar Setup
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(dataController.settings.menuFont);

        JMenu editMenu = new JMenu("Edit");
        editMenu.setFont(dataController.settings.menuFont);
        JMenuItem editRewardsItems = new JMenuItem("Edit Rewards Items");
        editRewardsItems.setFont(dataController.settings.menuFont);
        editMenu.add(editRewardsItems);
        editRewardsItems.addActionListener(e -> new RewardsConfiutator(dataController, this));

        JMenu settingsMenu = new JMenu("Settings");
        settingsMenu.setFont(dataController.settings.menuFont);
        JMenuItem rewardsSettings = new JMenuItem("Rewards Settings");
        rewardsSettings.setFont(dataController.settings.menuFont);
        settingsMenu.add(rewardsSettings);
        rewardsSettings.addActionListener(e -> new RewardsSettingsMenu(dataController, this));

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setFont(dataController.settings.menuFont);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(settingsMenu);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);

        //Add main panel to frame
        add(cardPanel);
        setVisible(true);

    }

    @Override
    public void switchScreen(String screenName) {
        refreshScreen(screenName);
        cardLayout.show(cardPanel, screenName);
    }

    private void refreshScreen(String screenName) {
        if (screenName.equals("HOME")) {
            home.refresh();
        }
        if (screenName.equals("PROFILE")) {
            profile.refresh();
        }
        if (screenName.equals("CREATE")) {
            create.refresh();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
