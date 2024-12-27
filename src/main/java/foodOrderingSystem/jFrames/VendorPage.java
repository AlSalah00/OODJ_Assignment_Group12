
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

public class VendorPage extends javax.swing.JFrame {

    
    
    Icon defaultIcon1 = new ImageIcon(ButtonStyler.class.getResource("/menu.png"));
    Icon hoverIcon1 = new ImageIcon(ButtonStyler.class.getResource("/menuHover.png"));
        
    Icon defaultIcon2 = new ImageIcon(ButtonStyler.class.getResource("/order.png"));
    Icon hoverIcon2 = new ImageIcon(ButtonStyler.class.getResource("/orderHover.png"));
    
    Icon defaultIcon3 = new ImageIcon(ButtonStyler.class.getResource("/track.png"));
    Icon hoverIcon3 = new ImageIcon(ButtonStyler.class.getResource("/trackHover.png"));
    
    Icon defaultIcon4 = new ImageIcon(ButtonStyler.class.getResource("/order-history.png"));
    Icon hoverIcon4 = new ImageIcon(ButtonStyler.class.getResource("/order-historyHover.png"));
    
    Icon defaultIcon5 = new ImageIcon(ButtonStyler.class.getResource("/review.png"));
    Icon hoverIcon5 = new ImageIcon(ButtonStyler.class.getResource("/reviewHover.png"));
    
    Icon defaultIcon6 = new ImageIcon(ButtonStyler.class.getResource("/profit.png"));
    Icon hoverIcon6 = new ImageIcon(ButtonStyler.class.getResource("/profitHover.png"));
    
    Icon defaultIcon7 = new ImageIcon(ButtonStyler.class.getResource("/logout.png"));
    Icon hoverIcon7 = new ImageIcon(ButtonStyler.class.getResource("/logoutHover.png"));
    
    public VendorPage(String username) {
        
        try { 
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception ignored){}
        
        initComponents();
        
        WelcomeLbl.setText("Welcome, " + username);
                         
        JButton[] allButtons = {ItemsBtn, OrdersBtn, OrderStatusBtn, OrderHisBtn, CusReviewBtn, RevenueBtn, LogoutBtn};      
        
        ButtonStyler.applyMouseEffects(ItemsBtn, allButtons, defaultIcon1, hoverIcon1);
        ButtonStyler.applyMouseEffects(OrdersBtn, allButtons, defaultIcon2, hoverIcon2);
        ButtonStyler.applyMouseEffects(OrderStatusBtn, allButtons, defaultIcon3, hoverIcon3);
        ButtonStyler.applyMouseEffects(OrderHisBtn, allButtons, defaultIcon4, hoverIcon4);
        ButtonStyler.applyMouseEffects(CusReviewBtn, allButtons, defaultIcon5, hoverIcon5);
        ButtonStyler.applyMouseEffects(RevenueBtn, allButtons, defaultIcon6, hoverIcon6);
        ButtonStyler.applyMouseEffects(LogoutBtn, allButtons, defaultIcon7, hoverIcon7);
    }
    
    private void resetToDefault() {
        ButtonStyler.applyDefaultStyle(ItemsBtn, defaultIcon1);
        ButtonStyler.applyDefaultStyle(OrdersBtn, defaultIcon2);
        ButtonStyler.applyDefaultStyle(OrderStatusBtn, defaultIcon3);
        ButtonStyler.applyDefaultStyle(OrderHisBtn, defaultIcon4);
        ButtonStyler.applyDefaultStyle(CusReviewBtn, defaultIcon5);
        ButtonStyler.applyDefaultStyle(RevenueBtn, defaultIcon6);
        ButtonStyler.applyDefaultStyle(LogoutBtn, defaultIcon7);
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
        ItemsBtn = new javax.swing.JButton();
        OrdersBtn = new javax.swing.JButton();
        OrderStatusBtn = new javax.swing.JButton();
        OrderHisBtn = new javax.swing.JButton();
        SeparatorPanel = new javax.swing.JPanel();
        LogoLbl = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JButton();
        CusReviewBtn = new javax.swing.JButton();
        RevenueBtn = new javax.swing.JButton();
        ParentPanel = new javax.swing.JPanel();
        WelcomePanel = new javax.swing.JPanel();
        BackgroundLbl = new javax.swing.JLabel();
        WelcomeLbl = new javax.swing.JLabel();
        PageTypeLbl = new javax.swing.JLabel();
        ManageMenuItemsPanel = new javax.swing.JPanel();
        OrdersPanel = new javax.swing.JPanel();
        OrderStatusPanel = new javax.swing.JPanel();
        OrderHistoryPanel = new javax.swing.JPanel();
        CusReviewPanel = new javax.swing.JPanel();
        RevenuePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        SidePanel.setBackground(new java.awt.Color(255, 153, 0));

        ItemsBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ItemsBtn.setForeground(new java.awt.Color(255, 255, 255));
        ItemsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu.png"))); // NOI18N
        ItemsBtn.setText("Manage Menu Items");
        ItemsBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        ItemsBtn.setBorderPainted(false);
        ItemsBtn.setContentAreaFilled(false);
        ItemsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ItemsBtn.setFocusPainted(false);
        ItemsBtn.setFocusable(false);
        ItemsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ItemsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ItemsBtn.setIconTextGap(10);
        ItemsBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        ItemsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemsBtnActionPerformed(evt);
            }
        });

        OrdersBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        OrdersBtn.setForeground(new java.awt.Color(255, 255, 255));
        OrdersBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/order.png"))); // NOI18N
        OrdersBtn.setText("Orders");
        OrdersBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        OrdersBtn.setBorderPainted(false);
        OrdersBtn.setContentAreaFilled(false);
        OrdersBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OrdersBtn.setFocusPainted(false);
        OrdersBtn.setFocusable(false);
        OrdersBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        OrdersBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        OrdersBtn.setIconTextGap(10);
        OrdersBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        OrdersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdersBtnActionPerformed(evt);
            }
        });

        OrderStatusBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        OrderStatusBtn.setForeground(new java.awt.Color(255, 255, 255));
        OrderStatusBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/track.png"))); // NOI18N
        OrderStatusBtn.setText("Order Status");
        OrderStatusBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        OrderStatusBtn.setBorderPainted(false);
        OrderStatusBtn.setContentAreaFilled(false);
        OrderStatusBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OrderStatusBtn.setFocusPainted(false);
        OrderStatusBtn.setFocusable(false);
        OrderStatusBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        OrderStatusBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        OrderStatusBtn.setIconTextGap(10);
        OrderStatusBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        OrderStatusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderStatusBtnActionPerformed(evt);
            }
        });

        OrderHisBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        OrderHisBtn.setForeground(new java.awt.Color(255, 255, 255));
        OrderHisBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/order-history.png"))); // NOI18N
        OrderHisBtn.setText("Order History");
        OrderHisBtn.setToolTipText("");
        OrderHisBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        OrderHisBtn.setBorderPainted(false);
        OrderHisBtn.setContentAreaFilled(false);
        OrderHisBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OrderHisBtn.setFocusPainted(false);
        OrderHisBtn.setFocusable(false);
        OrderHisBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        OrderHisBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        OrderHisBtn.setIconTextGap(10);
        OrderHisBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        OrderHisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderHisBtnActionPerformed(evt);
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

        CusReviewBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CusReviewBtn.setForeground(new java.awt.Color(255, 255, 255));
        CusReviewBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/review.png"))); // NOI18N
        CusReviewBtn.setText("Customer Review");
        CusReviewBtn.setToolTipText("");
        CusReviewBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        CusReviewBtn.setBorderPainted(false);
        CusReviewBtn.setContentAreaFilled(false);
        CusReviewBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CusReviewBtn.setFocusPainted(false);
        CusReviewBtn.setFocusable(false);
        CusReviewBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CusReviewBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        CusReviewBtn.setIconTextGap(10);
        CusReviewBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        CusReviewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusReviewBtnActionPerformed(evt);
            }
        });

        RevenueBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        RevenueBtn.setForeground(new java.awt.Color(255, 255, 255));
        RevenueBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profit.png"))); // NOI18N
        RevenueBtn.setText("Revenue");
        RevenueBtn.setToolTipText("");
        RevenueBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        RevenueBtn.setBorderPainted(false);
        RevenueBtn.setContentAreaFilled(false);
        RevenueBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RevenueBtn.setFocusPainted(false);
        RevenueBtn.setFocusable(false);
        RevenueBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RevenueBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        RevenueBtn.setIconTextGap(10);
        RevenueBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        RevenueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RevenueBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ItemsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(OrderHisBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(OrderStatusBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(OrdersBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CusReviewBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LogoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(LogoLbl))
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(SeparatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addComponent(RevenueBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(LogoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ItemsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrdersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrderStatusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrderHisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CusReviewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RevenueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SeparatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        ParentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanel.setLayout(new java.awt.CardLayout());

        WelcomePanel.setBackground(new java.awt.Color(255, 255, 255));

        BackgroundLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N

        WelcomeLbl.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        WelcomeLbl.setText("Welcome, User");

        PageTypeLbl.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        PageTypeLbl.setText("Vendor Page");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(BackgroundLbl))
        );

        ParentPanel.add(WelcomePanel, "card2");

        ManageMenuItemsPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ManageMenuItemsPanelLayout = new javax.swing.GroupLayout(ManageMenuItemsPanel);
        ManageMenuItemsPanel.setLayout(ManageMenuItemsPanelLayout);
        ManageMenuItemsPanelLayout.setHorizontalGroup(
            ManageMenuItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        ManageMenuItemsPanelLayout.setVerticalGroup(
            ManageMenuItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        ParentPanel.add(ManageMenuItemsPanel, "card3");

        OrdersPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout OrdersPanelLayout = new javax.swing.GroupLayout(OrdersPanel);
        OrdersPanel.setLayout(OrdersPanelLayout);
        OrdersPanelLayout.setHorizontalGroup(
            OrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        OrdersPanelLayout.setVerticalGroup(
            OrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        ParentPanel.add(OrdersPanel, "card4");

        OrderStatusPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout OrderStatusPanelLayout = new javax.swing.GroupLayout(OrderStatusPanel);
        OrderStatusPanel.setLayout(OrderStatusPanelLayout);
        OrderStatusPanelLayout.setHorizontalGroup(
            OrderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        OrderStatusPanelLayout.setVerticalGroup(
            OrderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        ParentPanel.add(OrderStatusPanel, "card5");

        OrderHistoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout OrderHistoryPanelLayout = new javax.swing.GroupLayout(OrderHistoryPanel);
        OrderHistoryPanel.setLayout(OrderHistoryPanelLayout);
        OrderHistoryPanelLayout.setHorizontalGroup(
            OrderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        OrderHistoryPanelLayout.setVerticalGroup(
            OrderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        ParentPanel.add(OrderHistoryPanel, "card6");

        CusReviewPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout CusReviewPanelLayout = new javax.swing.GroupLayout(CusReviewPanel);
        CusReviewPanel.setLayout(CusReviewPanelLayout);
        CusReviewPanelLayout.setHorizontalGroup(
            CusReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        CusReviewPanelLayout.setVerticalGroup(
            CusReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        ParentPanel.add(CusReviewPanel, "card7");

        RevenuePanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout RevenuePanelLayout = new javax.swing.GroupLayout(RevenuePanel);
        RevenuePanel.setLayout(RevenuePanelLayout);
        RevenuePanelLayout.setHorizontalGroup(
            RevenuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        RevenuePanelLayout.setVerticalGroup(
            RevenuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        ParentPanel.add(RevenuePanel, "card8");

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

    private void ItemsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemsBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(ManageMenuItemsPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(ItemsBtn, hoverIcon1);
    }//GEN-LAST:event_ItemsBtnActionPerformed

    private void OrdersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdersBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(OrdersPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(OrdersBtn, hoverIcon2);
    }//GEN-LAST:event_OrdersBtnActionPerformed

    private void OrderStatusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderStatusBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(OrderStatusPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(OrderStatusBtn, hoverIcon3);
    }//GEN-LAST:event_OrderStatusBtnActionPerformed

    private void OrderHisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderHisBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(OrderHistoryPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(OrderHisBtn, hoverIcon4);
    }//GEN-LAST:event_OrderHisBtnActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void CusReviewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusReviewBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(CusReviewPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(CusReviewBtn, hoverIcon5);
    }//GEN-LAST:event_CusReviewBtnActionPerformed

    private void RevenueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RevenueBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(RevenuePanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(RevenueBtn, hoverIcon6);
    }//GEN-LAST:event_RevenueBtnActionPerformed

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
            java.util.logging.Logger.getLogger(VendorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendorPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendorPage(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundLbl;
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JButton CusReviewBtn;
    private javax.swing.JPanel CusReviewPanel;
    private javax.swing.JButton ItemsBtn;
    private javax.swing.JLabel LogoLbl;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JPanel ManageMenuItemsPanel;
    private javax.swing.JButton OrderHisBtn;
    private javax.swing.JPanel OrderHistoryPanel;
    private javax.swing.JButton OrderStatusBtn;
    private javax.swing.JPanel OrderStatusPanel;
    private javax.swing.JButton OrdersBtn;
    private javax.swing.JPanel OrdersPanel;
    private javax.swing.JLabel PageTypeLbl;
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JButton RevenueBtn;
    private javax.swing.JPanel RevenuePanel;
    private javax.swing.JPanel SeparatorPanel;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JLabel WelcomeLbl;
    private javax.swing.JPanel WelcomePanel;
    // End of variables declaration//GEN-END:variables
}
