package rewards.lschej.view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UnknownNumberDialog{
    public static boolean createNewAccount(JPanel parent, String number){
        String formattedHTML = "<html>" +
                            "<div style='width: 450px; font-size: 24pt; font-family: calibri;'>" + 
                            number + " Does Not Have An Account. Create New?" + 
                            "</div>" +
                            "</html>";

        int choice = JOptionPane.showConfirmDialog(parent, formattedHTML, "Account Creation", JOptionPane.OK_CANCEL_OPTION);
        return choice == JOptionPane.OK_OPTION;
    }
}
