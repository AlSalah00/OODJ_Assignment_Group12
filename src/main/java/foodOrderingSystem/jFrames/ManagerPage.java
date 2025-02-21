
package foodOrderingSystem.jFrames;
import foodOrderingSystem.Classes.ButtonStyler;
import foodOrderingSystem.Classes.Item;
import foodOrderingSystem.Classes.Notification;
import foodOrderingSystem.Classes.Review;
import foodOrderingSystem.Classes.User;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ManagerPage extends javax.swing.JFrame {

    Color orange = new Color(255, 153, 0, 255);  
    
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
        TableHeaderStyle(RevenueTable);
        TableHeaderStyle(RatingsTable);
        TableHeaderStyle(ComplaintsTable);
        TableHeaderStyle(ItemsTableM);
        
        JButton[] allButtons = {VendorPerfBtn, DRPerfBtn, CusComplaintsBtn, RmvItemBtn, LogoutBtn};      
        
        ButtonStyler.applyMouseEffects(VendorPerfBtn, allButtons, defaultIcon1, hoverIcon1);
        ButtonStyler.applyMouseEffects(DRPerfBtn, allButtons, defaultIcon2, hoverIcon2);
        ButtonStyler.applyMouseEffects(CusComplaintsBtn, allButtons, defaultIcon3, hoverIcon3);
        ButtonStyler.applyMouseEffects(RmvItemBtn, allButtons, defaultIcon4, hoverIcon4);
        ButtonStyler.applyMouseEffects(LogoutBtn, allButtons, defaultIcon5, hoverIcon5);
    }
    
    private void TableHeaderStyle(JTable table) {
        JTableHeader header = table.getTableHeader();
        header.setOpaque(false);
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
            label.setBackground(orange);
            label.setForeground(Color.white);
            label.setFont(new Font("Segoe UI", Font.BOLD, 14));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            return label;
        }
        });
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
    
    private void refreshVendors() {
        
        User user = new User();
        user.displayVendors(VendorsComboBox);
        
    }
    private void refreshMenu() {
        
        Item item = new Item();
        String vendor = VendorsComboBox.getSelectedItem().toString();
        
        DefaultTableModel model = (DefaultTableModel) ItemsTableM.getModel();
        model.setRowCount(0);
        
        List<String[]> records = item.ViewItems();
        
        for (String[] itemDetails : records) {
            if (itemDetails.length >= 5) {
                String name = itemDetails[1].trim();
                if (name.equalsIgnoreCase(vendor)) {
                    String id = itemDetails[0];
                    String itemName = itemDetails[2];
                    String itemPrice = itemDetails[3];
                    String itemType = itemDetails[4];          
            
                    model.addRow(
                            new Object[]{id, itemName, itemPrice, itemType
                                });
                }
            }
        }   
    }
    private void delItem() {
        
        int selectedRow = ItemsTableM.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No record selected for Removing!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String id = (String) ItemsTableM.getValueAt(selectedRow, 0);
        Item item = new Item(id);
        item.delItem();
        refreshMenu();
        
    }
    private void refreshComplaints(){
        
        
        Review review = new Review();
             
        DefaultTableModel model = (DefaultTableModel) ComplaintsTable.getModel();
        model.setRowCount(0);
        
        
        List<String[]> records = review.displayReviews();
        
        for (String[] reviewDetails : records) {
            if (reviewDetails.length >= 7) {
                String Type = reviewDetails[8].trim();
                if (Type.equalsIgnoreCase("Complaint")) {
                    
                    String id = reviewDetails[0];
                    String customer = reviewDetails[1];
                    String vendor= reviewDetails[2];
                    String DeliveryRunner = reviewDetails[3];
                    String comment = reviewDetails[5];
                             
                   
            
                    model.addRow(
                            new Object[]{id, customer, vendor,DeliveryRunner, comment
                                });
                }
            }
        }
    }
    
    private void sendReply() {
        
        int selectedRow = ComplaintsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No record selected for updating!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        String CustomerName = (String) ComplaintsTable.getValueAt(selectedRow, 1);
        String reply = ReplyTxt.getText();
        String date = java.time.LocalDate.now().toString();
        
        Notification nt = new Notification(CustomerName, "Manager reply: " + reply, date);
        nt.sendNotification();       
    }
    
    private void refreshRevenues() {
        
        User user = new User();
        
        DefaultTableModel model = (DefaultTableModel) RevenueTable.getModel();
        model.setRowCount(0);
        
        
        List<String[]> records = user.viewRevenues();
        
        for (String[] reviewDetails : records) {
            if (reviewDetails.length >= 3) {
                String role = reviewDetails[1].trim();
                if (role.equalsIgnoreCase("Vendor")) {
                    
                    String username = reviewDetails[0];
                    String revenue = reviewDetails[2];
                             
                   
            
                    model.addRow(
                            new Object[]{username, revenue
                                });
                }
            }
        }
    }

    
    
    private void refreshRatings() {
        
        Review review = new Review();
        
        DefaultTableModel model = (DefaultTableModel) RatingsTable.getModel();
        model.setRowCount(0);
        
        
        List<String[]> records = review.displayReviews();
        
        for (String[] reviewDetails : records) {
                
                    String username = reviewDetails[3];
                    String rating = reviewDetails[7];
                             
                   
            
                    model.addRow(
                            new Object[]{username, rating
                                });
                
            
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
        jScrollPane3 = new javax.swing.JScrollPane();
        RevenueTable = new javax.swing.JTable();
        DRPerfPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        RatingsTable = new javax.swing.JTable();
        CusComplaintsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ComplaintsTable = new javax.swing.JTable();
        ReplyTxt = new javax.swing.JTextField();
        Separator4 = new javax.swing.JPanel();
        SendBtn = new javax.swing.JButton();
        RmvItemPanel = new javax.swing.JPanel();
        VendorsComboBox = new javax.swing.JComboBox<>();
        Removebtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemsTableM = new javax.swing.JTable();
        RestaurantsLbl = new javax.swing.JLabel();

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

        RevenueTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RevenueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Vendor", "Revenue"
            }
        ));
        RevenueTable.setFocusable(false);
        RevenueTable.setGridColor(new java.awt.Color(0, 0, 0));
        RevenueTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        RevenueTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        RevenueTable.setShowGrid(true);
        RevenueTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(RevenueTable);

        javax.swing.GroupLayout VendorPerfPanelLayout = new javax.swing.GroupLayout(VendorPerfPanel);
        VendorPerfPanel.setLayout(VendorPerfPanelLayout);
        VendorPerfPanelLayout.setHorizontalGroup(
            VendorPerfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VendorPerfPanelLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        VendorPerfPanelLayout.setVerticalGroup(
            VendorPerfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VendorPerfPanelLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        ParentPanel.add(VendorPerfPanel, "card3");

        DRPerfPanel.setBackground(new java.awt.Color(255, 255, 255));

        RatingsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RatingsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Delivery Runner", "Rating"
            }
        ));
        RatingsTable.setFocusable(false);
        RatingsTable.setGridColor(new java.awt.Color(0, 0, 0));
        RatingsTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        RatingsTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        RatingsTable.setShowGrid(true);
        RatingsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(RatingsTable);

        javax.swing.GroupLayout DRPerfPanelLayout = new javax.swing.GroupLayout(DRPerfPanel);
        DRPerfPanel.setLayout(DRPerfPanelLayout);
        DRPerfPanelLayout.setHorizontalGroup(
            DRPerfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DRPerfPanelLayout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        DRPerfPanelLayout.setVerticalGroup(
            DRPerfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DRPerfPanelLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        ParentPanel.add(DRPerfPanel, "card4");

        CusComplaintsPanel.setBackground(new java.awt.Color(255, 255, 255));

        ComplaintsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ComplaintsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer Name", "Vendor", "Delivery Runner", "Comment"
            }
        ));
        ComplaintsTable.setFocusable(false);
        ComplaintsTable.setGridColor(new java.awt.Color(0, 0, 0));
        ComplaintsTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        ComplaintsTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ComplaintsTable.setShowGrid(true);
        ComplaintsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(ComplaintsTable);

        ReplyTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ReplyTxt.setForeground(java.awt.Color.gray);
        ReplyTxt.setText("Reply");
        ReplyTxt.setBorder(null);
        ReplyTxt.setFocusable(false);
        ReplyTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ReplyTxtFocusLost(evt);
            }
        });
        ReplyTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReplyTxtMouseClicked(evt);
            }
        });
        ReplyTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplyTxtActionPerformed(evt);
            }
        });

        Separator4.setBackground(new java.awt.Color(0, 0, 0));
        Separator4.setMaximumSize(new java.awt.Dimension(300, 1));
        Separator4.setMinimumSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout Separator4Layout = new javax.swing.GroupLayout(Separator4);
        Separator4.setLayout(Separator4Layout);
        Separator4Layout.setHorizontalGroup(
            Separator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );
        Separator4Layout.setVerticalGroup(
            Separator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        SendBtn.setBackground(new java.awt.Color(255, 153, 0));
        SendBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SendBtn.setForeground(new java.awt.Color(255, 255, 255));
        SendBtn.setText("Send");
        SendBtn.setBorder(null);
        SendBtn.setBorderPainted(false);
        SendBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SendBtn.setFocusPainted(false);
        SendBtn.setFocusable(false);
        SendBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SendBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout CusComplaintsPanelLayout = new javax.swing.GroupLayout(CusComplaintsPanel);
        CusComplaintsPanel.setLayout(CusComplaintsPanelLayout);
        CusComplaintsPanelLayout.setHorizontalGroup(
            CusComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CusComplaintsPanelLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(CusComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReplyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        CusComplaintsPanelLayout.setVerticalGroup(
            CusComplaintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CusComplaintsPanelLayout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(ReplyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(SendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        ParentPanel.add(CusComplaintsPanel, "card5");

        RmvItemPanel.setBackground(new java.awt.Color(255, 255, 255));

        VendorsComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VendorsComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        VendorsComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VendorsComboBox.setFocusable(false);
        VendorsComboBox.setOpaque(true);
        VendorsComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                VendorsComboBoxItemStateChanged(evt);
            }
        });

        Removebtn.setBackground(new java.awt.Color(255, 0, 0));
        Removebtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Removebtn.setForeground(new java.awt.Color(255, 255, 255));
        Removebtn.setText("Remove");
        Removebtn.setBorder(null);
        Removebtn.setBorderPainted(false);
        Removebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Removebtn.setFocusPainted(false);
        Removebtn.setFocusable(false);
        Removebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RemovebtnMouseClicked(evt);
            }
        });
        Removebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemovebtnActionPerformed(evt);
            }
        });

        ItemsTableM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ItemsTableM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Item Name", "Item Price (RM)", "Item Type"
            }
        ));
        ItemsTableM.setFocusable(false);
        ItemsTableM.setGridColor(new java.awt.Color(0, 0, 0));
        ItemsTableM.setSelectionBackground(new java.awt.Color(255, 153, 0));
        ItemsTableM.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ItemsTableM.setShowGrid(true);
        ItemsTableM.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ItemsTableM);

        RestaurantsLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        RestaurantsLbl.setText("Vendors");

        javax.swing.GroupLayout RmvItemPanelLayout = new javax.swing.GroupLayout(RmvItemPanel);
        RmvItemPanel.setLayout(RmvItemPanelLayout);
        RmvItemPanelLayout.setHorizontalGroup(
            RmvItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RmvItemPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(RmvItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RestaurantsLbl)
                    .addComponent(VendorsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        RmvItemPanelLayout.setVerticalGroup(
            RmvItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RmvItemPanelLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(RestaurantsLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VendorsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(Removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addGap(36, 36, 36))
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
        refreshRevenues();
    }//GEN-LAST:event_VendorPerfBtnActionPerformed

    private void DRPerfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DRPerfBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(DRPerfPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(DRPerfBtn, hoverIcon2);
        refreshRatings();
    }//GEN-LAST:event_DRPerfBtnActionPerformed

    private void CusComplaintsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusComplaintsBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(CusComplaintsPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
       
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(CusComplaintsBtn, hoverIcon3);
        refreshComplaints();
    }//GEN-LAST:event_CusComplaintsBtnActionPerformed

    private void RmvItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RmvItemBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(RmvItemPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(RmvItemBtn, hoverIcon4);
        refreshVendors();
        refreshMenu();
        
    }//GEN-LAST:event_RmvItemBtnActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        LoginPage lp = new LoginPage();
        this.dispose();
        lp.setVisible(true);
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void RemovebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemovebtnMouseClicked

    }//GEN-LAST:event_RemovebtnMouseClicked

    private void RemovebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemovebtnActionPerformed

        delItem();
    }//GEN-LAST:event_RemovebtnActionPerformed

    private void VendorsComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_VendorsComboBoxItemStateChanged
        refreshMenu();
    }//GEN-LAST:event_VendorsComboBoxItemStateChanged

    private void ReplyTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ReplyTxtFocusLost
        if ("".equals(ReplyTxt.getText())) {
            ReplyTxt.setText("Reply");
            ReplyTxt.setForeground(Color.gray);
            ReplyTxt.setFocusable(false);
        }
    }//GEN-LAST:event_ReplyTxtFocusLost

    private void ReplyTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReplyTxtMouseClicked
        ReplyTxt.setFocusable(true);
        ReplyTxt.requestFocusInWindow();
        ReplyTxt.setForeground(Color.black);

        if ("Reply".equals(ReplyTxt.getText())) {
            ReplyTxt.setText("");
        }
    }//GEN-LAST:event_ReplyTxtMouseClicked

    private void ReplyTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReplyTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReplyTxtActionPerformed

    private void SendBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendBtnMouseClicked
            sendReply();
    }//GEN-LAST:event_SendBtnMouseClicked

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
    private javax.swing.JTable ComplaintsTable;
    private javax.swing.JButton CusComplaintsBtn;
    private javax.swing.JPanel CusComplaintsPanel;
    private javax.swing.JButton DRPerfBtn;
    private javax.swing.JPanel DRPerfPanel;
    private javax.swing.JTable ItemsTableM;
    private javax.swing.JLabel LogoLbl;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JLabel PageTypeLbl;
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JTable RatingsTable;
    private javax.swing.JButton Removebtn;
    private javax.swing.JTextField ReplyTxt;
    private javax.swing.JLabel RestaurantsLbl;
    private javax.swing.JTable RevenueTable;
    private javax.swing.JButton RmvItemBtn;
    private javax.swing.JPanel RmvItemPanel;
    private javax.swing.JButton SendBtn;
    private javax.swing.JPanel Separator4;
    private javax.swing.JPanel SeparatorPanel;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton VendorPerfBtn;
    private javax.swing.JPanel VendorPerfPanel;
    private javax.swing.JComboBox<String> VendorsComboBox;
    private javax.swing.JLabel WelcomeLbl;
    private javax.swing.JPanel WelcomePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
