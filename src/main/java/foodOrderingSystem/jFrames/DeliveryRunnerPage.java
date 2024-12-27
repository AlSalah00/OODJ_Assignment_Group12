
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

public class DeliveryRunnerPage extends javax.swing.JFrame {

    
    
    Icon defaultIcon1 = new ImageIcon(ButtonStyler.class.getResource("/task.png"));
    Icon hoverIcon1 = new ImageIcon(ButtonStyler.class.getResource("/taskHover.png"));
        
    Icon defaultIcon2 = new ImageIcon(ButtonStyler.class.getResource("/task-status.png"));
    Icon hoverIcon2 = new ImageIcon(ButtonStyler.class.getResource("/task-statusHover.png"));
    
    Icon defaultIcon3 = new ImageIcon(ButtonStyler.class.getResource("/task-history.png"));
    Icon hoverIcon3 = new ImageIcon(ButtonStyler.class.getResource("/task-historyHover.png"));
    
    Icon defaultIcon4 = new ImageIcon(ButtonStyler.class.getResource("/review.png"));
    Icon hoverIcon4 = new ImageIcon(ButtonStyler.class.getResource("/reviewHover.png"));
    
    Icon defaultIcon5 = new ImageIcon(ButtonStyler.class.getResource("/profit.png"));
    Icon hoverIcon5 = new ImageIcon(ButtonStyler.class.getResource("/profitHover.png"));
    
    Icon defaultIcon6 = new ImageIcon(ButtonStyler.class.getResource("/bell.png"));
    Icon hoverIcon6 = new ImageIcon(ButtonStyler.class.getResource("/bellHover.png"));
    
    Icon defaultIcon7 = new ImageIcon(ButtonStyler.class.getResource("/logout.png"));
    Icon hoverIcon7 = new ImageIcon(ButtonStyler.class.getResource("/logoutHover.png"));
    
    public DeliveryRunnerPage(String username) {
        
        try { 
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception ignored){}
        
        initComponents();
        
        WelcomeLbl.setText("Welcome, " + username);
                         
        JButton[] allButtons = {TasksBtn, TaskStatusBtn, TaskHisBtn, CusReviewsBtn, RevenueBtn, NotificationBtn, LogoutBtn};      
        
        ButtonStyler.applyMouseEffects(TasksBtn, allButtons, defaultIcon1, hoverIcon1);
        ButtonStyler.applyMouseEffects(TaskStatusBtn, allButtons, defaultIcon2, hoverIcon2);
        ButtonStyler.applyMouseEffects(TaskHisBtn, allButtons, defaultIcon3, hoverIcon3);
        ButtonStyler.applyMouseEffects(CusReviewsBtn, allButtons, defaultIcon4, hoverIcon4);
        ButtonStyler.applyMouseEffects(RevenueBtn, allButtons, defaultIcon5, hoverIcon5);
        ButtonStyler.applyMouseEffects(NotificationBtn, allButtons, defaultIcon6, hoverIcon6);
        ButtonStyler.applyMouseEffects(LogoutBtn, allButtons, defaultIcon7, hoverIcon7);
    }
    
    private void resetToDefault() {
        ButtonStyler.applyDefaultStyle(TasksBtn, defaultIcon1);
        ButtonStyler.applyDefaultStyle(TaskStatusBtn, defaultIcon2);
        ButtonStyler.applyDefaultStyle(TaskHisBtn, defaultIcon3);
        ButtonStyler.applyDefaultStyle(CusReviewsBtn, defaultIcon4);
        ButtonStyler.applyDefaultStyle(RevenueBtn, defaultIcon5);
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
        TasksBtn = new javax.swing.JButton();
        TaskStatusBtn = new javax.swing.JButton();
        TaskHisBtn = new javax.swing.JButton();
        CusReviewsBtn = new javax.swing.JButton();
        SeparatorPanel = new javax.swing.JPanel();
        LogoLbl = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JButton();
        RevenueBtn = new javax.swing.JButton();
        NotificationBtn = new javax.swing.JButton();
        ParentPanel = new javax.swing.JPanel();
        WelcomePanel = new javax.swing.JPanel();
        BackgroundLbl = new javax.swing.JLabel();
        WelcomeLbl = new javax.swing.JLabel();
        PageTypeLbl = new javax.swing.JLabel();
        TasksPanel = new javax.swing.JPanel();
        TaskStatusPanel = new javax.swing.JPanel();
        TaskHistoryPanel = new javax.swing.JPanel();
        CusReviewsPanel = new javax.swing.JPanel();
        RevenuePanel = new javax.swing.JPanel();
        NotificationPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        SidePanel.setBackground(new java.awt.Color(255, 153, 0));

        TasksBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TasksBtn.setForeground(new java.awt.Color(255, 255, 255));
        TasksBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/task.png"))); // NOI18N
        TasksBtn.setText("Tasks");
        TasksBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        TasksBtn.setBorderPainted(false);
        TasksBtn.setContentAreaFilled(false);
        TasksBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TasksBtn.setFocusPainted(false);
        TasksBtn.setFocusable(false);
        TasksBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TasksBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        TasksBtn.setIconTextGap(10);
        TasksBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        TasksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TasksBtnActionPerformed(evt);
            }
        });

        TaskStatusBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TaskStatusBtn.setForeground(new java.awt.Color(255, 255, 255));
        TaskStatusBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/task-status.png"))); // NOI18N
        TaskStatusBtn.setText("Task Status");
        TaskStatusBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        TaskStatusBtn.setBorderPainted(false);
        TaskStatusBtn.setContentAreaFilled(false);
        TaskStatusBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TaskStatusBtn.setFocusPainted(false);
        TaskStatusBtn.setFocusable(false);
        TaskStatusBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TaskStatusBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        TaskStatusBtn.setIconTextGap(10);
        TaskStatusBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        TaskStatusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaskStatusBtnActionPerformed(evt);
            }
        });

        TaskHisBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TaskHisBtn.setForeground(new java.awt.Color(255, 255, 255));
        TaskHisBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/task-history.png"))); // NOI18N
        TaskHisBtn.setText("Task History");
        TaskHisBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        TaskHisBtn.setBorderPainted(false);
        TaskHisBtn.setContentAreaFilled(false);
        TaskHisBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TaskHisBtn.setFocusPainted(false);
        TaskHisBtn.setFocusable(false);
        TaskHisBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TaskHisBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        TaskHisBtn.setIconTextGap(10);
        TaskHisBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        TaskHisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaskHisBtnActionPerformed(evt);
            }
        });

        CusReviewsBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CusReviewsBtn.setForeground(new java.awt.Color(255, 255, 255));
        CusReviewsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/review.png"))); // NOI18N
        CusReviewsBtn.setText("Customer Reviews");
        CusReviewsBtn.setToolTipText("");
        CusReviewsBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        CusReviewsBtn.setBorderPainted(false);
        CusReviewsBtn.setContentAreaFilled(false);
        CusReviewsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CusReviewsBtn.setFocusPainted(false);
        CusReviewsBtn.setFocusable(false);
        CusReviewsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CusReviewsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        CusReviewsBtn.setIconTextGap(10);
        CusReviewsBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        CusReviewsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusReviewsBtnActionPerformed(evt);
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

        NotificationBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NotificationBtn.setForeground(new java.awt.Color(255, 255, 255));
        NotificationBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bell.png"))); // NOI18N
        NotificationBtn.setText("Notification");
        NotificationBtn.setToolTipText("");
        NotificationBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        NotificationBtn.setBorderPainted(false);
        NotificationBtn.setContentAreaFilled(false);
        NotificationBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NotificationBtn.setFocusPainted(false);
        NotificationBtn.setFocusable(false);
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
            .addComponent(TasksBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CusReviewsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TaskHisBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TaskStatusBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RevenueBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(TasksBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TaskStatusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TaskHisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CusReviewsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RevenueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        PageTypeLbl.setText("Delivery Runner Page");

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

        TasksPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout TasksPanelLayout = new javax.swing.GroupLayout(TasksPanel);
        TasksPanel.setLayout(TasksPanelLayout);
        TasksPanelLayout.setHorizontalGroup(
            TasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        TasksPanelLayout.setVerticalGroup(
            TasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        ParentPanel.add(TasksPanel, "card3");

        TaskStatusPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout TaskStatusPanelLayout = new javax.swing.GroupLayout(TaskStatusPanel);
        TaskStatusPanel.setLayout(TaskStatusPanelLayout);
        TaskStatusPanelLayout.setHorizontalGroup(
            TaskStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        TaskStatusPanelLayout.setVerticalGroup(
            TaskStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        ParentPanel.add(TaskStatusPanel, "card4");

        TaskHistoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout TaskHistoryPanelLayout = new javax.swing.GroupLayout(TaskHistoryPanel);
        TaskHistoryPanel.setLayout(TaskHistoryPanelLayout);
        TaskHistoryPanelLayout.setHorizontalGroup(
            TaskHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        TaskHistoryPanelLayout.setVerticalGroup(
            TaskHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        ParentPanel.add(TaskHistoryPanel, "card5");

        CusReviewsPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout CusReviewsPanelLayout = new javax.swing.GroupLayout(CusReviewsPanel);
        CusReviewsPanel.setLayout(CusReviewsPanelLayout);
        CusReviewsPanelLayout.setHorizontalGroup(
            CusReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        CusReviewsPanelLayout.setVerticalGroup(
            CusReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        ParentPanel.add(CusReviewsPanel, "card6");

        RevenuePanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout RevenuePanelLayout = new javax.swing.GroupLayout(RevenuePanel);
        RevenuePanel.setLayout(RevenuePanelLayout);
        RevenuePanelLayout.setHorizontalGroup(
            RevenuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        RevenuePanelLayout.setVerticalGroup(
            RevenuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        ParentPanel.add(RevenuePanel, "card7");

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

    private void TasksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TasksBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(TasksPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(TasksBtn, hoverIcon1);
    }//GEN-LAST:event_TasksBtnActionPerformed

    private void TaskStatusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaskStatusBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(TaskStatusPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(TaskStatusBtn, hoverIcon2);
    }//GEN-LAST:event_TaskStatusBtnActionPerformed

    private void TaskHisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaskHisBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(TaskHistoryPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(TaskHisBtn, hoverIcon3);
    }//GEN-LAST:event_TaskHisBtnActionPerformed

    private void CusReviewsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusReviewsBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(CusReviewsPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(CusReviewsBtn, hoverIcon4);
    }//GEN-LAST:event_CusReviewsBtnActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void RevenueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RevenueBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(RevenuePanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(RevenueBtn, hoverIcon5);
    }//GEN-LAST:event_RevenueBtnActionPerformed

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
            java.util.logging.Logger.getLogger(DeliveryRunnerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeliveryRunnerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeliveryRunnerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeliveryRunnerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeliveryRunnerPage(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundLbl;
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JButton CusReviewsBtn;
    private javax.swing.JPanel CusReviewsPanel;
    private javax.swing.JLabel LogoLbl;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JButton NotificationBtn;
    private javax.swing.JPanel NotificationPanel;
    private javax.swing.JLabel PageTypeLbl;
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JButton RevenueBtn;
    private javax.swing.JPanel RevenuePanel;
    private javax.swing.JPanel SeparatorPanel;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton TaskHisBtn;
    private javax.swing.JPanel TaskHistoryPanel;
    private javax.swing.JButton TaskStatusBtn;
    private javax.swing.JPanel TaskStatusPanel;
    private javax.swing.JButton TasksBtn;
    private javax.swing.JPanel TasksPanel;
    private javax.swing.JLabel WelcomeLbl;
    private javax.swing.JPanel WelcomePanel;
    // End of variables declaration//GEN-END:variables
}
