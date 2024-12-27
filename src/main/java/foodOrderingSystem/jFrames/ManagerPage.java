
package foodOrderingSystem.jFrames;
import foodOrderingSystem.Classes.ButtonStyler;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class ManagerPage extends javax.swing.JFrame {

    
    
    Icon defaultIcon1 = new ImageIcon(ButtonStyler.class.getResource("/profit.png"));
    Icon hoverIcon1 = new ImageIcon(ButtonStyler.class.getResource("/profitHover.png"));
        
    Icon defaultIcon2 = new ImageIcon(ButtonStyler.class.getResource("/performance(runner).png"));
    Icon hoverIcon2 = new ImageIcon(ButtonStyler.class.getResource("/performance(runner)Hover.png"));
    
    Icon defaultIcon3 = new ImageIcon(ButtonStyler.class.getResource("/complaint.png"));
    Icon hoverIcon3 = new ImageIcon(ButtonStyler.class.getResource("/complaintHover.png"));
    
    Icon defaultIcon4 = new ImageIcon(ButtonStyler.class.getResource("/remove.png"));
    Icon hoverIcon4 = new ImageIcon(ButtonStyler.class.getResource("/removeHover.png"));
    
    Icon defaultIcon5 = new ImageIcon(ButtonStyler.class.getResource("/logout.png"));
    Icon hoverIcon5 = new ImageIcon(ButtonStyler.class.getResource("/logoutHover.png"));
    
    public ManagerPage(String username) {
        
        try { 
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception ignored){}
        
        initComponents();
        
        WelcomeLbl.setText("Welcome, " + username);               
        
        JButton[] allButtons = {VendorPerfBtn, DRPerfBtn, CusComplaintsBtn, RmvItemBtn, LogoutBtn};      
        
        ButtonStyler.applyMouseEffects(VendorPerfBtn, allButtons, defaultIcon1, hoverIcon1);
        ButtonStyler.applyMouseEffects(DRPerfBtn, allButtons, defaultIcon2, hoverIcon2);
        ButtonStyler.applyMouseEffects(CusComplaintsBtn, allButtons, defaultIcon3, hoverIcon3);
        ButtonStyler.applyMouseEffects(RmvItemBtn, allButtons, defaultIcon4, hoverIcon4);
        ButtonStyler.applyMouseEffects(LogoutBtn, allButtons, defaultIcon5, hoverIcon5);
    }
    
    private void resetToDefault() {
        ButtonStyler.applyDefaultStyle(VendorPerfBtn, defaultIcon1);
        ButtonStyler.applyDefaultStyle(DRPerfBtn, defaultIcon2);
        ButtonStyler.applyDefaultStyle(CusComplaintsBtn, defaultIcon3);
        ButtonStyler.applyDefaultStyle(RmvItemBtn, defaultIcon4);
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

        BackgroundPanel = new javax.swing.JPanel();
        SidePanel = new jPanelGradient();
        VendorPerfBtn = new javax.swing.JButton();
        DRPerfBtn = new javax.swing.JButton();
        CusComplaintsBtn = new javax.swing.JButton();
        RmvItemBtn = new javax.swing.JButton();
        SeparatorPanel = new javax.swing.JPanel();
        LogoLbl = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JButton();
        ParentPanel = new javax.swing.JPanel();
        WelcomePanel = new javax.swing.JPanel();
        BackgroundLbl = new javax.swing.JLabel();
        WelcomeLbl = new javax.swing.JLabel();
        PageTypeLbl = new javax.swing.JLabel();
        VendorPerfPanel = new javax.swing.JPanel();
        DRPerfPanel = new javax.swing.JPanel();
        CusComplaintsPanel = new javax.swing.JPanel();
        RmvItemPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        SidePanel.setBackground(new java.awt.Color(255, 153, 0));

        VendorPerfBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        VendorPerfBtn.setForeground(new java.awt.Color(255, 255, 255));
        VendorPerfBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profit.png"))); // NOI18N
        VendorPerfBtn.setText("Vendor Performance");
        VendorPerfBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        VendorPerfBtn.setBorderPainted(false);
        VendorPerfBtn.setContentAreaFilled(false);
        VendorPerfBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VendorPerfBtn.setFocusPainted(false);
        VendorPerfBtn.setFocusable(false);
        VendorPerfBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        VendorPerfBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        VendorPerfBtn.setIconTextGap(10);
        VendorPerfBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        VendorPerfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VendorPerfBtnActionPerformed(evt);
            }
        });

        DRPerfBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DRPerfBtn.setForeground(new java.awt.Color(255, 255, 255));
        DRPerfBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/performance(runner).png"))); // NOI18N
        DRPerfBtn.setText("Delivery Runner Performance");
        DRPerfBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        DRPerfBtn.setBorderPainted(false);
        DRPerfBtn.setContentAreaFilled(false);
        DRPerfBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DRPerfBtn.setFocusPainted(false);
        DRPerfBtn.setFocusable(false);
        DRPerfBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DRPerfBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        DRPerfBtn.setIconTextGap(10);
        DRPerfBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        DRPerfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DRPerfBtnActionPerformed(evt);
            }
        });

        CusComplaintsBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CusComplaintsBtn.setForeground(new java.awt.Color(255, 255, 255));
        CusComplaintsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/complaint.png"))); // NOI18N
        CusComplaintsBtn.setText("Customer Complaints");
        CusComplaintsBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        CusComplaintsBtn.setBorderPainted(false);
        CusComplaintsBtn.setContentAreaFilled(false);
        CusComplaintsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CusComplaintsBtn.setFocusPainted(false);
        CusComplaintsBtn.setFocusable(false);
        CusComplaintsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CusComplaintsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        CusComplaintsBtn.setIconTextGap(10);
        CusComplaintsBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        CusComplaintsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusComplaintsBtnActionPerformed(evt);
            }
        });

        RmvItemBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        RmvItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        RmvItemBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/remove.png"))); // NOI18N
        RmvItemBtn.setText("Remove Vendor Item");
        RmvItemBtn.setToolTipText("");
        RmvItemBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        RmvItemBtn.setBorderPainted(false);
        RmvItemBtn.setContentAreaFilled(false);
        RmvItemBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RmvItemBtn.setFocusPainted(false);
        RmvItemBtn.setFocusable(false);
        RmvItemBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RmvItemBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        RmvItemBtn.setIconTextGap(10);
        RmvItemBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        RmvItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RmvItemBtnActionPerformed(evt);
            }
        });

        SeparatorPanel.setBackground(new java.awt.Color(255, 255, 255));
        SeparatorPanel.setPreferredSize(new java.awt.Dimension(256, 3));

        javax.swing.GroupLayout SeparatorPanelLayout = new javax.swing.GroupLayout(SeparatorPanel);
        SeparatorPanel.setLayout(SeparatorPanelLayout);
        SeparatorPanelLayout.setHorizontalGroup(
            SeparatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );
        SeparatorPanelLayout.setVerticalGroup(
            SeparatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        LogoLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N

        LogoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LogoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png"))); // NOI18N
        LogoutBtn.setText("Logout");
        LogoutBtn.setToolTipText("");
        LogoutBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        LogoutBtn.setBorderPainted(false);
        LogoutBtn.setContentAreaFilled(false);
        LogoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutBtn.setFocusPainted(false);
        LogoutBtn.setFocusable(false);
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
            .addComponent(VendorPerfBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RmvItemBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CusComplaintsBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DRPerfBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LogoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(SeparatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(LogoLbl)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(LogoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(VendorPerfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DRPerfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CusComplaintsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RmvItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SeparatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ParentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanel.setLayout(new java.awt.CardLayout());

        WelcomePanel.setBackground(new java.awt.Color(255, 255, 255));

        BackgroundLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N

        WelcomeLbl.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        WelcomeLbl.setText("Welcome, User");

        PageTypeLbl.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        PageTypeLbl.setText("Manager Page");

        javax.swing.GroupLayout WelcomePanelLayout = new javax.swing.GroupLayout(WelcomePanel);
        WelcomePanel.setLayout(WelcomePanelLayout);
        WelcomePanelLayout.setHorizontalGroup(
            WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WelcomePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BackgroundLbl))
            .addGroup(WelcomePanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WelcomePanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(PageTypeLbl))
                    .addComponent(WelcomeLbl))
                .addContainerGap(283, Short.MAX_VALUE))
        );
        WelcomePanelLayout.setVerticalGroup(
            WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WelcomePanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(WelcomeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PageTypeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(BackgroundLbl))
        );

        ParentPanel.add(WelcomePanel, "card2");

        VendorPerfPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout VendorPerfPanelLayout = new javax.swing.GroupLayout(VendorPerfPanel);
        VendorPerfPanel.setLayout(VendorPerfPanelLayout);
        VendorPerfPanelLayout.setHorizontalGroup(
            VendorPerfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        VendorPerfPanelLayout.setVerticalGroup(
            VendorPerfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        ParentPanel.add(VendorPerfPanel, "card3");

        DRPerfPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout DRPerfPanelLayout = new javax.swing.GroupLayout(DRPerfPanel);
        DRPerfPanel.setLayout(DRPerfPanelLayout);
        DRPerfPanelLayout.setHorizontalGroup(
            DRPerfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        DRPerfPanelLayout.setVerticalGroup(
            DRPerfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        ParentPanel.add(DRPerfPanel, "card4");

        CusComplaintsPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout CusComplaintsPanelLayout = new javax.swing.GroupLayout(CusComplaintsPanel);
        CusComplaintsPanel.setLayout(CusComplaintsPanelLayout);
        CusComplaintsPanelLayout.setHorizontalGroup(
            CusComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        CusComplaintsPanelLayout.setVerticalGroup(
            CusComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        ParentPanel.add(CusComplaintsPanel, "card5");

        RmvItemPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout RmvItemPanelLayout = new javax.swing.GroupLayout(RmvItemPanel);
        RmvItemPanel.setLayout(RmvItemPanelLayout);
        RmvItemPanelLayout.setHorizontalGroup(
            RmvItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        RmvItemPanelLayout.setVerticalGroup(
            RmvItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        ParentPanel.add(RmvItemPanel, "card6");

        javax.swing.GroupLayout BackgroundPanelLayout = new javax.swing.GroupLayout(BackgroundPanel);
        BackgroundPanel.setLayout(BackgroundPanelLayout);
        BackgroundPanelLayout.setHorizontalGroup(
            BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ParentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BackgroundPanelLayout.setVerticalGroup(
            BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ParentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VendorPerfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VendorPerfBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(VendorPerfPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(VendorPerfBtn, hoverIcon1);
    }//GEN-LAST:event_VendorPerfBtnActionPerformed

    private void DRPerfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DRPerfBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(DRPerfPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(DRPerfBtn, hoverIcon2);
    }//GEN-LAST:event_DRPerfBtnActionPerformed

    private void CusComplaintsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusComplaintsBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(CusComplaintsPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(CusComplaintsBtn, hoverIcon3);
    }//GEN-LAST:event_CusComplaintsBtnActionPerformed

    private void RmvItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RmvItemBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(RmvItemPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(RmvItemBtn, hoverIcon4);
    }//GEN-LAST:event_RmvItemBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ManagerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerPage(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundLbl;
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JButton CusComplaintsBtn;
    private javax.swing.JPanel CusComplaintsPanel;
    private javax.swing.JButton DRPerfBtn;
    private javax.swing.JPanel DRPerfPanel;
    private javax.swing.JLabel LogoLbl;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JLabel PageTypeLbl;
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JButton RmvItemBtn;
    private javax.swing.JPanel RmvItemPanel;
    private javax.swing.JPanel SeparatorPanel;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton VendorPerfBtn;
    private javax.swing.JPanel VendorPerfPanel;
    private javax.swing.JLabel WelcomeLbl;
    private javax.swing.JPanel WelcomePanel;
    // End of variables declaration//GEN-END:variables
}
