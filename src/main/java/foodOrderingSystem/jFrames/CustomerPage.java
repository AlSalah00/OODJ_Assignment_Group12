
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

public class CustomerPage extends javax.swing.JFrame {

    
    
    Icon defaultIcon1 = new ImageIcon(ButtonStyler.class.getResource("/menu.png"));
    Icon hoverIcon1 = new ImageIcon(ButtonStyler.class.getResource("/menuHover.png"));
        
    Icon defaultIcon2 = new ImageIcon(ButtonStyler.class.getResource("/track.png"));
    Icon hoverIcon2 = new ImageIcon(ButtonStyler.class.getResource("/trackHover.png"));
    
    Icon defaultIcon3 = new ImageIcon(ButtonStyler.class.getResource("/order-history.png"));
    Icon hoverIcon3 = new ImageIcon(ButtonStyler.class.getResource("/order-historyHover.png"));
    
    Icon defaultIcon4 = new ImageIcon(ButtonStyler.class.getResource("/transaction-history.png"));
    Icon hoverIcon4 = new ImageIcon(ButtonStyler.class.getResource("/transaction-historyHover.png"));
    
    Icon defaultIcon5 = new ImageIcon(ButtonStyler.class.getResource("/review.png"));
    Icon hoverIcon5 = new ImageIcon(ButtonStyler.class.getResource("/reviewHover.png"));
    
    Icon defaultIcon6 = new ImageIcon(ButtonStyler.class.getResource("/bell.png"));
    Icon hoverIcon6 = new ImageIcon(ButtonStyler.class.getResource("/bellHover.png"));
    
    Icon defaultIcon7 = new ImageIcon(ButtonStyler.class.getResource("/logout.png"));
    Icon hoverIcon7 = new ImageIcon(ButtonStyler.class.getResource("/logoutHover.png"));
    
    public CustomerPage() {
        initComponents();
        
                         
        JButton[] allButtons = {MenuBtn, OrderStatusBtn, OrderHisBtn, TransactionHisBtn, ReviewsBtn, NotificationBtn, LogoutBtn};      
        
        ButtonStyler.applyMouseEffects(MenuBtn, allButtons, defaultIcon1, hoverIcon1);
        ButtonStyler.applyMouseEffects(OrderStatusBtn, allButtons, defaultIcon2, hoverIcon2);
        ButtonStyler.applyMouseEffects(OrderHisBtn, allButtons, defaultIcon3, hoverIcon3);
        ButtonStyler.applyMouseEffects(TransactionHisBtn, allButtons, defaultIcon4, hoverIcon4);
        ButtonStyler.applyMouseEffects(ReviewsBtn, allButtons, defaultIcon5, hoverIcon5);
        ButtonStyler.applyMouseEffects(NotificationBtn, allButtons, defaultIcon6, hoverIcon6);
        ButtonStyler.applyMouseEffects(LogoutBtn, allButtons, defaultIcon7, hoverIcon7);
    }
    
    private void resetToDefault() {
        ButtonStyler.applyDefaultStyle(MenuBtn, defaultIcon1);
        ButtonStyler.applyDefaultStyle(OrderStatusBtn, defaultIcon2);
        ButtonStyler.applyDefaultStyle(OrderHisBtn, defaultIcon3);
        ButtonStyler.applyDefaultStyle(TransactionHisBtn, defaultIcon4);
        ButtonStyler.applyDefaultStyle(ReviewsBtn, defaultIcon5);
        ButtonStyler.applyDefaultStyle(NotificationBtn, defaultIcon6);
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
        MenuBtn = new javax.swing.JButton();
        OrderStatusBtn = new javax.swing.JButton();
        OrderHisBtn = new javax.swing.JButton();
        TransactionHisBtn = new javax.swing.JButton();
        SeparatorPanel = new javax.swing.JPanel();
        LogoLbl = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JButton();
        ReviewsBtn = new javax.swing.JButton();
        NotificationBtn = new javax.swing.JButton();
        ParentPanel = new javax.swing.JPanel();
        WelcomePanel = new javax.swing.JPanel();
        BackgroundLbl = new javax.swing.JLabel();
        WelcomeLbl = new javax.swing.JLabel();
        PageTypeLbl = new javax.swing.JLabel();
        MenuPanel = new javax.swing.JPanel();
        OrderStatusPanel = new javax.swing.JPanel();
        OrderHistoryPanel = new javax.swing.JPanel();
        TransactionHisPanel = new javax.swing.JPanel();
        ReviewsPanel = new javax.swing.JPanel();
        NotificationPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        SidePanel.setBackground(new java.awt.Color(255, 153, 0));

        MenuBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MenuBtn.setForeground(new java.awt.Color(255, 255, 255));
        MenuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu.png"))); // NOI18N
        MenuBtn.setText("Menu");
        MenuBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4)));
        MenuBtn.setBorderPainted(false);
        MenuBtn.setContentAreaFilled(false);
        MenuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MenuBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MenuBtn.setIconTextGap(10);
        MenuBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        MenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBtnActionPerformed(evt);
            }
        });

        OrderStatusBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        OrderStatusBtn.setForeground(new java.awt.Color(255, 255, 255));
        OrderStatusBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/track.png"))); // NOI18N
        OrderStatusBtn.setText("Order Status");
        OrderStatusBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4)));
        OrderStatusBtn.setBorderPainted(false);
        OrderStatusBtn.setContentAreaFilled(false);
        OrderStatusBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        OrderHisBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4)));
        OrderHisBtn.setBorderPainted(false);
        OrderHisBtn.setContentAreaFilled(false);
        OrderHisBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OrderHisBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        OrderHisBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        OrderHisBtn.setIconTextGap(10);
        OrderHisBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        OrderHisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderHisBtnActionPerformed(evt);
            }
        });

        TransactionHisBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TransactionHisBtn.setForeground(new java.awt.Color(255, 255, 255));
        TransactionHisBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transaction-history.png"))); // NOI18N
        TransactionHisBtn.setText("Transaction History");
        TransactionHisBtn.setToolTipText("");
        TransactionHisBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 16, 5, 10), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255))));
        TransactionHisBtn.setBorderPainted(false);
        TransactionHisBtn.setContentAreaFilled(false);
        TransactionHisBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TransactionHisBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TransactionHisBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        TransactionHisBtn.setIconTextGap(10);
        TransactionHisBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        TransactionHisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransactionHisBtnActionPerformed(evt);
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

        ReviewsBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ReviewsBtn.setForeground(new java.awt.Color(255, 255, 255));
        ReviewsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/review.png"))); // NOI18N
        ReviewsBtn.setText("Reviews");
        ReviewsBtn.setToolTipText("");
        ReviewsBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 16, 5, 10), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255))));
        ReviewsBtn.setBorderPainted(false);
        ReviewsBtn.setContentAreaFilled(false);
        ReviewsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ReviewsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ReviewsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ReviewsBtn.setIconTextGap(10);
        ReviewsBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        ReviewsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReviewsBtnActionPerformed(evt);
            }
        });

        NotificationBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NotificationBtn.setForeground(new java.awt.Color(255, 255, 255));
        NotificationBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bell.png"))); // NOI18N
        NotificationBtn.setText("Notification");
        NotificationBtn.setToolTipText("");
        NotificationBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 16, 5, 10), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255))));
        NotificationBtn.setBorderPainted(false);
        NotificationBtn.setContentAreaFilled(false);
        NotificationBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NotificationBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NotificationBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        NotificationBtn.setIconTextGap(10);
        NotificationBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        NotificationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotificationBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TransactionHisBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(OrderHisBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(OrderStatusBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ReviewsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(NotificationBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(LogoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrderStatusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrderHisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransactionHisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ReviewsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NotificationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        PageTypeLbl.setText("Customer Page");

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

        MenuPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        ParentPanel.add(MenuPanel, "card3");

        OrderStatusPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout OrderStatusPanelLayout = new javax.swing.GroupLayout(OrderStatusPanel);
        OrderStatusPanel.setLayout(OrderStatusPanelLayout);
        OrderStatusPanelLayout.setHorizontalGroup(
            OrderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        OrderStatusPanelLayout.setVerticalGroup(
            OrderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        ParentPanel.add(OrderStatusPanel, "card4");

        OrderHistoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout OrderHistoryPanelLayout = new javax.swing.GroupLayout(OrderHistoryPanel);
        OrderHistoryPanel.setLayout(OrderHistoryPanelLayout);
        OrderHistoryPanelLayout.setHorizontalGroup(
            OrderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        OrderHistoryPanelLayout.setVerticalGroup(
            OrderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        ParentPanel.add(OrderHistoryPanel, "card5");

        TransactionHisPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout TransactionHisPanelLayout = new javax.swing.GroupLayout(TransactionHisPanel);
        TransactionHisPanel.setLayout(TransactionHisPanelLayout);
        TransactionHisPanelLayout.setHorizontalGroup(
            TransactionHisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        TransactionHisPanelLayout.setVerticalGroup(
            TransactionHisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        ParentPanel.add(TransactionHisPanel, "card6");

        ReviewsPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ReviewsPanelLayout = new javax.swing.GroupLayout(ReviewsPanel);
        ReviewsPanel.setLayout(ReviewsPanelLayout);
        ReviewsPanelLayout.setHorizontalGroup(
            ReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        ReviewsPanelLayout.setVerticalGroup(
            ReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        ParentPanel.add(ReviewsPanel, "card7");

        NotificationPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout NotificationPanelLayout = new javax.swing.GroupLayout(NotificationPanel);
        NotificationPanel.setLayout(NotificationPanelLayout);
        NotificationPanelLayout.setHorizontalGroup(
            NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        NotificationPanelLayout.setVerticalGroup(
            NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        ParentPanel.add(NotificationPanel, "card8");

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

    private void MenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(MenuPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(MenuBtn, hoverIcon1);
    }//GEN-LAST:event_MenuBtnActionPerformed

    private void OrderStatusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderStatusBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(OrderStatusPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(OrderStatusBtn, hoverIcon2);
    }//GEN-LAST:event_OrderStatusBtnActionPerformed

    private void OrderHisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderHisBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(OrderHistoryPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(OrderHisBtn, hoverIcon3);
    }//GEN-LAST:event_OrderHisBtnActionPerformed

    private void TransactionHisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransactionHisBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(TransactionHisPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(TransactionHisBtn, hoverIcon4);
    }//GEN-LAST:event_TransactionHisBtnActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void ReviewsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReviewsBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(ReviewsPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(ReviewsBtn, hoverIcon5);
    }//GEN-LAST:event_ReviewsBtnActionPerformed

    private void NotificationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificationBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(NotificationPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(NotificationBtn, hoverIcon6);
    }//GEN-LAST:event_NotificationBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundLbl;
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JLabel LogoLbl;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JButton MenuBtn;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JButton NotificationBtn;
    private javax.swing.JPanel NotificationPanel;
    private javax.swing.JButton OrderHisBtn;
    private javax.swing.JPanel OrderHistoryPanel;
    private javax.swing.JButton OrderStatusBtn;
    private javax.swing.JPanel OrderStatusPanel;
    private javax.swing.JLabel PageTypeLbl;
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JButton ReviewsBtn;
    private javax.swing.JPanel ReviewsPanel;
    private javax.swing.JPanel SeparatorPanel;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton TransactionHisBtn;
    private javax.swing.JPanel TransactionHisPanel;
    private javax.swing.JLabel WelcomeLbl;
    private javax.swing.JPanel WelcomePanel;
    // End of variables declaration//GEN-END:variables
}
