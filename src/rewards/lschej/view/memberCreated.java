package rewards.lschej.view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class memberCreated {

    public static boolean accountCreated(JPanel parent) {
        String formattedHTML = "<html>"
                + "<div style='width: 450px; font-size: 24pt; font-family: calibri;'>"
                + "Member Account Created"
                + "</div>"
                + "</html>";

        int choice = JOptionPane.showConfirmDialog(parent, formattedHTML, "Account Creation", JOptionPane.PLAIN_MESSAGE);
        return choice == JOptionPane.OK_OPTION;
    }
}
