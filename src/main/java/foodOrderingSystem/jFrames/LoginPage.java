
package foodOrderingSystem.jFrames;
import foodOrderingSystem.Classes.User;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
        initComponents();  
        
        
    }
    
    private User currentUser = null;
    
    Color hover = new Color(255, 165, 0, 255);
    Color normal = new Color(255, 153, 0, 255);
    
    class jPanelGradient extends JPanel {
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            
            Color c1 = new Color(255, 165, 0);
            Color c2 = new Color(255, 102, 0);
            
            GradientPaint gp = new GradientPaint(0,0,c1,180,height,c2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    }
    
    public void Login() {
        
        String username = UsernameTxt.getText();
        String password = new String(PasswordTxt.getPassword());
        
        currentUser = User.Login(username, password);
        
        if (currentUser != null) {
            goToPage(currentUser);
        }
        else {
            JOptionPane.showMessageDialog(null, "Incorrect username or password.", "Error", JOptionPane.ERROR_MESSAGE);            
        }
    }
    
    private void goToPage(User user) {
        
        String username = user.getUsername();
        
        switch(user.getRole()) {
            
            case "Admin":
                this.dispose();
                AdminPage ap = new AdminPage(username);
                ap.pack();
                ap.setLocationRelativeTo(null);
                ap.setVisible(true);
                break;
            case "Customer":
                this.dispose();
                CustomerPage cusp = new CustomerPage(username);
                cusp.pack();
                cusp.setLocationRelativeTo(null);
                cusp.setVisible(true);
                break;
            case "Delivery Runner":
                this.dispose();
                DeliveryRunnerPage drp = new DeliveryRunnerPage(username);
                drp.pack();
                drp.setLocationRelativeTo(null);
                drp.setVisible(true);
                break;
            case "Manager":
                this.dispose();
                ManagerPage mp = new ManagerPage(username);
                mp.pack();
                mp.setLocationRelativeTo(null);
                mp.setVisible(true);
                break;
            case "Vendor":
                this.dispose();
                VendorPage vp = new VendorPage(username);
                vp.pack();
                vp.setLocationRelativeTo(null);
                vp.setVisible(true);
                break;
            default:
            JOptionPane.showMessageDialog(null, "Unable to identify the user role.", "Error", JOptionPane.ERROR_MESSAGE);                
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        SidePanel = new jPanelGradient();
        LogoLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        UsernameTxt = new javax.swing.JTextField();
        SeparatorPanel = new javax.swing.JPanel();
        LoginLbl = new javax.swing.JLabel();
        LoginSptPanel = new javax.swing.JPanel();
        UsernameIcon = new javax.swing.JLabel();
        PasswordIcon = new javax.swing.JLabel();
        SeparatorPanel2 = new javax.swing.JPanel();
        LoginBtn = new javax.swing.JButton();
        PasswordTxt = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        BackgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        SidePanel.setBackground(new java.awt.Color(255, 153, 0));

        LogoLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("FLAVORSCAPE FOOD COURT");

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidePanelLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(54, 54, 54))
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(LogoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        UsernameTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        UsernameTxt.setForeground(java.awt.Color.gray);
        UsernameTxt.setText("Username");
        UsernameTxt.setBorder(null);
        UsernameTxt.setFocusable(false);
        UsernameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                UsernameTxtFocusLost(evt);
            }
        });
        UsernameTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsernameTxtMouseClicked(evt);
            }
        });

        SeparatorPanel.setBackground(new java.awt.Color(0, 0, 0));
        SeparatorPanel.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout SeparatorPanelLayout = new javax.swing.GroupLayout(SeparatorPanel);
        SeparatorPanel.setLayout(SeparatorPanelLayout);
        SeparatorPanelLayout.setHorizontalGroup(
            SeparatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        SeparatorPanelLayout.setVerticalGroup(
            SeparatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        LoginLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LoginLbl.setText("Login");

        LoginSptPanel.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout LoginSptPanelLayout = new javax.swing.GroupLayout(LoginSptPanel);
        LoginSptPanel.setLayout(LoginSptPanelLayout);
        LoginSptPanelLayout.setHorizontalGroup(
            LoginSptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        LoginSptPanelLayout.setVerticalGroup(
            LoginSptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        UsernameIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/username.png"))); // NOI18N

        PasswordIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/password.png"))); // NOI18N

        SeparatorPanel2.setBackground(new java.awt.Color(0, 0, 0));
        SeparatorPanel2.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout SeparatorPanel2Layout = new javax.swing.GroupLayout(SeparatorPanel2);
        SeparatorPanel2.setLayout(SeparatorPanel2Layout);
        SeparatorPanel2Layout.setHorizontalGroup(
            SeparatorPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        SeparatorPanel2Layout.setVerticalGroup(
            SeparatorPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        LoginBtn.setBackground(new java.awt.Color(255, 153, 0));
        LoginBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(255, 255, 255));
        LoginBtn.setText("Login");
        LoginBtn.setBorder(null);
        LoginBtn.setBorderPainted(false);
        LoginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginBtn.setFocusPainted(false);
        LoginBtn.setFocusable(false);
        LoginBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        LoginBtn.setOpaque(true);
        LoginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoginBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoginBtnMouseExited(evt);
            }
        });

        PasswordTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PasswordTxt.setForeground(java.awt.Color.gray);
        PasswordTxt.setText("Password");
        PasswordTxt.setBorder(null);
        PasswordTxt.setEchoChar('\u0000');
        PasswordTxt.setFocusable(false);
        PasswordTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordTxtFocusLost(evt);
            }
        });
        PasswordTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasswordTxtMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BackgroundPanelLayout = new javax.swing.GroupLayout(BackgroundPanel);
        BackgroundPanel.setLayout(BackgroundPanelLayout);
        BackgroundPanelLayout.setHorizontalGroup(
            BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundPanelLayout.createSequentialGroup()
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LoginLbl)
                            .addComponent(LoginSptPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BackgroundPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SeparatorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                            .addComponent(SeparatorPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                            .addComponent(LoginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(UsernameIcon)
                                    .addComponent(PasswordIcon))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(UsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BackgroundPanelLayout.setVerticalGroup(
            BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(LoginLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginSptPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(UsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackgroundPanelLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(UsernameIcon)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeparatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(PasswordIcon))
                    .addGroup(BackgroundPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(PasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeparatorPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginBtnMouseEntered
        LoginBtn.setBackground(hover);
    }//GEN-LAST:event_LoginBtnMouseEntered

    private void LoginBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginBtnMouseExited
        LoginBtn.setBackground(normal);
    }//GEN-LAST:event_LoginBtnMouseExited

    private void UsernameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsernameTxtMouseClicked
        UsernameTxt.setFocusable(true);
        UsernameTxt.requestFocusInWindow();
        UsernameTxt.setForeground(Color.black);
        
        if ("Username".equals(UsernameTxt.getText())) {
            UsernameTxt.setText("");
        }
    }//GEN-LAST:event_UsernameTxtMouseClicked

    private void UsernameTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UsernameTxtFocusLost
        if ("".equals(UsernameTxt.getText())) {
            UsernameTxt.setText("Username");
            UsernameTxt.setForeground(Color.gray);
            UsernameTxt.setFocusable(false);
        }
    }//GEN-LAST:event_UsernameTxtFocusLost

    private void PasswordTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordTxtMouseClicked
        PasswordTxt.setFocusable(true);
        PasswordTxt.requestFocusInWindow();
        PasswordTxt.setForeground(Color.black);
        
        if ("Password".equals(PasswordTxt.getText())) {
            PasswordTxt.setText("");
        }
        
        PasswordTxt.setEchoChar('\u2022');
    }//GEN-LAST:event_PasswordTxtMouseClicked

    private void PasswordTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordTxtFocusLost
        if ("".equals(PasswordTxt.getText())) {
            PasswordTxt.setText("Password");
            PasswordTxt.setForeground(Color.gray);
            PasswordTxt.setEchoChar('\u0000');
            PasswordTxt.setFocusable(false);
        }       
        
    }//GEN-LAST:event_PasswordTxtFocusLost

    private void LoginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginBtnMouseClicked
        
        if ("Username".equals(UsernameTxt.getText()) || "Password".equals(PasswordTxt.getText())) {
            JOptionPane.showMessageDialog(null, "Please enter your details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
           Login(); 
        }
    }//GEN-LAST:event_LoginBtnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JLabel LoginLbl;
    private javax.swing.JPanel LoginSptPanel;
    private javax.swing.JLabel LogoLbl;
    private javax.swing.JLabel PasswordIcon;
    private javax.swing.JPasswordField PasswordTxt;
    private javax.swing.JPanel SeparatorPanel;
    private javax.swing.JPanel SeparatorPanel2;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JLabel UsernameIcon;
    private javax.swing.JTextField UsernameTxt;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
