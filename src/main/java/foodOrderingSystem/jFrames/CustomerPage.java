
package foodOrderingSystem.jFrames;
import foodOrderingSystem.Classes.ButtonStyler;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.UIManager;

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
    
    public CustomerPage(String username) {
        
        try { 
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception ignored){}
        
        initComponents();
        
        WelcomeLbl.setText("Welcome, " + username);
        
                         
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
    
    private void refreshRestaurants() {
        
         try (BufferedReader br = new BufferedReader(new FileReader("User.txt"))) {
             String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("--"); 
                if (parts.length == 6 && parts[5].trim().equalsIgnoreCase("Vendor")) { 
                    RestaurantsComboBox.addItem(parts[1].trim());
                }
            }
         } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CustomerPage.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        MenuTable = new javax.swing.JTable();
        OrderBtn = new javax.swing.JButton();
        RestaurantsComboBox = new javax.swing.JComboBox<>();
        RestaurantsLbl = new javax.swing.JLabel();
        OrderStatusPanel = new javax.swing.JPanel();
        OrderHistoryPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TransactionTable1 = new javax.swing.JTable();
        TransactionHisPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TransactionTable = new javax.swing.JTable();
        ReviewsPanel = new javax.swing.JPanel();
        ReviewsPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ReviewsTable1 = new javax.swing.JTable();
        NotificationPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        NotificationTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        SidePanel.setBackground(new java.awt.Color(255, 153, 0));

        MenuBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MenuBtn.setForeground(new java.awt.Color(255, 255, 255));
        MenuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu.png"))); // NOI18N
        MenuBtn.setText("Menu");
        MenuBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        MenuBtn.setBorderPainted(false);
        MenuBtn.setContentAreaFilled(false);
        MenuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuBtn.setFocusPainted(false);
        MenuBtn.setFocusable(false);
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

        TransactionHisBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TransactionHisBtn.setForeground(new java.awt.Color(255, 255, 255));
        TransactionHisBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transaction-history.png"))); // NOI18N
        TransactionHisBtn.setText("Transaction History");
        TransactionHisBtn.setToolTipText("");
        TransactionHisBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        TransactionHisBtn.setBorderPainted(false);
        TransactionHisBtn.setContentAreaFilled(false);
        TransactionHisBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TransactionHisBtn.setFocusPainted(false);
        TransactionHisBtn.setFocusable(false);
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

        ReviewsBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ReviewsBtn.setForeground(new java.awt.Color(255, 255, 255));
        ReviewsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/review.png"))); // NOI18N
        ReviewsBtn.setText("Reviews");
        ReviewsBtn.setToolTipText("");
        ReviewsBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        ReviewsBtn.setBorderPainted(false);
        ReviewsBtn.setContentAreaFilled(false);
        ReviewsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ReviewsBtn.setFocusPainted(false);
        ReviewsBtn.setFocusable(false);
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

        MenuTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "ItemPrice", "ItemName", "ItemType"
            }
        ));
        MenuTable.setFocusable(false);
        MenuTable.setGridColor(new java.awt.Color(0, 0, 0));
        MenuTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        MenuTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        MenuTable.setShowGrid(true);
        MenuTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(MenuTable);
        if (MenuTable.getColumnModel().getColumnCount() > 0) {
            MenuTable.getColumnModel().getColumn(0).setHeaderValue("ID");
            MenuTable.getColumnModel().getColumn(3).setHeaderValue("ItemType");
        }

        OrderBtn.setBackground(new java.awt.Color(255, 153, 0));
        OrderBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        OrderBtn.setForeground(new java.awt.Color(255, 255, 255));
        OrderBtn.setText("Order");
        OrderBtn.setBorder(null);
        OrderBtn.setBorderPainted(false);
        OrderBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OrderBtn.setFocusPainted(false);
        OrderBtn.setFocusable(false);
        OrderBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderBtnMouseClicked(evt);
            }
        });

        RestaurantsComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RestaurantsComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RestaurantsComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RestaurantsComboBox.setFocusable(false);
        RestaurantsComboBox.setOpaque(true);

        RestaurantsLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        RestaurantsLbl.setText("Restaurants");

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RestaurantsLbl)
                    .addComponent(OrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RestaurantsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(RestaurantsLbl)
                .addGap(18, 18, 18)
                .addComponent(RestaurantsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(OrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
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

        TransactionTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TransactionTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "OrderID", "Restaurant", "Date", "Paid", "Status"
            }
        ));
        TransactionTable1.setFocusable(false);
        TransactionTable1.setGridColor(new java.awt.Color(0, 0, 0));
        TransactionTable1.setSelectionBackground(new java.awt.Color(255, 153, 0));
        TransactionTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TransactionTable1.setShowGrid(true);
        TransactionTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(TransactionTable1);

        javax.swing.GroupLayout OrderHistoryPanelLayout = new javax.swing.GroupLayout(OrderHistoryPanel);
        OrderHistoryPanel.setLayout(OrderHistoryPanelLayout);
        OrderHistoryPanelLayout.setHorizontalGroup(
            OrderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderHistoryPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        OrderHistoryPanelLayout.setVerticalGroup(
            OrderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderHistoryPanelLayout.createSequentialGroup()
                .addContainerGap(219, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );

        ParentPanel.add(OrderHistoryPanel, "card5");

        TransactionHisPanel.setBackground(new java.awt.Color(255, 255, 255));

        TransactionTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TransactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "OrderID", "Date", "Paid"
            }
        ));
        TransactionTable.setFocusable(false);
        TransactionTable.setGridColor(new java.awt.Color(0, 0, 0));
        TransactionTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        TransactionTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TransactionTable.setShowGrid(true);
        TransactionTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TransactionTable);
        if (TransactionTable.getColumnModel().getColumnCount() > 0) {
            TransactionTable.getColumnModel().getColumn(0).setHeaderValue("ID");
        }

        javax.swing.GroupLayout TransactionHisPanelLayout = new javax.swing.GroupLayout(TransactionHisPanel);
        TransactionHisPanel.setLayout(TransactionHisPanelLayout);
        TransactionHisPanelLayout.setHorizontalGroup(
            TransactionHisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionHisPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        TransactionHisPanelLayout.setVerticalGroup(
            TransactionHisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransactionHisPanelLayout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );

        ParentPanel.add(TransactionHisPanel, "card6");

        ReviewsPanel.setBackground(new java.awt.Color(255, 255, 255));

        ReviewsPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ReviewsTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ReviewsTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "OrderID", "Vendor", "Date"
            }
        ));
        ReviewsTable1.setFocusable(false);
        ReviewsTable1.setGridColor(new java.awt.Color(0, 0, 0));
        ReviewsTable1.setSelectionBackground(new java.awt.Color(255, 153, 0));
        ReviewsTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ReviewsTable1.setShowGrid(true);
        ReviewsTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(ReviewsTable1);
        if (ReviewsTable1.getColumnModel().getColumnCount() > 0) {
            ReviewsTable1.getColumnModel().getColumn(0).setHeaderValue("ID");
        }

        javax.swing.GroupLayout ReviewsPanel1Layout = new javax.swing.GroupLayout(ReviewsPanel1);
        ReviewsPanel1.setLayout(ReviewsPanel1Layout);
        ReviewsPanel1Layout.setHorizontalGroup(
            ReviewsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReviewsPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        ReviewsPanel1Layout.setVerticalGroup(
            ReviewsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReviewsPanel1Layout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );

        javax.swing.GroupLayout ReviewsPanelLayout = new javax.swing.GroupLayout(ReviewsPanel);
        ReviewsPanel.setLayout(ReviewsPanelLayout);
        ReviewsPanelLayout.setHorizontalGroup(
            ReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(ReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ReviewsPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ReviewsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        ReviewsPanelLayout.setVerticalGroup(
            ReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
            .addGroup(ReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ReviewsPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ReviewsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        ParentPanel.add(ReviewsPanel, "card7");

        NotificationPanel.setBackground(new java.awt.Color(255, 255, 255));

        NotificationTable2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NotificationTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Message", "Date"
            }
        ));
        NotificationTable2.setFocusable(false);
        NotificationTable2.setGridColor(new java.awt.Color(0, 0, 0));
        NotificationTable2.setSelectionBackground(new java.awt.Color(255, 153, 0));
        NotificationTable2.setSelectionForeground(new java.awt.Color(255, 255, 255));
        NotificationTable2.setShowGrid(true);
        NotificationTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(NotificationTable2);
        if (NotificationTable2.getColumnModel().getColumnCount() > 0) {
            NotificationTable2.getColumnModel().getColumn(0).setHeaderValue("ID");
        }

        javax.swing.GroupLayout NotificationPanelLayout = new javax.swing.GroupLayout(NotificationPanel);
        NotificationPanel.setLayout(NotificationPanelLayout);
        NotificationPanelLayout.setHorizontalGroup(
            NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NotificationPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        NotificationPanelLayout.setVerticalGroup(
            NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NotificationPanelLayout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
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
        refreshRestaurants();
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

    private void OrderBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderBtnMouseClicked
        //addUser();
        //resetFields();
    }//GEN-LAST:event_OrderBtnMouseClicked

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
                new CustomerPage(null).setVisible(true);
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
    private javax.swing.JTable MenuTable;
    private javax.swing.JButton NotificationBtn;
    private javax.swing.JPanel NotificationPanel;
    private javax.swing.JTable NotificationTable2;
    private javax.swing.JButton OrderBtn;
    private javax.swing.JButton OrderHisBtn;
    private javax.swing.JPanel OrderHistoryPanel;
    private javax.swing.JButton OrderStatusBtn;
    private javax.swing.JPanel OrderStatusPanel;
    private javax.swing.JLabel PageTypeLbl;
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JComboBox<String> RestaurantsComboBox;
    private javax.swing.JLabel RestaurantsLbl;
    private javax.swing.JButton ReviewsBtn;
    private javax.swing.JPanel ReviewsPanel;
    private javax.swing.JPanel ReviewsPanel1;
    private javax.swing.JTable ReviewsTable1;
    private javax.swing.JPanel SeparatorPanel;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton TransactionHisBtn;
    private javax.swing.JPanel TransactionHisPanel;
    private javax.swing.JTable TransactionTable;
    private javax.swing.JTable TransactionTable1;
    private javax.swing.JLabel WelcomeLbl;
    private javax.swing.JPanel WelcomePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
