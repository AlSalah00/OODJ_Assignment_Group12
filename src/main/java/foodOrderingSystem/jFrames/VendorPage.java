
package foodOrderingSystem.jFrames;
import foodOrderingSystem.Classes.ButtonStyler;
import foodOrderingSystem.Classes.Item;
import foodOrderingSystem.Classes.Notification;
import foodOrderingSystem.Classes.Order;
import foodOrderingSystem.Classes.Review;
import foodOrderingSystem.Classes.User;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
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

public class VendorPage extends javax.swing.JFrame {

    Color orange = new Color(255, 153, 0, 255);   
    private String Vendor;
    
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
        TableHeaderStyle(ItemsTable);
        TableHeaderStyle(OrderTable);
        TableHeaderStyle(OrderStatusTable);
        TableHeaderStyle(OrderHistoryTable);
        TableHeaderStyle(ReviewsTable);
        
        String name = WelcomeLbl.getText();
        String[] parts = name.split(", ");
        Vendor = parts[1];
                         
        JButton[] allButtons = {ItemsBtn, OrdersBtn, OrderStatusBtn, OrderHisBtn, CusReviewBtn, RevenueBtn, LogoutBtn};      
        
        ButtonStyler.applyMouseEffects(ItemsBtn, allButtons, defaultIcon1, hoverIcon1);
        ButtonStyler.applyMouseEffects(OrdersBtn, allButtons, defaultIcon2, hoverIcon2);
        ButtonStyler.applyMouseEffects(OrderStatusBtn, allButtons, defaultIcon3, hoverIcon3);
        ButtonStyler.applyMouseEffects(OrderHisBtn, allButtons, defaultIcon4, hoverIcon4);
        ButtonStyler.applyMouseEffects(CusReviewBtn, allButtons, defaultIcon5, hoverIcon5);
        ButtonStyler.applyMouseEffects(RevenueBtn, allButtons, defaultIcon6, hoverIcon6);
        ButtonStyler.applyMouseEffects(LogoutBtn, allButtons, defaultIcon7, hoverIcon7);
        
        
        ItemsTable.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting()) {
                    populateForm();
                }
            }
        });
        this.refreshItems();
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
    
    
    private void resetFields() {
        
        ItemNameTxt.setText("Item Name");
        ItemNameTxt.setForeground(Color.gray);
        ItemNameTxt.setFocusable(false);
        
        ItemPriceTxt.setText("Item Price");
        ItemPriceTxt.setForeground(Color.gray);
        ItemPriceTxt.setFocusable(false);
    }
    
    private void refreshItems() {
        
        Item item = new Item();
        
        DefaultTableModel model = (DefaultTableModel) ItemsTable.getModel();
        model.setRowCount(0);
        
        List<String[]> records = item.ViewItems();
        
        for (String[] itemDetails : records) {
            if (itemDetails.length >= 5) {
                String name = itemDetails[1].trim();
                if (name.equalsIgnoreCase(Vendor)) {
                    
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
    
    
    private void refreshOrders(JTable table) {
        
        Order order = new Order();
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Set<String> validStatuses = Set.of("Accepted", "Preparing");
        Set<String> validHisStatuses = Set.of("Done", "Cancelled");

        
        List<String[]> records = order.ViewOrders();
        
        for (String[] OrderDetails : records) {
        if (OrderDetails.length >= 8) {
            String status = OrderDetails[7].trim();
            String name = OrderDetails[2].trim();
            
            if (name.equalsIgnoreCase(Vendor) && table == OrderTable && 
                    status.equalsIgnoreCase("Pending") || 
                    name.equalsIgnoreCase(Vendor) && table == OrderStatusTable && 
                    validStatuses.contains(status) || name.equalsIgnoreCase(Vendor) &&
                    table == OrderHistoryTable && validHisStatuses.contains(status)) {
                model.addRow(new Object[]{
                    OrderDetails[0], // ID
                    OrderDetails[1], // Customer Name
                    OrderDetails[2], // Vendor
                    OrderDetails[3], // Item
                    OrderDetails[4], // Quantity
                    OrderDetails[5], // Total
                    OrderDetails[6], // Date
                    OrderDetails[7]  // Status
                });
            }
        }
    }
    }
       
    
    private void populateForm() {
        
        int selectedRow = ItemsTable.getSelectedRow();
        if (selectedRow != -1) {
            String itemName = (String) ItemsTable.getValueAt(selectedRow, 1);
            String itemPrice = (String) ItemsTable.getValueAt(selectedRow, 2);
            String itemType = (String) ItemsTable.getValueAt(selectedRow, 3);
            
            ItemNameTxt.setForeground(Color.black);
            ItemNameTxt.setText(itemName);
            ItemPriceTxt.setForeground(Color.black);
            ItemPriceTxt.setText(itemPrice);     
            
        }
    }
    
    private static Set<String> getExistingIDs() {
        Set<String> existingIDs = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Item.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("--");
                if (data.length > 0) {
                    existingIDs.add(data[0]);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the file: " + e.getMessage());
        }
        return existingIDs;
    }
    
    public static String generateID() {
        
        Random random = new Random();
        Set<String> existingIDs = getExistingIDs();
        
        StringBuilder ID = new StringBuilder();
        String newID;
        
        do {
            ID.setLength(0);
            for (int i = 0; i < 3; i++) {
                int randomDigit = random.nextInt(10);
                ID.append(randomDigit);
            }
            newID = "I0" + ID.toString();
        } while (existingIDs.contains(newID));
        
        return newID;
    }    
    
    private void addItem() {
    
        String itemId = generateID();
        String itemName = ItemNameTxt.getText();
        String itemPrice = ItemPriceTxt.getText();
        String FoodType;
        
        if (FoodRB.isSelected()) {
            
            FoodType = "Food";
        }
        else {
            FoodType = "Drink";
        }
        
        Item item = new Item(itemId, Vendor, itemName, itemPrice, FoodType);
        item.addItem();
        refreshItems();
    }
    
    
    
    private void editItem() {
        
        String itemName = ItemNameTxt.getText();
        String itemPrice = ItemPriceTxt.getText();
        String FoodType = "";
            
        int selectedRow = ItemsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No record selected for editing!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (FoodRB.isSelected()) {
            
            FoodType = "Food";
            DrinkRB.setSelected(false);
        }
        if (DrinkRB.isSelected()) {
            FoodType = "Drink";
            FoodRB.setSelected(false);
        }
            
        String Id = (String) ItemsTable.getValueAt(selectedRow, 0);
            
        Item item = new Item(Id, Vendor, itemName, itemPrice, FoodType);
        item.editItem();  
        refreshItems();
            
    }
        private void delItem() {
        
        int selectedRow = ItemsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No record selected for deleting!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String id = (String) ItemsTable.getValueAt(selectedRow, 0);
        Item item = new Item(id);
        item.delItem();
        refreshItems(); 
    }
        
    private void updateStatus(String status, JTable table) {
     
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No record selected for updating!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            
        String Id = (String) table.getValueAt(selectedRow, 0);
        String CustomerName = (String) table.getValueAt(selectedRow, 1);
        String item = (String) table.getValueAt(selectedRow, 3);
        String quantity = (String) table.getValueAt(selectedRow, 4);
        String total = (String) table.getValueAt(selectedRow, 5);
        String date = (String) table.getValueAt(selectedRow, 6);
        
        Order order = new Order(Id, CustomerName, Vendor, item, quantity, total , date, status);
        order.updateOrderStatus();
        refreshOrders(table);
    } 

    
    private void refreshReview(){
        
        
        Review review = new Review();
             
        DefaultTableModel model = (DefaultTableModel) ReviewsTable.getModel();
        model.setRowCount(0);
        
        
        List<String[]> records = review.displayReviews();
        
        for (String[] reviewDetails : records) {
            if (reviewDetails.length >= 7) {
                String name = reviewDetails[2].trim();
                if (name.equalsIgnoreCase(Vendor)) {
                    
                    String id = reviewDetails[0];
                    String customer = reviewDetails[1];
                    String comment = reviewDetails[4];
                    String rating = reviewDetails[5];     
                    String date = reviewDetails[3];          
                   
            
                    model.addRow(
                            new Object[]{id, customer, comment, rating, date
                                });
                }
            }
        }
    }
    
    private void displayRevenue() {
        
        User user = new User();
        
        List<String[]> records = user.viewRevenues();
        
        for (String[] reviewDetails : records) {
            if (reviewDetails.length >= 3) {
                String name = reviewDetails[0].trim();
                if (name.equalsIgnoreCase(Vendor)) {
                    String revenue = reviewDetails[2];
                    RevenueLbl.setText("RM " + revenue);
                }
            }
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
        ItemNameTxt = new javax.swing.JTextField();
        Separator1 = new javax.swing.JPanel();
        Separator2 = new javax.swing.JPanel();
        ItemPriceTxt = new javax.swing.JTextField();
        ItemTypeLbl = new javax.swing.JLabel();
        DrinkRB = new javax.swing.JRadioButton();
        FoodRB = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemsTable = new javax.swing.JTable();
        DelItemBtn = new javax.swing.JButton();
        EditItemBtn = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();
        OrdersPanel = new javax.swing.JPanel();
        AccBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();
        OrderStatusPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        OrderStatusTable = new javax.swing.JTable();
        DoneBtn = new javax.swing.JButton();
        CancelBtn2 = new javax.swing.JButton();
        PreparingBtn = new javax.swing.JButton();
        OrderHistoryPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        OrderHistoryTable = new javax.swing.JTable();
        CusReviewPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ReviewsTable = new javax.swing.JTable();
        RevenuePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        RevenueLbl = new javax.swing.JLabel();
        RevenueLbl1 = new javax.swing.JLabel();

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

        ItemNameTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ItemNameTxt.setForeground(java.awt.Color.gray);
        ItemNameTxt.setText("Item Name");
        ItemNameTxt.setBorder(null);
        ItemNameTxt.setFocusable(false);
        ItemNameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ItemNameTxtFocusLost(evt);
            }
        });
        ItemNameTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemNameTxtMouseClicked(evt);
            }
        });

        Separator1.setBackground(new java.awt.Color(0, 0, 0));
        Separator1.setMaximumSize(new java.awt.Dimension(300, 1));
        Separator1.setMinimumSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout Separator1Layout = new javax.swing.GroupLayout(Separator1);
        Separator1.setLayout(Separator1Layout);
        Separator1Layout.setHorizontalGroup(
            Separator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        Separator1Layout.setVerticalGroup(
            Separator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        Separator2.setBackground(new java.awt.Color(0, 0, 0));
        Separator2.setMaximumSize(new java.awt.Dimension(300, 1));
        Separator2.setMinimumSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout Separator2Layout = new javax.swing.GroupLayout(Separator2);
        Separator2.setLayout(Separator2Layout);
        Separator2Layout.setHorizontalGroup(
            Separator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        Separator2Layout.setVerticalGroup(
            Separator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        ItemPriceTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ItemPriceTxt.setForeground(java.awt.Color.gray);
        ItemPriceTxt.setText("Item Price");
        ItemPriceTxt.setBorder(null);
        ItemPriceTxt.setFocusable(false);
        ItemPriceTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ItemPriceTxtFocusLost(evt);
            }
        });
        ItemPriceTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemPriceTxtMouseClicked(evt);
            }
        });

        ItemTypeLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ItemTypeLbl.setText("Item Type");

        DrinkRB.setBackground(new java.awt.Color(255, 255, 255));
        DrinkRB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DrinkRB.setText("Drink");
        DrinkRB.setFocusable(false);
        DrinkRB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                DrinkRBStateChanged(evt);
            }
        });

        FoodRB.setBackground(new java.awt.Color(255, 255, 255));
        FoodRB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FoodRB.setSelected(true);
        FoodRB.setText("Food");
        FoodRB.setFocusable(false);
        FoodRB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                FoodRBStateChanged(evt);
            }
        });
        FoodRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoodRBActionPerformed(evt);
            }
        });

        ItemsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ItemsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        ItemsTable.setFocusable(false);
        ItemsTable.setGridColor(new java.awt.Color(0, 0, 0));
        ItemsTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        ItemsTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ItemsTable.setShowGrid(true);
        ItemsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ItemsTable);

        DelItemBtn.setBackground(new java.awt.Color(255, 0, 0));
        DelItemBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DelItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        DelItemBtn.setText("Delete");
        DelItemBtn.setBorder(null);
        DelItemBtn.setBorderPainted(false);
        DelItemBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelItemBtn.setFocusPainted(false);
        DelItemBtn.setFocusable(false);
        DelItemBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DelItemBtnMouseClicked(evt);
            }
        });

        EditItemBtn.setBackground(new java.awt.Color(255, 153, 0));
        EditItemBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EditItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        EditItemBtn.setText("Edit");
        EditItemBtn.setBorder(null);
        EditItemBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditItemBtn.setFocusPainted(false);
        EditItemBtn.setFocusable(false);
        EditItemBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditItemBtnMouseClicked(evt);
            }
        });

        AddBtn.setBackground(new java.awt.Color(255, 153, 0));
        AddBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn.setText("Add +");
        AddBtn.setBorder(null);
        AddBtn.setBorderPainted(false);
        AddBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddBtn.setFocusPainted(false);
        AddBtn.setFocusable(false);
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ManageMenuItemsPanelLayout = new javax.swing.GroupLayout(ManageMenuItemsPanel);
        ManageMenuItemsPanel.setLayout(ManageMenuItemsPanelLayout);
        ManageMenuItemsPanelLayout.setHorizontalGroup(
            ManageMenuItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageMenuItemsPanelLayout.createSequentialGroup()
                .addGroup(ManageMenuItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageMenuItemsPanelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(ManageMenuItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ItemTypeLbl)
                            .addGroup(ManageMenuItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ItemPriceTxt)
                                .addComponent(Separator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ManageMenuItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ItemNameTxt)
                                .addComponent(Separator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ManageMenuItemsPanelLayout.createSequentialGroup()
                                .addComponent(FoodRB)
                                .addGap(18, 18, 18)
                                .addComponent(DrinkRB))
                            .addGroup(ManageMenuItemsPanelLayout.createSequentialGroup()
                                .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(EditItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DelItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ManageMenuItemsPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        ManageMenuItemsPanelLayout.setVerticalGroup(
            ManageMenuItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageMenuItemsPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(ItemNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ItemPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ItemTypeLbl)
                .addGap(18, 18, 18)
                .addGroup(ManageMenuItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DrinkRB)
                    .addComponent(FoodRB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(ManageMenuItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        ParentPanel.add(ManageMenuItemsPanel, "card3");

        OrdersPanel.setBackground(new java.awt.Color(255, 255, 255));

        AccBtn.setBackground(new java.awt.Color(255, 153, 0));
        AccBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AccBtn.setForeground(new java.awt.Color(255, 255, 255));
        AccBtn.setText("Accept");
        AccBtn.setBorder(null);
        AccBtn.setBorderPainted(false);
        AccBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AccBtn.setFocusPainted(false);
        AccBtn.setFocusable(false);
        AccBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AccBtnMouseClicked(evt);
            }
        });

        CancelBtn.setBackground(new java.awt.Color(255, 0, 0));
        CancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        CancelBtn.setText("Cancel");
        CancelBtn.setBorder(null);
        CancelBtn.setBorderPainted(false);
        CancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CancelBtn.setFocusPainted(false);
        CancelBtn.setFocusable(false);
        CancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelBtnMouseClicked(evt);
            }
        });
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        OrderTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer", "Vendor", "Item", "Quantity", "Total", "Date", "Status"
            }
        ));
        OrderTable.setFocusable(false);
        OrderTable.setGridColor(new java.awt.Color(0, 0, 0));
        OrderTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        OrderTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        OrderTable.setShowGrid(true);
        OrderTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(OrderTable);

        javax.swing.GroupLayout OrdersPanelLayout = new javax.swing.GroupLayout(OrdersPanel);
        OrdersPanel.setLayout(OrdersPanelLayout);
        OrdersPanelLayout.setHorizontalGroup(
            OrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrdersPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(OrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(OrdersPanelLayout.createSequentialGroup()
                        .addComponent(AccBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        OrdersPanelLayout.setVerticalGroup(
            OrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrdersPanelLayout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addGroup(OrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AccBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        ParentPanel.add(OrdersPanel, "card4");

        OrderStatusPanel.setBackground(new java.awt.Color(255, 255, 255));

        OrderStatusTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        OrderStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer", "Vendor", "Item", "Quantity", "Total", "Date", "Status"
            }
        ));
        OrderStatusTable.setFocusable(false);
        OrderStatusTable.setGridColor(new java.awt.Color(0, 0, 0));
        OrderStatusTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        OrderStatusTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        OrderStatusTable.setShowGrid(true);
        OrderStatusTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(OrderStatusTable);

        DoneBtn.setBackground(new java.awt.Color(255, 153, 0));
        DoneBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DoneBtn.setForeground(new java.awt.Color(255, 255, 255));
        DoneBtn.setText("Done");
        DoneBtn.setBorder(null);
        DoneBtn.setBorderPainted(false);
        DoneBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DoneBtn.setFocusPainted(false);
        DoneBtn.setFocusable(false);
        DoneBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DoneBtnMouseClicked(evt);
            }
        });
        DoneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneBtnActionPerformed(evt);
            }
        });

        CancelBtn2.setBackground(new java.awt.Color(255, 0, 0));
        CancelBtn2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CancelBtn2.setForeground(new java.awt.Color(255, 255, 255));
        CancelBtn2.setText("Cancel ");
        CancelBtn2.setToolTipText("");
        CancelBtn2.setBorder(null);
        CancelBtn2.setBorderPainted(false);
        CancelBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CancelBtn2.setFocusPainted(false);
        CancelBtn2.setFocusable(false);
        CancelBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelBtn2MouseClicked(evt);
            }
        });
        CancelBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtn2ActionPerformed(evt);
            }
        });

        PreparingBtn.setBackground(new java.awt.Color(255, 153, 0));
        PreparingBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PreparingBtn.setForeground(new java.awt.Color(255, 255, 255));
        PreparingBtn.setText("Preparing ");
        PreparingBtn.setBorder(null);
        PreparingBtn.setBorderPainted(false);
        PreparingBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PreparingBtn.setFocusPainted(false);
        PreparingBtn.setFocusable(false);
        PreparingBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PreparingBtnMouseClicked(evt);
            }
        });
        PreparingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreparingBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OrderStatusPanelLayout = new javax.swing.GroupLayout(OrderStatusPanel);
        OrderStatusPanel.setLayout(OrderStatusPanelLayout);
        OrderStatusPanelLayout.setHorizontalGroup(
            OrderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderStatusPanelLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(OrderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OrderStatusPanelLayout.createSequentialGroup()
                        .addComponent(PreparingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DoneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CancelBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        OrderStatusPanelLayout.setVerticalGroup(
            OrderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderStatusPanelLayout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addGroup(OrderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DoneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PreparingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        ParentPanel.add(OrderStatusPanel, "card5");

        OrderHistoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        OrderHistoryTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        OrderHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer", "Vendor", "Item", "Quantity", "Total", "Date", "Status"
            }
        ));
        OrderHistoryTable.setFocusable(false);
        OrderHistoryTable.setGridColor(new java.awt.Color(0, 0, 0));
        OrderHistoryTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        OrderHistoryTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        OrderHistoryTable.setShowGrid(true);
        OrderHistoryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(OrderHistoryTable);

        javax.swing.GroupLayout OrderHistoryPanelLayout = new javax.swing.GroupLayout(OrderHistoryPanel);
        OrderHistoryPanel.setLayout(OrderHistoryPanelLayout);
        OrderHistoryPanelLayout.setHorizontalGroup(
            OrderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderHistoryPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        OrderHistoryPanelLayout.setVerticalGroup(
            OrderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderHistoryPanelLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        ParentPanel.add(OrderHistoryPanel, "card6");

        CusReviewPanel.setBackground(new java.awt.Color(255, 255, 255));

        ReviewsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ReviewsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer", "Comment", "Rating", "Date"
            }
        ));
        ReviewsTable.setFocusable(false);
        ReviewsTable.setGridColor(new java.awt.Color(0, 0, 0));
        ReviewsTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        ReviewsTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ReviewsTable.setShowGrid(true);
        ReviewsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(ReviewsTable);

        javax.swing.GroupLayout CusReviewPanelLayout = new javax.swing.GroupLayout(CusReviewPanel);
        CusReviewPanel.setLayout(CusReviewPanelLayout);
        CusReviewPanelLayout.setHorizontalGroup(
            CusReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CusReviewPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        CusReviewPanelLayout.setVerticalGroup(
            CusReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CusReviewPanelLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        ParentPanel.add(CusReviewPanel, "card7");

        RevenuePanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        RevenueLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        RevenueLbl.setForeground(new java.awt.Color(255, 255, 255));
        RevenueLbl.setText("RM 0");

        RevenueLbl1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        RevenueLbl1.setForeground(new java.awt.Color(255, 255, 255));
        RevenueLbl1.setText("Revenue");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(RevenueLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RevenueLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RevenueLbl)
                    .addComponent(RevenueLbl1))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RevenuePanelLayout = new javax.swing.GroupLayout(RevenuePanel);
        RevenuePanel.setLayout(RevenuePanelLayout);
        RevenuePanelLayout.setHorizontalGroup(
            RevenuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RevenuePanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );
        RevenuePanelLayout.setVerticalGroup(
            RevenuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RevenuePanelLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(345, Short.MAX_VALUE))
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
            .addComponent(ParentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
        refreshItems();
    }//GEN-LAST:event_ItemsBtnActionPerformed

    private void OrdersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdersBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(OrdersPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(OrdersBtn, hoverIcon2);
        refreshOrders(OrderTable);
    }//GEN-LAST:event_OrdersBtnActionPerformed

    private void OrderStatusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderStatusBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(OrderStatusPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(OrderStatusBtn, hoverIcon3);
        refreshOrders(OrderStatusTable);
    }//GEN-LAST:event_OrderStatusBtnActionPerformed

    private void OrderHisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderHisBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(OrderHistoryPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(OrderHisBtn, hoverIcon4);
        refreshOrders(OrderHistoryTable);
    }//GEN-LAST:event_OrderHisBtnActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        LoginPage lp = new LoginPage();
        this.dispose();
        lp.setVisible(true);
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void CusReviewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusReviewBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(CusReviewPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(CusReviewBtn, hoverIcon5);
        refreshReview();
    }//GEN-LAST:event_CusReviewBtnActionPerformed

    private void RevenueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RevenueBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(RevenuePanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(RevenueBtn, hoverIcon6);
        displayRevenue();
    }//GEN-LAST:event_RevenueBtnActionPerformed

    private void ItemNameTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ItemNameTxtFocusLost
        if ("".equals(ItemNameTxt.getText())) {
            ItemNameTxt.setText("Item Name");
            ItemNameTxt.setForeground(Color.gray);
            ItemNameTxt.setFocusable(false);
        }
    }//GEN-LAST:event_ItemNameTxtFocusLost

    private void ItemNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemNameTxtMouseClicked
        ItemNameTxt.setFocusable(true);
        ItemNameTxt.requestFocusInWindow();
        ItemNameTxt.setForeground(Color.black);

        if ("Item Name".equals(ItemNameTxt.getText())) {
            ItemNameTxt.setText("");
        }
    }//GEN-LAST:event_ItemNameTxtMouseClicked

    private void ItemPriceTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ItemPriceTxtFocusLost
        if ("".equals(ItemPriceTxt.getText())) {
            
            for (KeyListener kl : ItemPriceTxt.getKeyListeners()) {
                ItemPriceTxt.removeKeyListener(kl);
            }
            
            ItemPriceTxt.setText("Item Price");
            ItemPriceTxt.setForeground(Color.gray);
            ItemPriceTxt.setFocusable(false);
        }
    }//GEN-LAST:event_ItemPriceTxtFocusLost

    private void ItemPriceTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemPriceTxtMouseClicked
            ItemPriceTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }

                if (ItemPriceTxt.getText().length() >= 10) {
                    e.consume();
                }
            }
        });

        
        ItemPriceTxt.setFocusable(true);
        ItemPriceTxt.requestFocusInWindow();
        ItemPriceTxt.setForeground(Color.black);

        if ("Item Price".equals(ItemPriceTxt.getText())) {
            ItemPriceTxt.setText("");
        }
    }//GEN-LAST:event_ItemPriceTxtMouseClicked

    private void FoodRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoodRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FoodRBActionPerformed

    private void DelItemBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelItemBtnMouseClicked
       delItem();
       resetFields();
    }//GEN-LAST:event_DelItemBtnMouseClicked

    private void EditItemBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditItemBtnMouseClicked
       editItem();
       resetFields();
    }//GEN-LAST:event_EditItemBtnMouseClicked

    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked
       addItem();
       resetFields();
    }//GEN-LAST:event_AddBtnMouseClicked

    private void AccBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccBtnMouseClicked
        updateStatus("Accepted", OrderTable);       
    }//GEN-LAST:event_AccBtnMouseClicked

    private void CancelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelBtnMouseClicked
        updateStatus("Cancelled", OrderTable); 
    }//GEN-LAST:event_CancelBtnMouseClicked

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void DoneBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DoneBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DoneBtnMouseClicked

    private void CancelBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelBtn2MouseClicked
        
    }//GEN-LAST:event_CancelBtn2MouseClicked

    private void CancelBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtn2ActionPerformed
        updateStatus("Cancelled", OrderStatusTable);
    }//GEN-LAST:event_CancelBtn2ActionPerformed

    private void PreparingBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PreparingBtnMouseClicked
        
    }//GEN-LAST:event_PreparingBtnMouseClicked

    private void DoneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneBtnActionPerformed
        updateStatus("Done", OrderStatusTable); 

        
    }//GEN-LAST:event_DoneBtnActionPerformed

    private void PreparingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreparingBtnActionPerformed
        updateStatus("Preparing", OrderStatusTable); 
    }//GEN-LAST:event_PreparingBtnActionPerformed

    private void DrinkRBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_DrinkRBStateChanged

    }//GEN-LAST:event_DrinkRBStateChanged

    private void FoodRBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_FoodRBStateChanged

    }//GEN-LAST:event_FoodRBStateChanged

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
    private javax.swing.JButton AccBtn;
    private javax.swing.JButton AddBtn;
    private javax.swing.JLabel BackgroundLbl;
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton CancelBtn2;
    private javax.swing.JButton CusReviewBtn;
    private javax.swing.JPanel CusReviewPanel;
    private javax.swing.JButton DelItemBtn;
    private javax.swing.JButton DoneBtn;
    private javax.swing.JRadioButton DrinkRB;
    private javax.swing.JButton EditItemBtn;
    private javax.swing.JRadioButton FoodRB;
    private javax.swing.JTextField ItemNameTxt;
    private javax.swing.JTextField ItemPriceTxt;
    private javax.swing.JLabel ItemTypeLbl;
    private javax.swing.JButton ItemsBtn;
    private javax.swing.JTable ItemsTable;
    private javax.swing.JLabel LogoLbl;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JPanel ManageMenuItemsPanel;
    private javax.swing.JButton OrderHisBtn;
    private javax.swing.JPanel OrderHistoryPanel;
    private javax.swing.JTable OrderHistoryTable;
    private javax.swing.JButton OrderStatusBtn;
    private javax.swing.JPanel OrderStatusPanel;
    private javax.swing.JTable OrderStatusTable;
    private javax.swing.JTable OrderTable;
    private javax.swing.JButton OrdersBtn;
    private javax.swing.JPanel OrdersPanel;
    private javax.swing.JLabel PageTypeLbl;
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JButton PreparingBtn;
    private javax.swing.JButton RevenueBtn;
    private javax.swing.JLabel RevenueLbl;
    private javax.swing.JLabel RevenueLbl1;
    private javax.swing.JPanel RevenuePanel;
    private javax.swing.JTable ReviewsTable;
    private javax.swing.JPanel Separator1;
    private javax.swing.JPanel Separator2;
    private javax.swing.JPanel SeparatorPanel;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JLabel WelcomeLbl;
    private javax.swing.JPanel WelcomePanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
