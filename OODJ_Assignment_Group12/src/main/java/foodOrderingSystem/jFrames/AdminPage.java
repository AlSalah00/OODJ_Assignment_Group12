
package foodOrderingSystem.jFrames;
import foodOrderingSystem.ButtonStyler;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AdminPage extends javax.swing.JFrame {

    
    
    Icon defaultIcon1 = new ImageIcon(ButtonStyler.class.getResource("/add.png"));
    Icon hoverIcon1 = new ImageIcon(ButtonStyler.class.getResource("/addHover.png"));
        
    Icon defaultIcon2 = new ImageIcon(ButtonStyler.class.getResource("/top-up.png"));
    Icon hoverIcon2 = new ImageIcon(ButtonStyler.class.getResource("/top-upHover.png"));
    
    Icon defaultIcon3 = new ImageIcon(ButtonStyler.class.getResource("/transaction.png"));
    Icon hoverIcon3 = new ImageIcon(ButtonStyler.class.getResource("/transactionHover.png"));
    
    Icon defaultIcon4 = new ImageIcon(ButtonStyler.class.getResource("/bill.png"));
    Icon hoverIcon4 = new ImageIcon(ButtonStyler.class.getResource("/billHover.png"));
    
    Icon defaultIcon5 = new ImageIcon(ButtonStyler.class.getResource("/logout.png"));
    Icon hoverIcon5 = new ImageIcon(ButtonStyler.class.getResource("/logoutHover.png"));
    
    public AdminPage() {
        initComponents();
        
                         
        JButton[] allButtons = {UserRegBtn, TopUpBtn, TransactionBtn, ReceiptsBtn, LogoutBtn};      
        
        ButtonStyler.applyMouseEffects(UserRegBtn, allButtons, defaultIcon1, hoverIcon1);
        ButtonStyler.applyMouseEffects(TopUpBtn, allButtons, defaultIcon2, hoverIcon2);
        ButtonStyler.applyMouseEffects(TransactionBtn, allButtons, defaultIcon3, hoverIcon3);
        ButtonStyler.applyMouseEffects(ReceiptsBtn, allButtons, defaultIcon4, hoverIcon4);
        ButtonStyler.applyMouseEffects(LogoutBtn, allButtons, defaultIcon5, hoverIcon5);
    }
    
    private void resetToDefault() {
        ButtonStyler.applyDefaultStyle(UserRegBtn, defaultIcon1);
        ButtonStyler.applyDefaultStyle(TopUpBtn, defaultIcon2);
        ButtonStyler.applyDefaultStyle(TransactionBtn, defaultIcon3);
        ButtonStyler.applyDefaultStyle(ReceiptsBtn, defaultIcon4);
        ButtonStyler.applyDefaultStyle(LogoutBtn, defaultIcon5);
    }

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SidePanel = new jPanelGradient();
        UserRegBtn = new javax.swing.JButton();
        TopUpBtn = new javax.swing.JButton();
        TransactionBtn = new javax.swing.JButton();
        ReceiptsBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        LogoLbl = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JButton();
        ParentPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        SidePanel.setBackground(new java.awt.Color(255, 153, 0));

        UserRegBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UserRegBtn.setForeground(new java.awt.Color(255, 255, 255));
        UserRegBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        UserRegBtn.setText("User Registration");
        UserRegBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4)));
        UserRegBtn.setBorderPainted(false);
        UserRegBtn.setContentAreaFilled(false);
        UserRegBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserRegBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserRegBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        UserRegBtn.setIconTextGap(10);
        UserRegBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        UserRegBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserRegBtnActionPerformed(evt);
            }
        });

        TopUpBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TopUpBtn.setForeground(new java.awt.Color(255, 255, 255));
        TopUpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top-up.png"))); // NOI18N
        TopUpBtn.setText("Top-Up");
        TopUpBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4)));
        TopUpBtn.setBorderPainted(false);
        TopUpBtn.setContentAreaFilled(false);
        TopUpBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TopUpBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TopUpBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        TopUpBtn.setIconTextGap(10);
        TopUpBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        TopUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopUpBtnActionPerformed(evt);
            }
        });

        TransactionBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TransactionBtn.setForeground(new java.awt.Color(255, 255, 255));
        TransactionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transaction.png"))); // NOI18N
        TransactionBtn.setText("Transactions");
        TransactionBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4)));
        TransactionBtn.setBorderPainted(false);
        TransactionBtn.setContentAreaFilled(false);
        TransactionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TransactionBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TransactionBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        TransactionBtn.setIconTextGap(10);
        TransactionBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        TransactionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransactionBtnActionPerformed(evt);
            }
        });

        ReceiptsBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ReceiptsBtn.setForeground(new java.awt.Color(255, 255, 255));
        ReceiptsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bill.png"))); // NOI18N
        ReceiptsBtn.setText("Receipts");
        ReceiptsBtn.setToolTipText("");
        ReceiptsBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 16, 5, 10), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255))));
        ReceiptsBtn.setBorderPainted(false);
        ReceiptsBtn.setContentAreaFilled(false);
        ReceiptsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ReceiptsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ReceiptsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ReceiptsBtn.setIconTextGap(10);
        ReceiptsBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        ReceiptsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceiptsBtnActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(256, 3));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        LogoLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N

        LogoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LogoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png"))); // NOI18N
        LogoutBtn.setText("Logout");
        LogoutBtn.setToolTipText("");
        LogoutBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 16, 5, 10), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255))));
        LogoutBtn.setBorderPainted(false);
        LogoutBtn.setContentAreaFilled(false);
        LogoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LogoutBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        LogoutBtn.setIconTextGap(10);
        LogoutBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UserRegBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
            .addComponent(ReceiptsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TransactionBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TopUpBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(LogoLbl))
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addComponent(LogoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(LogoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserRegBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TopUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransactionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ReceiptsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ParentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanel.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 634, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        ParentPanel.add(jPanel2, "card2");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 634, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        ParentPanel.add(jPanel3, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ParentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ParentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserRegBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserRegBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(jPanel2);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(UserRegBtn, hoverIcon1);
    }//GEN-LAST:event_UserRegBtnActionPerformed

    private void TopUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopUpBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(jPanel3);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(TopUpBtn, hoverIcon2);
    }//GEN-LAST:event_TopUpBtnActionPerformed

    private void TransactionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransactionBtnActionPerformed
        resetToDefault();
        ButtonStyler.applyHoverStyle(TransactionBtn, hoverIcon3);
    }//GEN-LAST:event_TransactionBtnActionPerformed

    private void ReceiptsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceiptsBtnActionPerformed
        resetToDefault();
        ButtonStyler.applyHoverStyle(ReceiptsBtn, hoverIcon4);
    }//GEN-LAST:event_ReceiptsBtnActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoLbl;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JButton ReceiptsBtn;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton TopUpBtn;
    private javax.swing.JButton TransactionBtn;
    private javax.swing.JButton UserRegBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
