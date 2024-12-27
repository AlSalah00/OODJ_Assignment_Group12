

package foodOrderingSystem;
import foodOrderingSystem.jFrames.LoginPage;
import foodOrderingSystem.Classes.User;
import javax.swing.UIManager;

public class OODJ_Assignment_Group12 {

    public static void main(String[] args) {
        
        try { 
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception ignored){}
        
        LoginPage lp = new LoginPage();
        lp.pack();
        lp.setLocationRelativeTo(null);
        lp.setVisible(true);
        
        
    }
}
